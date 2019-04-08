//package com.demo.config;
//
//import javax.jms.Queue;
//
//import com.demo.mq.ConsumerListener;
//import org.apache.activemq.ActiveMQConnectionFactory;
//import org.apache.activemq.command.ActiveMQQueue;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jms.connection.CachingConnectionFactory;
//import org.springframework.jms.listener.DefaultMessageListenerContainer;
//import org.springframework.jms.listener.MessageListenerContainer;
//import org.springframework.jms.listener.adapter.MessageListenerAdapter;
//import org.springframework.jms.support.converter.SimpleMessageConverter;
//import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
//
//@Configuration
//public class ActiveMQConfig {
//    public static final String TEST_QUEEN = "test.queen";
//
//    @Bean
//    public Queue testQueue() {
//        return new ActiveMQQueue(TEST_QUEEN);
//    }
//
//    @Bean(name = "textMessageListenerAdapter")
//    public MessageListenerAdapter messageListenerAdapter() {
//        MessageListenerAdapter adapter = new MessageListenerAdapter();
//        adapter.setMessageConverter(new SimpleMessageConverter());
//        adapter.setDelegate(textConsumerListener());
//        return adapter;
//    }
//
//    public CachingConnectionFactory connectionFactory(ActiveMQConnectionFactory connectionFactory) {
//        CachingConnectionFactory factory = new CachingConnectionFactory(connectionFactory);
//        return factory;
//    }
//
//    @Bean
//    public MessageListenerContainer messageListenerContainer(ActiveMQConnectionFactory connectionFactory) {
//        DefaultMessageListenerContainer container = new DefaultMessageListenerContainer();
//        container.setConnectionFactory(connectionFactory(connectionFactory));
//        container.setDestination(testQueue());
//        container.setMessageListener(messageListenerAdapter());
//        container.setConcurrency("10-50");
//        container.setTaskExecutor(threadPoolExecutor());
//        return container;
//    }
//
//    @Bean
//    public ConsumerListener textConsumerListener() {
//        return new ConsumerListener();
//    }
//
//    @Bean
//    public ThreadPoolTaskExecutor threadPoolExecutor() {
//        ThreadPoolTaskExecutor threadPoolExecutor = new ThreadPoolTaskExecutor();
//        //amq消费线程数
//        threadPoolExecutor.setCorePoolSize(4);
//        threadPoolExecutor.setMaxPoolSize(8);
//        //队列容量
//        threadPoolExecutor.setQueueCapacity(10000);
//        threadPoolExecutor.setDaemon(true);
//        threadPoolExecutor.setKeepAliveSeconds(120);
//        threadPoolExecutor.setAllowCoreThreadTimeOut(true);
//        //线程名称前缀
//        threadPoolExecutor.setThreadNamePrefix("MQ-");
//        return threadPoolExecutor;
//    }
//}