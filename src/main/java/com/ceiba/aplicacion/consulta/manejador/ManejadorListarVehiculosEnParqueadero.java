package com.ceiba.aplicacion.consulta.manejador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.dominio.modelo.VehiculosEnParqueadero;
import com.ceiba.dominio.servicio.ServicioListarVehiculosEnParqueadero;

@Component
public class ManejadorListarVehiculosEnParqueadero {

	private ServicioListarVehiculosEnParqueadero servicioListarVehiculosEnParqueadero;
	
	@Autowired
	public ManejadorListarVehiculosEnParqueadero(ServicioListarVehiculosEnParqueadero servicioListarVehiculosEnParqueadero) {
		this.servicioListarVehiculosEnParqueadero = servicioListarVehiculosEnParqueadero;
	}
	
	public List<VehiculosEnParqueadero> ejecutar(){
		return this.servicioListarVehiculosEnParqueadero.ejecutar();
	}
	
}
