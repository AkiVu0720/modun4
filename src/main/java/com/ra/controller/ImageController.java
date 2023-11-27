package com.ra.controller;

import com.ra.model.ImageProductModel;
import com.ra.model.ProductModel;
import com.ra.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("image")
public class ImageController {
    @Autowired
    private ImageService imageService;
    private static final int SIZE = 5;
    private static String productNameDefault = "";
    private static String directionDefault = "ASC";
    private static String sortByDefault = "imageId";
    private static int pageDefault = 1;
    @GetMapping("findImage")
    public ModelAndView displayProduct(Optional<String> productName, Optional<Integer>page,
                                       Optional<String>direction, Optional<String>sortBy){
        ModelAndView mav = new ModelAndView("image");
        productNameDefault = productName.orElse(productNameDefault);
        directionDefault = direction.orElse(directionDefault);
        sortByDefault = sortBy.orElse(sortByDefault);
        pageDefault = page.orElse(pageDefault);
        List<ImageProductModel> modelList = imageService.displayData(productNameDefault,
                pageDefault-1,SIZE,directionDefault,sortByDefault);
        List<Integer> listPage = imageService.getListPage(productNameDefault,SIZE);
        mav.addObject("listImage", modelList);
        mav.addObject("listPage",listPage);
        mav.addObject("productName", productNameDefault);
        mav.addObject("direction", directionDefault);
        mav.addObject("sortBy", sortByDefault);
        return mav;
    }
//    @GetMapping(value = "deleteById")
//    public String deleteImageById(int imageId){
//        boolean result = imageService;
//        if (result){
//            return "redirect:findImage";
//        }else {
//            return "404";
//        }
//    }
    @GetMapping(value = "delete")
    public String deleteImageByUrl(Optional<String> imageUrl,Optional<Integer>imageId){
        boolean result = imageService.delete1(imageId,imageUrl);
        String productId = imageService.findById(imageId.get()).getProduct().getProductId();
        if (result){
            return "redirect:../product/initUpdate?productId="+productId;
        }else {
            return "404";
        }
    }
}
