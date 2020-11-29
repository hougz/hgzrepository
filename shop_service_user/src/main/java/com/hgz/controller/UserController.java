package com.hgz.controller;

import com.hgz.pojo.TbUser;
import com.hgz.serviceImpl.UserServiceImpl;
import com.hgz.utils.MD5Utils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(description = "用户管理")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @ApiOperation(value = "用户列表")
    @GetMapping("/list")
    public List findAll() {
        return userService.findAll();
    }

    @ApiOperation(value = "根据ID查询用户信息")
    @GetMapping("/{id}")
    @ApiImplicitParam(name="id",value = "用户id",defaultValue = "1",required = true)
    public TbUser findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @ApiOperation("添加用户的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name="username",value = "用户名",defaultValue = "李四"),
            @ApiImplicitParam(name="age",value = "年龄",defaultValue = "12")
    })
    @PostMapping
    public String save(@RequestBody TbUser product) {
        String pasword= MD5Utils.MD5Pwd(product.getUsername(),product.getPassword());
        product.setPassword(pasword);
        userService.save(product);
        return "保存成功";
    }
    @ApiOperation("根据id修改用户")
    @PutMapping("/{id}")
    public String update(@RequestBody TbUser product) {
        userService.update(product);
        return "修改成功";
    }
    @ApiOperation("根据id删除用户")
    @DeleteMapping("/{id}")
    public String delete(Long id) {
        userService.delete(id);
        return "删除成功";
    }

}
