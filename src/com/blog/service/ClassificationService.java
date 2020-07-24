package com.blog.service;

import com.blog.dao.ClassNumberDao;

import java.util.List;
import java.util.Map;

public class ClassificationService {
    private ClassNumberDao classNumberDao = new ClassNumberDao();
    public List<Map<String,Object>> getClassAndNumber(){
        /*
        用于返回类别和数量信息
         */
        return classNumberDao.getClassesAndNumber();
    }
}
