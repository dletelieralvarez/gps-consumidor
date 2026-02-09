package ubicaciones.gps_consumidor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ubicaciones.gps_consumidor.model.GpsActualizacionEntity;

public interface GpsActualizacionRepository extends JpaRepository<GpsActualizacionEntity, Long> {
    
}
