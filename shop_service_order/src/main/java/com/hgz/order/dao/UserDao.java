package com.hgz.order.dao;

import com.hgz.order.serviceImpl.UserFeginClientCallBack;
import com.hgz.pojo.TbUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name="shop-service-user",fallback = UserFeginClientCallBack.class)
public interface UserDao {


    @GetMapping("/user/{id}")
    public TbUser getById(@PathVariable("id") int id);

}
