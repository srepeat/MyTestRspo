package com.atguigu.dao;

import org.springframework.stereotype.Repository;

/**
 * @author XL
 * @date 2019/3/18 - 8:43
 **/
@Repository
public class BookDao {

    private String lible="1";

    public String getLible() {
        return lible;
    }

    public void setLible(String lible) {
        this.lible = lible;
    }

    @Override
    public String toString() {
        return "BookDao{" +
                "lible='" + lible + '\'' +
                '}';
    }
}
