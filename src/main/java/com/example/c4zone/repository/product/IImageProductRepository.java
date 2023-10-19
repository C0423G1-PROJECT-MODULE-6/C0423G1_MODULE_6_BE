package com.example.c4zone.repository.product;

import com.example.c4zone.model.product.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IImageProductRepository extends JpaRepository<Image, Long> {

    /**
     * author: DaoPTA
     * workday: 12/10/2023
     *
     * @param image save image using firebase
     * @param idProduct save the image to an object with an idProduct
     */
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO image (name, status_image, id_product)" +
            " VALUES (:#{#image.name}, true, :idProduct) ", nativeQuery = true)
    void createImage(@Param("image") Image image, Long idProduct);

    @Transactional
    @Modifying
    @Query(value = " INSERT INTO image (name, status_image, id_product)" +
            " VALUES ( :name, true, :idProduct)",nativeQuery = true)
    void insertImageProduct(@Param("name") String name,  Long idProduct);


    /**
     * author: DaoPTA
     * workday: 12/10/2023
     *
     * @param image update image using firebase
     * @param idProduct update the image to an object with an idProduct
     */
    @Transactional
    @Modifying
    @Query(value = "call update_img(:image , :idProduct)", nativeQuery = true)
    void updateImage(@Param("image") String image,@Param("idProduct") Long idProduct);

    @Transactional
    @Modifying
    @Query(value = "update image set status_image = false where image.id_product = :id",nativeQuery = true)
    void deleteImg(Long id);

    /**
     * author: DaoPTA
     * workday: 12/10/2023
     *
     * @param idProduct find by image with idProduct
     * @return image with idProduct
     */
    @Query(value = "SELECT i.id_image, i.name, i.id_product, i.status_image " +
            "FROM image as i WHERE id_product = :idProduct",nativeQuery = true)
    List<Image> findImageByIdProduct(@Param("idProduct") Long idProduct);

}
