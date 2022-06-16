package com.example.demo.entity;


import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category")
public class CategoryEntity extends BaseEntity {
    @Column
    private String code;
    @Column
    private String name;
    public String getCode() {
        return code;
    }
    @OneToMany(mappedBy = "category")
    private List<NewEntity> news=new ArrayList<>();

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<NewEntity> getNews() {
        return news;
    }

    public void setNews(List<NewEntity> news) {
        this.news = news;
    }
}
