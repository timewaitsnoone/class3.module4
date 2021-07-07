package com.lagou.edu.service.Impl;

import com.lagou.edu.service.IMessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;

@EnableBinding(Source.class)
public class MessageProducerImpl implements IMessageProducer {

    @Autowired
    private Source source;

    @Override
    public void sendMessage(String content) {
        source.output().send(MessageBuilder.withPayload(content).build());
    }
}
