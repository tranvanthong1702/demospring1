package com.example.demo.repository;


import com.example.demo.entity.NewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface NewRepository extends JpaRepository<NewEntity, Long> {

    @Override
    void deleteById(Long aLong);
    List<NewEntity> findAll();


}
