package com.example.c4zone.service.product;

import com.example.c4zone.model.product.Image;
import com.example.c4zone.repository.product.IImageProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService implements IImageService{
    @Autowired
    private IImageProductRepository imageProductRepository;

    /**
     * author: DaoPTA
     * workday: 12/10/2023
     *
     * @param image create image with firebase
     * @param idProduct create image with idProduct
     */
    @Override
    public void createImageProduct(Image image, Long idProduct) {
        imageProductRepository.createImage(image, idProduct);
    }

    @Override
    public Image findImageProductByIdProduct(Long idProduct) {
        return imageProductRepository.findImageByIdProduct(idProduct);
    }

    /**
     * author: DaoPTA
     * workday: 12/10/2023
     *
     * @param image update image with firebase
     * @param idProduct update image with idProduct
     */
    @Override
    public void updateImageProduct(Image image, Long idProduct) {
        imageProductRepository.updateImage(image, idProduct);
    }
}
