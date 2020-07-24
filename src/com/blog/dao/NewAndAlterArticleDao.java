package com.blog.dao;

import com.neu.dao.BaseDao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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

    /**
    * @description: 接受文章信息，将新建的文章写入数据库
    * @author: BIG_TRUCK li zonglin
    **/
    public int newArticle(String title, String date, String context, String context_md, String cname) {

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
        String sql_insert = "insert into article_info (a_title, a_cid, a_context, a_context_md, a_ldate, a_date) VALUES" +
                " (?,?,?,?,?,?)";
        row=super.executeUpdate(sql_insert, title, id, context, context_md, date, date);

        return row;
    }

    /**
    * @description: 接受文章信息，将 对相应的文章在数据库中进行修改
     * -- 在这里不用修改date了，只修改ldate就行
    * @author: BIG_TRUCK li zonglin
    **/
    public int updateArticle(int a_id, String title, String ldate, String context, String contentmd, String cname){
        int row;

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

        int cid = (int)c_id.get(0).get("class_id");

        String sql_update = "update article_info set " +
                " a_title=?, a_cid=?, a_context=?, a_context_md=?, a_ldate=? " +
                " where a_id=?";

        row=super.executeUpdate(sql_update, title, cid, context, contentmd, ldate, a_id);

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

    /**
    * @description: 通过分类id获取分类名字
    * @author: BIG_TRUCK li zonglin
    **/
    public String getClassName(int cid){

        List<Map<String, Object>> res;

        String sql_getcname = "select class_name from class_info where class_id=?";

        res = super.executeQuery(sql_getcname, cid);

        Map<String, Object> cmap = res.get(0);

        String cnam = (String) cmap.get("class_name");

        return cnam;

    }

    /**
    * @description: 获得最大评论id
    * @author: BIG_TRUCK li zonglin
    **/
    public int getMaxRemarkid(){
        List<Map<String, Object>> list_id;
        Map<String, Object> map_id;
        int m_id;

        String sql_getMax = "select remark_id from remark_info where remark_id=(select max(remark_id) from remark_info)";

        list_id = super.executeQuery(sql_getMax);
        map_id = list_id.get(0);

        m_id = (int) map_id.get("remark_id");

        return m_id;
    }


    /**
    * @description: 获取最大 文章id
    * @author: BIG_TRUCK li zonglin
    **/
    public int getMaxId(){

        List<Map<String, Object>> list_id;
        Map<String, Object> map_id;
        int m_id;

        String sql_getMax = "select a_id from article_info where a_id=(select max(a_id) from article_info)";

        list_id = super.executeQuery(sql_getMax);
        map_id = list_id.get(0);

        m_id = (int) map_id.get("a_id");

        return m_id;
    }

    /**
    * @description: 在新建文文章页面实现 输入分类进行模糊匹配，返回一个查询后的字符串数组
    * @author: BIG_TRUCK li zonglin
    **/
    public String[] getClassNameList(String field){

        ArrayList<String> class_name_Arraylist = new ArrayList<String>();
        List<Map<String, Object>> class_name_ListMap;

        //
//正确写法，注意：filed前后引号后要加空格 “ ”
//        String sql = "select * from user where "+ filed +" like ?;
//        Object[] obj = {"%"+key+"%"};
//        ResultSet resultSet = dbUtil1.select(sql,objects);


        String sql_getClassName  = "select class_name from class_info where  class_del=0 and class_name like \"%\"?\"%\" ";

        class_name_ListMap = super.executeQuery(sql_getClassName, field);

        Map<String, Object> temp;
        for(int i = 0; i < class_name_ListMap.size(); i++){

            temp = class_name_ListMap.get(i);
            class_name_Arraylist.add((String) temp.get("class_name"));

        }

        // ArrayList转为字符串数组
        String[] class_name_array = new String[class_name_Arraylist.size()];

        class_name_Arraylist.toArray(class_name_array);

//        for(int i=0; i<class_name_Arraylist.size(); i++){
//            class_name_array[i] = class_name_Arraylist.get(i);
//        }

        return class_name_array;

    }
}
