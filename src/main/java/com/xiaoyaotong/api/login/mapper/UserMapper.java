package com.xiaoyaotong.api.login.mapper;

import com.xiaoyaotong.api.login.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UserMapper {
    public User findByUserName(String username);
    public String test();
}
