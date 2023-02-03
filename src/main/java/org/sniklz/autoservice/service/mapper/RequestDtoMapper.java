package org.sniklz.autoservice.service.mapper;

public interface RequestDtoMapper<D, M> {
    M toModel(D requestDto);
}
