package com.ceiba.dominio.testdatabuilder;

import java.time.LocalDateTime;

import com.ceiba.dominio.modelo.Historial;
import com.ceiba.dominio.modelo.Vehiculo;
import com.ceiba.dominio.util.Constantes;

public class HistorialTestDataBuilder {
	
	private static final LocalDateTime FECHA_ENTRADA = LocalDateTime.of(2019, 7, 7, 8, 14);
	private static final LocalDateTime FECHA_SALIDA = LocalDateTime.of(2019, 7, 7, 18, 14);
	private static final Vehiculo VEHICULO_PRUEBA = new VehiculoTestDataBuilder().build();
	private static final double VALOR_PRUEBA = Constantes.VALOR_DIA_CARRO;

	private Vehiculo vehiculo;

	private LocalDateTime fechaEntrada;

	private LocalDateTime fechaSalida;

	private double valor;
	
	public HistorialTestDataBuilder() {
		this.vehiculo = VEHICULO_PRUEBA;
		this.fechaEntrada = FECHA_ENTRADA;
		this.fechaSalida = FECHA_SALIDA;
		this.valor = VALOR_PRUEBA;
	}
	
	public HistorialTestDataBuilder conVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
		return this;
	}

	public HistorialTestDataBuilder conFechaEntrada(LocalDateTime fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
		return this;
	}

	public HistorialTestDataBuilder conFechaSalida(LocalDateTime fechaSalida) {
		this.fechaSalida = fechaSalida;
		return this;
	}

	public HistorialTestDataBuilder conValor(double valor) {
		this.valor = valor;
		return this;
	}

	public Historial build() {
		return new Historial(this.vehiculo, this.fechaEntrada, this.fechaSalida, this.valor);
	}

}
