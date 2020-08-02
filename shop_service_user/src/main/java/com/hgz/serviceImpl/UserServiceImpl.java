package com.hgz.serviceImpl;

import com.hgz.dao.UserDao;
import com.hgz.pojo.TbUser;
import com.hgz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public TbUser findById(Long id) {
        return userDao.findById(id).get();
    }

    @Override
    public List findAll() {
        return userDao.findAll();
    }

    @Override
    public void save(TbUser user) {
         userDao.save(user);
    }

    @Override
    public void update(TbUser user) {
           userDao.save(user);
    }

    @Override
    public void delete(Long id) {
        userDao.deleteById(id);
    }
}
