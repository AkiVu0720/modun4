package com.ra.service;

import com.ra.model.CategoryModel;
import com.ra.model.ProductModel;

import java.util.List;

public interface ProductService {
    List<ProductModel> displayData(String productName, int page, int size, String direction, String sortBy);
    List<Integer>getListPage(String productName, int size);

    ProductModel findById(String productId);
    ProductModel save0rUpdate(ProductModel productModel);
    boolean delete(String productId);
    List<ProductModel> findAll();
    int productStatusTrue();
    int productStatusFalse();
    boolean productStatus(String productId);
}
