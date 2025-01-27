package com.example.atlproject.Dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProductResponseDtoGroupBy {

    private String product_name;

    private Integer count;

    private String category;
}
