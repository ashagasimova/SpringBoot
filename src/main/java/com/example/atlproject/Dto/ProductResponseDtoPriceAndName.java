package com.example.atlproject.Dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProductResponseDtoPriceAndName {

    private String product_name;
    private float price;
}
