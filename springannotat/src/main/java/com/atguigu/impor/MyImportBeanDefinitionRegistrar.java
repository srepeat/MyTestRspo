package com.atguigu.impor;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import com.atguigu.bean.RowBlue;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar{
	/**
	 * importingClassMetadata==>当前类的注解信息
	 * BeanDefinitionRegistry:BeanDefinition注册类；
	 * 		把所有需要添加到容器中的bean；调用
	 * 		BeanDefinitionRegistry.registerBeanDefinition手工注册进来
	 */
	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		// TODO Auto-generated method stub
		boolean beanDefinition1 = registry.containsBeanDefinition("com.atguigu.bean.Color");
		boolean beanDefinition2 = registry.containsBeanDefinition("com.atguigu.bean.Red");
		//判断两个bean是否存在
		if(beanDefinition1 && beanDefinition2) {
			//等同于把两个bean注册到一个bean中==>当前这个bean包装了两个bean
			//指定bean的定义信息 (Bean的类型)
			RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(RowBlue.class);
			//注册一个bean，指定bean的名==>手动注入bean
			registry.registerBeanDefinition("rowBlue", rootBeanDefinition);
		}
	}

}
