package com.ra.serviceImp;

import com.ra.model.AccountModel;
import com.ra.model.BillModel;
import com.ra.repository.BillRepository;
import com.ra.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class BillServiceImp implements BillService {
    @Autowired
    private BillRepository billRepository;
    @Override
    public List<BillModel> displayData(String billId, int page, int size, String direction, String sortBy) {
        Pageable pageable = PageRequest.of(page,size,direction.equals("ASC")? Sort.Direction.ASC: Sort.Direction.DESC,sortBy);
        List<BillModel> billList = billRepository.findByBillId(billId,pageable).getContent();

        return billList;
    }

    @Override
    public List<Integer> getListPage(String billId, int size) {
        int countBill= billRepository.countByBillId(billId);
        List<Integer> listPage = new ArrayList<>();
        for (int i = 0; i < (int)Math.ceil((double) countBill/(double) size); i++) {
            listPage.add(i+1);
        }
        return listPage;
    }

    @Override
    public List<BillModel> findAll() {
        return billRepository.findAll();
    }

    @Override
    public BillModel findById(String billId) {
        return billRepository.findById(billId).get();
    }

    @Override
    public boolean save0rUpdate(BillModel billModel) {
        try {
            billRepository.save(billModel);
            return true;
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(String biiId) {
        try {
            billRepository.delete(findById(biiId));
            return true;
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public int billStatus(int billStatus) {
        return billRepository.countBillStatus(billStatus);
    }

    @Override
    public int billAll() {
        return billRepository.countBillAll();
    }
}
