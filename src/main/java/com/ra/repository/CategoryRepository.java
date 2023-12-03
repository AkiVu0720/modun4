package com.ra.repository;

import com.ra.model.CategoryModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryModel, Integer> {
    @Query("select c from CategoryModel c where c.categoryName like %?1%")
    Page<CategoryModel> findByCategoryName(String categoryName, Pageable pageable);
    int countByCategoryNameContains(String categoryName);
    @Transactional
    @Modifying
    @Query(value = "update category c set c.category_status = ?2 where c.category_id=?1",nativeQuery = true)
    void setStatus(int categoryId, boolean status);
}
