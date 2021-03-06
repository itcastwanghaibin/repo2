package com.itheima.dao;

import com.github.pagehelper.Page;
import com.itheima.pojo.CheckGroup;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 持久层Dao接口
 */
@Repository
public interface CheckGroupDao {

    void add(CheckGroup checkGroup);

    void setCheckGroupAndCheckItem(Map<String, Integer> map);

    Page<CheckGroup> selectByCondition(String queryString);
    CheckGroup findById(Integer id);

    List<Integer> findCheckItemIdsByCheckGroupId(Integer id);

    void deleteAssociation(Integer id);

    void edit(CheckGroup checkGroup);

    List<CheckGroup> findAll();
}