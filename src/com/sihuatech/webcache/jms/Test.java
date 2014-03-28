package com.sihuatech.webcache.jms;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jms-applicationContext.xml");
		UserMessageProducerImpl producer = (UserMessageProducerImpl) ctx.getBean("userMessageProducerImpl");
		producer.sendUserLoginInformationMail(new User("xxoo", 18));
	}
	
}
