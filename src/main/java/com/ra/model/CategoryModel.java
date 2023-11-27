package com.ra.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "category")
public class CategoryModel {
    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;
    @Column(name = "category_name")
    private String categoryName;
    @Column(name = "category_description")
    private String description;
    @Column(name = "category_status")
    private boolean categoryStatus;
    @OneToMany(mappedBy = "category")
    private Set<ProductModel> productModelList;

    // Get,Set
    /**
     *
     * @return
     */
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCategoryStatus() {
        return categoryStatus;
    }

    public void setCategoryStatus(boolean categoryStatus) {
        this.categoryStatus = categoryStatus;
    }

    public Set<ProductModel> getProductModelList() {
        return productModelList;
    }

    public void setProductModelList(Set<ProductModel> productModelList) {
        this.productModelList = productModelList;
    }

    // Constructor
    /**
     * Constructor init object
     */

    public CategoryModel() {
    }

    public CategoryModel(int categoryId, String categoryName, String description, boolean categoryStatus, Set<ProductModel> productModelList) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.description = description;
        this.categoryStatus = categoryStatus;
        this.productModelList = productModelList;
    }
}
