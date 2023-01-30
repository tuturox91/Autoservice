package org.sniklz.autoservice.service.impl;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.sniklz.autoservice.model.Master;
import org.sniklz.autoservice.model.Order;
import org.sniklz.autoservice.model.Service;
import org.sniklz.autoservice.repository.MasterRepository;
import org.sniklz.autoservice.repository.ServiceRepository;
import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class MasterServiceImplTest {

    Master master = new Master();
    Service service = new Service();
    Service service2 = new Service();
    Service service3 = new Service();
    Order order = new Order();
    Order order2 = new Order();

    @InjectMocks
    private MasterServiceImpl masterService;

    @Mock
    private ServiceServiceImpl serviceService;

    @Mock
    private MasterRepository masterRepository;

    @Mock
    private ServiceRepository serviceRepository;


    @Test
    void calculateMasterSalary_withDiagnostic_ok() {

        Master master = new Master();
        master.setFullName("test");
        master.setId(1L);

        Service service = new Service();
        service.setId(1L);
        service.setStatus(Service.ServiceStatus.NOT_PAYED);
        service.setMaster(master);
        service.setServiceType(Service.ServiceType.DIAGNOSTIC);
        service.setCost(BigDecimal.valueOf(200));

        Service service2 = new Service();
        service2.setId(2L);
        service2.setStatus(Service.ServiceStatus.NOT_PAYED);
        service2.setMaster(master);
        service2.setServiceType(Service.ServiceType.DIAGNOSTIC);
        service2.setCost(BigDecimal.valueOf(200));

        Service service3 = new Service();
        service3.setId(3L);
        service3.setStatus(Service.ServiceStatus.NOT_PAYED);
        service3.setMaster(master);
        service3.setServiceType(Service.ServiceType.DEFAULT);
        service3.setCost(BigDecimal.valueOf(200));

        Order order = new Order();
        order.setId(1L);
        order.setServices(List.of(service));

        Order order2 = new Order();
        order2.setId(2L);
        order2.setServices(List.of(service2, service3));

        service.setOrder(order);
        service2.setOrder(order2);
        service3.setOrder(order2);

        master.setCompletedOrders(List.of(order, order2));

        Long masterId = 1L;

        Mockito.when(masterService.getMasterById(masterId)).thenReturn(master);
        Mockito.when(serviceService.update(service)).thenReturn(service);


        assertTrue(BigDecimal.valueOf(240).compareTo(masterService.calculateMasterSalary(1L)) == 0);
    }



}