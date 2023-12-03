package com.ra.serviceImp;

import com.ra.model.AccountModel;
import com.ra.model.CategoryModel;
import com.ra.repository.AccountRepository;
import com.ra.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class AccountServiceImp implements AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Override
    public List<AccountModel> displayData(String email, int page, int size, String direction, String sortBy) {
        Pageable pageable = PageRequest.of(page,size,direction.equals("ASC")? Sort.Direction.ASC: Sort.Direction.DESC,sortBy);
        List<AccountModel> accountlList = accountRepository.findByEmail(email,pageable).getContent();
        return accountlList;
    }

    @Override
    public List<Integer> getListPage(String email, int size) {
        int countEmail= accountRepository.countByEmailContains(email);
        List<Integer> listPage = new ArrayList<>();
        for (int i = 0; i < (int)Math.ceil((double) countEmail/(double) size); i++) {
            listPage.add(i+1);
        }
        return listPage;
    }

    @Override
    public List<AccountModel> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public AccountModel findById(int accId) {
        return accountRepository.findById(accId).get();
    }

    @Override
    public boolean save0rUpdate(AccountModel account) {
        try {
            accountRepository.save(account);
            return true;
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int accId) {
        try {
            accountRepository.delete(findById(accId));
            return true;
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }
    public int accStatusTrue(){
       return accountRepository.findByAccStatusTrue();

    }

    @Override
    public int accStatusFalse() {
        return  accountRepository.findByAccStatusFalse();
    }

    @Override
    public boolean findByUserNameAndPassword(String userName, String password) {
        try {
        AccountModel accLogin = accountRepository.findByUserNameAndPassword(userName,password);

        if (accLogin!=null){
            return accLogin.isRole();
        }
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    @Override
    public boolean accStatus(int accId, boolean accStatus) {
        try {
            accountRepository.setStatus(accId, !accStatus);
            return  true;
        } catch (Exception e){
            e.printStackTrace();
            return  false;
        }
    }

}
