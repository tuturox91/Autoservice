package org.sniklz.autoservice.service.impl;

import org.sniklz.autoservice.model.Master;
import org.sniklz.autoservice.model.Order;
import org.sniklz.autoservice.repository.MasterRepository;
import org.sniklz.autoservice.service.MasterService;
import org.sniklz.autoservice.service.ServiceService;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MasterServiceImpl implements MasterService {

    private final MasterRepository masterRepository;
    private final ServiceService serviceService;

    public MasterServiceImpl(MasterRepository masterRepository, ServiceService serviceService) {
        this.masterRepository = masterRepository;
        this.serviceService = serviceService;
    }

    @Override
    public Master save(Master model) {
        return masterRepository.save(model);
    }

    @Override
    public Master update(Master model) {
        return masterRepository.save(model);
    }

    @Override
    public Master getMasterById(Long id) {
        return masterRepository.getReferenceById(id);
    }

    @Override
    public BigDecimal calculateMasterSalary(Long masterId) {
        BigDecimal masterSalaryPercent = BigDecimal.valueOf(0.4);
        List<Order> orders = getMasterById(masterId).getCompletedOrders();

        List<org.sniklz.autoservice.model.Service> services = orders.stream()
                .flatMap(order -> order.getServices().stream())
                .filter(service -> service.getStatus()
                        .equals(org.sniklz.autoservice.model.Service.ServiceStatus.NOT_PAYED))
                .collect(Collectors.toList());
        services.forEach(service -> service.setStatus(org.sniklz.autoservice.model.Service.ServiceStatus.PAYED));
        services.forEach(service -> serviceService.update(service));
        BigDecimal resultService = services.stream().map(service -> service.getCost()).reduce(BigDecimal.ZERO, (x, y) -> x.add(y));
        resultService = resultService.multiply(masterSalaryPercent);
        return resultService;
    }
}
