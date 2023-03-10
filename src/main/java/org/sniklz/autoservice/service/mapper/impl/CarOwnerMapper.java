package org.sniklz.autoservice.service.mapper.impl;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import org.sniklz.autoservice.dto.request.CarOwnerRequestDto;
import org.sniklz.autoservice.dto.response.CarOwnerResponseDto;
import org.sniklz.autoservice.model.Car;
import org.sniklz.autoservice.model.CarOwner;
import org.sniklz.autoservice.model.Order;
import org.sniklz.autoservice.service.CarService;
import org.sniklz.autoservice.service.OrderService;
import org.sniklz.autoservice.service.mapper.UniversalDtoMapper;
import org.springframework.stereotype.Component;

@Component
public class CarOwnerMapper implements
        UniversalDtoMapper<CarOwnerRequestDto, CarOwnerResponseDto, CarOwner> {

    private final CarService carService;
    private final OrderService orderService;

    public CarOwnerMapper(CarService carService, OrderService orderService) {
        this.carService = carService;
        this.orderService = orderService;
    }

    @Override
    public CarOwner toModel(CarOwnerRequestDto requestDto) {
        CarOwner carOwner = new CarOwner();
        List<Car> carList = requestDto.getCarIds()
                .stream()
                .map(carService::getCarById)
                .toList();
        carOwner.setCars(carList);
        List<Order> orders = requestDto.getOrderIds()
                .stream()
                .map(orderService::getOrderById)
                .toList();
        carOwner.setOrders(orders);
        return carOwner;
    }

    @Override
    public CarOwnerResponseDto toDto(CarOwner model) {
        CarOwnerResponseDto carOwnerResponseDto = new CarOwnerResponseDto();
        carOwnerResponseDto.setId(model.getId());
        carOwnerResponseDto.setCarIds(model.getCars()
                .stream()
                .map(car -> car.getId())
                .collect(Collectors.toList()));
        carOwnerResponseDto.setOrderIds(model.getOrders()
                .stream()
                .map(order -> order.getId())
                .collect(Collectors.toList()));
        return carOwnerResponseDto;
    }
}
