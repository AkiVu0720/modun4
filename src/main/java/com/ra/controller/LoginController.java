package com.ra.controller;

import com.ra.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("loginManager")
public class LoginController {
    @Autowired
    private AccountService accountService;
    @GetMapping("loginPage")
    public String loginPage(){
        return "login";
    }
    @PostMapping("loginHandle")
    public String handleLogin(String userName, String passWord){
         boolean result = accountService.findByUserNameAndPassword(userName,passWord);
         if (result){
            return "redirect:../dashboard/data";
        }else {
            return "error";
        }
    }

}
