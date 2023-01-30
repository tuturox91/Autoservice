package org.sniklz.autoservice.service;

public interface DefaultService<T> {

    T save(T model);
    T update (T model);
}
