package com.jr.kafka.springbootkafkaproducer.controller;

import com.jr.kafka.springbootkafkaproducer.model.Message;
import com.jr.kafka.springbootkafkaproducer.service.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("kafka")
public class KafkaController {

    @Autowired
    Publisher publisher;

    @PostMapping("/publish")
    public void postMessage(@RequestBody Message message) {
        publisher.sendMessage(message);
    }
}
