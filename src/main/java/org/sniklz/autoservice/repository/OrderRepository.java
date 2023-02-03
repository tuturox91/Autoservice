package org.sniklz.autoservice.repository;

import java.util.List;
import java.util.Set;
import org.sniklz.autoservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> getOrdersByIdIn(Set<Long> id);
}
