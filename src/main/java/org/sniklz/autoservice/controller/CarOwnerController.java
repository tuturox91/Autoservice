package org.sniklz.autoservice.controller;

import org.sniklz.autoservice.dto.request.CarOwnerRequestDto;
import org.sniklz.autoservice.dto.response.CarOwnerResponseDto;
import org.sniklz.autoservice.model.CarOwner;
import org.sniklz.autoservice.service.CarOwnerService;
import org.sniklz.autoservice.service.mapper.UniversalDtoMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/car-owner")
public class CarOwnerController {

    private final UniversalDtoMapper<CarOwnerRequestDto,
            CarOwnerResponseDto, CarOwner> carOwnerMapper;
    private final CarOwnerService carOwnerService;

    public CarOwnerController(UniversalDtoMapper<CarOwnerRequestDto, CarOwnerResponseDto, CarOwner> carOwnerMapper, CarOwnerService carOwnerService) {
        this.carOwnerMapper = carOwnerMapper;
        this.carOwnerService = carOwnerService;
    }

    @PostMapping
    public CarOwnerResponseDto addCarOwner(@RequestBody CarOwnerRequestDto requestDto) {
        return carOwnerMapper.toDto(carOwnerService.save(carOwnerMapper.toModel(requestDto)));
    }

    @PutMapping("/{id}")
    public  CarOwnerResponseDto updateCarOwner(@PathVariable Long id, @RequestBody CarOwnerRequestDto requestDto) {
        CarOwner carOwner = carOwnerMapper.toModel(requestDto);
        carOwner.setId(id);
        return carOwnerMapper.toDto(carOwnerService.update(carOwner));
    }

    @GetMapping("/{id}")
    public CarOwnerResponseDto getCarById(@PathVariable Long id) {
        return carOwnerMapper.toDto(carOwnerService.getCarOwnerById(id));
    }


}
