package com.ratel.middleware.rabbitmq.sender;

public interface SenderService {
    void sendMessage(String message);

    void sendFanoutMessage(String message);

    void sendTopicMessage(String message);
}
