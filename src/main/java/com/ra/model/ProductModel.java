package com.ra.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "product")
public class ProductModel {
    @Id
    @Column(name = "product_id")
    private String productId;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "price")
    private float price;
    @Column(name = "created")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date productCreated;
    @Column(name = "tittle")
    private String tittle;
    @Column(name = "productDescription")
    private String description;
    @Column(name = "product_image")
    private String image;
    @Column(name = "product_unit")
    private String productUnit;
    @Column(name = "product_status")
    private boolean productStatus;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryModel category;
    @OneToMany(mappedBy = "product")
    private List<ImageProductModel> imageList;
    @OneToMany(mappedBy = "product")
    private List<BillDetailModel>billDetailModels;

    // Get, Set

    /**
     *
     * @return
     */
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getProductUnit() {
        return productUnit;
    }

    public void setProductUnit(String productUnit) {
        this.productUnit = productUnit;
    }

    public boolean isProductStatus() {
        return productStatus;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }

    public CategoryModel getCategory() {
        return category;
    }

    public void setCategory(CategoryModel category) {
        this.category = category;
    }

    public List<ImageProductModel> getImageList() {
        return imageList;
    }

    public void setImageList(List<ImageProductModel> imageList) {
        this.imageList = imageList;
    }

    public List<BillDetailModel> getBillDetailModels() {
        return billDetailModels;
    }

    public void setBillDetailModels(List<BillDetailModel> billDetailModels) {
        this.billDetailModels = billDetailModels;
    }

    public Date getProductCreated() {
        return productCreated;
    }

    public void setProductCreated(Date productCreated) {
        this.productCreated = productCreated;
    }

    //Constructor

    /**
     * Constructor init object
     */
    public ProductModel() {
    }

    public ProductModel(String productId, String productName, float price, String tittle, String description, String image, String productUnit, boolean productStatus, CategoryModel category, List<ImageProductModel> imageList, List<BillDetailModel> billDetailModels) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.tittle = tittle;
        this.description = description;
        this.image = image;
        this.productUnit = productUnit;
        this.productStatus = productStatus;
        this.category = category;
        this.imageList = imageList;
        this.billDetailModels = billDetailModels;
    }
}
