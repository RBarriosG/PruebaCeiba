package com.ceiba.dominio.testdatabuilder;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.ceiba.dominio.modelo.Vehiculo;
import com.ceiba.dominio.modelo.VehiculosEnParqueadero;
import com.ceiba.dominio.util.Constantes;

public class VehiculosEnParqueaderoTestDataBuilder {

	private static final Vehiculo VEHICULO = new VehiculoTestDataBuilder().build();
	private static final LocalDateTime FECHA_ENTRADA = LocalDateTime.of(2019, 7, 7, 8, 14);
	private static final int CILINDRAJE = 600;
	private static final String PLACA = "DFA31";

	private Vehiculo vehiculo;

	private LocalDateTime fechaEntrada;

	public VehiculosEnParqueaderoTestDataBuilder() {
		this.vehiculo = VEHICULO;
		this.fechaEntrada = FECHA_ENTRADA;
	}

	public VehiculosEnParqueaderoTestDataBuilder conVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
		return this;
	}

	public VehiculosEnParqueaderoTestDataBuilder conFechaEntrada(LocalDateTime fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
		return this;
	}

	public VehiculosEnParqueadero build() {
		return new VehiculosEnParqueadero(this.vehiculo, this.fechaEntrada);
	}

	public static List<VehiculosEnParqueadero> crearRegistros(int tamanio_registro) {
		List<VehiculosEnParqueadero> vehiculosEnParqueadero = new ArrayList<>();
		for (int i = 0; i < tamanio_registro; i++) {
			if (i % 2 == 0) {
				vehiculosEnParqueadero.add(new VehiculosEnParqueadero(
						new VehiculoTestDataBuilder().conTipo(Constantes.CARRO).conPlaca(PLACA+String.valueOf(i)).build(),
						FECHA_ENTRADA));
			} else {
				vehiculosEnParqueadero
						.add(new VehiculosEnParqueadero(new VehiculoTestDataBuilder().conTipo(Constantes.MOTO)
								.conPlaca(PLACA+String.valueOf(i)).conCilindraje(CILINDRAJE).build(), FECHA_ENTRADA));
			}
		}
		return vehiculosEnParqueadero;
	}

}
