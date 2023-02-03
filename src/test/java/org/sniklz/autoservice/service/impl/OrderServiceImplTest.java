package org.sniklz.autoservice.service.impl;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.sniklz.autoservice.model.Car;
import org.sniklz.autoservice.model.CarOwner;
import org.sniklz.autoservice.model.Order;
import org.sniklz.autoservice.model.Product;
import org.sniklz.autoservice.model.Service;
import org.sniklz.autoservice.repository.OrderRepository;
import org.sniklz.autoservice.service.OrderService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class OrderServiceImplTest {

    @InjectMocks
    private OrderServiceImpl orderService;

    @Mock
    private OrderRepository orderRepository;

    @Test
    public void calculateServiceCostWithDiscountsWithOneOrder_OK() {
        Service service = new Service();
        service.setId(1L);
        service.setCost(BigDecimal.valueOf(200));
        List<Service> serviceList = List.of(service);
        assertTrue(BigDecimal.valueOf(196).compareTo(orderService.calculateServiceCost(serviceList, BigDecimal.ONE)) == 0);
    }

    @Test
    public void calculateServiceCostWithDiscountsWithTwoOrders_OK() {
        Service service = new Service();
        service.setId(1L);
        service.setCost(BigDecimal.valueOf(200));
        List<Service> serviceList = List.of(service);
        assertTrue(BigDecimal.valueOf(192).compareTo(orderService.calculateServiceCost(serviceList, BigDecimal.valueOf(2))) == 0);
    }

    @Test
    public void calculateProductsCostWithDiscountsOneOrder_OK() {
        Product product = new Product();
        product.setId(1L);
        product.setCost(BigDecimal.valueOf(200));
        List<Product> productList = List.of(product);
        assertTrue(BigDecimal.valueOf(198).compareTo(orderService.calculateProductCost(productList, BigDecimal.ONE)) == 0);
    }

    @Test
    public void calculateProductsCostWithDiscountsTwoOrders_OK() {
        Product product = new Product();
        product.setId(1L);
        product.setCost(BigDecimal.valueOf(200));
        List<Product> productList = List.of(product);
        assertTrue(BigDecimal.valueOf(196).compareTo(orderService.calculateProductCost(productList, BigDecimal.valueOf(2))) == 0);
    }

    @Test
    public void calculateOrderCostWithDiscountsTwoOrders_OK() {
        Product product = new Product();
        product.setId(1L);
        product.setCost(BigDecimal.valueOf(200));

        Service service = new Service();
        service.setId(1L);
        service.setCost(BigDecimal.valueOf(200));

        List<Service> serviceList = List.of(service);
        List<Product> productList = List.of(product);

        Long orderId = 1L;

        Order order = new Order();
        order.setId(1L);
        order.setServices(serviceList);
        order.setProducts(productList);

        List<Order> fakeOrdersForSize = List.of(order, order);

        Car car = new Car();
        CarOwner carOwner = new CarOwner();
        carOwner.setOrders(fakeOrdersForSize);
        car.setCarOwner(carOwner);

        order.setCar(car);

        Mockito.when(orderService.getOrderById(orderId)).thenReturn(order);

        assertTrue(BigDecimal.valueOf(388).compareTo(orderService.calculateOrderCost(orderId).getResultCost()) == 0);
    }

    @Test
    public void calculateOrderCostWithDiscountsOneOrder_OK() {

        Service service = new Service();
        service.setId(1L);
        service.setCost(BigDecimal.valueOf(200));
        service.setServiceType(Service.ServiceType.DEFAULT);

        Service service1 = new Service();
        service1.setId(2L);
        service1.setCost(BigDecimal.valueOf(200));
        service1.setServiceType(Service.ServiceType.DEFAULT);

        List<Service> serviceList = List.of(service, service1);
        List<Product> productList = new ArrayList<>();

        Long orderId = 1L;

        Order order = new Order();
        order.setId(1L);
        order.setServices(serviceList);
        order.setProducts(productList);

        List<Order> fakeOrdersForSize = List.of(order);

        Car car = new Car();
        CarOwner carOwner = new CarOwner();
        carOwner.setOrders(fakeOrdersForSize);
        car.setCarOwner(carOwner);

        order.setCar(car);

        Mockito.when(orderService.getOrderById(orderId)).thenReturn(order);

        assertTrue(BigDecimal.valueOf(392).compareTo(orderService.calculateOrderCost(orderId).getResultCost()) == 0);
    }
}