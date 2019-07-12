package com.ceiba.dominio.modelo;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Test;

import com.ceiba.dominio.testdatabuilder.EntradaTestDataBuilder;
import com.ceiba.dominio.testdatabuilder.VehiculoTestDataBuilder;
import com.ceiba.dominio.util.Constantes;

public class EntradaTest {
	
	private static final LocalDateTime FECHA_ENTRADA = LocalDateTime.of(2019,7,7,8,20);
	private static final Vehiculo VEHICULO = new VehiculoTestDataBuilder().build();
	
	@Test
	public void validarVehiculoObligatorioTest() {
		//Arrange
		EntradaTestDataBuilder entradaTestDataBuilder = new EntradaTestDataBuilder();
		entradaTestDataBuilder.conVechiculo(null);
		entradaTestDataBuilder.conFechaEntrada(FECHA_ENTRADA);

		// Act
		try {
			entradaTestDataBuilder.build();
			fail();
		} catch (Exception e) {
			// assert
			assertEquals(Constantes.VEHICULO_NULO, e.getMessage());
		}
	}
	
	@Test
	public void validarFechaEntradaObligatorioTest() {
		//Arrange
		EntradaTestDataBuilder entradaTestDataBuilder = new EntradaTestDataBuilder();
		entradaTestDataBuilder.conFechaEntrada(null);
		entradaTestDataBuilder.conVechiculo(VEHICULO);

		// Act
		try {
			entradaTestDataBuilder.build();
			fail();
		} catch (Exception e) {
			// assert
			assertEquals(Constantes.SIN_FECHA_DE_ENTRADA, e.getMessage());
		}
	}
	
	@Test
	public void entradaCreadaTest() {
		//Arrange
		EntradaTestDataBuilder entradaTestDataBuilder = new EntradaTestDataBuilder()
				.conFechaEntrada(FECHA_ENTRADA)
				.conVechiculo(VEHICULO);
		
		//Act
		Entrada entrada = entradaTestDataBuilder.build();
		
		//Assert
		assertEquals(FECHA_ENTRADA, entrada.getFechaEntrada());
		assertEquals(VEHICULO, entrada.getVehiculo());
	}

}
