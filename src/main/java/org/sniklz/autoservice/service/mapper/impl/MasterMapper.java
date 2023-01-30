package org.sniklz.autoservice.service.mapper.impl;

import org.sniklz.autoservice.dto.request.MasterRequestDto;
import org.sniklz.autoservice.dto.response.MasterResponseDto;
import org.sniklz.autoservice.model.Master;
import org.sniklz.autoservice.model.Order;
import org.sniklz.autoservice.repository.OrderRepository;
import org.sniklz.autoservice.service.mapper.UniversalDtoMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MasterMapper
        implements UniversalDtoMapper<MasterRequestDto, MasterResponseDto, Master> {

    private final OrderRepository orderRepository;

    public MasterMapper(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Master toModel(MasterRequestDto requestDto) {
        Master master = new Master();
        List<Order> orders = requestDto.getCompletedOrderIds()
                .stream()
                .map(orderRepository::getReferenceById)
                .collect(Collectors.toList());
        master.setCompletedOrders(orders);
        master.setFullName(requestDto.getFullName());
        return master;
    }

    @Override
    public MasterResponseDto toDto(Master model) {
        MasterResponseDto masterResponseDto = new MasterResponseDto();
        masterResponseDto.setFullName(model.getFullName());
        List<Long> ordersIds = model.getCompletedOrders()
                .stream()
                .map(order -> order.getId()).collect(Collectors.toList());
        masterResponseDto.setCompletedOrderIds(ordersIds);
        masterResponseDto.setId(model.getId());
        return masterResponseDto;
    }
}
