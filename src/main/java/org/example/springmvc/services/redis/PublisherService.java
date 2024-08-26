//package org.example.springmvc.services.redis;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.stereotype.Service;
//
//@Service
//public class PublisherService {
//
//    @Autowired
//    private StringRedisTemplate template;
//
//    public void publishMessage(String channel, String message) {
//        template.convertAndSend(channel, message);
//    }
//}
