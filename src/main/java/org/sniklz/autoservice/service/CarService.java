package org.sniklz.autoservice.service;

import java.util.List;
import java.util.Set;
import org.sniklz.autoservice.model.Car;

public interface CarService extends DefaultService<Car> {

    List<Car> getCarsByIdIn(Set<Long> id);

    Car getCarById(Long id);
}
