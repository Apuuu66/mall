package com.guier.mall.goods.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guier.mall.goods.dao.BrandMapper;
import com.guier.mall.goods.pojo.Brand;
import com.guier.mall.goods.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {


    @Autowired
    private BrandMapper brandMapper;

    @Override
    public PageInfo<Brand> findPage(Brand brand, Integer pageNum, Integer size) {
        //静态分页 PageHelper.startPage(pageNum,size)
        PageHelper.startPage(pageNum, size);
        //条件搜索
        Example example = createExample(brand);
        //搜索
        List<Brand> brands = brandMapper.selectByExample(example);
        //封装PageInfo<T>
        return new PageInfo<Brand>(brands);
    }

    @Override
    public PageInfo<Brand> findPage(Integer pageNum, Integer size) {
        //静态分页 PageHelper.startPage(pageNum,size)
        PageHelper.startPage(pageNum, size);
        //查询
        List<Brand> brands = brandMapper.selectAll();
        //封装PageInfo<T>
        return new PageInfo<Brand>(brands);
    }

    @Override
    public List<Brand> findList(Brand brand) {
        //条件组装抽取
        Example example = createExample(brand);
        return brandMapper.selectByExample(example);
    }

    public Example createExample(Brand brand) {
        //动态构建条件Example,criteria:动态组装条件
        Example example = new Example(Brand.class);
        Example.Criteria criteria = example.createCriteria();

        //组装条件
        if (brand != null) {
            //id
            if (!StringUtils.isEmpty(brand.getId())) {
                criteria.andEqualTo("id", brand.getId());
            }

            if (!StringUtils.isEmpty(brand.getName())) {
                //1)输入name-根据name查询[模糊查询]   select * from tb_brand wehere name like '%brand.getName%'
                criteria.andLike("name", "%" + brand.getName() + "%");
            }

            if (!StringUtils.isEmpty(brand.getLetter())) {
                //2)输入了letter-根据letter查询       select * from tb_brand where letter= 'brand.getLetter'
                criteria.andEqualTo("letter", brand.getLetter());
            }
        }
        return example;
    }

    @Override
    public void delete(Integer id) {
        brandMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(Brand brand) {
        brandMapper.updateByPrimaryKeySelective(brand);
    }

    @Override
    public void add(Brand brand) {

        brandMapper.insertSelective(brand);
    }

    @Override
    public Brand findById(Integer id) {
        //通用Mapper：selectByPrimaryKey:根据ID查询
        return brandMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Brand> findAll() {
        //使用通用Mapper查询所有
        return brandMapper.selectAll();
    }
}
