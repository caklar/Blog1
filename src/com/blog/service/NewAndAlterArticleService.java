package com.blog.service;

import com.blog.dao.NewAndAlterArticleDao;

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

    public int delete_Article(int article_id){

        int row;
        row = newAndAlterArticleDao.deleteArticle(article_id);
        return row;

    }


}
