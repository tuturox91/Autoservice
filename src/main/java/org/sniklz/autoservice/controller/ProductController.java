package org.sniklz.autoservice.controller;

import org.sniklz.autoservice.dto.request.ProductRequestDto;
import org.sniklz.autoservice.dto.response.ProductResponseDto;
import org.sniklz.autoservice.model.Product;
import org.sniklz.autoservice.service.ProductService;
import org.sniklz.autoservice.service.mapper.UniversalDtoMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final UniversalDtoMapper<ProductRequestDto, ProductResponseDto, Product> productMapper;
    private final ProductService productService;

    public ProductController(UniversalDtoMapper<ProductRequestDto, ProductResponseDto,
            Product> productMapper, ProductService productService) {
        this.productMapper = productMapper;
        this.productService = productService;
    }
    
    @PostMapping
    public ProductResponseDto addProduct(@RequestBody ProductRequestDto requestDto) {
        return productMapper.toDto(productService.save(productMapper.toModel(requestDto)));
    }

    @PutMapping("/{id}")
    public ProductResponseDto updateProduct(@PathVariable Long id, @RequestBody ProductRequestDto requestDto) {
        Product Product = productMapper.toModel(requestDto);
        Product.setId(id);
        return productMapper.toDto(productService.update(Product));
    }

    @GetMapping("/{id}")
    public ProductResponseDto getCarById(@PathVariable Long id) {
        return productMapper.toDto(productService.getProductById(id));
    }

}
