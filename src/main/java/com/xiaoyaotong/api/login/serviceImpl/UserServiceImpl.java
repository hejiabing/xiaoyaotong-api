package com.xiaoyaotong.api.login.serviceImpl;

import com.xiaoyaotong.api.login.entity.User;
import com.xiaoyaotong.api.login.mapper.UserMapper;
import com.xiaoyaotong.api.login.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    public User findUserByUserName(String username, String password){
        User user = userMapper.findByUserName(username);
        //判断用户不为空
        if (null != user){
            //判断用户名和密码一致
            if(password.equals(user.getPassword())){//如果一致，返回该用户
                return user;
            }
        }
        //否则，全部返回空
        return null;
    }

    @Override
    public User findOne(long id) {
        User user = userMapper.findByID(id);
        return user;
    }

    @Override
    public String test() {
        //return userMapper.toString();
        //System.out.println("ttttttt");
        return userMapper.test();
    }

}
