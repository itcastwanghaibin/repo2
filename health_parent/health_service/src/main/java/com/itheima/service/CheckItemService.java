package com.itheima.service;

import com.itheima.entity.PageResult;
import com.itheima.pojo.CheckItem;

import java.util.List;

/**
 * 检查项服务接口
 */
public interface CheckItemService {
    void add(CheckItem checkItem);
    PageResult pageQuery(Integer currentPage, Integer pageSize, String queryString);
    void delete(Integer id);
    // 跳转到检查项编辑页面
    CheckItem findById(Integer id);
    // 编辑保存
    void edit(CheckItem checkItem);
    List<CheckItem> findAll();
}