package com.ceiba.dominio.testdatabuilder;

import com.ceiba.dominio.modelo.Vehiculo;

public class VehiculoTestDataBuilder {

	private static final String PLACA_V = "EDC345";
	private static final String TIPO_V = "CARRO";
	private static final int CILINDRAJE_V = 0;
	
	private String placa;
	private String tipo;
	private int cilindraje;
	
	public VehiculoTestDataBuilder() {
		this.placa = PLACA_V;
		this.tipo = TIPO_V;
		this.cilindraje = CILINDRAJE_V;
	}
	
	public VehiculoTestDataBuilder conPlaca(String placa) {
		this.placa = placa;
		return this;
	}
	
	public VehiculoTestDataBuilder conTipo(String tipo) {
		this.tipo = tipo;
		return this;
	}
	
	public VehiculoTestDataBuilder conCilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
		return this;
	}
	
	public Vehiculo build() {
		return new Vehiculo(this.placa, this.tipo, this.cilindraje);
	}
	
}
