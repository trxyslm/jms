package com.sihuatech.webcache.jms;

import org.springframework.jms.core.JmsTemplate;
/**
* Send user's login information mail via JMS.
*
* @author Yangtze
*/
public class UserMessageProducerImpl {
    private JmsTemplate jmsTemplate;
    /**
     * {@inheritDoc}
     *
     * @see com.tiandinet.jms.sample.IUserMessageProducer
     * #sendUserLoginInformationMail(com.tiandinet.jms.sample.User)
     */
    public void sendUserLoginInformationMail(User user) {
        getJmsTemplate().convertAndSend(user);
    }
    /**
     * Return the jmsTemplate.
     *
     * @return the jmsTemplate
     */
    public final JmsTemplate getJmsTemplate() {
        return jmsTemplate;
    }
    /**
     * Set the jmsTemplate.
     *
     * @param jmsTemplate
     *            the jmsTemplate to set
     */
    public final void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }
} 