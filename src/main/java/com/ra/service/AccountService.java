package com.ra.service;

import com.ra.model.AccountModel;
import com.ra.model.CategoryModel;

import java.util.List;

public interface AccountService {
    List<AccountModel> displayData(String userName, int page, int size, String direction,String sortBy);
    List<Integer>getListPage(String email, int size);
    List<AccountModel> findAll();
    AccountModel findById(int accId);
    boolean save0rUpdate(AccountModel accountModel);
    boolean delete(int accId);
    int accStatusTrue();
    int accStatusFalse();
}
