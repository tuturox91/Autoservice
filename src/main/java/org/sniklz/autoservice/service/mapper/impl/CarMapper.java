package org.sniklz.autoservice.service.mapper.impl;

import org.sniklz.autoservice.dto.request.CarRequestDto;
import org.sniklz.autoservice.dto.response.CarResponseDto;
import org.sniklz.autoservice.model.Car;
import org.sniklz.autoservice.service.CarOwnerService;
import org.sniklz.autoservice.service.mapper.UniversalDtoMapper;
import org.springframework.stereotype.Component;

@Component
public class CarMapper implements
        UniversalDtoMapper<CarRequestDto, CarResponseDto, Car> {

    private final CarOwnerService carOwnerService;

    public CarMapper(CarOwnerService carOwnerService) {
        this.carOwnerService = carOwnerService;
    }

    @Override
    public Car toModel(CarRequestDto requestDto) {
        Car car = new Car();
        car.setModel(requestDto.getModel());
        car.setMark(requestDto.getMark());
        car.setNumber(requestDto.getNumber());
        car.setProductionYear(requestDto.getProductionYear());
        car.setCarOwner(carOwnerService.getCarOwnerById(requestDto.getCarOwner()));
        return car;
    }

    @Override
    public CarResponseDto toDto(Car model) {
        CarResponseDto carResponseDto = new CarResponseDto();
        carResponseDto.setId(model.getId());
        carResponseDto.setModel(model.getModel());
        carResponseDto.setMark(model.getMark());
        carResponseDto.setNumber(model.getNumber());
        carResponseDto.setProductionYear(model.getProductionYear());
        carResponseDto.setCarOwnerId(model.getCarOwner().getId());
        return carResponseDto;
    }
}
