package org.sniklz.autoservice.service;

import org.sniklz.autoservice.model.CarOwner;

public interface CarOwnerService extends DefaultService<CarOwner> {

    CarOwner getCarOwnerById(Long id);

}
