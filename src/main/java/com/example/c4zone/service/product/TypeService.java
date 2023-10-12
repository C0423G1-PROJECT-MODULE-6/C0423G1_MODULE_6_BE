package com.example.c4zone.service.product;

import com.example.c4zone.model.product.Type;
import com.example.c4zone.repository.product.ITypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeService implements ITypeService{
    @Autowired
    private ITypeRepository typeRepository;
    @Override
    public List<Type> findAll() {
        return typeRepository.findAll();
    }
}
