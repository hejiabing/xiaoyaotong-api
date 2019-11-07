package com.xiaoyaotong.api.login.serviceImpl;

import com.xiaoyaotong.api.login.entity.User;
import com.xiaoyaotong.api.login.mapper.UserMapper;
import com.xiaoyaotong.api.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;

@Component
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    public User findUserByUserName(String username, String password){
        User users = userMapper.findByUserName(username);
        return users;
    }

    @Override
    public String test() {
        //return userMapper.toString();
        //System.out.println("ttttttt");
        return userMapper.test();
    }

}
