package com.ratel.middleware.rabbitmq.receiver.impl;

import com.ratel.middleware.rabbitmq.receiver.ReceiverService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("rabbitmqReceiverService")
public class ReceiverServiceImpl implements ReceiverService {
    @Resource
    private AmqpTemplate amqpTemplate;

    /**
     * @Author: Eric
     * @Date: 2:05 pm
     * @Description: 一次只能接收一条，无法实时监听
     * @Param:
     * @Return:
     */
    @Override
    public void receive() {
        String message = (String) amqpTemplate.receiveAndConvert("bootDirectQueue");
        System.out.println("***************************************");
        System.out.println("message : " + message);
        System.out.println("***************************************");
    }

    /**
     * @Author: Eric
     * @Date: 2:07 pm
     * @Description: @RabbitListener注解用于标记当前方法是一个Rabbitmq的消息监听方法
     * queues 属性: 用于指定一个已经存在的队列名称，用于进行队列的监听
     * 注意: 如果当前监听方法正常结束spring就会自动确认消息，
     * 如果出现异常则不会确认消息，因此在消息处理时需要做好消息的重复处理
     * @Param:
     * @Return:
     */
    @RabbitListener(queues = {"bootDirectQueue"})
    public void directReceive(String message) {
        System.out.println("***************************************");
        System.out.println("监听器接收的消息 : " + message);
        System.out.println("***************************************");
    }

    /**
     * @Author: Eric
     * @Date: 2:25 pm
     * @Description:
     * @QueueBinding 注解要完成队列和交换机的绑定
     * @Queue() 创建一个队列，(没有指定参数则表示创建一个随机队列)
     * @Exchange(name="fanoutExchange",type="fanout") 创建一个交换机
     * @Param:
     * @Return:
     */
    @RabbitListener(bindings = {@QueueBinding(value = @Queue(),exchange = @Exchange(name="fanoutExchange",type="fanout"))})
    public void fanoutReceive01(String message){
        System.out.println("***************************************");
        System.out.println("fanoutReceive01监听器接收的消息 : " + message);
        System.out.println("***************************************");
    }

    @RabbitListener(bindings = {@QueueBinding(value = @Queue(),exchange = @Exchange(name="fanoutExchange",type="fanout"))})
    public void fanoutReceive02(String message){
        System.out.println("***************************************");
        System.out.println("fanoutReceive02监听器接收的消息 : " + message);
        System.out.println("***************************************");
    }

    @RabbitListener(bindings = {@QueueBinding(value=@Queue("topic01"),key={"aa"},exchange = @Exchange(name="topicExchange",type="topic"))})
    public void topicReceive01(String message){
        System.out.println("***************************************");
        System.out.println("topic01消费者 -- aa --: " + message);
        System.out.println("***************************************");
    }

    @RabbitListener(bindings = {@QueueBinding(value=@Queue("topic02"),key={"aa.*"},exchange = @Exchange(name="topicExchange",type="topic"))})
    public void topicReceive02(String message){
        System.out.println("***************************************");
        System.out.println("topic02消费者 -- aa.* --: " + message);
        System.out.println("***************************************");
    }

    @RabbitListener(bindings = {@QueueBinding(value=@Queue("topic03"),key={"aa.#"},exchange = @Exchange(name="topicExchange",type="topic"))})
    public void topicReceive03(String message){
        System.out.println("***************************************");
        System.out.println("topic03消费者 -- aa.# --: " + message);
        System.out.println("***************************************");
    }
}
