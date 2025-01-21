package com.example.atlproject.Mapper;

import com.example.atlproject.Dto.ProductResponseDto;
import com.example.atlproject.dao.Entity.ProductEntity;
import org.springframework.jdbc.datasource.JdbcTransactionObjectSupport;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductMapper {

    public List<ProductResponseDto> ProductEntityListToDto (List<ProductEntity> entityList){
        List<ProductResponseDto> dtos = new ArrayList<>();
        for (ProductEntity e: entityList){
            ProductResponseDto dto = ProductResponseDto.builder()
                    .product_name(e.getProduct_name())
                    .price(e.getPrice())
                    .stock(e.getStock())
                    .category(e.getCategory())
                    .build();
            dtos.add(dto);
        }

        return dtos;
    }

    public ProductResponseDto ProductEntityToDto(ProductEntity e){
        ProductResponseDto dto = ProductResponseDto.builder()
                .product_name(e.getProduct_name())
                .category(e.getCategory())
                .stock(e.getStock())
                .price(e.getPrice())
                .build();

        return dto;
    }

}
