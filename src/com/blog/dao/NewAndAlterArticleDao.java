package com.blog.dao;

import com.neu.dao.BaseDao;

import java.util.*;

/**
 * @program: blog
 * @description:
 * 接受新文章的数据，写入数据库；
 * 接受修改过的文章数据，更新数据库；
 * 修改文章时，从数据库中返回需要的一些信息；
 * 根据id删除文章
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


    /**
    * @description: 根据id删除一篇文章
    * @author: BIG_TRUCK li zonglin
    **/
    public int deleteArticle(int article_id){

        int row;

        // 先找他的 class id
        String sql_getcid = "select a_cid from article_info where a_id=?";
        List<Map<String, Object>> cidlist;
        Map<String , Object> cidmap;
        int classid;

        cidlist = super.executeQuery(sql_getcid, article_id);

        cidmap = cidlist.get(0);
        classid = (int) cidmap.get("a_cid");


        // 然后看看还有几行
        String sql_classid_howmany= "select a_id from article_info where a_cid=? and a_del=0";
        List<Map<String, Object>> cidrow;
        int rowid;
        cidrow = super.executeQuery(sql_classid_howmany, classid);

        // 删除文章
        String sql_delete = "update article_info set a_del=1 where a_id=?";
        row = super.executeUpdate(sql_delete, article_id);

        if(cidrow.size()==1){
            // 如果 这个分类就剩一个了
            String class_del= "update class_info set class_del=1 where class_id=?";
            super.executeUpdate(class_del, classid);
        }

        return row;
    }
}
