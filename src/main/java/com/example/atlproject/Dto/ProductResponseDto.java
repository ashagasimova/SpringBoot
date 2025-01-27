package com.example.atlproject.Dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponseDto {

    private String product_name;
    private float price;
    private String category;
    private Integer stock;
}

