package com.ra.service;

import com.ra.model.CategoryModel;
import com.ra.model.ImageProductModel;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface ImageService {
    String uploadFile(MultipartFile multipartFile);
    String uploadFileLocal(String localFilePath);
    boolean save(ImageProductModel image);
    List<ImageProductModel> displayData(String productName, int page, int size, String direction, String sortBy);
    List<Integer>getListPage(String productName, int size);
    List<ImageProductModel> findAll();
    List<ImageProductModel> findByProductId(String productId);

    ImageProductModel findById(int imageId);
    boolean delete();

    boolean delete1(Optional<Integer> imageId, Optional<String> imageUrl);

    ImageProductModel findByImageUrl(String imageUrl);
}
