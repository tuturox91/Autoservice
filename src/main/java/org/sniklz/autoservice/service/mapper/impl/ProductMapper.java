package org.sniklz.autoservice.service.mapper.impl;

import org.sniklz.autoservice.dto.request.ProductRequestDto;
import org.sniklz.autoservice.dto.response.ProductResponseDto;
import org.sniklz.autoservice.model.Product;
import org.sniklz.autoservice.service.mapper.UniversalDtoMapper;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper implements
        UniversalDtoMapper<ProductRequestDto, ProductResponseDto, Product> {
    @Override
    public Product toModel(ProductRequestDto requestDto) {
        Product product =  new Product();
        product.setCost(requestDto.getCost());
        product.setName(requestDto.getName());
        return product;
    }

    @Override
    public ProductResponseDto toDto(Product model) {
        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setId(model.getId());
        productResponseDto.setName(model.getName());
        productResponseDto.setCost(model.getCost());
        return productResponseDto;
    }
}
