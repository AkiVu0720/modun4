package com.ra.repository;

import com.ra.model.AccountModel;
import com.ra.model.CategoryModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface AccountRepository extends JpaRepository<AccountModel,Integer> {
    @Query("select a from AccountModel a where a.email like %?1%")
    Page<AccountModel> findByEmail(String email , Pageable pageable);
    AccountModel findByUserNameAndPassword(String userName, String password);
    int countByEmailContains(String email);
    @Query("select  count (*)  from AccountModel a where a.accStatus=true ")
    int findByAccStatusTrue();
    @Query("select  count (*)  from AccountModel a where a.accStatus=false ")
    int findByAccStatusFalse();
    @Transactional
    @Modifying
    @Query(value = "update account a set a.acc_status = ?2 where a.acc_id=?1",nativeQuery = true)
    void setStatus(int accId, boolean status);
}
