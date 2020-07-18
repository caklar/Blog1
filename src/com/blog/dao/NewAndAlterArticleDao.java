package com.blog.dao;

import com.neu.dao.BaseDao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;

/**
 * @program: blog
 * @description: 接受新文章的数据，写入数据库；接受修改过的文章数据，更新数据库；修改文章时，从数据库中返回需要的一些信息
 * @author: BIG_TRUCK li zonglin
 * @create: 2020-07-17 14:04
 **/

public class NewAndAlterArticleDao extends BaseDao {

    public static List getKeySet(Map map){
        List<String> list= new ArrayList<>();
        Set set = map.keySet();
        Iterator it = set.iterator();
        while(it.hasNext()){
            list.add(it.next().toString());
        }
        return list;
    }


    public int newArticle(String title, String date, String context, String cname) {

        int row=0;

        // 先判断分类信息是否需要更新
        List<Map<String, Object>> c_id;
        String sql_getcid = "select class_id from class_info where class_name='" + cname + "'";
        c_id = super.executeQuery(sql_getcid);

        // 如果为空，就插入,同时获取id
        if(c_id.size()==0){
            String sql_insertcid = "insert into class_info (class_name) VALUES" +
                    " (?)";
            super.executeUpdate(sql_insertcid, cname);
            c_id = super.executeQuery(sql_getcid);
        }

        int id = (int)c_id.get(0).get("class_id");


        // 插入
        //INSERT INTO article_info (a_title, a_context, a_ldate, a_date) VALUES
        // ('新建文章测试','随便写"dsd"点什么','2020-21-11','2020-09-11');
        String sql_insert = "insert into article_info (a_title, a_cid, a_context, a_ldate, a_date) VALUES" +
                " (?,?,?,?,?)";
        row=super.executeUpdate(sql_insert, title, id, context, date, date);


        return row;
    }
}
