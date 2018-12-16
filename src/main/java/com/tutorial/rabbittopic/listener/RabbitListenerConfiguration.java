package com.tutorial.rabbittopic.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class RabbitListenerConfiguration {

    @Bean
    public SimpleMessageListenerContainer simpleRabbitListener1(
            final ConnectionFactory connectionFactory,
            final Queue queue1
    ) {
        SimpleMessageListenerContainer listenerContainer = new SimpleMessageListenerContainer(connectionFactory);
        listenerContainer.addQueues(queue1);
        listenerContainer.setMessageListener(message -> log.info("Received message with body [{}] from [{}]", new String(message.getBody()), message.getMessageProperties().getConsumerQueue()));
        return listenerContainer;
    }

    @Bean
    public SimpleMessageListenerContainer simpleRabbitListener2(
            final ConnectionFactory connectionFactory,
            final Queue queue2
    ) {
        SimpleMessageListenerContainer listenerContainer = new SimpleMessageListenerContainer(connectionFactory);
        listenerContainer.addQueues(queue2);
        listenerContainer.setMessageListener(message -> log.info("Received message with body [{}] from [{}]", new String(message.getBody()), message.getMessageProperties().getConsumerQueue()));
        return listenerContainer;
    }

}
