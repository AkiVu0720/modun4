package com.ra.model;

import javax.persistence.*;

@Entity
@Table(name = "bill_detail")
public class BillDetailModel {
    @Id
    @Column(name = "billDetail_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int billDetailId;
    @Column(name = "import_price")
    private float importPrice;
    @Column(name = "quantity")
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "bill_id",referencedColumnName = "bill_id")
    private BillModel bill;
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private ProductModel product;

    //Get, Set

    /**
     *
     * @return
     */
    public int getBillDetailId() {
        return billDetailId;
    }

    public void setBillDetailId(int billDetailId) {
        this.billDetailId = billDetailId;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

//    public double getIntoMoney() {
//        return intoMoney;
//    }
//
//    public void setIntoMoney(double intoMoney) {
//        this.intoMoney = intoMoney;
//    }

    public BillModel getBill() {
        return bill;
    }

    public void setBill(BillModel bill) {
        this.bill = bill;
    }

    public ProductModel getProduct() {
        return product;
    }

    public void setProduct(ProductModel product) {
        this.product = product;
    }

    //Constructor

    /**
     * Constructor init object
     */
    public BillDetailModel() {
    }

    public BillDetailModel(int billDetailId, float importPrice, int quantity, BillModel bill, ProductModel product) {
        this.billDetailId = billDetailId;
        this.importPrice = importPrice;
        this.quantity = quantity;
//        this.intoMoney = intoMoney;
        this.bill = bill;
        this.product = product;
    }
}
