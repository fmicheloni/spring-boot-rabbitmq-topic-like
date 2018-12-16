This tutorial explains how a topic-like architecture can be achieved easily by combining RabbitMQ and Spring Boot.

Medium Article can be [found here](https://medium.com/@fabrizio.micheloni1994/topic-like-architecture-with-rabbitmq-and-spring-boot-c5f73b27f098).

1. Start RabbitMQ `docker-compose -f compose/rabbit-compose.yml up -d`
2. Start the application `mvn spring-boot:run`
3. Publish a message through HTTP `http://localhost:8080/sendMessage?messageBody=myMessage`
4. Check that both the consumers got the right message!
