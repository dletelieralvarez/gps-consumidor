package ubicaciones.gps_consumidor.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "GPS_ACTUALIZACIONES")
public class GpsActualizacionEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "BUS_ID", nullable = false)
    private Long busId;

    @Column(name = "LINEA_ID")
    private Long lineaId;

    @Column(name = "FECHA_EVENTO", nullable = false)
    private LocalDateTime fechaEvento;

    @Column(name = "LATITUD")
    private Double latitud;

    @Column(name = "LONGITUD")
    private Double longitud;

    @Column(name = "ESTADO", length = 30)
    private String estado;

    @Column(name = "RUTA", length = 200)
    private String ruta;

    @Column(name = "INTERSECCION", length = 200)
    private String interseccion;

    // getters/setters
    public Long getId() { return id; }
    public Long getBusId() { return busId; }
    public void setBusId(Long busId) { this.busId = busId; }
    public Long getLineaId() { return lineaId; }
    public void setLineaId(Long lineaId) { this.lineaId = lineaId; }
    public LocalDateTime getFechaEvento() { return fechaEvento; }
    public void setFechaEvento(LocalDateTime fechaEvento) { this.fechaEvento = fechaEvento; }
    public Double getLatitud() { return latitud; }
    public void setLatitud(Double latitud) { this.latitud = latitud; }
    public Double getLongitud() { return longitud; }
    public void setLongitud(Double longitud) { this.longitud = longitud; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public String getRuta() { return ruta; }
    public void setRuta(String ruta) { this.ruta = ruta; }
    public String getInterseccion() { return interseccion; }
    public void setInterseccion(String interseccion) { this.interseccion = interseccion; }
}
