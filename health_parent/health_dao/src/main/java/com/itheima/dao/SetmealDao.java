package com.itheima.dao;
import com.itheima.pojo.Setmeal;
import org.springframework.stereotype.Repository;
import java.util.Map;
public interface SetmealDao {

    void add(Setmeal setmeal);

    void setSetmealAndCheckGroup(Map<String, Integer> map);
}