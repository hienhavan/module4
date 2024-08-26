//package org.example.springmvc.services.redis;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.stereotype.Service;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@Service
//
//public class SubscriberService {
//@Autowired
//    private StringRedisTemplate templates;
//
//    private final Map<String, String> customerSubscriptions = new HashMap<>();
//
//    public void subscribeCustomer(String customerId, String channel) {
//        // Lưu thông tin khách hàng và kênh đã đăng ký
//        customerSubscriptions.put(customerId, channel);
//    }
//
//    public void notifyCustomer(String customerId, String message) {
//        String channel = customerSubscriptions.get(customerId);
//        if (channel != null) {
//            templates.convertAndSend(channel, message);
//        }
//    }
//}
