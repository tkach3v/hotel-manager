package com.tkachev.broker.impl;

import com.tkachev.broker.BrokerService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;

//@Service
@Log4j2
public class ActiveMQServiceImpl implements BrokerService {
    @Autowired
    JmsTemplate jmsTemplate;

    @Override
    public <T> void sendMessage(T entity) {
        jmsTemplate.convertAndSend(entity);
        log.info("Message sent to " + jmsTemplate.getDefaultDestinationName());
    }
}
