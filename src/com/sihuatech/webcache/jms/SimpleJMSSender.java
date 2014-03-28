package com.sihuatech.webcache.jms;


import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class SimpleJMSSender {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-send.xml");
		
		JmsTemplate jmsTemplate = (JmsTemplate) ctx.getBean("myJmsTemplate");
		for (int i = 0; i < 10; i++) {
			jmsTemplate.send(new MessageCreator() {
				public Message createMessage(Session session) throws JMSException {
					TextMessage msg = session.createTextMessage();
					// 设置消息属性
					msg.setStringProperty("phrCode", "C001");
					// 设置消息内容
					msg.setText("Hello World!");
					return msg;
				}
			});
		}
	}
}
