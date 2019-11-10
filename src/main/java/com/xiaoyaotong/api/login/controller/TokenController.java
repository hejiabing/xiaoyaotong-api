package com.xiaoyaotong.api.login.controller;


import com.xiaoyaotong.api.login.annotation.Authorization;
import com.xiaoyaotong.api.login.annotation.CurrentUser;
import com.xiaoyaotong.api.login.config.ResultStatus;
import com.xiaoyaotong.api.login.entity.User;
import com.xiaoyaotong.api.login.manager.TokenManager;
import com.xiaoyaotong.api.login.model.ResultModel;
import com.xiaoyaotong.api.login.model.TokenModel;
import com.xiaoyaotong.api.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

/**
 * 获取和删除token的请求地址，在Restful设计中其实就对应着登录和退出登录的资源映射
 * @author ScienJus
 * @date 2015/7/30.
 */

@RestController
@RequestMapping("/tokens")
public class TokenController {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenManager tokenManager;
    @RequestMapping(value="/login", method = RequestMethod.POST)
    public ResponseEntity<ResultModel> login(@RequestBody User loguser) {
        String username = loguser.getUsername();
        String password = loguser.getPassword();
        Assert.notNull(username, "username can not be empty");
        Assert.notNull(password, "password can not be empty");

        User user = userService.findUserByUserName(username,password);
        if (user == null ||  //未注册
                !user.getPassword().equals(password)) {  //密码错误
            //提示用户名或密码错误
            return new ResponseEntity<>(ResultModel.error(ResultStatus.USERNAME_OR_PASSWORD_ERROR), HttpStatus.NOT_FOUND);
        }
        //生成一个token，保存用户登录状态
        TokenModel model = tokenManager.createToken(user.getId());
        return new ResponseEntity<>(ResultModel.ok(model), HttpStatus.OK);
    }

    @RequestMapping(value="logout",method = RequestMethod.POST)
    @Authorization
    public ResponseEntity<ResultModel> logout(@CurrentUser User user) {
        tokenManager.deleteToken(user.getId());
        return new ResponseEntity<>(ResultModel.ok(), HttpStatus.OK);
    }
}