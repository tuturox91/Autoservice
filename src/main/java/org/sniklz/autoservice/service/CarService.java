package org.sniklz.autoservice.service;

import org.sniklz.autoservice.model.Car;

import java.util.List;
import java.util.Set;

public interface CarService extends DefaultService<Car> {

    List<Car> getCarsByIdIn(Set<Long> id);

    Car getCarById(Long id);
}
