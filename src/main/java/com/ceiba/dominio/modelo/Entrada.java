package com.ceiba.dominio.modelo;

import java.time.LocalDateTime;

import com.ceiba.dominio.modelo.validador.ValidadorArgumento;
import com.ceiba.dominio.util.Constantes;

public class Entrada {

	private LocalDateTime fechaEntrada;

	private Vehiculo vehiculo;

	public Entrada(LocalDateTime fechaEntrada, Vehiculo vehiculo) {
		validar(fechaEntrada, vehiculo);
		this.fechaEntrada = fechaEntrada;
		this.vehiculo = vehiculo;
	}

	private void validar(LocalDateTime fechaEntrada, Vehiculo vehiculo) {
		ValidadorArgumento.validarObligatorio(fechaEntrada, Constantes.SIN_FECHA_DE_ENTRADA);
		ValidadorArgumento.validarObligatorio(vehiculo, Constantes.VEHICULO_NULO);
	}

	public LocalDateTime getFechaEntrada() {
		return fechaEntrada;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

}
