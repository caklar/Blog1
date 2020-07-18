package test;

import com.blog.dao.article_info_Dao;
import org.junit.Test;

public class Article_Info_Dao_Test {
    article_info_Dao aid = new article_info_Dao();
    @Test
    public void getAllArticleTest(){

        System.out.println(aid.get_All_Article());
    }
    @Test
    public void get_exhibit_infoTest(){
        System.out.println(aid.get_exhibit_info(1));
    }
}
