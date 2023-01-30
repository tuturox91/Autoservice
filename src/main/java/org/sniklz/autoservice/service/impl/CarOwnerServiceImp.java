package org.sniklz.autoservice.service.impl;

import org.sniklz.autoservice.model.CarOwner;
import org.sniklz.autoservice.repository.CarOwnerRepository;
import org.sniklz.autoservice.service.CarOwnerService;
import org.springframework.stereotype.Service;

@Service
public class CarOwnerServiceImp implements CarOwnerService {

    private final CarOwnerRepository carOwnerRepository;

    public CarOwnerServiceImp(CarOwnerRepository carOwnerRepository) {
        this.carOwnerRepository = carOwnerRepository;
    }

    @Override
    public CarOwner save(CarOwner model) {
        return carOwnerRepository.save(model);
    }

    @Override
    public CarOwner update(CarOwner model) {
        return carOwnerRepository.save(model);
    }

    @Override
    public CarOwner getCarOwnerById(Long id) {
        return carOwnerRepository.getReferenceById(id);
    }
}
