package com.zjh.dao;

import com.zjh.po.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositor extends JpaRepository<User,Long> {

    User findByUsernameAndPassword(String username,String password);

}
