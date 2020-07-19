package com.blog.service;

import com.blog.dao.ClassInfoDao;
import com.blog.dao.article_info_Dao;
import net.sf.json.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArticleInfoService_wsy {
    private article_info_Dao article_Dao=new article_info_Dao();
    private ClassInfoDao classInfoDao = new ClassInfoDao();
    /*
    获取所有文章信息
     */
    public List<Map<String ,Object>> get_All_Article(){
        List<Map<String ,Object>> list=null;
        list = article_Dao.get_All_Article();
        return list;
    }
    /*
    返回某种类型的文章信息
     */
    public List<Map<String,Object>> getArticleOfClass(String class_id){
        return article_Dao.get_id_article(class_id);
    }


    /*
    返回json格式的数据
     */
    public JSONArray findAll()
    {
        List<Map<String,Object>> list=null;
        list=article_Dao.get_All_Article();
        JSONArray jsonArray = JSONArray.fromObject(list);
        return jsonArray;
    }
    /*
    返回类别和数量信息
     */
    public JSONArray getAllClasses(){
        List<Map<String,Object>> ClassAndNumber=new ArrayList<Map<String, Object>>();//返回类别和数量信息
        List<Map<String,Object>> Classes = classInfoDao.getAllClasses();
        for(Map<String,Object> map:Classes){
            //class_name_id;
            Map<String,Object> classAndNumber = new HashMap<String, Object>();
            classAndNumber.put("class_id",map.get("class_id"));
            Integer number = (article_Dao.get_id_article(map.get("class_id").toString())).size();

        }
        JSONArray jsonArray = JSONArray.fromObject(ClassAndNumber);
        return jsonArray;
    }
}
