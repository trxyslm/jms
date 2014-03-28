package com.sihuatech.webcache.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.apache.activemq.command.ActiveMQObjectMessage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jms.support.converter.MessageConverter;

/**
 * Converte User message.
 * 
 * @author Yangtze
 */
public class UserMessageConverter implements MessageConverter {
	private static transient Log logger = LogFactory
			.getLog(UserMessageConverter.class);

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.springframework.jms.support.converter.MessageConverter
	 *      #fromMessage(javax.jms.Message)
	 */
	public Object fromMessage(Message message) throws JMSException {
		if (logger.isDebugEnabled()) {
			logger.debug("Receive JMS message: " + message);
		}
		if (message instanceof ObjectMessage) {
			ObjectMessage oMsg = (ObjectMessage) message;
			if (oMsg instanceof ActiveMQObjectMessage) {
				ActiveMQObjectMessage aMsg = (ActiveMQObjectMessage) oMsg;
				try {
					User user = (User) aMsg.getObject();
					return user;
				} catch (Exception e) {
					logger.error("Message:[" + message
							+ "] is not a instance of User.");
					throw new JMSException("Message:[" + message
							+ "] is not a instance of User.");
				}
			} else {
				logger.error("Message:[" + message + "] is not "
						+ "a instance of ActiveMQObjectMessage[User].");
				throw new JMSException("Message:[" + message + "] is not "
						+ "a instance of ActiveMQObjectMessage[User].");
			}
		} else {
			logger.error("Message:[" + message
					+ "] is not a instance of ObjectMessage.");
			throw new JMSException("Message:[" + message
					+ "] is not a instance of ObjectMessage.");
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.springframework.jms.support.converter.MessageConverter#toMessage(java.lang.Object,
	 *      javax.jms.Session)
	 */
	public Message toMessage(Object obj, Session session) throws JMSException {
		if (logger.isDebugEnabled()) {
			logger.debug("Convert User object to JMS message: " + obj);
		}
		if (obj instanceof User) {
			ActiveMQObjectMessage msg = (ActiveMQObjectMessage) session
					.createObjectMessage();
			msg.setObject((User) obj);
			return msg;
		} else {
			logger.error("Object:[" + obj + "] is not a instance of User.");
			throw new JMSException("Object:[" + obj
					+ "] is not a instance of User.");
		}
	}
}
