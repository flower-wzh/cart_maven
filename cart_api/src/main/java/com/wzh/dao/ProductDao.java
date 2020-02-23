package com.wzh.dao;

import com.wzh.entity.Product;

import java.util.List;

public interface ProductDao {
    /**
     * 分页查询
     * @param start
     * @return
     */
    List<Product> queryAll(Integer start);

    /**
     * 查询数量
     * @return
     */
    Integer queryCount();

    /**
     * 根据id查询
     * @param id
     * @return
     */
    Product queryById(String id);
}
