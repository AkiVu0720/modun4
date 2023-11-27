package com.ra.controller;

import com.ra.model.CategoryModel;
import com.ra.service.CategoryService;
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
@RequestMapping(value = "category")
public class CatelogyContoller {
    @Autowired
    private CategoryService categoryService;
    private static  final int SIZE = 5;
    private static String categoryNameDefault = "";
    private static String directionDefault = "ASC";
    private static String sortByDefault = "categoryId";
    private static int pageDefault = 1;
    @GetMapping("findCategory")
    public ModelAndView displayCategory(Optional<String>categoryName, Optional<Integer>page,
                                        Optional<String>direction, Optional<String>sortBy){
        ModelAndView mav = new ModelAndView("category");
        categoryNameDefault = categoryName.orElse(categoryNameDefault);
        directionDefault = direction.orElse(directionDefault);
        sortByDefault = sortBy.orElse(sortByDefault);
        pageDefault = page.orElse(pageDefault);
        List<CategoryModel>categoryList = categoryService.displayData(categoryNameDefault,
                pageDefault-1,SIZE,directionDefault, sortByDefault);
        //Lấy danh sách các trang theo kết quả.
        List<Integer>listPage = categoryService.getListPage(categoryNameDefault,SIZE);
        mav.addObject("listCategory", categoryList);
        mav.addObject("listPage", listPage);
        mav.addObject("category",categoryNameDefault);
        mav.addObject("sortBy",sortByDefault);
        mav.addObject("direction", directionDefault);
        return  mav;
    }
    @GetMapping("initCreate")
    public String initCreateCategory(ModelMap modelMap){
        CategoryModel categoryNew = new CategoryModel();
        modelMap.addAttribute("categoryNew",categoryNew);
        return "category-new";
    }
    @PostMapping(value = "create")
    public String createCategory(CategoryModel categoryNew){
        boolean result = categoryService.save0rUpdate(categoryNew);
        if (result){
        return "redirect:findCategory";
        }else {
            return "404";
        }
    }
    @GetMapping("initUpdate")
    public String initUploadCategory(ModelMap modelMap, int categoryId){
        CategoryModel categoryEdit = categoryService.findById(categoryId);
        modelMap.addAttribute("categoryEdit",categoryEdit);
        return "category-update";
    }
    @PostMapping(value = "update")
    public String save0rUpdate(CategoryModel categoryEdit){
        boolean result = categoryService.save0rUpdate(categoryEdit);
        if (result){
            return "redirect:findCategory";
        }else {
            return "404";
        }
    }
    @GetMapping(value = "delete")
    public String deleteCategory(int categoryId){
        boolean result = categoryService.delete(categoryId);
        if (result){
            return "redirect:findCategory";
        }else {
            return "404";
        }
    }

}
