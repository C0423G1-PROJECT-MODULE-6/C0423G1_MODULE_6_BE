package com.example.c4zone.repository.order;

import com.example.c4zone.dto.order.ICartDto;
import com.example.c4zone.model.order.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICartRepository extends JpaRepository<Cart,Long> {
    @Query(value = "select cart.id_cart as idCart, p.name_product as nameProduct, p.price_product as priceProduct " +
            "p.quantity_product as quantityProduct " +
            "from cart " +
            "join product as p " +
            "on cart.id_product = p.id_product " +
            "where id_user = :id",nativeQuery = true)
    List<ICartDto> getAllCart(Long idUser);
}
