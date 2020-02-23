package com.wzh.service.impl;


import com.wzh.dao.ProductDao;
import com.wzh.entity.Product;
import com.wzh.service.ProductService;
import com.wzh.util.MybatisUtil;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    @Override
    public List<Product> queryAll(Integer page) {
        ProductDao dao = MybatisUtil.getMapper(ProductDao.class);
        List<Product> products = dao.queryAll((page - 1) * 2);
        MybatisUtil.close();
        return products;
    }

    @Override
    public Integer queryCount() {
        ProductDao mapper = MybatisUtil.getMapper(ProductDao.class);
        Integer integer = mapper.queryCount();
        MybatisUtil.close();
        return integer;
    }

    @Override
    public Product queryById(String id) {
        ProductDao mapper = MybatisUtil.getMapper(ProductDao.class);
        Product product = mapper.queryById(id);
        MybatisUtil.close();
        return product;
    }
}