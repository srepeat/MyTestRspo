package com.atguigu.bean;

import org.springframework.beans.factory.FactoryBean;
/**
 * factoryBean ʵ��bean�����ӿڣ�����ִ��class��==>�������ڶ�class��İ�װ
 * @author ����
 *
 */

public class ColorFactoryBean implements FactoryBean<Color> {

	@Override
	public Color getObject() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("ColorFactoryBean....getObject...");
		//���ص�ǰ�������
		return new Color();
	}

	@Override
	public Class<?> getObjectType() {
		// TODO Auto-generated method stub
		//���ص�ǰ����ֵ������
		System.out.println("ColorFactoryBean....Class....");
		return Color.class;
	}

	@Override
	public boolean isSingleton() {
		// TODO Auto-generated method stub
		//singleton == true��������(ָ������������Ҫʱ�������л�ȡ)   ==>false����(ÿ�ζ�����һ���µĶ���)
		return false;
	}

}
