package org.sniklz.autoservice.repository;

import java.util.List;
import java.util.Set;
import org.sniklz.autoservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> getProductsByIdIn(Set<Long> ids);
}
