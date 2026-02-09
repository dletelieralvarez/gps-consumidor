package ubicaciones.gps_consumidor.dto;

public record GpsActualizacion (
  Long idBus, 
  Long idLinea,
  String timestamp, 
  Double latitud,
  Double longitud, 
  String estado, 
  String ruta, 
  String interseccion
){}
