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
    /**
     * author: DaoPTA
     * workday: 12/10/2023
     *
     * @return find all list type
     */
    @Override
    public List<Type> findAll() {
        return typeRepository.findAll();
    }

    @Override
    public Type findByIdType(Long idType) {
        return typeRepository.findTypeById(idType);
    }
}
