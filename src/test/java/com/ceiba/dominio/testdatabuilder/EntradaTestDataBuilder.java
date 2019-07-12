package com.ceiba.dominio.testdatabuilder;

import java.time.LocalDateTime;

import com.ceiba.dominio.modelo.Entrada;
import com.ceiba.dominio.modelo.Vehiculo;

public class EntradaTestDataBuilder {

	private static final Vehiculo VEHICULO = new VehiculoTestDataBuilder().build();
	private static final LocalDateTime FECHA_ENTRADA = LocalDateTime.of(2019,7,7,8,14); // 2019-07-10 08:14

	private Vehiculo vehiculo;

	private LocalDateTime fechaEntrada;
	
	public EntradaTestDataBuilder() {
		this.vehiculo = VEHICULO;
		this.fechaEntrada = FECHA_ENTRADA;
	}
	
	public EntradaTestDataBuilder conVechiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
		return this;
	}
	
	public EntradaTestDataBuilder conFechaEntrada(LocalDateTime fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
		return this;
	}

	public Entrada build() {
		return new Entrada(this.fechaEntrada, this.vehiculo);
	}
	
}
