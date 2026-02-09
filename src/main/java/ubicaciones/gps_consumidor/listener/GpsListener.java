package ubicaciones.gps_consumidor.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import ubicaciones.gps_consumidor.dto.GpsActualizacion;
import ubicaciones.gps_consumidor.model.GpsActualizacionEntity;
import ubicaciones.gps_consumidor.repository.GpsActualizacionRepository;

import java.time.LocalDateTime;
@Component
public class GpsListener {
    
private final GpsActualizacionRepository repo;

    public GpsListener(GpsActualizacionRepository repo) {
        this.repo = repo;
    }

    @RabbitListener(queues = "ubicaciones_gps")
    public void consumir(GpsActualizacion msg) {
        LocalDateTime fecha = (msg.timestamp() == null || msg.timestamp().isBlank())
                ? LocalDateTime.now()
                : LocalDateTime.parse(msg.timestamp()); 

        GpsActualizacionEntity e = new GpsActualizacionEntity();
        e.setBusId(msg.idBus());
        e.setLineaId(msg.idLinea());
        e.setFechaEvento(fecha);
        e.setLatitud(msg.latitud());
        e.setLongitud(msg.longitud());
        e.setEstado(msg.estado());
        e.setRuta(msg.ruta());
        e.setInterseccion(msg.interseccion());

        repo.save(e);

        System.out.println("GPS guardado OK busId=" + msg.idBus() + " fecha=" + fecha);
    }
}

