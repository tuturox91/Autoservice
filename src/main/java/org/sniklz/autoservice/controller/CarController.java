package org.sniklz.autoservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.sniklz.autoservice.dto.request.CarRequestDto;
import org.sniklz.autoservice.dto.response.CarResponseDto;
import org.sniklz.autoservice.model.Car;
import org.sniklz.autoservice.service.CarService;
import org.sniklz.autoservice.service.mapper.UniversalDtoMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/car")
public class CarController {

    private final UniversalDtoMapper<CarRequestDto, CarResponseDto, Car> serviceMapper;
    private final CarService carService;

    public CarController(UniversalDtoMapper<CarRequestDto,
            CarResponseDto, Car> mapper, CarService carService) {
        this.serviceMapper = mapper;
        this.carService = carService;
    }

    @PostMapping
    @Operation(description = "add car")
    public CarResponseDto addCar(@RequestBody CarRequestDto requestDto) {
        return serviceMapper.toDto(carService.save(serviceMapper.toModel(requestDto)));
    }

    @PutMapping("/{id}")
    @Operation(description = "Update car")
    public CarResponseDto updateCar(
            @Parameter(description = "Required car id")
            @PathVariable Long id,
            @RequestBody CarRequestDto requestDto) {
        Car car = serviceMapper.toModel(requestDto);
        car.setId(id);
        return serviceMapper.toDto(carService.update(car));
    }

    @GetMapping("/{id}")
    @Operation(description = "get car by id")
    public CarResponseDto getCarById(@PathVariable Long id) {
        return serviceMapper.toDto(carService.getCarById(id));
    }
}
