package com.ceiba.dominio.modelo;

import java.time.LocalDateTime;

import com.ceiba.dominio.modelo.validador.ValidadorArgumento;
import com.ceiba.dominio.util.Constantes;

public class Salida {

	private Vehiculo vehiculo;
	
	private LocalDateTime fechaEntrada;
	
	private LocalDateTime fechaSalida;
	
	private double valor;

	public Salida(Vehiculo vehiculo, LocalDateTime fechaEntrada, LocalDateTime fechaSalida, double valor) {
		validar(vehiculo, fechaEntrada, fechaSalida, valor);
		this.vehiculo = vehiculo;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.valor = valor;
	}

	private void validar(Vehiculo vehiculo, LocalDateTime fechaEntrada, LocalDateTime fechaSalida, double valor) {
		ValidadorArgumento.validarObligatorio(vehiculo, Constantes.VEHICULO_NULO);
		ValidadorArgumento.validarObligatorio(fechaEntrada, Constantes.SIN_FECHA_DE_ENTRADA);
		ValidadorArgumento.validarObligatorio(fechaSalida, Constantes.SIN_FECHA_DE_SALIDA);
		ValidadorArgumento.validarObligatorioValor(valor, Constantes.VALOR_CERO);
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
