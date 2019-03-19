package com.atguigu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import com.atguigu.bean.Color;
import com.atguigu.bean.ColorFactoryBean;
import com.atguigu.bean.Person;
import com.atguigu.bean.Red;
import com.atguigu.conditional.LiunxConditional;
import com.atguigu.conditional.WindowsConditional;


@Configuration //使用配置的方式加载bean
@Conditional({WindowsConditional.class})
@Import({Red.class})
public class MyConfig {
    /**
     * scope域的作用范围
     * ConfigurableBeanFactory#SCOPE_PROTOTYPE  prototype
     * ConfigurableBeanFactory#SCOPE_SINGLETON  singleton
     * prototype : 在每次调用的时候会才创建
     *             在每一次调用都会去获取一个新的容器，每次获取到的地址都不一样
     * singleton : 默认域的作用范围(每次获取执行都是同一个容器)
     *             在执行第一次的时间就创建ioc容器，使用的时候(map.get())获取
     * 懒加载
     *     单例bean==>默认在容器启动创建bean,(单例只会被创建一次，多例就相反)
     *     懒加载==>容器启动不创建对象，第一次使用获取bean创建对象==>懒加载表明需要采取加载，不需要就不管
     * @Conditional==>按照条件注册bean，如果满足给定条件即为true
     *    可以使用在类上添加注解,表明整个类的bean都为同一个条件
     *    注意:如果没有给bean使用条件注解,即默认为bean注册到ioc容器中，
     *    			bean在运行时只看那些满足条件的bean让其注册
     * 给容器中注册组件
     * @Import  将自定义注解加载到springIOC容器中
     * 		Import[快速导入一个组件,打印显示全类名] ==>com.atguigu.bean.Color
     * 		ImportSelector[返回导入的整个容器的全类名的数组]
     *      ImportBeanDefinitionRegistrar
     *
     * @return
     */
    //@Scope("prototype")
    @Lazy
    @Conditional({WindowsConditional.class})
    @Bean("person")
    public Person person() {
        System.out.println("ioc容器创建了........");
        return new Person("王五", 10);
    }

    @Bean("bill")
    @Conditional(LiunxConditional.class)
    public Person person01() {
        return new Person("Bill caits", 60);
    }

    @Bean("lucy")
    @Conditional(WindowsConditional.class)
    public Person person02() {
        return new Person("Lucy", 50);
    }

    /**
     * factoryBean spring的bean工厂
     *              ==>1、默认获取到的是bean工厂getObjcetClass(指的类型)
     *              ==>2、要获取bean的本身，需要在id前面加&符号
     * @return
     */
    @Bean
    public ColorFactoryBean colorFactoryBean() {
        return new ColorFactoryBean();
    }
}
