package org.sniklz.autoservice.service.mapper;

public interface ResponseDtoMapper<D, M> {
    D toDto(M model);
}
