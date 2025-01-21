package com.example.atlproject.Controller;

import com.example.atlproject.Dto.ProductRequestDto;
import com.example.atlproject.Dto.ProductResponseDto;
import com.example.atlproject.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public void addProduct(@RequestBody ProductRequestDto dto){
        productService.addProduct(dto);
    }
@GetMapping
    public List<ProductResponseDto> getProducts (){
        return productService.getProducts();
    }

    @GetMapping("{id}")
    public ProductResponseDto getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }

    @PutMapping("/update/{id}")
    public Long updateProduct(@PathVariable Long id, @RequestBody ProductRequestDto dto){
       return  productService.updateProduct(id, dto);
    }
}
