package com.ra.repository;

import com.ra.model.CategoryModel;
import com.ra.model.ImageProductModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<ImageProductModel, Integer> {
    @Query("select i from ImageProductModel i where i.product.productName like %?1%")
    Page<ImageProductModel> findByImageProductName( String productName, Pageable pageable);
    @Query("select  count (*) from ImageProductModel i where i.product.productName like %?1%")
    int countByProductName(String productName);
    @Query("select i from ImageProductModel i where i.product.productId like ?1")
    List<ImageProductModel> findByProductId (String productId);
    @Query("select i from ImageProductModel i where i.product.image = ?1")
    ImageProductModel findByImageUrl(String imageUrl);

}
