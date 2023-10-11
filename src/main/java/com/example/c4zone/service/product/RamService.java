package com.example.c4zone.service.product;

import com.example.c4zone.model.product.Ram;
import com.example.c4zone.repository.product.IRamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RamService implements IRamService{
    @Autowired
    private IRamRepository ramRepository;
    @Override
    public List<Ram> findAll() {
        return ramRepository.findAll();
    }
}
