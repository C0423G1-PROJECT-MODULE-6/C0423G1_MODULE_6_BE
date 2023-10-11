package com.example.c4zone.service.product;

import com.example.c4zone.model.product.Image;
import com.example.c4zone.repository.product.IImageProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageService implements IImageService{
    @Autowired
    private IImageProductRepository imageProductRepository;
    @Override
    public void createImageProduct(Image image, Long idProduct) {
        imageProductRepository.createImage(image, idProduct);
    }

    @Override
    public Image findImageProductByIdProduct(Long idProduct) {
        return imageProductRepository.findImageByIdProduct(idProduct);
    }

    @Override
    public void updateImageProduct(Image image, Long idProduct) {
        imageProductRepository.updateImage(image, idProduct);
    }
}
