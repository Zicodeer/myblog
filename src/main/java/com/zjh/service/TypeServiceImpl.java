package com.zjh.service;

import com.zjh.NotFoundException.NotFoundException;
import com.zjh.dao.TypeRepository;
import com.zjh.po.Type;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeRepository typeRepository;
    @Transactional
    @Override
    public Type saveType(Type type) {
        return typeRepository.save(type);
    }
    @Transactional
    @Override
    public Type getType(Long id) {
        return typeRepository.findById(id).get();
    }
    @Transactional
    @Override
    public Page<Type> listType(Pageable pageable) {
        return typeRepository.findAll(pageable);
    }

    @Override
    public List<Type> listType() {
        return typeRepository.findAll();
    }

    @Override
    public Type getTypeByName(String name) {
        return typeRepository.findByName(name);
    }

    @Transactional
    @Override
    public Type updateType(Long id, Type type) {
        Type type1 = typeRepository.findById(id).get();
        if (type1 == null){
            throw new NotFoundException("不存在该类型..");
        }
        BeanUtils.copyProperties(type,type1);
        return typeRepository.save(type1);
    }
    @Transactional
    @Override
    public void deleteType(Long id) {

        typeRepository.deleteById(id);
    }
}
