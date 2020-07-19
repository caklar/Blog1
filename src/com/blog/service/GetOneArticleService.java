package com.blog.service;

import com.blog.dao.GetOneArticleDao;

import java.util.List;
import java.util.Map;

/**
 * @program: Blog1
 * @description: 获取一篇文章信息的服务
 * @author: BIG_TRUCK li zonglin
 * @create: 2020-07-19 17:02
 **/

public class GetOneArticleService {

    private GetOneArticleDao getOneArticleDao = new GetOneArticleDao();

    /**
    * @description: 通过 id 号获取一篇文章的详细信息 的 服务实现
    * @author: BIG_TRUCK li zonglin
    **/
    public List<Map<String, Object>> get_One_Article(int article_id){

        List<Map<String, Object>> article_info = null;

        article_info = getOneArticleDao.getOneArticle(article_id);

        return article_info;
    }
}
