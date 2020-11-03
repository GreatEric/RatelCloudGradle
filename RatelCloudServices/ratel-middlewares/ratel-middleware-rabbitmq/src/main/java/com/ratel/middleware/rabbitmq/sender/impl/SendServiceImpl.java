package com.ratel.middleware.rabbitmq.sender.impl;

import com.ratel.middleware.rabbitmq.sender.SenderService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("rabbitmqSenderService")
public class SendServiceImpl implements SenderService {
    @Resource
    private AmqpTemplate amqpTemplate;

    @Override
    public void sendMessage(String message) {
        amqpTemplate.convertAndSend("bootDirectExchange", "bootDirectRoutingkey", message);
    }

    @Override
    public void sendFanoutMessage(String message) {
        amqpTemplate.convertAndSend("fanoutExchange","",message);
    }

    @Override
    public void sendTopicMessage(String message) {
        /*amqpTemplate.convertAndSend("topicExchange","aa",message);*/
        amqpTemplate.convertAndSend("topicExchange","aa.bb",message);
    }
}
