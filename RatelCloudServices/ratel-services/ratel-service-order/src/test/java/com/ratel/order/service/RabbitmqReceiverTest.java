package com.ratel.order.service;

import com.ratel.common.core.utils.Debugger;
import com.ratel.middleware.rabbitmq.receiver.ReceiverService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqReceiverTest {
    @Autowired
    @Qualifier("rabbitmqReceiverService")
    private ReceiverService receiverService;

    @Test
    public void testReceiverService() {
        //receiverService.receive();
    }
}
