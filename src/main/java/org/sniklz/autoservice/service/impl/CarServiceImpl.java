package org.sniklz.autoservice.service.impl;

import org.sniklz.autoservice.model.Car;
import org.sniklz.autoservice.repository.CarRepository;
import org.sniklz.autoservice.service.CarService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public Car save(Car model) {
        return carRepository.save(model);
    }

    @Override
    public Car update(Car model) {
        return carRepository.save(model);
    }

    @Override
    public List<Car> getCarsByIdIn(Set<Long> ids) {
        return carRepository.getCarsByIdIn(ids);
    }

    @Override
    public Car getCarById(Long id) {
        return carRepository.getReferenceById(id);
    }
}
