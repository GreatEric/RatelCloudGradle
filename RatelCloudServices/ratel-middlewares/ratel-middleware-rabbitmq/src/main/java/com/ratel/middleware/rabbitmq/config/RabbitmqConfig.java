package com.ratel.middleware.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqConfig {

    //配置一个Direct类型的交换机
    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange("bootDirectExchange");
    }

    //配置一个队列
    @Bean
    public Queue directQueue(){
        return new Queue("bootDirectQueue");
    }

    /**
     * @Author: Eric
     * @Date: 1:38 pm
     * @Description: 配置一个队列和交换机的绑定
     * @Param: Queue directQueue 需要绑定的队列的对象，参数名称必须要与某个@Bean的方法名完全相同，这样就会自动进行注入
     * @Param: DirectExchange directExchange 需要绑定的交换机的对象，参数名称必须要与某个@Bean的方法名完全相同，这样就会自动进行注入
     * @Return:
     */
    @Bean
    public Binding directBinding(Queue directQueue,DirectExchange directExchange){
        return BindingBuilder.bind(directQueue).to(directExchange).with("bootDirectRoutingkey");
    }

    //配置一个Fanout类型的交换机
    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("fanoutExchange");
    }

    //配置一个Topic类型的交换机
    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange("topicExchange");
    }
}
