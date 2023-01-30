package org.sniklz.autoservice.service.impl;

import org.sniklz.autoservice.model.Service;
import org.sniklz.autoservice.repository.ServiceRepository;
import org.sniklz.autoservice.service.ServiceService;

import java.util.List;
import java.util.Set;

@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService {

    private final ServiceRepository serviceRepository;

    public ServiceServiceImpl(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @Override
    public Service save(Service model) {
        model.setStatus(Service.ServiceStatus.NOT_PAYED);
        return serviceRepository.save(model);
    }

    @Override
    public Service update(Service model) {
        return serviceRepository.save(model);
    }


    @Override
    public Service changeServiceStatus(Long serviceId, String serviceStatus) {
        Service service = getServiceById(serviceId);
        service.setStatus(Service.ServiceStatus.valueOf(serviceStatus.toUpperCase()));
        return update(service);
    }

    @Override
    public List<Service> getServicesByIdIn(Set<Long> ids) {
        return serviceRepository.getServicesByIdIn(ids);
    }

    @Override
    public Service getServiceById(Long id) {
        return serviceRepository.getReferenceById(id);
    }


}
