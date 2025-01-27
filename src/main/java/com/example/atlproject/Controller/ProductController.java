package com.example.atlproject.Controller;

import com.example.atlproject.Dto.*;
import com.example.atlproject.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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

    @GetMapping("{id}")
    public ProductResponseDto getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }

    @PutMapping("/update/{id}")
    public Long updateProduct(@PathVariable Long id, @RequestBody ProductRequestDto dto){
       return  productService.updateProduct(id, dto);
    }

    @DeleteMapping("delete/{id}")
    public Long deleteProduct(@PathVariable Long id){
        return productService.deleteProduct(id);

    }

    @GetMapping("get")
    public List<ProductResponseDto> getProductByPrice(@RequestParam("minPrice") float minPrice,
                                                      @RequestParam ("maxPrice") float maxPrice) {
        return productService.getProducts(minPrice, maxPrice);
    }

    @GetMapping("search")
    public List<ProductResponseDto> getProductsByName(@RequestParam(value = "product_name", required = false)
                                                          String product_name){
        return productService.getProductByName(product_name);
    }

    @GetMapping("count")
    public Long getProductCount(){
        return productService.getProductCount();
    }

    @GetMapping("maxPrice")
    public ProductResponseDto getMaxPrice(){
        return productService.getMaxPrice();
    }

    @GetMapping("avg")
    public Long getAvgPrice(){
        return productService.getAvgPrice();
    }

   @GetMapping("desc")
    public List<ProductResponseDto> getDescCreatedAt(){
       return productService.getDescCreatedAt();
   }

   @GetMapping("groupBy")
    public List<ProductResponseDtoGroupBy> getGroupBy(){
        return productService.getGroupBy();
   }

   @GetMapping("priceAndName")
    public List<ProductResponseDtoPriceAndName> getPriceAndName(){
        return productService.getPriceAndName();
   }

   @GetMapping("createdAt")
    public List<ProductResponseDto> getCreatedAt(@RequestParam(value = "ctreatedAt", required = false)
                                                    LocalDateTime ctreatedAt){
        return productService.getCreatedAt(ctreatedAt);
   }

   @GetMapping("distinct")
   public List<ProductResponseDto> getDistinctProducts(){
        return productService.getDistinctProducts();
   }

   @GetMapping("namePrice")
    public List<ProductResponseDto> getNameAndMaxPrice (@RequestParam("product_name") String product_name,
                                                  @RequestParam("price") float price){
        return productService.getNameAndMaxPrice(product_name,price);
   }


}



