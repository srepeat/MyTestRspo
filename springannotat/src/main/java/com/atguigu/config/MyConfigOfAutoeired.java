package com.atguigu.config;

import com.atguigu.dao.BookDao;
import com.atguigu.service.BookService;
import org.springframework.context.annotation.*;

/**
 * @author XL
 * @date 2019/3/18 - 8:42
 **/
@Configuration //配置类注解
@ComponentScan({"com.atguigu.service","com.atguigu.dao"})
//@Import({BookService.class, BookDao.class})
public class MyConfigOfAutoeired {

    //@Primary
    @Bean("bookDao2")
    public BookDao bookDao(){
        BookDao bookDao = new BookDao();
        bookDao.setLible("2");
        return bookDao;
    }

}
