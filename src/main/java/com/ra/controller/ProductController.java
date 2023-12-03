package com.ra.controller;

import com.ra.model.CategoryModel;
import com.ra.model.ImageProductModel;
import com.ra.model.ProductModel;
import com.ra.service.CategoryService;
import com.ra.service.ImageService;
import com.ra.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ImageService imageService;
    private static final int SIZE = 5;
    private static String productNameDefault = "";
    private static String directionDefault = "ASC";
    private static String sortByDefault = "productId";
    private static int pageDefault = 1;
    private String imageUrl = "";
    private List<ImageProductModel> listImage = new ArrayList<>();
    @GetMapping("findProduct")
    public ModelAndView displayProduct(Optional<String>productName, Optional<Integer>page,
                                       Optional<String>direction, Optional<String>sortBy){
        ModelAndView mav = new ModelAndView("product");
        productNameDefault = productName.orElse(productNameDefault);
        directionDefault = direction.orElse(directionDefault);
        sortByDefault = sortBy.orElse(sortByDefault);
        pageDefault = page.orElse(pageDefault);
        List<ProductModel> modelList = productService.displayData(productNameDefault,
                pageDefault-1,SIZE,directionDefault,sortByDefault);
        List<Integer> listPage = productService.getListPage(productNameDefault,SIZE);
        mav.addObject("listProduct", modelList);
        mav.addObject("listPage",listPage);
        mav.addObject("productName", productNameDefault);
        mav.addObject("direction", directionDefault);
        mav.addObject("sortBy", sortByDefault);
        return mav;
    }
    @GetMapping("view")
    public String viewsProduct( String productId){
        return "product-view";
    }
    @GetMapping("initCreate")
    public String initCreateProduct(ModelMap modelMap){
        ProductModel productNew = new ProductModel();
        List<CategoryModel>categoryList = categoryService.findAll();
        modelMap.addAttribute("productNew",productNew);
        modelMap.addAttribute("categoryList",categoryList);
        return "product-new";
    }
    @PostMapping("create")
    public String createProduct(ProductModel productNew,MultipartFile productImage, MultipartFile[] listImage){
        String imageUrl = imageService.uploadFile(productImage);
        productNew.setImage(imageUrl);
        ProductModel productModel = productService.save0rUpdate(productNew);
        if (productImage!=null) {
            ImageProductModel imageProductModel = new ImageProductModel();
            imageProductModel.setProduct(productModel);
            imageProductModel.setImageUrl(imageUrl);
            boolean result = imageService.save(imageProductModel);
        }

        if (listImage!=null){
                Arrays.asList(listImage).forEach(image->{
                    String imageLink = imageService.uploadFile(image);
                    ImageProductModel imageProductModel = new ImageProductModel();
                    imageProductModel.setProduct(productModel);
                    imageProductModel.setImageUrl(imageLink);
                    boolean result = imageService.save(imageProductModel);
                });
            }

            return "redirect:findProduct";

    }
    @GetMapping("initUpdate")
    public String initUpdate(ModelMap modelMap, String productId){
        ProductModel productEdit = productService.findById(productId);
        List<CategoryModel>categoryList = categoryService.findAll();
        List<ImageProductModel> imageList = imageService.findByProductId(productId);
        imageUrl = productEdit.getImage();
        listImage = imageList;
        modelMap.addAttribute("categoryList",categoryList);
        modelMap.addAttribute("productEdit",productEdit);
        modelMap.addAttribute("imageList",imageList);
        return "product-update";
    }
    @PostMapping("update")
    public String update(ProductModel productEdit,MultipartFile productImageEdit, MultipartFile[] listImageEdit ){
        if (productImageEdit.getSize()>1){
            String imageUrlItem = imageService.uploadFile(productImageEdit);
            productEdit.setImage(imageUrlItem);
            ImageProductModel imageProductModel = new ImageProductModel();
            imageProductModel.setProduct(productEdit);
            imageProductModel.setImageUrl(imageUrl);
            boolean result = imageService.save(imageProductModel);
        }else {
            productEdit.setImage(imageUrl);
        }

        if (listImageEdit.length >1){
                Arrays.asList(listImageEdit).forEach(image->{
                    String imageLink = imageService.uploadFile(image);
                    ImageProductModel imageProductModel = new ImageProductModel();
                    imageProductModel.setProduct(productEdit);
                    imageProductModel.setImageUrl(imageLink);
                    boolean result = imageService.save(imageProductModel);
                });
        }else {
            productEdit.setImageList(listImage);
        }
        ProductModel updateProduct = productService.save0rUpdate(productEdit);

            return "redirect:findProduct";
    }
    @GetMapping("delete")
    public String delete(String productId){
        boolean result = productService.productStatus(productId);
        if (result){
            return "redirect:findProduct";
        }else {
            return "404";
        }
    }
    @GetMapping("viewProduct")
    public String viewProduct(ModelMap modelMap, String productId){
        ProductModel productView = productService.findById(productId);
        List<ImageProductModel> imageList = imageService.findByProductId(productId);
        productView.setImageList(imageList);
        List<CategoryModel>categoryList = categoryService.findAll();
        modelMap.addAttribute("categoryList",categoryList);
        modelMap.addAttribute("productView",productView);
        modelMap.addAttribute("imageList",imageList);
        return "product-single";
    }
//    @GetMapping("test")


}
