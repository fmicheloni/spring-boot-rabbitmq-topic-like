package com.tutorial.rabbittopic;

import com.tutorial.rabbittopic.controller.MessageSenderController;
import com.tutorial.rabbittopic.listener.RabbitListenerConfiguration;
import com.tutorial.rabbittopic.queue.RabbitQueueConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Slf4j
@Import(value = {
        RabbitQueueConfiguration.class,
        RabbitListenerConfiguration.class,
        MessageSenderController.class
})
public class RabbittopicApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbittopicApplication.class, args);
    }

    @Bean
    public Exchange fanoutExchange(@Value("${tutorial.exchange.name}") final String exchangeName) {
        return new FanoutExchange(exchangeName);
    }

}
