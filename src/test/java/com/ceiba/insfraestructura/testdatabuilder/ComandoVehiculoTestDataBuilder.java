package com.ceiba.insfraestructura.testdatabuilder;

import com.ceiba.aplicacion.comando.ComandoVehiculo;

public class ComandoVehiculoTestDataBuilder {

	private String placa;

	private String tipo;

	private int cilindraje;

	public ComandoVehiculoTestDataBuilder() {
		this.placa = "ZAS3451";
		this.tipo = "CARRO";
		this.cilindraje = 0;
	}

	public ComandoVehiculoTestDataBuilder conPlaca(String placa) {
		this.placa = placa;
		return this;
	}

	public ComandoVehiculoTestDataBuilder conTipo(String tipo) {
		this.tipo = tipo;
		return this;
	}

	public ComandoVehiculoTestDataBuilder conCilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
		return this;
	}

	public ComandoVehiculo build() {
		return new ComandoVehiculo(this.placa, this.tipo, this.cilindraje);
	}

}
