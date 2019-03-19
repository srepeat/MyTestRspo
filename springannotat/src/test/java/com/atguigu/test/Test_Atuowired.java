package com.atguigu.test;

import com.atguigu.config.MyConfigOfAutoeired;
import com.atguigu.dao.BookDao;
import com.atguigu.service.BookService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author XL
 * @date 2019/3/18 - 8:44
 **/
public class Test_Atuowired {
    
    
    @Test
    public void test(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfigOfAutoeired.class);

        printBean(applicationContext);

        BookService bookService = applicationContext.getBean(BookService.class);
        System.out.println(bookService);

        BookDao bean = applicationContext.getBean(BookDao.class);
        System.out.println(bean);

    }

    private void printBean(AnnotationConfigApplicationContext applicationContext){
        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        for (String name : definitionNames){
            System.out.println(name);
        }
    }


}
