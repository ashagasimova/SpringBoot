package com.example.atlproject.Service.Impl;

import com.example.atlproject.Dto.ProductRequestDto;
import com.example.atlproject.Dto.ProductResponseDto;
import com.example.atlproject.Mapper.ProductMapper;
import com.example.atlproject.Service.ProductService;
import com.example.atlproject.dao.Entity.ProductEntity;
import com.example.atlproject.dao.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
    public List<ProductResponseDto> getProducts() {
        List<ProductEntity> entity = productRepository.findAll();
         return productMapper.ProductEntityListToDto(entity);
    }

    @Override
    public ProductResponseDto getProductById(Long id) {
        Optional<ProductEntity> optionalProductEntity = productRepository.findById(id);
        ProductEntity entity = ProductEntity.builder().build();
        if (optionalProductEntity.isPresent()){
            entity = optionalProductEntity.get();
        }
        return productMapper.ProductEntityToDto(entity);
    }

    @Override
    public Long updateProduct(Long id, ProductRequestDto dto) {
        Optional<ProductEntity> optionalProductEntity = productRepository.findById(id);
        if (optionalProductEntity.isPresent()){
            ProductEntity productEntity = optionalProductEntity.get();
            productEntity.setProduct_name(dto.getProduct_name());
            productEntity.setCategory(dto.getCategory());
            productEntity.setStock(dto.getStock());
            productEntity.setPrice(dto.getPrice());
            productRepository.save(productEntity);

            return id;
        }

        return 0L;
    }
}
