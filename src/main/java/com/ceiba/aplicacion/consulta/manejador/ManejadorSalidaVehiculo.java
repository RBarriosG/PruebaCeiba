package com.ceiba.aplicacion.consulta.manejador;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.dominio.servicio.ServicioSalidaVehiculo;

@Component 
public class ManejadorSalidaVehiculo {

	private ServicioSalidaVehiculo servicioSalidaVehiculo;
	
	@Autowired
	public ManejadorSalidaVehiculo(ServicioSalidaVehiculo servicioSalidaVehiculo) {
		this.servicioSalidaVehiculo = servicioSalidaVehiculo;
	}
	
	public double ejecutar(String placa) {
		LocalDateTime fechaSalida = LocalDateTime.now();
		return this.servicioSalidaVehiculo.ejecutar(placa, fechaSalida);
	}
	
}
