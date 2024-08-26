//package org.example.springmvc.homecontroller.RedisController;
//
//import org.example.springmvc.services.redis.PublisherService;
//import org.example.springmvc.services.redis.SubscriberService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//public class MessageController {
//
//    @Autowired
//    private PublisherService publisherService;
//
//    @Autowired
//    private SubscriberService subscriberService;
//
//    @PostMapping("/subscribe")
//    public void subscribe(@RequestParam String customerId, @RequestParam String channel) {
//        subscriberService.subscribeCustomer(customerId, channel);
//    }
//
//    @PostMapping("/publish")
//    public void publish(@RequestParam String channel, @RequestParam String message) {
//        publisherService.publishMessage(channel, message);
//    }
//
//    @PostMapping("/notifyCustomer")
//    public void notifyCustomer(@RequestParam String customerId, @RequestParam String message) {
//        subscriberService.notifyCustomer(customerId, message);
//    }
//}
