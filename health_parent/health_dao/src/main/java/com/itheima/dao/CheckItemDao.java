package com.itheima.dao;

import com.github.pagehelper.Page;
import com.itheima.pojo.CheckItem;

import java.util.List;

/**
 * 持久层Dao接口
 */
public interface CheckItemDao {
    public void add(CheckItem checkItem);
    Page<CheckItem> selectByCondition(String queryString);
    long findCountByCheckItemId(Integer id);
    void deleteById(Integer id);
    CheckItem findCheckItemById(Integer id);
    void edit(CheckItem checkItem);
    List<CheckItem> findAll();
}