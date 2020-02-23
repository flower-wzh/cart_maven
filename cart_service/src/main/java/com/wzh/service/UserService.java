package com.wzh.service;

import com.wzh.entity.User;

public interface UserService {
    /**
     * 登陆
     * @param username
     * @param password
     * @return
     */
    User login(String username, String password);
}