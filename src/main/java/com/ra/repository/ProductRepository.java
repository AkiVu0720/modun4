package com.ra.repository;

import com.ra.model.ProductModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, String> {
    @Query ("select p from ProductModel p where p.productName like %?1% and p.productStatus=true ")
    Page<ProductModel> findByProductNameContaining(String productName,Pageable pageable);
    int countByProductNameContains(String productName);
    @Query("select count (*) from ProductModel p where p.productStatus=false ")
    int countByProductStatusFalse();
    @Query("select count (*) from ProductModel p where p.productStatus=true ")
    int countByProductStatusTrue();
    @Query("update ProductModel p set p.productStatus=false where p.productId like ?1")
    boolean setProductStatus (String productId);
    @Query("select p from ProductModel p where p.image like ?1")
    ProductModel findByImage(String imageUrl);

}
