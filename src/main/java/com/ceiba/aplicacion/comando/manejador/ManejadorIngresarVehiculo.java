package com.ceiba.aplicacion.comando.manejador;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.aplicacion.comando.ComandoVehiculo;
import com.ceiba.dominio.modelo.Vehiculo;
import com.ceiba.dominio.modelo.VehiculosEnParqueadero;
import com.ceiba.dominio.servicio.ServicioIngresarVehiculo;

@Component
public class ManejadorIngresarVehiculo {

	private ServicioIngresarVehiculo servicioIngresarVehiculo;

	@Autowired
	public ManejadorIngresarVehiculo(ServicioIngresarVehiculo servicioIngresarVehiculo) {
		this.servicioIngresarVehiculo = servicioIngresarVehiculo;
	}

	public VehiculosEnParqueadero ejecutar(ComandoVehiculo comandoVehiculo) {
		LocalDateTime fechaEntrada = LocalDateTime.now();
		Vehiculo vehiculo = new Vehiculo(comandoVehiculo.getPlaca(), comandoVehiculo.getTipo(),
				comandoVehiculo.getCilindraje());
		return this.servicioIngresarVehiculo.ejecutar(vehiculo, fechaEntrada);
	}

}
