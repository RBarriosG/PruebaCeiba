package com.ceiba.dominio.modelo;

import java.time.LocalDateTime;

import com.ceiba.dominio.modelo.validador.ValidadorArgumento;
import com.ceiba.dominio.util.Constantes;

public class VehiculosEnParqueadero {

	private Vehiculo vehiculo;

	private LocalDateTime fechaEntrada;

	public VehiculosEnParqueadero(Vehiculo vehiculo, LocalDateTime fechaEntrada) {
		ValidadorArgumento.validarObligatorio(vehiculo, Constantes.VEHICULO_NULO);
		ValidadorArgumento.validarObligatorio(fechaEntrada, Constantes.SIN_FECHA_DE_ENTRADA);
		this.vehiculo = vehiculo;
		this.fechaEntrada = fechaEntrada;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public LocalDateTime getFechaEntrada() {
		return fechaEntrada;
	}

}
