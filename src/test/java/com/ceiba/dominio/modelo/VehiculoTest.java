package com.ceiba.dominio.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ceiba.dominio.testdatabuilder.VehiculoTestDataBuilder;
import com.ceiba.dominio.util.Constantes;

public class VehiculoTest {

	private static final int CILINDRAJE = 250;
	private static final String TIPO_VEHICULO_INVALIDO = "Tipo vehiculo invalido";
	private static final int CILINDRAJE_VALOR_0 = 0;

	private static final String PLACA = "ERT234";

	@Test
	public void validarPlacaObligatoriaTest() {
		// Arrenge
		VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder();
		vehiculoTestDataBuilder.conPlaca(null);

		// Act
		try {
			vehiculoTestDataBuilder.build();
			fail();
		} catch (Exception e) {
			// assert
			assertEquals(Constantes.PLACA_SIN_VALOR, e.getMessage());
		}
	}

	@Test
	public void validarTipoObligatorioTest() {
		// Arrenge
		VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder();
		vehiculoTestDataBuilder.conTipo(null);

		// Act
		try {
			vehiculoTestDataBuilder.build();
			fail();
		} catch (Exception e) {
			// assert
			assertEquals(Constantes.TIPO_SIN_VALOR, e.getMessage());
		}
	}

	@Test
	public void validarCilindrajeObligatorioMotoTest() {
		// Arrenge
		VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder();
		vehiculoTestDataBuilder.conCilindraje(CILINDRAJE_VALOR_0);
		vehiculoTestDataBuilder.conTipo(Constantes.MOTO);

		// Act
		try {
			vehiculoTestDataBuilder.build();
			fail();
		} catch (Exception e) {
			// assert
			assertEquals(Constantes.VEHICULO_TIPO_MOTO_NECESITA_CILINDRAJE, e.getMessage());
		}
	}

	@Test
	public void validarTipoVehiculoCarro() {
		// Arrenge
		VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder();
		// Act
		Vehiculo vehiculo = vehiculoTestDataBuilder.build();
		// asseert
		assertEquals(Constantes.CARRO, vehiculo.getTipo());
	}

	@Test
	public void validarTipoVehiculoMoto() {
		// Arrenge
		VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder();
		vehiculoTestDataBuilder.conTipo(Constantes.MOTO);
		vehiculoTestDataBuilder.conCilindraje(CILINDRAJE);
		vehiculoTestDataBuilder.conPlaca(PLACA);
		// Act
		Vehiculo vehiculo = vehiculoTestDataBuilder.build();
		// asseert
		assertEquals(Constantes.MOTO, vehiculo.getTipo());
		assertEquals(CILINDRAJE, vehiculo.getCilindraje());
		assertEquals(PLACA, vehiculo.getPlaca());
	}

	@Test
	public void validarTipoVehiculoExcepcion() {
		// Arrenge
		VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder();
		vehiculoTestDataBuilder.conTipo(TIPO_VEHICULO_INVALIDO);
		// Act
		try {
			vehiculoTestDataBuilder.build();
			fail();
		} catch (Exception e) {
			// assert
			assertEquals(Constantes.TIPO_VEHICULO_NO_EXISTE, e.getMessage());
		}
	}
}
