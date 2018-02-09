package com.abs.infrastructure.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

/**
 * 获取spring容器中的bean实例实现类。
 * 
 * @author Administrator
 * 
 */
public class SpringBeanFactory implements BeanFactoryAware {

	private static BeanFactory beanFactory;

	public static Object getBean(String beanName) {
		return beanFactory.getBean(beanName);
	}

	/**
	 * 获取bean。
	 * 
	 * @param beanName
	 * @param clazs
	 * @return
	 */
	public static <T> T getBean(String beanName, Class<T> clazs) {
		return clazs.cast(getBean(beanName));
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		SpringBeanFactory.beanFactory = beanFactory;
	}

}