package org.sniklz.autoservice.service;

import java.util.List;
import java.util.Set;
import org.sniklz.autoservice.model.Order;

public interface OrderService extends DefaultService<Order> {

    List<Order> getOrdersByMasterId(Long masterId);

    List<Order> getOrdersByCarOwnersId(Long ownerId);

    Order addServiceToOrder(Long id, Long productId);

    Order changeOrderStatus(Long id, String orderStatus);

    List<Order> getOrdersByIdIn(Set<Long> ids);

    Order getOrderById(Long id);

    Order calculateOrderCost(Long orderId);
}
