//package test;
//
//import com.blog.service.DemoService;
//import com.blog.service.article_info_Service;
//import org.junit.Test;
//
//import java.util.List;
//import java.util.Map;
//
///**
// * @program: blog
// * @description: 这个实例是如何写测试文件
// * @author: BIG_TRUCK li zonglin
// * @create: 2020-07-17 00:16
// **/
//
//public class DemoTest {
//    // 比如我们这个类就测试DemoService能不能正常工作
//    // 注意我们用的是Junit4
//    @Test
//    public void test(){
//
//        // 首先把类的实体对象创建出来
//        DemoService demoService = new DemoService();
//        // 调用方法即可
////<<<<<<< HEAD
////        List<Map<String, Object>> list = demoService.getOne();
////=======
////        List<Map<String, Object>> list = Service.Find_CID("2");
////>>>>>>> a3a57d732812b4efdd6e186c93913db724c93c61
//
//        // 打印看看，检查一下有没有错误
//        System.out.println(list);
//    }
//
//}

package test;

import com.blog.service.DemoService;
import com.blog.service.article_info_Service;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * @program: blog
 * @description: 这个实例是如何写测试文件
 * @author: BIG_TRUCK li zonglin
 * @create: 2020-07-17 00:16
 **/

public class DemoTest {
    // 比如我们这个类就测试DemoService能不能正常工作
    // 注意我们用的是Junit4
    @Test
    public void test(){

        // 首先把类的实体对象创建出来
        DemoService demoService = new DemoService();
/*        // 调用方法即可
<<<<<<< HEAD
        List<Map<String, Object>> list = demoService.getOne();
=======
        List<Map<String, Object>> list = Service.Find_CID("2");
>>>>>>> a3a57d732812b4efdd6e186c93913db724c93c61

        // 打印看看，检查一下有没有错误
        System.out.println(list);*/
    }

}
