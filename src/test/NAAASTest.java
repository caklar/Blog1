package test;

import com.blog.service.NewAndAlterArticleService;
import org.junit.Test;

import java.sql.SQLException;

/**
 * @program: blog
 * @description: 新建文章修改文章测试类
 * @author: BIG_TRUCK li zonglin
 * @create: 2020-07-17 16:22
 **/

public class NAAASTest {


    // 测试新建文章
    @Test
    public void testCreateArticle() {
        //String title, String date, String context, String cname
        String title = "雷霆八嘎";
        String date = "2020-07-18";
        String context = "小鸟伏特加喝了这么高";
        String cname = "时尚";

        NewAndAlterArticleService newAndAlterArticleService = new NewAndAlterArticleService();
        newAndAlterArticleService.createArticle(title,date,context,cname);
    }

}
