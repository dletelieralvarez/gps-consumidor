package ubicaciones.gps_consumidor.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    
public static final String EXCHANGE = "exc_ubicaciones";
    public static final String ROUTING_KEY = "keyubi";
    public static final String QUEUE = "ubicaciones_gps";

    @Bean
    public TopicExchange ubicacionesExchange() {
        return new TopicExchange(EXCHANGE, true, false);
    }

    @Bean
    public Queue gpsUpdateQueue() {
        return new Queue(QUEUE, true);
    }

    @Bean
    public Binding gpsUpdateBinding(Queue gpsUpdateQueue, TopicExchange ubicacionesExchange) {
        return BindingBuilder.bind(gpsUpdateQueue).to(ubicacionesExchange).with(ROUTING_KEY);
    }
}
