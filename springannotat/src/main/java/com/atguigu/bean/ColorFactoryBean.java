package com.atguigu.bean;

import org.springframework.beans.factory.FactoryBean;
/**
 * factoryBean 实现bean工厂接口，类型执行class类==>基本属于对class类的包装
 * @author 鲜磊
 *
 */

public class ColorFactoryBean implements FactoryBean<Color> {

	@Override
	public Color getObject() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("ColorFactoryBean....getObject...");
		//返回当前对象的类
		return new Color();
	}

	@Override
	public Class<?> getObjectType() {
		// TODO Auto-generated method stub
		//返回当前返回值的类型
		System.out.println("ColorFactoryBean....Class....");
		return Color.class;
	}

	@Override
	public boolean isSingleton() {
		// TODO Auto-generated method stub
		//singleton == true开启单例(指容器创建，需要时从容器中获取)   ==>false多例(每次都创建一个新的对象)
		return false;
	}

}
