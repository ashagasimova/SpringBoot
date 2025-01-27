package com.example.atlproject.Service;

import com.example.atlproject.Dto.ProductRequestDto;
import com.example.atlproject.Dto.ProductResponseDto;
import com.example.atlproject.Dto.ProductResponseDtoGroupBy;
import com.example.atlproject.Dto.ProductResponseDtoPriceAndName;

import java.time.LocalDateTime;
import java.util.List;

public interface ProductService {

    void addProduct(ProductRequestDto dto);

    List<ProductResponseDto> getProducts(float minPrice, float maxPrice);

    ProductResponseDto getProductById(Long id);

    Long updateProduct(Long id, ProductRequestDto dto);

    Long deleteProduct (Long id);

    List<ProductResponseDto> getProductByName(String product_name);

    Long getProductCount();

    ProductResponseDto getMaxPrice();

    Long getAvgPrice();

    List<ProductResponseDto> getDescCreatedAt();

    List<ProductResponseDtoGroupBy> getGroupBy();

    List<ProductResponseDtoPriceAndName> getPriceAndName();

    List<ProductResponseDto> getCreatedAt(LocalDateTime ctreatedAt);

    List<ProductResponseDto> getDistinctProducts();

    List<ProductResponseDto> getNameAndMaxPrice(String product_name, float price);


}
