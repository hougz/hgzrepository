package com.hgz.order.serviceImpl;

import com.hgz.order.dao.OrderMapper;
import com.hgz.order.service.OrderService;
import com.hgz.pojo.TbOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {


    @Autowired
    private OrderMapper orderMapper;

    @Override
    public TbOrder selectByPrimaryKey(Integer id) {
        return orderMapper.selectByPrimaryKey(1);
    }
}
