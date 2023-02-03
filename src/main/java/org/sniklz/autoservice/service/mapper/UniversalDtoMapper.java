package org.sniklz.autoservice.service.mapper;

public interface UniversalDtoMapper<R, T, M>
        extends RequestDtoMapper<R, M>, ResponseDtoMapper<T, M> {
}
