package com.ra.repository;

import com.ra.model.AccountModel;
import com.ra.model.BillModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository  extends JpaRepository<BillModel, String> {
    @Query("select b from BillModel b where b.billId like %?1%")
    Page<BillModel> findByBillId(String billId , Pageable pageable);
    @Query("select  count (*) from BillModel i where i.billId like %?1%")
    int countByBillId(String billId);

   @Query("select count (*) from BillModel b where  b.billStatus=?1")
    int countBillStatus(int billStatus);
    @Query("select count (*) from BillModel b")
    int countBillAll();
}
