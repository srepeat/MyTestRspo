package com.atguigu.config;

import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

public class MyTypeFilter implements TypeFilter {

	/**
	 * metadataReader:读取到的当前正在扫描的类信息
	 * metadataReaderFactory：可以获取到其他类信息
	 */
	public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
		// TODO Auto-generated method stub
		//获取当前注解的信息
		AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
		//获取当前正在扫描类的信息
		ClassMetadata classMetadata = metadataReader.getClassMetadata();
		//获取当前资源
		Resource resource = metadataReader.getResource();
		//当前类的className
		String className = classMetadata.getClassName();
		System.out.println("===>"+className);
		//可以使用classNmae来判断那些来进行拦截和匹配
		if(className.contains("er")) {
			//如果为真就返回true
			return true;
		}
		return false;
	}

}
