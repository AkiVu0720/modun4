package com.ra.repository;

import com.ra.model.CategoryModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryModel, Integer> {
    @Query("select c from CategoryModel c where c.categoryName like %?1%")
    Page<CategoryModel> findByCategoryName(String categoryName, Pageable pageable);
    int countByCategoryNameContains(String categoryName);
}
