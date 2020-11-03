package com.ratel.middleware.rabbitmq.receiver;

public interface ReceiverService {
    void receive();

    void directReceive(String message);

    void fanoutReceive01(String message);

    void fanoutReceive02(String message);
}
