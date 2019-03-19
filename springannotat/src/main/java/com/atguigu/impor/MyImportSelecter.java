package com.atguigu.impor;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelecter implements ImportSelector {

	//importingClassMetadata:当前注解的类信息  返回值不能为null，可以返回数组
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		// TODO Auto-generated method stub
		String [] classMetadata = new String[]{"com.atguigu.bean.Color","com.atguigu.bean.Red"};
		return classMetadata;
	}

}
