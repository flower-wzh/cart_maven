package com.wzh.service.impl;

import com.wzh.dao.ProductDao;
import com.wzh.dao.UserDao;
import com.wzh.entity.Product;
import com.wzh.entity.User;
import com.wzh.service.ProductService;
import com.wzh.service.UserService;
import com.wzh.util.MybatisUtil;

import java.util.List;

public class UserServiceImpl implements UserService {
    @Override
    public User login(String username, String password) {
        UserDao dao = MybatisUtil.getMapper(UserDao.class);
        User user = dao.queryOneUser(username);
        if(user != null && password.equals(user.getPassword())){
            MybatisUtil.close();
            return user;
        }
        MybatisUtil.close();
        return null;
    }
}