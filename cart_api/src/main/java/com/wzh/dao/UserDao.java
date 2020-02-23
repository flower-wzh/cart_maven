package com.wzh.dao;

import com.wzh.entity.User;

public interface UserDao {
    /**
     * 根据用户名查询用户
     * @param username
     * @return
     */
    User queryOneUser(String username);
}
