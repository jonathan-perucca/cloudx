package com.under.cloudx;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BrokerConfig {

    @Bean
    public FanoutExchange gamerFanoutExchange() {
        return new FanoutExchange("gamer.fanout");
    }

    @Bean
    public Queue gamerQueue() {
        return new AnonymousQueue((NamingStrategy) () -> "gamer.logevent.queue");
    }

    @Bean
    public Binding gamerBinding() {
        return BindingBuilder.bind(gamerQueue()).to(gamerFanoutExchange());
    }

    @Bean
    public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
        var rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }

    @Bean
    public Jackson2JsonMessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
