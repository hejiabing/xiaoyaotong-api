package com.xiaoyaotong.api.login.serviceImpl;

import com.xiaoyaotong.api.login.entity.User;
import com.xiaoyaotong.api.login.service.UserService;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceImplTest {
    @Autowired
    UserService userService;

    @Test
    void findUserByUserName() {

        User user = userService.findUserByUserName("hejiabing","hejiabing");
        System.out.println(user.getUsername());
    }

    //@Test
    void test() {
        userService.test();
    }
}