package com.jr.kafka.springbootkafkaproducer.service;
import com.jr.kafka.springbootkafkaproducer.model.Message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
public class Publisher {

    private static final Logger LOG = LoggerFactory.getLogger(Publisher.class);

    @Autowired
    KafkaTemplate<String, Message> kafkaTemplate;

    @Value("${kafka.topic.name}")
    private String topicName;

    public void sendMessage(Message message) {

        ListenableFuture<SendResult<String, Message>> future = kafkaTemplate.send(topicName, message);

        future.addCallback(new ListenableFutureCallback<SendResult<String, Message>>() {

            @Override
            public void onSuccess(SendResult<String, Message> result) {
                LOG.info("Sent message=[" + message.toString() +
                        "] with offset=[" + result.getRecordMetadata().offset() + "]");
            }
            @Override
            public void onFailure(Throwable ex) {
                LOG.error("Unable to send message=["
                        + message.toString() + "] due to : " + ex.getMessage());
            }
        });

        //kafkaTemplate.send(topicName, message);
    }
}
