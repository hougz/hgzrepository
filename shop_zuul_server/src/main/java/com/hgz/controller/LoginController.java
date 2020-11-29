package com.hgz.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String defaultLogin() {
        return "首页";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
        // 从SecurityUtils里边创建一个 subject
        Subject subject = SecurityUtils.getSubject();
        // 在认证提交前准备 token（令牌）
        UsernamePasswordToken token=new UsernamePasswordToken(username,password);
        System.out.println(token);
        //执行认证登录
        subject.login(token);
        if (subject.isAuthenticated()){
            return "登录成功";
        } else {
            token.clear();
            return "登录失败";
        }

    }


    }
