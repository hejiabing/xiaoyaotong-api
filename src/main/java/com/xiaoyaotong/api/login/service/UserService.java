package com.xiaoyaotong.api.login.service;

import com.xiaoyaotong.api.login.entity.User;

import java.util.ArrayList;

public interface UserService {
    public User findUserByUserName(String username, String password);
    public String test();
}
