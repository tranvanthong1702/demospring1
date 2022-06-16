package com.example.demo.service.impl;

import com.example.demo.converter.NewConverter;
import com.example.demo.dto.NewDTO;
import com.example.demo.entity.CategoryEntity;
import com.example.demo.entity.NewEntity;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.NewRepository;
import com.example.demo.service.INewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NewService implements INewService {
@Autowired
private NewRepository newRepository;
@Autowired
private CategoryRepository categoryRepository;
@Autowired
private NewConverter newConverter;

    @Override
    public List<NewDTO> findAll(Pageable pageable ) {
        List<NewDTO> results= new ArrayList<>();
        List<NewEntity> entities =newRepository.findAll(pageable).getContent();
        for (NewEntity item:entities){
            NewDTO newDTO = newConverter.toDTO(item);
            results.add(newDTO);

        }        return results;
    }

    @Override
    public int totalItem() {
        return (int) newRepository.count();
    }

    @Override
    public NewDTO save(NewDTO newDTO){
        CategoryEntity categoryEntity=categoryRepository.findOneByCode(newDTO.getCategoryCode());
        NewEntity newEntity=newConverter.toEntity(newDTO);
        newEntity.setCategory(categoryEntity);
        newEntity=newRepository.save(newEntity);
        return newConverter.toDTO(newEntity);
    };
//
//
    @Override
    public NewDTO update(NewDTO newDTO)  {
        Optional<NewEntity> oldNewEntity = newRepository.findById(newDTO.getId());
        NewEntity newEntity = newConverter.toEntity(newDTO,oldNewEntity.get());
        CategoryEntity categoryEntity=categoryRepository.findOneByCode(newDTO.getCategoryCode());
        newEntity.setCategory(categoryEntity);
        newEntity=newRepository.save(newEntity);
        return newConverter.toDTO(newEntity);
    }

    @Override
    public void delete(long[] ids) {
        for (long item : ids){
            newRepository.deleteById(item);
        }

    }
    //
//    @Override
//    public NewDTO save(NewDTO newDTO) {
//        NewEntity newEntity= new NewEntity();
//        if (Long.valueOf(newDTO.getId()) != null){
//            Optional<NewEntity> oldNewEntity=newRepository.findById(newDTO.getId());
//            newEntity =newConverter.toEntity(newDTO, oldNewEntity.get());
//        }else {
//            newEntity =newConverter.toEntity(newDTO);
//        }
//        CategoryEntity categoryEntity =categoryRepository.findOneByCode(newDTO.getCategoryCode());
//        newEntity.setCategory(categoryEntity);
//        newEntity=newRepository.save(newEntity);
//        return  newConverter.toDTO(newEntity);
//    }

}
