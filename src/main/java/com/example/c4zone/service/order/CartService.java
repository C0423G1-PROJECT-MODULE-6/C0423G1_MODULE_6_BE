package com.example.c4zone.service.order;

import com.example.c4zone.dto.order.ICartDto;
import com.example.c4zone.repository.order.ICartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService implements ICartService {
    @Autowired
    private ICartRepository cartRepository;
    /**
     * method getAllCart
     * Create ThoiND
     * Date 12-10-2023
     * param Long idUser
     * return List<ICartDto>
     */
    @Override
    public List<ICartDto> getAllCart(Long idUser) {
        return cartRepository.getAllCart(idUser);
    }
}
