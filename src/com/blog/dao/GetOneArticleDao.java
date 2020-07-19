package com.blog.dao;

import com.neu.dao.BaseDao;

import java.util.List;
import java.util.Map;

/**
 * @program: Blog1
 * @description: 获得一篇文章的数据
 * @author: BIG_TRUCK li zonglin
 * @create: 2020-07-19 16:49
 **/

public class GetOneArticleDao extends BaseDao {

  /**
  * @description: 通过 id 获得一篇文章的详细数据
  * @author: BIG_TRUCK li zonglin
  **/
  public List<Map<String, Object>> getOneArticle(int article_id){

      List<Map<String, Object>> article_info = null;

      String sql_getOne = "select * from article_info where a_id=?";

      article_info = super.executeQuery(sql_getOne, article_id);

      return article_info;
  }


}
