package com.xiaoyaotong.api.login.service;

import com.xiaoyaotong.api.login.entity.User;

public interface UserService {
    public User findUserByUserName(String username, String password);
    public User findOne(long id);
    public String test();
}
