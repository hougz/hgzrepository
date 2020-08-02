package com.hgz.order.service;

import com.hgz.pojo.TbOrder;

public interface OrderService {

    TbOrder selectByPrimaryKey(Integer id);
}
