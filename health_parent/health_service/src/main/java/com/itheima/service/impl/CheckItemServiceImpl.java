package com.itheima.service.impl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.dao.CheckItemDao;
import com.itheima.entity.PageResult;
import com.itheima.pojo.CheckItem;
import com.itheima.service.CheckItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 检查项服务
 */
@Service
@Transactional
public class CheckItemServiceImpl implements CheckItemService {
    @Autowired
    private CheckItemDao checkItemDao;
    //新增
    public void add(CheckItem checkItem) {
        checkItemDao.add(checkItem);
    }

    public PageResult pageQuery(Integer currentPage, Integer pageSize, String queryString) {
        PageHelper.startPage(currentPage,pageSize);
        Page<CheckItem> page = checkItemDao.selectByCondition(queryString);
        return new PageResult(page.getTotal(),page.getResult());
    }

    //删除
    public void delete(Integer id) throws RuntimeException{
        //查询当前检查项是否和检查组关联
        long count = checkItemDao.findCountByCheckItemId(id);
        if(count > 0){
            //当前检查项被引用，不能删除
            throw new RuntimeException("当前检查项被检查组引用，不能删除");
        }
        checkItemDao.deleteById(id);
    }

    // 主键查询
    @Override
    public CheckItem findById(Integer id) {
        CheckItem checkItem = checkItemDao.findCheckItemById(id);
        return checkItem;
    }

    // 编辑保存
    @Override
    public void edit(CheckItem checkItem) {
        checkItemDao.edit(checkItem);
    }
    public List<CheckItem> findAll() {
        return checkItemDao.findAll();
    }
}