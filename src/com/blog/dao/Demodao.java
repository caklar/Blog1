package com.blog.dao;

import com.neu.dao.BaseDao;

import java.util.List;
import java.util.Map;

/**
 * @program: blog
 * @description: this is a demo 本示例功能是从数据库中取一条作品记录
 * @author: BIG_TRUCK li zonglin
 * @create: 2020-07-17 00:04
 **/

public class Demodao extends BaseDao {
    public List<Map<String, Object>> getOneArticle(){
        List<Map<String, Object>> list=null;
        String sql="select * from article_info " +
                " where a_id=1";
        list=super.executeQuery(sql);
        return list;
    }
}
