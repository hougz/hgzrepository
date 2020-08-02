package com.hgz.order.serviceImpl;

import com.hgz.order.dao.UserDao;
import com.hgz.pojo.TbUser;
import org.springframework.stereotype.Component;

@Component
public class UserFeginClientCallBack implements UserDao {


    /**
     * 降级方法
     * @param id
     * @return
     */
    @Override
    public TbUser getById(int id) {
        TbUser tbUser=new TbUser();
        tbUser.setId(-1L);
        tbUser.setUsername("熔断:触发降级方法");
        return tbUser;
    }
}
