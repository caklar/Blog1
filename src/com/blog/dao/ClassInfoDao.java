package com.blog.dao;

import com.neu.dao.BaseDao;

import java.util.List;
import java.util.Map;

public class ClassInfoDao extends BaseDao {
    public List<Map<String ,Object>> getAllClasses(){
        List<Map<String ,Object>> list=null;
        String sql="SELECT * FROM class_info " +
                " WHERE class_del=0";
        list=super.executeQuery(sql);
        return list;
    }
}
