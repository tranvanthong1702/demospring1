package com.example.demo.repository;

import com.example.demo.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface CategoryRepository  extends JpaRepository<CategoryEntity, Long> {

    CategoryEntity findOneByCode(String code);
}
