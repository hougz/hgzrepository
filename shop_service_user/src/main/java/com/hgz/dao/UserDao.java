package com.hgz.dao;

import com.hgz.pojo.TbUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserDao extends JpaRepository<TbUser,Long >, JpaSpecificationExecutor<TbUser> {

}
