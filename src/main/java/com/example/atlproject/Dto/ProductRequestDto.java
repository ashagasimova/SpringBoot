package com.example.atlproject.Dto;

import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductRequestDto {

    private String product_name;
    private float price;
    private String category;
    private Integer stock;
}
