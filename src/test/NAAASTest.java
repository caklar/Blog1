package test;

import com.alibaba.fastjson.JSONArray;
import com.blog.service.NewAndAlterArticleService;
import org.junit.Test;

import java.sql.SQLException;
import java.util.Arrays;

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
        String title = "窝窝头";
        String date = "2020-07-18";
        String context = "小鸟伏特加";
        String cname = "时尚";
        String context_md = "# 123";

        NewAndAlterArticleService newAndAlterArticleService = new NewAndAlterArticleService();
        newAndAlterArticleService.createArticle(title, date, context, context_md, cname);
    }

    // 测试修改文章
    @Test
    public void updateArticle(){

        int row;

        int a_id = 6;
        String title = "Test修改文章测试";
        String cname = "以及";
        String context = "测试新的修改文章的分类";
        String ldate = "2020-07-20";
        String contentmd = "# erwr";

        NewAndAlterArticleService update_Article = new NewAndAlterArticleService();
        row = update_Article.update_Article(a_id, title, ldate, context, contentmd, cname);
        System.out.print(row);

    }

    // 测试删除文章
    @Test
    public void deleteArticle(){
        int article_id = 38;
        int row;
        NewAndAlterArticleService newAndAlterArticleService = new NewAndAlterArticleService();
        row = newAndAlterArticleService.delete_Article(article_id);
        System.out.print(row);
    }


    // 测试根据classid查classname
    @Test
    public void  getclassname(){

        int cid = 22;
        NewAndAlterArticleService newAndAlterArticleService = new NewAndAlterArticleService();
        System.out.print(newAndAlterArticleService.get_class_name(cid));

    }

    // 测试根据输入返回模糊匹配到的分类列表
    @Test
    public void getclasslist(){

        String field1 = "法";
        String field2 = "";

        NewAndAlterArticleService getclasslist = new NewAndAlterArticleService();

        String[] string =  getclasslist.get_class_name_list(field1);

        JSONArray jsonArray=new JSONArray(Arrays.asList(string));
        System.out.println(jsonArray.toString());

//        for (int i=0;i < string.length; i++){
//            System.out.println(string[i]);
//        }
//
//        System.out.println(string);


    }

}
