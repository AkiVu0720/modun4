package com.ra.controller;

import com.ra.model.AccountModel;
import com.ra.model.BillDetailModel;
import com.ra.model.BillModel;
import com.ra.model.CategoryModel;
import com.ra.service.BillDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("billDetai")
public class BillDetailController {
    @Autowired
    private BillDetailService billDetailService;
    private static  final int SIZE = 5;
    private static String billIdDefault = "";
    private static int billIdDefault1 = 1 ;
    private static String directionDefault = "ASC";
    private static String sortByDefault = "billDetailId";
    private static int pageDefault = 1;
    @GetMapping("findBill")
    public ModelAndView displayBillDetail(Optional<String> billId, Optional<Integer>page,
                                    Optional<String>direction, Optional<String>sortBy, Optional<Integer>billId1){
        ModelAndView mav = new ModelAndView("bill");
        billIdDefault = billId.orElse(billIdDefault);
        billIdDefault1 = billId1.orElse(billIdDefault1);
        directionDefault = direction.orElse(directionDefault);
        sortByDefault = sortBy.orElse(sortByDefault);
        pageDefault = page.orElse(pageDefault);
        List<BillDetailModel> billDetailModelList = billDetailService.displayData(billIdDefault,
                pageDefault-1,SIZE,directionDefault, sortByDefault);
        List<BillDetailModel> newList = billDetailModelList.stream().distinct().collect(Collectors.toList());
        //Lấy danh sách các trang theo kết quả.
        List<Integer>listPage = billDetailService.getListPage(billIdDefault,SIZE);
        mav.addObject("listBillDetail", newList);
        mav.addObject("listPage", listPage);
        mav.addObject("billId",billIdDefault);
        mav.addObject("sortBy",sortByDefault);
        mav.addObject("direction", directionDefault);
        return  mav;
    }
    @GetMapping("initUpdate")
    public String initUploadCategory(ModelMap modelMap, int billDetailId){
        BillDetailModel billEdit= billDetailService.findByDetailId(billDetailId);
        modelMap.addAttribute("editBill",billEdit);
        return "billdateil-update";
    }
    @PostMapping(value = "update")
    public String save0rUpdate(BillModel editBill, BillDetailModel editBillDetail ){
        String billDetailId = editBillDetail.getBill().getBillId();
        boolean result = billDetailService.save0rUpdate(editBillDetail);
        if (result){
            return "redirect:../bill/initUpdate?billId="+billDetailId;
        }else {
            return "404";
        }
    }
    @GetMapping(value = "delete")
    public String delete(int billDetailId){
        boolean result = billDetailService.delete(billDetailId);
        if (result){
            return "bill-update";
        }else {
            return "404";
        }
    }
}
