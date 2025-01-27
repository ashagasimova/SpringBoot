package com.example.atlproject.Service.Impl;

import com.example.atlproject.Dto.ProductRequestDto;
import com.example.atlproject.Dto.ProductResponseDto;
import com.example.atlproject.Dto.ProductResponseDtoGroupBy;
import com.example.atlproject.Dto.ProductResponseDtoPriceAndName;
import com.example.atlproject.Mapper.ProductMapper;
import com.example.atlproject.Service.ProductService;
import com.example.atlproject.dao.Entity.ProductEntity;
import com.example.atlproject.dao.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public void addProduct(ProductRequestDto dto) {
        ProductEntity productEntity = ProductEntity.builder()
                .product_name(dto.getProduct_name())
                .stock(dto.getStock())
                .price(dto.getPrice())
                .category(dto.getCategory())
                .build();
        productRepository.save(productEntity);

    }

    @Override
    public List<ProductResponseDto> getProducts (float minPrice, float maxPrice){
        List<ProductEntity> productEntities = productRepository.getProductByPriceRange(minPrice, maxPrice);
        return productMapper.ProductEntityListToDto(productEntities);
    }



    @Override
    public ProductResponseDto getProductById(Long id) {
        Optional<ProductEntity> optionalProductEntity = productRepository.findById(id);
        ProductEntity entity = ProductEntity.builder().build();
        if (optionalProductEntity.isPresent()) {
            entity = optionalProductEntity.get();
        }
        return productMapper.ProductEntityToDto(entity);
    }

    @Override
    public Long updateProduct(Long id, ProductRequestDto dto) {
        Optional<ProductEntity> optionalProductEntity = productRepository.findById(id);
        if (optionalProductEntity.isPresent()) {
            ProductEntity productEntity = optionalProductEntity.get();
//            if (dto.getProduct_name()!=null)
     //           productEntity.setProduct_name(dto.getProduct_name());

            productEntity.setProduct_name(dto.getProduct_name());
            productEntity.setCategory(dto.getCategory());
            productEntity.setStock(dto.getStock());
            productEntity.setPrice(dto.getPrice());
            productRepository.save(productEntity);

            return id;
        }

        return 0L;
    }

    @Override
    public Long deleteProduct(Long id) {
        Optional<ProductEntity> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            productRepository.deleteById(id);
            return id;
        }
        return 0L;
    }

    @Override
    public List<ProductResponseDto> getProductByName(String product_name) {
        return productMapper.ProductEntityListToDto(productRepository.getProductByProduct_name(product_name));
    }

    @Override
    public Long getProductCount() {
        return productRepository.getProductCount();
    }

    @Override
    public ProductResponseDto getMaxPrice(){
        return  productMapper.ProductEntityToDto(productRepository.getMaxPrice());
    }

    @Override
    public Long getAvgPrice() {
        return productRepository.getAvgPrice();
    }


    @Override
    public List<ProductResponseDto> getDescCreatedAt() {
        return productMapper.ProductEntityListToDto(productRepository.getDescCreated());
    }

    @Override
    public List<ProductResponseDtoGroupBy> getGroupBy() {
        var entity = productRepository.findAll();
        return productMapper.ProductEntityListToDtoGroup(entity);
    }

    @Override
    public List<ProductResponseDtoPriceAndName> getPriceAndName() {
        return productMapper.ProductEntityListToDtoPrice(productRepository.getPriceAndProduct_name());
    }

    @Override
    public List<ProductResponseDto> getCreatedAt(LocalDateTime ctreatedAt) {
        return productMapper.ProductEntityListToDto(productRepository.getCreatedAt(ctreatedAt));
    }

    @Override
    public List<ProductResponseDto> getDistinctProducts() {
        return productMapper.ProductEntityListToDto(productRepository.getDistinctProducts());
    }

    @Override
    public List<ProductResponseDto> getNameAndMaxPrice(String product_name, float price) {
        return productMapper.ProductEntityListToDto(productRepository.getNameAndMaxPrice(product_name, price));
    }
}
