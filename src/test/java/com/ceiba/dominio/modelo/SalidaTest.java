package com.ceiba.dominio.modelo;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Test;

import com.ceiba.dominio.testdatabuilder.SalidaTestDataBuilder;
import com.ceiba.dominio.testdatabuilder.VehiculoTestDataBuilder;
import com.ceiba.dominio.util.Constantes;

public class SalidaTest {

	private static final double VALOR_0 = 0d;
	
	private static final LocalDateTime FECHA_ENTRADA = LocalDateTime.of(2019, 7, 12, 10, 25);
	
	private static final LocalDateTime FECHA_SALIDA = LocalDateTime.of(2019, 7, 12, 12, 25);
	
	private static final double VALOR = Constantes.VALOR_HORA_CARRO * 2;
	
	private static final Vehiculo VEHICULO = new VehiculoTestDataBuilder().build();

	@Test
	public void validarVehiculoObligatoriaTest() {
		// Arrenge
		SalidaTestDataBuilder salidaTestDataBuilder = new SalidaTestDataBuilder();
		salidaTestDataBuilder.conVehiculo(null);

		// Act
		try {
			salidaTestDataBuilder.build();
			fail();
		} catch (Exception e) {
			// assert
			assertEquals(Constantes.VEHICULO_NULO, e.getMessage());
		}
	}
	
	@Test
	public void validarFechaEntradaObligatoriaTest() {
		// Arrenge
		SalidaTestDataBuilder salidaTestDataBuilder = new SalidaTestDataBuilder();
		salidaTestDataBuilder.conFechaEntrada(null);

		// Act
		try {
			salidaTestDataBuilder.build();
			fail();
		} catch (Exception e) {
			// assert
			assertEquals(Constantes.SIN_FECHA_DE_ENTRADA, e.getMessage());
		}
	}
	
	@Test
	public void validarFechaSalidaObligatoriaTest() {
		// Arrenge
		SalidaTestDataBuilder salidaTestDataBuilder = new SalidaTestDataBuilder();
		salidaTestDataBuilder.conFechaSalida(null);

		// Act
		try {
			salidaTestDataBuilder.build();
			fail();
		} catch (Exception e) {
			// assert
			assertEquals(Constantes.SIN_FECHA_DE_SALIDA, e.getMessage());
		}
	}

	@Test
	public void validarValorObligatoriaTest() {
		// Arrenge
		SalidaTestDataBuilder salidaTestDataBuilder = new SalidaTestDataBuilder();
		salidaTestDataBuilder.conValor(VALOR_0);

		// Act
		try {
			salidaTestDataBuilder.build();
			fail();
		} catch (Exception e) {
			// assert
			assertEquals(Constantes.VALOR_CERO, e.getMessage());
		}
	}
	
	@Test
	public void crearSalidaTest() {
		//Arrange
		SalidaTestDataBuilder salidaTestDataBuilder  = new SalidaTestDataBuilder()
				.conVehiculo(VEHICULO)
				.conFechaEntrada(FECHA_ENTRADA)
				.conFechaSalida(FECHA_SALIDA)
				.conValor(VALOR);
		//Act
		Salida salida = salidaTestDataBuilder.build();
		
		//Assert
		assertEquals(VEHICULO, salida.getVehiculo());
		assertEquals(FECHA_ENTRADA, salida.getFechaEntrada());
		assertEquals(FECHA_SALIDA, salida.getFechaSalida());
		assertTrue(VALOR == salida.getValor());
	}

}
