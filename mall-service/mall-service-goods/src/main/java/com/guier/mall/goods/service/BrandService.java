package com.guier.mall.goods.service;

import com.github.pagehelper.PageInfo;
import com.guier.mall.goods.pojo.Brand;

import java.util.List;

public interface BrandService {
    PageInfo<Brand> findPage(Brand brand, Integer pageNum, Integer size);

    PageInfo<Brand> findPage(Integer pageNum, Integer size);

    List<Brand> findList(Brand brand);

    void delete(Integer id);

    void update(Brand brand);

    void add(Brand brand);

    Brand findById(Integer id);

    List<Brand> findAll();
}
