package org.sniklz.autoservice.service;

import java.util.List;
import java.util.Set;
import org.sniklz.autoservice.model.Service;

public interface ServiceService extends DefaultService<Service> {

    Service changeServiceStatus(Long serviceId, String serviceStatus);

    List<Service> getServicesByIdIn(Set<Long> ids);

    Service getServiceById(Long id);
}
