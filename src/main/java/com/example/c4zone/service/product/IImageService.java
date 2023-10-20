package com.example.c4zone.service.product;

import com.example.c4zone.model.product.Image;

import java.util.List;

public interface IImageService {
    void createImageProduct(Image image, Long idProduct);
    List<Image> findImageProductByIdProduct(Long idProduct);
    void updateImageProduct(String image, Long idProduct);
    void deleteImg(Long id);
    void insertImageByProductId(List<String> imageDtoList, Long idProduct);
}
