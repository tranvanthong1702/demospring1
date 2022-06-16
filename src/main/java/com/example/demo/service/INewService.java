package com.example.demo.service;

import com.example.demo.dto.NewDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface INewService  {
   List<NewDTO> findAll(Pageable pageable );
   int totalItem();
    NewDTO save(NewDTO newDTO);
    NewDTO update(NewDTO newDTO);


    void delete(long[] ids);

}
