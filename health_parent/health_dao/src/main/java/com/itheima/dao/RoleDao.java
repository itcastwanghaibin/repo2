package com.itheima.dao;

import com.itheima.pojo.Role;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * 持久层Dao接口
 */
public interface RoleDao {

    Set<Role> findRolesByUserId(Integer userId);

}