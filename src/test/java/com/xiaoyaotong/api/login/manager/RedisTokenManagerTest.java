package com.xiaoyaotong.api.login.manager;

import com.xiaoyaotong.api.login.model.TokenModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class RedisTokenManagerTest {

    @Autowired
    TokenManager tokenManager;

    private long id = 73942;
    @Test
    void testCreateToken(){
        TokenModel model = tokenManager.createToken(id);
        System.out.println(model.getToken());
        assert (id == model.getUserId());
    }

    @Test
    void testGetToken(){
        TokenModel model = tokenManager.createToken(12345);
        assert(true == tokenManager.checkToken(model));
    }
}