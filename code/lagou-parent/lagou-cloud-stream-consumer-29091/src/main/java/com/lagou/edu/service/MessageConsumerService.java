package com.lagou.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;

@EnableBinding(Sink.class)
public class MessageConsumerService {

//    @Autowired
//    private Sink sink;

    @StreamListener(Sink.INPUT)
    public void recieveMessages(Message<String> message){
        System.out.println("=======recieveMessages : "+message.getPayload()+" port : ");
    }
}
