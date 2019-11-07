package com.xiaoyaotong.api.login.mapper;

import com.xiaoyaotong.api.login.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    public User findByUserName(String username);
    public User findByID(long id);
    public String test();
}
