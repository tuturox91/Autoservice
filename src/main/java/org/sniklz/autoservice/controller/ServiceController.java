package org.sniklz.autoservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.sniklz.autoservice.dto.request.ServiceRequestDto;
import org.sniklz.autoservice.dto.response.ServiceResponseDto;
import org.sniklz.autoservice.model.Service;
import org.sniklz.autoservice.service.ServiceService;
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
@RequestMapping ("/service")
public class ServiceController {

    private final UniversalDtoMapper<ServiceRequestDto, ServiceResponseDto, Service> serviceMapper;
    private final ServiceService serviceService;

    public ServiceController(UniversalDtoMapper<ServiceRequestDto,
            ServiceResponseDto, Service> serviceMapper, ServiceService serviceService) {
        this.serviceMapper = serviceMapper;
        this.serviceService = serviceService;
    }

    @PostMapping
    @Parameter(description = "Add service")
    public ServiceResponseDto addService(@RequestBody ServiceRequestDto requestDto) {
        return serviceMapper.toDto(serviceService.save(serviceMapper.toModel(requestDto)));
    }

    @PutMapping("/{id}")
    @Operation(description = "Update service")
    public ServiceResponseDto updateService(
            @Parameter(description = "Service id")
            @PathVariable Long id,
            @RequestBody ServiceRequestDto requestDto) {
        Service service = serviceMapper.toModel(requestDto);
        service.setId(id);
        return serviceMapper.toDto(serviceService.update(service));
    }

    @PutMapping("/{serviceId}")
    @Operation (description = "Change Service status")
    public ServiceResponseDto changeServiceStatus(
            @Parameter(description = "Service id")
            @PathVariable Long serviceId,
            @RequestParam String serviceStatus) {
        return serviceMapper.toDto(serviceService.changeServiceStatus(serviceId, serviceStatus));
    }

    @GetMapping("/{id}")
    @Operation (description = "Get service by id")
    public ServiceResponseDto getServiceById(
            @Parameter(description = "Service id")
            @PathVariable Long id) {
        return serviceMapper.toDto(serviceService.getServiceById(id));
    }

}
