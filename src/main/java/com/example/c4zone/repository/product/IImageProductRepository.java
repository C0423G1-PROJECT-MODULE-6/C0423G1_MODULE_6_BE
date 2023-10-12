package com.example.c4zone.repository.product;

import com.example.c4zone.model.product.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface IImageProductRepository extends JpaRepository<Image, Long> {

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO image (name, status_image, id_product)" +
            " VALUES (:#{#image.name}, true, :idProduct) ", nativeQuery = true)
    void createImage(@Param("image") Image image, Long idProduct);

    @Transactional
    @Modifying
    @Query(value = "UPDATE image SET name = :#{#image.name} WHERE id_product = :idProduct", nativeQuery = true)
    void updateImage(@Param("image") Image image, Long idProduct);

    @Query(value = "SELECT i.id_image, i.name, i.id_product, i.status_image " +
            "FROM image as i WHERE id_product = :idProduct",nativeQuery = true)
    Image findImageByIdProduct(@Param("idProduct") Long idProduct);

}
