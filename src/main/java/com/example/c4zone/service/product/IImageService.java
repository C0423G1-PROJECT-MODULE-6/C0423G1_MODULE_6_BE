package com.example.c4zone.service.product;

import com.example.c4zone.model.product.Image;

import java.util.List;

public interface IImageService {
    void createImageProduct(Image image, Long idProduct);
    List<Image> findImageProductByIdProduct(Long idProduct);
    void updateImageProduct(Image image, Long idProduct);

    void insertImageByProductId(List<String> imageDtoList, Long idProduct);
}
