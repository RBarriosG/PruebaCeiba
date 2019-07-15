package com.ceiba.dominio.modelo;

import java.time.LocalDateTime;

import com.ceiba.dominio.modelo.validador.ValidadorArgumento;
import com.ceiba.dominio.util.Constantes;

public class Historial {

	private Vehiculo vehiculo;
	
	private LocalDateTime fechaEntrada;
	
	private LocalDateTime fechaSalida;
	
	private double valor;

	public Historial(Vehiculo vehiculo, LocalDateTime fechaEntrada, LocalDateTime fechaSalida, double valor) {
		validar(vehiculo, fechaEntrada);
		this.vehiculo = vehiculo;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.valor = valor;
	}

	public Historial(Vehiculo vehiculo, LocalDateTime fechaEntrada) {
		this.vehiculo = vehiculo;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = null;
		this.valor = 0;
	}
	
	private void validar(Vehiculo vehiculo, LocalDateTime fechaEntrada) {
		ValidadorArgumento.validarObligatorio(vehiculo, Constantes.VEHICULO_NULO);
		ValidadorArgumento.validarObligatorio(fechaEntrada, Constantes.SIN_FECHA_DE_ENTRADA);
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public LocalDateTime getFechaEntrada() {
		return fechaEntrada;
	}

	public LocalDateTime getFechaSalida() {
		return fechaSalida;
	}

	public double getValor() {
		return valor;
	}
	
	
	
}
