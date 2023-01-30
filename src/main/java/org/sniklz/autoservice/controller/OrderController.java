package org.sniklz.autoservice.controller;

import org.sniklz.autoservice.dto.request.OrderRequestDto;
import org.sniklz.autoservice.dto.response.OrderResponseDto;
import org.sniklz.autoservice.model.Order;
import org.sniklz.autoservice.service.OrderService;
import org.sniklz.autoservice.service.mapper.UniversalDtoMapper;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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
    public OrderResponseDto addOrder(@RequestBody OrderRequestDto requestDto) {
        return orderMapper.toDto(orderService.save(orderMapper.toModel(requestDto)));
    }

    @PutMapping("/{id}")
    public OrderResponseDto updateOrder(@PathVariable Long id, @RequestBody OrderRequestDto requestDto) {
        Order order = orderMapper.toModel(requestDto);
        order.setId(id);
        return orderMapper.toDto(orderService.update(order));
    }

    @GetMapping("/by-master/{id}")
    public List<OrderResponseDto> getOrdersByMasterId(@PathVariable Long id) {
        return orderService.getOrdersByMasterId(id)
                .stream()
                .map(orderMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/by-owner/{id}")
    public List<OrderResponseDto> getOrdersByOwnerId(@PathVariable Long id) {
        return orderService.getOrdersByCarOwnersId(id)
                .stream()
                .map(orderMapper::toDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/change/status/{orderId}")
    public OrderResponseDto changeOrderStatus(@PathVariable Long orderId, @RequestParam String orderStatus) {
        return orderMapper.toDto(orderService.changeOrderStatus(orderId, orderStatus));
    }

    @PostMapping("/add/product/{orderId}")
    public OrderResponseDto addProductToOrder(@PathVariable Long orderId, @RequestParam Long productId) {
        return orderMapper.toDto(orderService.addServiceToOrder(orderId, productId));
    }

    @GetMapping("/{id}")
    public OrderResponseDto getCarById(@PathVariable Long id) {
        return orderMapper.toDto(orderService.getOrderById(id));
    }

    @GetMapping("/cost/{id}")
    public OrderResponseDto calculateOrderCost(@PathVariable Long id) {
        return orderMapper.toDto(orderService.calculateOrderCost(id));
    }

}
