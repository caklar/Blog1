package com.blog.service;

import com.blog.dao.article_info_Dao;

import java.util.List;
import java.util.Map;

/*
更新于7-17 10:16
完成对于article_info_Dao具体化
*/
public class article_info_Service {
    private article_info_Dao article_Dao=new article_info_Dao();

    public List<Map<String,Object>> Find_All()
    {
        List<Map<String,Object>> list=null;
        list=article_Dao.get_All_Article();
        return list;
    }

    public List<Map<String,Object>> Find_CID(String id)
    {
        List<Map<String,Object>> list=null;
        list=article_Dao.get_id_article(id);
        return list;
    }
    //显示文章外部信息
    public List<Map<String ,Object>> Find_exhibit_info(int id){
        List<Map<String,Object>> list=null;
        list=article_Dao.get_exhibit_info(id);
        return list;
    }
    public List<Map<String ,Object>> Find_class_info(){
        List<Map<String,Object>> list=null;
        list=article_Dao.get_class_info();
        return list;
    }
    public List<Map<String ,Object>> Find_exhibit_info_2(){
        List<Map<String,Object>> list=null;
        list=article_Dao.get_exhibit_info_2();
        return list;
    }
}
