package org.sniklz.autoservice.service.impl;

import java.util.List;
import java.util.Set;
import org.sniklz.autoservice.model.Product;
import org.sniklz.autoservice.repository.ProductRepository;
import org.sniklz.autoservice.service.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product save(Product model) {
        return productRepository.save(model);
    }

    @Override
    public Product update(Product model) {
        return productRepository.save(model);
    }

    @Override
    public List<Product> getProductsByIdIn(Set<Long> ids) {
        return productRepository.getProductsByIdIn(ids);
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.getReferenceById(id);
    }
}
