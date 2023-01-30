package org.sniklz.autoservice.service.mapper.impl;

import org.sniklz.autoservice.dto.request.ServiceRequestDto;
import org.sniklz.autoservice.dto.response.ServiceResponseDto;
import org.sniklz.autoservice.model.Service;
import org.sniklz.autoservice.service.MasterService;
import org.sniklz.autoservice.service.OrderService;
import org.sniklz.autoservice.service.mapper.UniversalDtoMapper;
import org.springframework.stereotype.Component;

@Component
public class ServiceMapper implements
        UniversalDtoMapper<ServiceRequestDto, ServiceResponseDto, Service> {

    private final MasterService masterService;
    private final OrderService orderService;

    public ServiceMapper(MasterService masterService, OrderService orderService) {
        this.masterService = masterService;
        this.orderService = orderService;
    }


    @Override
    public Service toModel(ServiceRequestDto requestDto) {
        Service service = new Service();
        service.setMaster(masterService.getMasterById(requestDto.getMasterId()));
        service.setCost(requestDto.getCost());
        service.setServiceType(Service.ServiceType.valueOf(requestDto.getServiceType().toUpperCase()));
        service.setOrder(orderService.getOrderById(requestDto.getOrderId()));
        return service;
    }

    @Override
    public ServiceResponseDto toDto(Service model) {
        ServiceResponseDto responseDto = new ServiceResponseDto();
        responseDto.setId(model.getId());
        responseDto.setCost(model.getCost());
        responseDto.setStatus(model.getStatus().toString());
        responseDto.setMasterId(model.getMaster().getId());
        responseDto.setServiceType(model.getServiceType().toString());
        responseDto.setOrderId(model.getOrder().getId());
        return responseDto;
    }
}
