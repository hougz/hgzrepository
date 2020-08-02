package com.hgz.service;

import com.hgz.pojo.TbUser;

import java.util.List;

public interface UserService {

    //根据id查询
    TbUser findById(Long id);
    //查询全部
    List findAll();
    //保存
    void save(TbUser user);
    //更新
    void update(TbUser user);
    //删除
    void delete(Long id);
}
