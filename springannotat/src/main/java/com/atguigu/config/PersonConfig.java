package com.atguigu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import com.atguigu.bean.Person;
//使用注解一定要有构造参数，并且是有参的构造参数
@Configuration  //bean.xml ==>annotationConf方式代替
/*
 * 使用注解方式==>默认是扫描所有,可以通过Filers方式设置过滤
 * classes ==>数组格式可以配置多个
 * type ==>filterType过滤类型 ==>本次使用注解过滤
 * includeFilters ==>包含那些组件要关闭扫描全部组件
 * useDefaultFilters默认为true(表示全部扫描) ==>我们改为false(只扫描我们所指定的)
 * componentScans==>配置多个扫描(数组)
 */
@ComponentScans(value= {
		@ComponentScan(value="com.atguigu",includeFilters= {
				//@Filter(type=FilterType.ANNOTATION,classes= {Controller.class,Bean.class}),
				@Filter(type=FilterType.CUSTOM,classes=MyTypeFilter.class)//自定义
		},useDefaultFilters=false)
})
//Filter []
//includeFilters [] filters ===>指定要包含那些组件
//excludeFilters [] filters ==>指定排除那些声明了的组件
public class PersonConfig {

	//@Bean("person") //等同配置bean一样  注入一个bean(实体),类型为返回类型，id默认以方法名为id
	public Person person() {
		return new Person("李四", 20);
	}
}
