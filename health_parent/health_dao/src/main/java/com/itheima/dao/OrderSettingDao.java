package com.itheima.dao;

import com.itheima.pojo.OrderSetting;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 持久层Dao接口
 */
public interface OrderSettingDao {


    int findCountByOrderDate(Date orderDate);

    void editNumberByOrderDate(OrderSetting orderSetting);

    void add(OrderSetting orderSetting);

    List<OrderSetting> getOrderSettingByMonth(Map map);
}