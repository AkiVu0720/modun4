package com.ra.serviceImp;

import com.ra.model.CategoryModel;
import com.ra.repository.CategoryRepository;
import com.ra.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;
@Service
public class CategoryServiceImp implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public List<CategoryModel> displayData(String categoryName, int page, int size, String direction, String sortBy) {
      Pageable pageable = PageRequest.of(page,size,direction.equals("ASC")? Sort.Direction.ASC: Sort.Direction.DESC,sortBy);
        List<CategoryModel> categoryList = categoryRepository.findByCategoryName(categoryName,pageable).getContent();
        return categoryList;
    }


    @Override
    public List<Integer> getListPage(String categoryName, int size) {
        int countCategory= categoryRepository.countByCategoryNameContains(categoryName);
        List<Integer> listPage = new ArrayList<>();
        for (int i = 0; i < (int)Math.ceil((double) countCategory/(double) size); i++) {
            listPage.add(i+1);
        }
        return listPage;
    }

    @Override
    public List<CategoryModel> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public CategoryModel findById(int categoryId) {
        return categoryRepository.findById(categoryId).get();
    }

    @Override
    public boolean save0rUpdate(CategoryModel category) {
        try {
            categoryRepository.save(category);
            return true;
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int categoryId) {
        try {
            categoryRepository.delete(findById(categoryId));
            return true;
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean setStatus(int categoryId, boolean status) {
        try {
            categoryRepository.setStatus(categoryId, status);
            return  true;
        } catch (Exception e){
            e.printStackTrace();
            return  false;
        }

    }
}
