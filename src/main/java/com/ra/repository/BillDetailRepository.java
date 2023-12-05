package com.ra.repository;

import com.ra.model.BillDetailModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface BillDetailRepository extends JpaRepository<BillDetailModel,Integer> {
    @Query("select bd from BillDetailModel bd inner join BillModel b on bd.bill.billId = b.billId where b.billId like %?1%")
    Page<BillDetailModel> findByBillDetailId(String billId, Pageable pageable );
    @Query("select count (*) from BillDetailModel b where b.bill.billId like %?1%")
    int countByBill_BillId(String billId);
    @Query("select bd from BillDetailModel bd inner join BillModel b on bd.bill.billId = b.billId where b.billId like %?1%")
    List<BillDetailModel>findBillDetailModelByBill_BillId(String billId);
    @Query("select sum(b.importPrice*b.quantity) from BillDetailModel b where b.bill.billId like ?1")
    Float sumBill(String billId );
    @Query( value = "select COALESCE(sum(bd.import_price*bd.quantity),0) from (bill_detail bd inner join bill b on bd.bill_id = b.bill_id) where b.bill_status = 3 AND   b.created = CURRENT_DATE()",nativeQuery = true)
    float sumInDay();

    @Query( value = "select sum(bd.import_price*bd.quantity) from (bill_detail bd inner join bill b on bd.bill_id = b.bill_id) where b.bill_status = 3 AND  MONTH(b.created) = MONTH(CURRENT_DATE())",nativeQuery = true)
    float sumInMonth();
    @Query( value = "select sum(bd.import_price*bd.quantity) from (bill_detail bd inner join bill b on bd.bill_id = b.bill_id) where b.bill_status = 3 AND  YEAR(b.created) = YEAR(CURRENT_DATE())",nativeQuery = true)
    float sumInYear();
}
