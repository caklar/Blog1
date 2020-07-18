package test;

import com.blog.dao.ClassInfoDao;
import org.junit.Test;

public class ClassInfoTest {
    @Test
    public void getAllClassTest(){
        System.out.println(new ClassInfoDao().getAllClasses());
    }
}
