package com.ra.serviceImp;

import com.google.cloud.storage.*;
import com.ra.model.ImageProductModel;
import com.ra.repository.ImageRepository;
import com.ra.repository.ProductRepository;
import com.ra.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ImageServiceImp implements ImageService {
    @Autowired
    private Storage storage;
    @Autowired
    private ServletContext servletContext;
    @Autowired
    private ImageRepository imageRepository;
    @Autowired
    private ProductRepository productRepository;
    private  final String LINK_NAME = "fruit-c76ea.appspot.com";
    @Override
    public String uploadFile(MultipartFile multipartFile) {
        String pathUpload = servletContext.getRealPath("/");
        File uploadFolder = new File(pathUpload+"/uploads");
        if (!uploadFolder.exists()){
            uploadFolder.mkdirs();
        }
        String fileName = multipartFile.getOriginalFilename();
        File fileUpload = new File(uploadFolder+File.separator+fileName);

        try {
            FileCopyUtils.copy(multipartFile.getBytes(), fileUpload);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return uploadFileLocal(uploadFolder+File.separator+fileName);
    }

    /*
     * 1. lấy dữ liệu ảnh trong thư mục upload
     * 2. upload lên firebase
     * 3. return url ảnh trên firebase
     * */
    @Override
    public String uploadFileLocal(String localFilePath) {
        Path localPath = Paths.get(localFilePath);
        String fileName = localPath.getFileName().toString();

        BlobId blobId = BlobId.of(LINK_NAME, fileName);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).build();
        // Thiết lập quyền truy cập công cộng
        List<Acl> acls = new ArrayList<>();
        acls.add(Acl.of(Acl.User.ofAllUsers(), Acl.Role.READER));
        blobInfo = blobInfo.toBuilder().setAcl(acls).build();
        try {
            Blob blob = storage.create(blobInfo, Files.readAllBytes(localPath));
            return blob.getMediaLink();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public boolean save(ImageProductModel image) {
        try {
            imageRepository.save(image);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<ImageProductModel> displayData(String productName, int page, int size, String direction, String sortBy) {
        Pageable pageable = PageRequest.of(page,size,direction.equals("ASC")? Sort.Direction.ASC: Sort.Direction.DESC,sortBy);
        List<ImageProductModel>modelList = imageRepository.findByImageProductName(productName,pageable).getContent();
        return modelList;
    }

    @Override
    public List<Integer> getListPage(String productName, int size) {
        int imagePage = imageRepository.countByProductName(productName);;
        List<Integer> listPage = new ArrayList<>();
        for (int i = 0; i < (int) Math.ceil((double)imagePage/(double) size); i++) {
            listPage.add(i+1);
        }
        return listPage;
    }

    @Override
    public List<ImageProductModel> findAll() {
        return imageRepository.findAll();
    }

    @Override
    public List<ImageProductModel> findByProductId( String productId) {
        return imageRepository.findByProductId(productId);
    }

    @Override
    public ImageProductModel findById(int imageId) {
        return imageRepository.findById(imageId).get();
    }

    @Override
    public boolean delete() {
        return false;
    }

    @Override
    public boolean delete1(Optional<Integer> imageId, Optional<String> imageUrl) {
        try {
            imageId.ifPresent(integer -> imageRepository.delete(findById(integer)));
            imageUrl.ifPresent(s -> imageRepository.delete(findByImageUrl(s)));
            return true;
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public ImageProductModel findByImageUrl(String imageUrl) {
        ImageProductModel imageProductModel = imageRepository.findByImageUrl(imageUrl);
        return  imageProductModel;
    }


    @Override
    public String findProductId(Optional<Integer> imageId, Optional<String> imageUrl) {
         int imageIdItem =  imageId.orElse(0);
         String imageUrlItem =  imageUrl.orElse("");
        if (imageIdItem !=0){
            return findById(imageIdItem).getProduct().getProductId();
        }
        if (imageUrlItem.length()>1){
            ImageProductModel productModel = findByImageUrl(imageUrlItem);
            System.out.println("getProductId"+productModel.getProduct().getProductId());
            return findByImageUrl(imageUrlItem).getProduct().getProductId();
        }
        return null;
    }

}
