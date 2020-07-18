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

    public int createArticle(String title, String date, String context, String cname) {

        int row;
        row = newAndAlterArticleDao.newArticle(title,date,context,cname);
        return row;
    }


}
