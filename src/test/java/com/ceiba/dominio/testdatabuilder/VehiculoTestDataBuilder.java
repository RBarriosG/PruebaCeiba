package com.ceiba.dominio.testdatabuilder;

import java.util.ArrayList;
import java.util.List;

import com.ceiba.dominio.modelo.Vehiculo;
import com.ceiba.dominio.util.Constantes;

public class VehiculoTestDataBuilder {

	private static final String PLACA_V = "EDC345";
	private static final String PLACA_A = "EDC345";
	private static final String TIPO_V = "CARRO";
	private static final int CILINDRAJE_V = 0;
	private static final int CILINDRAJE_A = 700;

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

	public static List<Vehiculo> crearVehiculos(int tamanio_registro) {
		List<Vehiculo> vehiculos = new ArrayList<>();
		for (int i = 0; i < tamanio_registro; i++) {
			if (i % 2 == 0) {
				vehiculos.add(new VehiculoTestDataBuilder().conTipo(Constantes.CARRO)
						.conPlaca(PLACA_A + String.valueOf(i)).build());
			} else {
				vehiculos.add(new VehiculoTestDataBuilder().conTipo(Constantes.MOTO)
						.conPlaca(PLACA_V + String.valueOf(i)).conCilindraje(CILINDRAJE_A).build());
			}
		}
		return vehiculos;
	}

}
