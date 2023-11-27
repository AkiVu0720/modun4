package com.ra.serviceImp;

import com.ra.model.ProductModel;
import com.ra.repository.ProductRepository;
import com.ra.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImp implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<ProductModel> displayData(String productName, int page, int size, String direction, String sortBy) {
        Pageable pageable = PageRequest.of(page,size,direction.equals("ASC")? Sort.Direction.ASC: Sort.Direction.DESC,sortBy);
        List<ProductModel> productModelList = productRepository.findByProductNameContaining(productName,pageable).getContent();
        return productModelList;
    }

    @Override
    public List<Integer> getListPage(String productName, int size) {
        int productPage = productRepository.countByProductNameContains(productName);
        List<Integer> listPage = new ArrayList<>();
        for (int i = 0; i < (int) Math.ceil((double)productPage/(double) size); i++) {
            listPage.add(i+1);
        }
        return listPage;
    }

    @Override
    public ProductModel findById(String productId) {
        return productRepository.findById(productId).get();
    }

    @Override
    public ProductModel save0rUpdate(ProductModel productModel) {
        try {
            ProductModel productNew = productRepository.save(productModel);
            return productNew;
        } catch (Exception ex){
            return null;
        }
    }

    @Override
    public boolean delete(String productId) {
        try {
            productRepository.delete(findById(productId));
            return true;
        } catch (Exception ex){
            return false;
        }
    }

    @Override
    public List<ProductModel> findAll() {
        return productRepository.findAll();
    }

    @Override
    public int productStatusTrue() {
        return productRepository.countByProductStatusTrue();
    }

    @Override
    public int productStatusFalse() {
        return productRepository.countByProductStatusFalse();
    }

    @Override
    public boolean productStatus(String productId) {
        return productRepository.productStatus(productId);
    }
}
