package com.br.myfood.cadastro.configuration;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfiguration {



    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange("minha-exchange");
    }

    @Bean
    public Queue filaCadastro() {
        return new Queue("fila-cadastro");
    }

    @Bean
    public Queue filaMenu() {
        return new Queue("fila-menu");
    }

    @Bean
    public Binding bindingCadastro(Queue filaCadastro, DirectExchange directExchange) {
        return BindingBuilder.bind(filaCadastro).to(directExchange).with("chave-cadastro");
    }

    @Bean
    public Binding bindingMenu(Queue filaMenu, DirectExchange directExchange) {
        return BindingBuilder.bind(filaMenu).to(directExchange).with("chave-menu");
    }

//    @Value("${cadastro.rabbitmq.exchange}")
//    private String exchange;
//
//    @Bean
//    public Queue cadastroFila() {
//        return QueueBuilder
//                .nonDurable("cadastro.client.rabbitmq.queue")
//                .build();
//    }
//
//    @Bean
//    public Queue menuFila() {
//        return QueueBuilder
//                .nonDurable("cadastro.menu.rabbitmq.queue")
//                .build();
//    }
//
//    @Bean
//    public Exchange getExchange() {
//        return ExchangeBuilder.directExchange(exchange)
//                .durable(true)
//                .build();
//    }
//
//
//
//    @Bean
//    @Autowired
//    public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
//        final var rabbitTemplate = new RabbitTemplate(connectionFactory);
//        rabbitTemplate.setMessageConverter(producerJackson2MessageConverter());
//        return rabbitTemplate;
//    }
//
//    @Bean
//    public MessageConverter producerJackson2MessageConverter() {
//        return new Jackson2JsonMessageConverter();
//    }
//
//    @Bean
//    public Binding binding(Queue queue, DirectExchange exchange) {
//        return BindingBuilder.bind(queue).to(exchange).with("cadastro.menu.rabbitmq.queue");
//    }



}
