package test;

import com.blog.service.GetOneArticleService;
import org.junit.Test;

/**
 * @program: Blog1
 * @description: 测试获得一篇文章信息服务
 * @author: BIG_TRUCK li zonglin
 * @create: 2020-07-19 17:08
 **/

public class GOATest {

    /**
    * @description: 通过 id 获得一篇文章的详细信息
    * @author: BIG_TRUCK li zonglin
    **/
    @Test
    public void testGetOneArticle(){
        int article_id = 16;

        GetOneArticleService getOneArticleService = new GetOneArticleService();

        System.out.print(getOneArticleService.get_One_Article(article_id));

    }
}
