package com.ceiba.aplicacion.consulta.manejador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.dominio.modelo.Vehiculo;
import com.ceiba.dominio.servicio.ServicioListarVehiculo;

@Component
public class ManejadorListarVehiculos {

	private ServicioListarVehiculo servicioListarVehiculo;
	
	@Autowired
	public ManejadorListarVehiculos(ServicioListarVehiculo servicioListarVehiculo) {
		this.servicioListarVehiculo = servicioListarVehiculo;
	}
	
	public List<Vehiculo> ejecutar(){
		return this.servicioListarVehiculo.ejecutar();
	}
	
}
