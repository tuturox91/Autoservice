package org.sniklz.autoservice.service.impl;

import org.sniklz.autoservice.model.Order;
import org.sniklz.autoservice.model.Product;
import org.sniklz.autoservice.repository.CarOwnerRepository;
import org.sniklz.autoservice.repository.MasterRepository;
import org.sniklz.autoservice.repository.OrderRepository;
import org.sniklz.autoservice.repository.ProductRepository;
import org.sniklz.autoservice.service.OrderService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final MasterRepository masterRepository;

    private final ProductRepository productRepository;

    private final CarOwnerRepository ownerRepository;

    public OrderServiceImpl(OrderRepository orderRepository,
                            MasterRepository masterRepository,
                            ProductRepository productRepository, CarOwnerRepository ownerRepository) {
        this.orderRepository = orderRepository;
        this.masterRepository = masterRepository;
        this.productRepository = productRepository;
        this.ownerRepository = ownerRepository;
    }


    @Override
    public Order save(Order model) {
        return orderRepository.save(model);
    }

    @Override
    public Order update(Order model) {
        Order updatedOrder = orderRepository.getReferenceById(model.getId());
        updatedOrder.setCar(model.getCar());
        updatedOrder.setDescription(model.getDescription());
        updatedOrder.setServices(model.getServices());
        updatedOrder.setProducts(model.getProducts());
        return orderRepository.save(updatedOrder);
    }

    @Override
    public List<Order> getOrdersByMasterId(Long masterId) {
        return masterRepository.getReferenceById(masterId).getCompletedOrders();
    }

    @Override
    public List<Order> getOrdersByCarOwnersId(Long ownerId) {
        return ownerRepository.getReferenceById(ownerId).getOrders();
    }

    @Override
    public Order addServiceToOrder(Long orderId, Long productId) {
        Order order = orderRepository.getReferenceById(orderId);
        Product product = productRepository.getReferenceById(productId);
        Set<Product> products = new HashSet<>(order.getProducts());
        products.add(product);
        order.setProducts(new ArrayList<>(products));
        save(order);
        return order;
    }

    @Override
    public Order changeOrderStatus(Long id, String orderStatus) {
        Order.OrderStatus status = Order.OrderStatus.valueOf(orderStatus.toUpperCase());
        Order order = getOrderById(id);
        order.setOrderStatus(status);
        return save(order);
    }

    @Override
    public List<Order> getOrdersByIdIn(Set<Long> ids) {
        return orderRepository.getOrdersByIdIn(ids);
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.getReferenceById(id);
    }

    @Override
    public Order calculateOrderCost(Long orderId) {
        Order order = getOrderById(orderId);
        BigDecimal orderSize = BigDecimal.valueOf(order.getCar().getCarOwner().getOrders().size());
        BigDecimal result = BigDecimal.ZERO;
        result = result.add(calculateServiceCost(order.getServices(), orderSize));
        result = result.add(calculateProductCost(order.getProducts(), orderSize));
        order.setResultCost(result);
        order.setCompleteTime(LocalDateTime.now());
        save(order);
        return order;
    }

    BigDecimal calculateServiceCost(List<org.sniklz.autoservice.model.Service> services, BigDecimal orderSize) {
        BigDecimal serviceDiscountCost = orderSize.multiply(BigDecimal.valueOf(0.02));
        if(services.size() > 1) {
            services.stream().filter(service -> service.getServiceType().equals(org.sniklz.autoservice.model.Service.ServiceType.DIAGNOSTIC))
                    .forEach(service -> service.setCost(BigDecimal.ZERO));
        }
        BigDecimal resulCost = services.stream().map(service -> service.getCost())
                .map(cost -> cost.subtract(cost.multiply(serviceDiscountCost)))
                .reduce(BigDecimal.ZERO, (x, y) -> x.add(y));
        return resulCost;
    }

    BigDecimal calculateProductCost(List<Product> products, BigDecimal orderSize) {
        BigDecimal productDiscountCost = orderSize.multiply(BigDecimal.valueOf(0.01));
        BigDecimal resultCost = products.stream().map(product -> product.getCost())
                .map(cost -> cost.subtract(cost.multiply(productDiscountCost)))
                .reduce(BigDecimal.ZERO, (x, y) -> x.add(y));
        return resultCost;
    }
}
