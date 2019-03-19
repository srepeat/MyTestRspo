package com.atguigu.service;

import com.atguigu.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author XL
 * @date 2019/3/18 - 8:43
 **/
@Service
public class BookService {

    //@Qualifier("bookDao2")
    @Autowired(required = false)
    private BookDao bookDao;


    public void prinit(){
        System.out.println(bookDao);
    }

    @Override
    public String toString() {
        return "BookService{" +
                "bookDao=" + bookDao +
                '}';
    }
}
