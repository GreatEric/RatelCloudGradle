package com.ratel.order.service;

import com.ratel.common.core.utils.Debugger;

import com.ratel.middleware.rabbitmq.sender.SenderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqSenderTest {
    @Autowired
    @Qualifier("rabbitmqSenderService")
    private SenderService senderService;

    @Test
    public void testDirectSend(){
        senderService.sendMessage("Boot测试数据xxx");
    }

    @Test
    public void testFanoutSend(){
        senderService.sendFanoutMessage("Boot Fanout测试数据");
    }

    @Test
    public void testTopicSend(){
        senderService.sendTopicMessage("Boot Topic测试数据");
    }
}
