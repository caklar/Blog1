package com.blog.dao;

import com.neu.dao.BaseDao;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/*
    用于返回类别数量信息
 */
public class ClassNumberDao extends BaseDao {
    /*
    用于返回类别id,类别名，类别数量
     */
    public List<Map<String,Object>> getClassesAndNumber(){
        List<Map<String,Object>> list=null;
        String sql = "select * from class_number";
        list = super.executeQuery(sql);
        return list;
    }
}
