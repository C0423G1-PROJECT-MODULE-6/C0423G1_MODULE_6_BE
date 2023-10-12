package com.example.c4zone.service.order;

import com.example.c4zone.dto.order.ICartDto;

import java.util.List;

public interface ICartService {

    /**
     * method getAllCart
     * Create ThoiND
     * Date 12-10-2023
     * param Long idUser
     * return List<ICartDto>
     */
    List<ICartDto> getAllCart(Long idUser);
}
