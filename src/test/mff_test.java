package test;

import com.blog.service.article_info_Service;
import org.junit.Test;
import org.omg.CORBA.OBJ_ADAPTER;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class mff_test {
    @Test
    public void test() {

        // 首先把类的实体对象创建出来
        article_info_Service Service = new article_info_Service();
        // 调用方法即可
        List<Map<String, Object>> list = Service.Find_exhibit_info(1);
        //Map<String,Object> map=new HashMap<String,Object>();
        //打算分割list
        String[] key_info = new String[]{"a_title", "a_ldate", "a_date", "a_context"};
        Object[] value_info = new Object[4];
        int j = 0;
        for (int i = 0; i < list.size(); i++) {
            Map<String, Object> map = list.get(i);
            for (j = 0; j < 4; j++) {
                value_info[j] = map.get(key_info[j]);
            }
        }
        for (int i = 0; i < value_info.length; i++)
            System.out.println(value_info[i]);
        // 打印看看，检查一下有没有错误
//        System.out.println(list);
//    }
    }
}