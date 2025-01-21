package com.example.atlproject.Service;

import com.example.atlproject.Dto.ProductRequestDto;
import com.example.atlproject.Dto.ProductResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {

    void addProduct(ProductRequestDto dto);

    List<ProductResponseDto> getProducts();

    ProductResponseDto getProductById(Long id);

    Long updateProduct(Long id, ProductRequestDto dto);
}
