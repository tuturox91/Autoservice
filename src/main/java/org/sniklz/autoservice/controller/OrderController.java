package org.sniklz.autoservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import java.util.List;
import java.util.stream.Collectors;
import org.sniklz.autoservice.dto.request.OrderRequestDto;
import org.sniklz.autoservice.dto.response.OrderResponseDto;
import org.sniklz.autoservice.model.Order;
import org.sniklz.autoservice.service.OrderService;
import org.sniklz.autoservice.service.mapper.UniversalDtoMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final UniversalDtoMapper<OrderRequestDto, OrderResponseDto, Order> orderMapper;
    private final OrderService orderService;

    public OrderController(UniversalDtoMapper<OrderRequestDto,
            OrderResponseDto, Order> orderMapper, OrderService orderService) {
        this.orderMapper = orderMapper;
        this.orderService = orderService;
    }

    @PostMapping
    @Operation(description = "Add order")
    public OrderResponseDto addOrder(@RequestBody OrderRequestDto requestDto) {
        return orderMapper.toDto(orderService.save(orderMapper.toModel(requestDto)));
    }

    @PutMapping("/{id}")
    @Operation(description = "Update order")
    public OrderResponseDto updateOrder(@Parameter(description = "Order id") @PathVariable Long id,
                                        @RequestBody OrderRequestDto requestDto) {
        Order order = orderMapper.toModel(requestDto);
        order.setId(id);
        return orderMapper.toDto(orderService.update(order));
    }

    @GetMapping("/by-master/{id}")
    @Operation(description = "Get order by master id")
    public List<OrderResponseDto> getOrdersByMasterId(@Parameter(description = "Master id")
                                                      @PathVariable Long id) {
        return orderService.getOrdersByMasterId(id)
                .stream()
                .map(orderMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/by-owner/{id}")
    @Operation(description = "Get order by owner id")
    public List<OrderResponseDto> getOrdersByOwnerId(@Parameter(description = "Owner id")
                                                     @PathVariable Long id) {
        return orderService.getOrdersByCarOwnersId(id)
                .stream()
                .map(orderMapper::toDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/change/status/{orderId}")
    @Operation(description = "Change only order status")
    public OrderResponseDto changeOrderStatus(
            @Parameter(description = "Order id")
            @PathVariable Long orderId,
            @RequestParam String orderStatus) {
        return orderMapper.toDto(orderService.changeOrderStatus(orderId, orderStatus));
    }

    @PostMapping("/add/product/{orderId}")
    @Operation(description = "Add product to order")
    public OrderResponseDto addProductToOrder(
            @Parameter(description = "Order id")
            @PathVariable Long orderId,
            @RequestParam Long productId) {
        return orderMapper.toDto(orderService.addServiceToOrder(orderId, productId));
    }

    @GetMapping("/{id}")
    @Operation(description = "Get order by id")
    public OrderResponseDto getOrderById(
            @Parameter(description = "Order id")
            @PathVariable Long id) {
        return orderMapper.toDto(orderService.getOrderById(id));
    }

    @GetMapping("/cost/{id}")
    @Operation(description = "Calculate order cost")
    public OrderResponseDto calculateOrderCost(
            @Parameter(description = "Order id")
            @PathVariable Long id) {
        return orderMapper.toDto(orderService.calculateOrderCost(id));
    }

}
