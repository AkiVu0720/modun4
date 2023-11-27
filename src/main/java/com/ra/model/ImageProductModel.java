package com.ra.model;

import javax.persistence.*;

@Entity
@Table(name = "imageProduct")
public class ImageProductModel {
    @Id
    @Column(name = "image_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int imageId;
    @Column(name = "image_url")
    private String imageUrl;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductModel product;

    //Get, Set

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public ProductModel getProduct() {
        return product;
    }

    public void setProduct(ProductModel product) {
        this.product = product;
    }

    // Constructor

    /**
     * Constructor init object
     */
    public ImageProductModel() {
    }
    public ImageProductModel(int imageId, String imageUrl, ProductModel product) {
        this.imageId = imageId;
        this.imageUrl = imageUrl;
        this.product = product;
    }
}
