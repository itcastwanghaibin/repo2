package com.itheima.dao;

import com.itheima.pojo.User;
import org.springframework.stereotype.Repository;

/**
 * 持久层Dao接口
 */
public interface UserDao {

    User findUserByUsername(String username);
}