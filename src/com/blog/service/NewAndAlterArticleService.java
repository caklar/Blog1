package com.blog.service;

import com.blog.dao.NewAndAlterArticleDao;

import java.sql.SQLException;

/**
 * @program: blog
 * @description: 新建或修改文章服务
 * @author: BIG_TRUCK li zonglin
 * @create: 2020-07-17 16:06
 **/

public class NewAndAlterArticleService {

    private NewAndAlterArticleDao newAndAlterArticleDao = new NewAndAlterArticleDao();

    // 创建文章
    public int createArticle(String title, String date, String context, String context_md, String cname) {

        int row;
        row = newAndAlterArticleDao.newArticle(title,date,context, context_md, cname);
        return row;
    }

    // 修改文章
    public int update_Article(int a_id, String title, String ldate, String context, String contentmd, String cname){

        int row;

        row = newAndAlterArticleDao.updateArticle(a_id, title, ldate, context, contentmd,cname);

        return row;

    }

    // 删除文章
    public int delete_Article(int article_id){

        int row;
        row = newAndAlterArticleDao.deleteArticle(article_id);
        return row;

    }

    // 根据 classid查 classname
    public String get_class_name(int cid){

        return  newAndAlterArticleDao.getClassName(cid);

    }

    // 获得最大的 a_id
    public int get_max_id(){

        return newAndAlterArticleDao.getMaxId();

    }

    // 获得最大 remark_id
    public int get_Max_remarkid(){

        return newAndAlterArticleDao.getMaxRemarkid();

    }

    // 获得模糊匹配的分类列表
    public String[] get_class_name_list(String field){

        return newAndAlterArticleDao.getClassNameList(field);

    }


}
