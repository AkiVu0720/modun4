package com.ra.controller;

import com.ra.model.AccountModel;
import com.ra.model.CategoryModel;
import com.ra.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("userManage")
public class AccController {
    @Autowired
    private AccountService accountService;
    private static  final int SIZE = 5;
    private static String emailDefault = "";
    private static String directionDefault = "ASC";
    private static String sortByDefault = "accId";
    private static int pageDefault = 1;
    @GetMapping("findUser")
    public ModelAndView displayUser(Optional<String> email, Optional<Integer>page,
                                        Optional<String>direction, Optional<String>sortBy, Optional<Boolean>sortRole){
        ModelAndView mav = new ModelAndView("user1");
        emailDefault = email.orElse(emailDefault);
        directionDefault = direction.orElse(directionDefault);
        sortByDefault = sortBy.orElse(sortByDefault);
        pageDefault = page.orElse(pageDefault);
        List<AccountModel> accountList = accountService.displayData(emailDefault,
                pageDefault-1,SIZE,directionDefault, sortByDefault);
        //Lấy danh sách các trang theo kết quả.
        List<Integer>listPage = accountService.getListPage(emailDefault,SIZE);
        mav.addObject("listUser", accountList);
        mav.addObject("listPage", listPage);
        mav.addObject("email",emailDefault);
        mav.addObject("sortBy",sortByDefault);
        mav.addObject("direction", directionDefault);
        return  mav;
    }
    @GetMapping("initUpdate")
    public String initUploadCategory(ModelMap modelMap, int accId){
        AccountModel accountModel = accountService.findById(accId);
        modelMap.addAttribute("accountUpdate",accountModel);
        return "user-update";
    }
    @PostMapping(value = "update")
    public String save0rUpdate(AccountModel accountUpdate){
        boolean result = accountService.save0rUpdate(accountUpdate);
        if (result){
            return "redirect:findUser";
        }else {
            return "404";
        }
    }
}
