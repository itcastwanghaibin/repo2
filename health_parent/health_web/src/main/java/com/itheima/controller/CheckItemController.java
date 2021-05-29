package com.itheima.controller;

import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import org.springframework.beans.factory.annotation.Autowired;
import com.itheima.constant.MessageConstant;
import com.itheima.entity.Result;
import com.itheima.pojo.CheckItem;
import com.itheima.service.CheckItemService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * 体检检查项管理
 */
@RestController
@RequestMapping("/checkitem")
public class CheckItemController {
    @Autowired
    private CheckItemService checkItemService;

    //新增
    @RequestMapping("/add")
    @PreAuthorize("hasAuthority('CHECKITEM_ADD')")//权限校验
    public Result add(@RequestBody CheckItem checkItem){
        try {
            checkItemService.add(checkItem);
        }catch (Exception e){
            return new Result(false, MessageConstant.ADD_CHECKITEM_FAIL);
        }
        return new Result(true,MessageConstant.ADD_CHECKITEM_SUCCESS);
    }

    //分页查询
    @RequestMapping("/findPage")
    @PreAuthorize("hasAuthority('CHECKITEM_QUERY')")//权限校验
    public PageResult findPage(@RequestBody QueryPageBean queryPageBean){
        PageResult pageResult = checkItemService.pageQuery(
                queryPageBean.getCurrentPage(),
                queryPageBean.getPageSize(),
                queryPageBean.getQueryString());
        return pageResult;
    }

    //删除
    @RequestMapping("/delete")
    @PreAuthorize("hasAuthority('CHECKITEM_DELETE')")
    public Result delete(Integer id){
        try {
            checkItemService.delete(id);
        }catch (RuntimeException e){
            return new Result(false,e.getMessage());
        }catch (Exception e){
            return new Result(false, MessageConstant.DELETE_CHECKITEM_FAIL);
        }
        return new Result(true,MessageConstant.DELETE_CHECKITEM_SUCCESS);
    }

    // 跳转到检查项编辑页面
    @RequestMapping("/findById")
    public Result findById(Integer id){
        CheckItem checkItem = checkItemService.findById(id);
        if(checkItem!=null){
            return new Result(true,MessageConstant.QUERY_CHECKITEM_SUCCESS,checkItem);
        }
        else{
            return new Result(false,MessageConstant.QUERY_CHECKITEM_FAIL);
        }
    }

    //编辑保存
    @RequestMapping("/edit")
    @PreAuthorize("hasAuthority('CHECKITEM_EDIT')")//权限校验
    public Result edit(@RequestBody CheckItem checkItem){
        try {
            checkItemService.edit(checkItem);
        }catch (Exception e){
            return new Result(false,MessageConstant.EDIT_CHECKITEM_FAIL);
        }
        return new Result(true,MessageConstant.EDIT_CHECKITEM_SUCCESS);
    }

    //查询所有
    @RequestMapping("/findAll")
    public Result findAll(){
        List<CheckItem> checkItemList = checkItemService.findAll();
        if(checkItemList != null && checkItemList.size() > 0){
            Result result = new Result(true, MessageConstant.QUERY_CHECKITEM_SUCCESS,checkItemList);
            //result.setData(checkItemList);
            return result;
        }
        return new Result(false,MessageConstant.QUERY_CHECKITEM_FAIL);
    }
}