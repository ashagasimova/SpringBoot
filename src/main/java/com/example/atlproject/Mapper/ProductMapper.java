package com.example.atlproject.Mapper;

import com.example.atlproject.Dto.ProductResponseDto;
import com.example.atlproject.Dto.ProductResponseDtoGroupBy;
import com.example.atlproject.Dto.ProductResponseDtoPrice;
import com.example.atlproject.Dto.ProductResponseDtoPriceAndName;
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

    public List<ProductResponseDtoGroupBy> ProductEntityListToDtoGroup (List<ProductEntity> entityList) {
        List<ProductResponseDtoGroupBy> dtos2 = new ArrayList<>();
        for (ProductEntity e : entityList) {
            ProductResponseDtoGroupBy dto2 = ProductResponseDtoGroupBy.builder()
                    .product_name(e.getProduct_name())
                    .category(e.getCategory())
                    .build();
            dtos2.add(dto2);
        }

        return dtos2;
    }


    public List<ProductResponseDtoPriceAndName> ProductEntityListToDtoPrice(List<ProductEntity> entityList) {
        List<ProductResponseDtoPriceAndName> dtos3 = new ArrayList<>();
        for (ProductEntity e : entityList) {
            ProductResponseDtoPriceAndName dto3 = ProductResponseDtoPriceAndName.builder()
                    .product_name(e.getProduct_name())
                    .price(e.getPrice())
                    .build();
            dtos3.add(dto3);
        }

        return dtos3;
    }



}
