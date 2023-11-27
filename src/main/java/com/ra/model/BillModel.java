package com.ra.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "bill")
public class BillModel {
    @Id
    @Column(name = "bill_id")
    private String billId;
    @Column(name = "created")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date created;
    @Column(name = "bill_status")
    private int billStatus;
    @ManyToOne
    @JoinColumn(name = "accId")
    private AccountModel account;
    @OneToMany(mappedBy = "bill")
    private List<BillDetailModel> billDetailModels;

    //Get, Set
    /**
     *
     * @return
     */
    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public int getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(int billStatus) {
        this.billStatus = billStatus;
    }

    public AccountModel getAccount() {
        return account;
    }

    public void setAccount(AccountModel account) {
        this.account = account;
    }

    public List<BillDetailModel> getBillDetailModels() {
        return billDetailModels;
    }

    public void setBillDetailModels(List<BillDetailModel> billDetailModels) {
        this.billDetailModels = billDetailModels;
    }

    //Constructor

    /**
     * Constructor init object
     */
    public BillModel() {
    }
    public BillModel(String billId, Date created, int billStatus, AccountModel account, List<BillDetailModel> billDetailModels) {
        this.billId = billId;
        this.created = created;
        this.billStatus = billStatus;
        this.account = account;
        this.billDetailModels = billDetailModels;
    }
}
