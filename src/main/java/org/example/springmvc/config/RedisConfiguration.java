//package org.example.springmvc.config;
//
//import org.example.springmvc.repository.MessageReceiver;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
//import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.data.redis.listener.PatternTopic;
//import org.springframework.data.redis.listener.RedisMessageListenerContainer;
//import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
//import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//
//@Configuration
//public class RedisConfiguration {
//
//    @Value("${redis.port:6379}")
//    private String redisPort;
//    @Value("${redis.host:localhost}")
//    private String redisHost;
//
//    @Bean
//    public JedisConnectionFactory jedisConnectionFactory() {
//        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
//        redisStandaloneConfiguration.setHostName(redisHost);
//        redisStandaloneConfiguration.setPort(Integer.parseInt(redisPort));
//        return new JedisConnectionFactory(redisStandaloneConfiguration);
//    }
//
////    @Bean
////    public StringRedisTemplate stringRedisTemplate() {
////        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
////        stringRedisTemplate.setConnectionFactory(jedisConnectionFactory());
////        // Optional: use default serializers
////        return stringRedisTemplate;
////    }
////
//    @Bean
//    public RedisMessageListenerContainer redisMessageListenerContainer(
//            JedisConnectionFactory jedisConnectionFactory,
//            MessageListenerAdapter messageListener) {
//        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
//        container.setConnectionFactory(jedisConnectionFactory);
//        // Đăng ký nhiều kênh
//        container.addMessageListener(messageListener, new PatternTopic("tech_channel"));
//        container.addMessageListener(messageListener, new PatternTopic("news_channel"));
//        return container;
//    }
//
//    @Bean
//    public MessageListenerAdapter messageListener() {
//        return new MessageListenerAdapter(new MessageReceiver());
//    }
//}
