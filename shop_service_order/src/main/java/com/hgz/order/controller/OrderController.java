package com.hgz.order.controller;


import com.hgz.order.dao.UserDao;
import com.hgz.order.service.OrderService;
import com.hgz.pojo.TbOrder;
import com.hgz.pojo.TbUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {


    @Autowired
    private OrderService orderService;

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/findById/{id}",method = RequestMethod.GET)
    public TbOrder findById(@PathVariable Integer id){
       return orderService.selectByPrimaryKey(id);
    }


    @GetMapping("/finduserbyId/{id}")
    public TbUser getUser(@PathVariable("id") int id){
      return  userDao.getById(id);
    }
}
