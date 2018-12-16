package com.tutorial.rabbittopic.queue;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;

@Configuration
public class RabbitQueueConfiguration {

    @Bean
    public Queue queue1(@Value("${tutorial.queue.name1}") final String queueName) {
        return new Queue(queueName);
    }

    @Bean
    public Queue queue2(@Value("${tutorial.queue.name2}") final String queueName) {
        return new Queue(queueName);
    }

    @Bean
    public Binding binding1(final Queue queue1, final Exchange fanoutExchange) {
        return BindingBuilder.bind(queue1).to(fanoutExchange).with("*").noargs();
    }

    @Bean
    public Binding binding2(final Queue queue2, final Exchange fanoutExchange) {
        return BindingBuilder.bind(queue2).to(fanoutExchange).with("*").noargs();
    }

}
