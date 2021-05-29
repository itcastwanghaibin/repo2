package com.itheima.service;

import com.itheima.pojo.OrderSetting;

import java.util.List;
import java.util.Map;

/**
 * 预约设置服务接口
 */
public interface OrderSettingService {

    void add(List<OrderSetting> orderSettingList);

    List<Map> getOrderSettingByMonth(String date); //参数格式为：2019-03

    void editNumberByDate(OrderSetting orderSetting);
}