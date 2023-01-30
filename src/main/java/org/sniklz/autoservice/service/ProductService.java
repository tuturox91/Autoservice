package org.sniklz.autoservice.service;

import org.sniklz.autoservice.model.Product;

import java.util.List;
import java.util.Set;

public interface ProductService extends DefaultService<Product> {
    List<Product> getProductsByIdIn(Set<Long> ids);

    Product getProductById(Long id);
}
