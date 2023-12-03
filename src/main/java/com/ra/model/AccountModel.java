package com.ra.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "account")
public class AccountModel {
    @Id
    @Column(name ="acc_id" )
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accId;
    @Column(name = "email")
    private String email;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "password")
    private String password;
    @Column(name = "created")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date created;
    @Column(name = "permission")
    private boolean role;
    @Column(name = "acc_status")
    private boolean accStatus;
    @OneToMany(mappedBy = "account")
    private Set<BillModel> billModels;

    //Get,set

    /**
     *
     * @return
     */
    public int getAccId() {
        return accId;
    }

    public void setAccId(int accId) {
        this.accId = accId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public boolean isRole() {
        return role;
    }

    public void setRole(boolean role) {
        this.role = role;
    }

    public boolean isAccStatus() {
        return accStatus;
    }

    public void setAccStatus(boolean accStatus) {
        this.accStatus = accStatus;
    }

    public Set<BillModel> getBillModels() {
        return billModels;
    }

    public void setBillModels(Set<BillModel> billModels) {
        this.billModels = billModels;
    }

    //Constructor

    /**
     * Constructor init object
     */
    public AccountModel() {
    }

    public AccountModel(int accId, String email, String password, Date created, boolean role, boolean accStatus, Set<BillModel> billModels) {
        this.accId = accId;
        this.email = email;
        this.password = password;
        this.created = created;
        this.role = role;
        this.accStatus = accStatus;
        this.billModels = billModels;
    }
}
