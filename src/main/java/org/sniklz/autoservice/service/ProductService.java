package org.sniklz.autoservice.service;

import java.util.List;
import java.util.Set;
import org.sniklz.autoservice.model.Product;

public interface ProductService extends DefaultService<Product> {
    List<Product> getProductsByIdIn(Set<Long> ids);

    Product getProductById(Long id);
}
