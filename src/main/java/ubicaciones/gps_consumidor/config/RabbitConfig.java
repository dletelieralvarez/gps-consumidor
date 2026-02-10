package ubicaciones.gps_consumidor.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Topic Exchange:
 * Permite enrutar mensajes a colas en función de patrones en el routing key.
 * Soporta comodines:
 *  - '*' coincide con una sola palabra
 *  - '#' coincide con cero o más palabras
 * 
 * Es ideal para arquitecturas orientadas a eventos donde se requiere
 * flexibilidad y múltiples consumidores según el tipo de mensaje.
 */

@Configuration
public class RabbitConfig {
    public static final String EXCHANGE = "exc_ubicaciones";
    public static final String QUEUE = "ubicaciones_gps";
    public static final String ROUTING_KEY = "ubicacion.gps.#";

    @Bean
    public TopicExchange ubicacionesExchange() {
        return new TopicExchange(EXCHANGE, true, false);
    }

    @Bean
    public Queue gpsUpdateQueue() {
        return new Queue(QUEUE, true);
    }

    @Bean
    public Binding gpsUpdateBinding(
            Queue gpsUpdateQueue,
            TopicExchange ubicacionesExchange) {

        return BindingBuilder
                .bind(gpsUpdateQueue)
                .to(ubicacionesExchange)
                .with(ROUTING_KEY);
    }
    
}
