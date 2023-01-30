package org.sniklz.autoservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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
    @Operation(description = "Add product")
    public ProductResponseDto addProduct(@RequestBody ProductRequestDto requestDto) {
        return productMapper.toDto(productService.save(productMapper.toModel(requestDto)));
    }

    @PutMapping("/{id}")
    @Operation (description = "Update product")
    public ProductResponseDto updateProduct(
            @Parameter(description = "Product id")
            @PathVariable Long id, @RequestBody ProductRequestDto requestDto) {
        Product product = productMapper.toModel(requestDto);
        product.setId(id);
        return productMapper.toDto(productService.update(product));
    }

    @GetMapping("/{id}")
    @Operation (description = "Get product by id")
    public ProductResponseDto getProductById(
            @Parameter(description = "Product id")
            @PathVariable Long id) {
        return productMapper.toDto(productService.getProductById(id));
    }

}
