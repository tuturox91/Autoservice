package org.sniklz.autoservice.service.mapper.impl;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import org.sniklz.autoservice.dto.request.OrderRequestDto;
import org.sniklz.autoservice.dto.response.OrderResponseDto;
import org.sniklz.autoservice.model.Order;
import org.sniklz.autoservice.model.Product;
import org.sniklz.autoservice.model.Service;
import org.sniklz.autoservice.service.CarOwnerService;
import org.sniklz.autoservice.service.CarService;
import org.sniklz.autoservice.service.OrderService;
import org.sniklz.autoservice.service.ProductService;
import org.sniklz.autoservice.service.ServiceService;
import org.sniklz.autoservice.service.mapper.UniversalDtoMapper;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper implements UniversalDtoMapper<OrderRequestDto, OrderResponseDto, Order> {

    private final OrderService orderService;
    private final ServiceService serviceService;
    private final CarOwnerService carOwnerService;
    private final ProductService productService;
    private final CarService carService;

    public OrderMapper(
            OrderService orderService, ServiceService serviceService,
            CarOwnerService carOwnerService,
            ProductService productService,
            CarService carService) {
        this.orderService = orderService;
        this.serviceService = serviceService;
        this.carOwnerService = carOwnerService;
        this.productService = productService;
        this.carService = carService;
    }

    @Override
    public Order toModel(OrderRequestDto requestDto) {
        Order order = new Order();
        order.setCar(carService.getCarById(requestDto.getCarId()));
        order.setDescription(requestDto.getDescription());
        List<Service> services = requestDto.getServicesIds()
                .stream()
                .map(serviceService::getServiceById)
                .toList();
        order.setServices(services);
        List<Product> products = requestDto.getProductsIds()
                .stream()
                .map(productService::getProductById)
                .toList();
        order.setProducts(products);
        order.setAcceptOrderTime(requestDto.getAcceptOrderTime());
        order.setOrderStatus(Order.OrderStatus.valueOf(requestDto.getOrderStatus().toUpperCase()));
        return order;
    }

    @Override
    public OrderResponseDto toDto(Order model) {
        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setId(model.getId());
        orderResponseDto.setCarId(model.getCar().getId());
        orderResponseDto.setDescription(model.getDescription());
        orderResponseDto.setAcceptOrderTime(model.getAcceptOrderTime());
        orderResponseDto.setServicesIds(model.getServices()
                .stream()
                .map(Service::getId)
                .collect(Collectors.toList()));
        orderResponseDto.setProductsIds(model.getProducts()
                .stream()
                .map(Product::getId)
                .collect(Collectors.toList()));
        orderResponseDto.setOrderStatus(model.getOrderStatus().toString());
        orderResponseDto.setResultCost(model.getResultCost());
        orderResponseDto.setCompleteTime(model.getCompleteTime());
        return orderResponseDto;
    }
}
