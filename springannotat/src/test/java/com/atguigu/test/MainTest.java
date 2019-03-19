package com.atguigu.test;

import com.atguigu.bean.Person;
import com.atguigu.config.MyConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author XL
 * @date 2019/3/16 - 11:26
 **/
public class MainTest {
    
    
    @Test
    public void test01(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfig.class);
        Person bean = applicationContext.getBean(Person.class);
        System.out.println(bean);
    }
    
}
