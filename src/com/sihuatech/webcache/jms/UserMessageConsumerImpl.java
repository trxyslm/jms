package com.sihuatech.webcache.jms;

import javax.jms.JMSException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/**
* JMS message handler - for User Message.
*
* Yangtze
*/
public class UserMessageConsumerImpl {
    private static transient Log logger = LogFactory.getLog(UserMessageConsumerImpl.class);
//    private IMailService mailService;
    /**
     * {@inheritDoc}
     *
     * @see com.tiandinet.jms.sample.IMessageConsumer
* #handleMessage(com.tiandinet.jms.sample.User)
     */
    public void handleMessage(User user) throws JMSException {
        if (logger.isDebugEnabled()) {
            logger.debug("Receive a User object from ActiveMQ: " + user.toString());
        }
        System.out.println("收到消息："+user.toString());
//        mailService.sendUserLoginInforMail(user);
    }
}