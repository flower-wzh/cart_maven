package com.wzh.service;

import com.wzh.entity.Product;

import java.util.List;

/**
 * @author origg
 * @version 1.0
 * @date 2020/2/22 17:54
 */
public interface ProductService {

    /**
     * 展示第几页的商品
     * @param page
     * @return
     */
    List<Product> queryAll(Integer page);

    /**
     * 查询数量
     * @return
     */
    Integer queryCount();

    /**
     * 根据id查询商品
     * @param id
     * @return
     */
    Product queryById(String id);
}