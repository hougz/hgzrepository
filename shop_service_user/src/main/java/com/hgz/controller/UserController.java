package com.hgz.controller;

import com.hgz.pojo.TbUser;
import com.hgz.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping
    public List findAll() {
        return userService.findAll();
    }
    @GetMapping("/{id}")
    public TbUser findById(@PathVariable Long id) {
        return userService.findById(id);
    }
    @PostMapping
    public String save(@RequestBody TbUser product) {
        userService.save(product);
        return "保存成功";
    }
    @PutMapping("/{id}")
    public String update(@RequestBody TbUser product) {
        userService.update(product);
        return "修改成功";
    }
    @DeleteMapping("/{id}")
    public String delete(Long id) {
        userService.delete(id);
        return "删除成功";
    }

}
