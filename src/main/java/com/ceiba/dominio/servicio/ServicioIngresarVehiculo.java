package com.ceiba.dominio.servicio;

import java.time.LocalDateTime;

import com.ceiba.dominio.modelo.Historial;
import com.ceiba.dominio.modelo.Vehiculo;
import com.ceiba.dominio.modelo.VehiculosEnParqueadero;
import com.ceiba.dominio.puerto.repositorio.RepositorioHistorial;
import com.ceiba.dominio.servicio.reglas.ReglasCrearHistorial;

public class ServicioIngresarVehiculo {

	private RepositorioHistorial repositorioHistorial;
	private ReglasCrearHistorial reglasCrearHistorial;
	
	public ServicioIngresarVehiculo(RepositorioHistorial repositorioHistorial) {
		this.repositorioHistorial = repositorioHistorial;
		this.reglasCrearHistorial = new ReglasCrearHistorial(repositorioHistorial);
	}
	
	public VehiculosEnParqueadero ejecutar(Vehiculo vehiculo, LocalDateTime fechaEntrada) {
		reglasCrearHistorial.validar(vehiculo, fechaEntrada);
		return almacenar(vehiculo, fechaEntrada);
	}
	
	private VehiculosEnParqueadero almacenar(Vehiculo vehiculo, LocalDateTime fechaEntrada) {
		Historial historial = repositorioHistorial.guardar(new Historial(vehiculo, fechaEntrada));
		return new VehiculosEnParqueadero(historial.getVehiculo(), historial.getFechaEntrada());
	}
}
