package com.blog.dao;
import com.neu.dao.BaseDao;
import org.omg.CORBA.OBJ_ADAPTER;

import java.util.List;
import java.util.Map;

/*
更新于7-17 10:10
实现关于文章的全部选取
实现按照分类进行文章的选取
*/
public class article_info_Dao extends BaseDao {

    // 按照修改时间
    public List<Map<String ,Object>> get_All_Article_Bydate(){

        List<Map<String ,Object>> list=null;
        String sql="SELECT * FROM article_info " +
                " WHERE a_del=0 ORDER  BY a_date DESC";
        list=super.executeQuery(sql);
        return list;

    }

    //搜索所有文章 按照创建时间
    public List<Map<String ,Object>> get_All_Article(){
        List<Map<String ,Object>> list=null;
        String sql="SELECT * FROM article_info " +
                " WHERE a_del=0 ORDER BY a_ldate DESC";
        list=super.executeQuery(sql);
        return list;
    }
    //按照文章分类搜索
    public List<Map<String, Object>> get_id_article(String id){
        List<Map<String ,Object>> list=null;
        // li zong lin 做了修改，添加了 AND a_del=0
        String sql="SELECT * from article_info where a_cid=? AND a_del=0 ORDER  BY a_date DESC";
        list=super.executeQuery(sql,id);
        return list;
    }
    //展示文章必要信息
    public List<Map<String ,Object>> get_exhibit_info(int id){
        List<Map<String,Object>> list=null;
        String sql="SELECT a_title,a_context,a_date,a_ldate from article_info where a_id=?";
        list=super.executeQuery(sql,id);
        return list;
    }
    //显示文章分类
    public List<Map<String , Object>> get_class_info(){
        List<Map<String,Object>> list=null;
        String sql="SELECT class_id,class_name from class_info where class_del=0";
        list=super.executeQuery(sql);
        return list;
    }
    public List<Map<String ,Object>> get_exhibit_info_2(){
        List<Map<String,Object>> list=null;
        String sql="SELECT a_id,a_title,a_context_md,a_date,a_ldate from article_info where a_del=0 ORDER BY a_ldate DESC";
        list=super.executeQuery(sql);
        return list;
    }
}
