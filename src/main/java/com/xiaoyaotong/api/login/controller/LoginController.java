package com.xiaoyaotong.api.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/api/login")
public class LoginController {

    public boolean isValidUser(@RequestParam String userName, String password){
        return false;
    }
}
