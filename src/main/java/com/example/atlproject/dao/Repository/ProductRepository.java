package com.example.atlproject.dao.Repository;


import com.example.atlproject.Dto.ProductResponseDtoGroupBy;
import com.example.atlproject.Dto.ProductResponseDtoPrice;
import com.example.atlproject.dao.Entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    @Query(value = "SELECT * FROM product WHERE price > :minPrice AND price < :maxPrice", nativeQuery = true)
    List<ProductEntity> getProductByPriceRange(@Param("minPrice") float minPrice, @Param("maxPrice") float maxPrice);


    @Query(value = "SELECT * FROM product WHERE product_name LIKE %:product_name%", nativeQuery = true)
    List<ProductEntity> getProductByProduct_name(@Param("product_name") String product_name);

    @Query(value = "select count(id) from product", nativeQuery = true)
    Long getProductCount();

    @Query(value = "select * from product where price = (select max(price) from product)", nativeQuery = true)
    ProductEntity getMaxPrice();

    @Query(value = "select avg(price) from product", nativeQuery = true)
    Long getAvgPrice();

    @Query(value = "select * from product order by product.ctreated_at desc limit 10", nativeQuery = true)
    List<ProductEntity> getDescCreated();

    @Query(value = "select count(category), product_name " +
            "from product group by category, product_name", nativeQuery = true)
    List<ProductResponseDtoGroupBy> getGroupByCategory();

    @Query(value = "select * from product", nativeQuery = true)
    List<ProductEntity> getPriceAndProduct_name ();

    @Query(value = "select * from product where ctreated_at =:ctreatedAt  ", nativeQuery = true)
    List<ProductEntity> getCreatedAt(@Param("ctreatedAt")LocalDateTime ctreatedAt);

    @Query(value = "select distinct  * from product", nativeQuery = true)
    List<ProductEntity> getDistinctProducts();

    @Query(value = "select * from product where product_name like %:product_name% and price>:price", nativeQuery = true)
    List<ProductEntity> getNameAndMaxPrice(@Param("product_name") String product_name, @Param("price") float price);









}

