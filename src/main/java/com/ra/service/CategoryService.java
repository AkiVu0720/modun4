package com.ra.service;

import com.ra.model.CategoryModel;
import java.util.List;

public interface CategoryService {
    List<CategoryModel> displayData(String categoryName, int page, int size,String direction,String sortBy);
    List<Integer>getListPage(String categoryName, int size);
    List<CategoryModel> findAll();
    CategoryModel findById(int categoryId);
    boolean save0rUpdate(CategoryModel category);
    boolean delete(int categoryId);
}
