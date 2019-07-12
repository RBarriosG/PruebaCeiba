package com.ceiba.dominio.testdatabuilder;

import java.time.LocalDateTime;

import com.ceiba.dominio.modelo.Salida;
import com.ceiba.dominio.modelo.Vehiculo;
import com.ceiba.dominio.util.Constantes;

public class SalidaTestDataBuilder {

	private static final LocalDateTime FECHA_ENTRADA = LocalDateTime.of(2019, 7, 7, 8, 14);
	private static final LocalDateTime FECHA_SALIDA = LocalDateTime.of(2019, 7, 7, 18, 14);
	private static final Vehiculo VEHICULO = new VehiculoTestDataBuilder().build();
	private static final double VALOR = Constantes.VALOR_DIA_CARRO;

	private Vehiculo vehiculo;

	private LocalDateTime fechaEntrada;

	private LocalDateTime fechaSalida;

	private double valor;

	public SalidaTestDataBuilder() {
		this.vehiculo = VEHICULO;
		this.fechaEntrada = FECHA_ENTRADA;
		this.fechaSalida = FECHA_SALIDA;
		this.valor = VALOR;
	}

	public SalidaTestDataBuilder conVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
		return this;
	}

	public SalidaTestDataBuilder conFechaEntrada(LocalDateTime fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
		return this;
	}

	public SalidaTestDataBuilder conFechaSalida(LocalDateTime fechaSalida) {
		this.fechaSalida = fechaSalida;
		return this;
	}

	public SalidaTestDataBuilder conValor(double valor) {
		this.valor = valor;
		return this;
	}

	public Salida build() {
		return new Salida(this.vehiculo, this.fechaEntrada, this.fechaSalida, this.valor);
	}

}
