package com.ceiba.dominio.modelo;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Test;

import com.ceiba.dominio.testdatabuilder.HistorialTestDataBuilder;
import com.ceiba.dominio.testdatabuilder.VehiculoTestDataBuilder;
import com.ceiba.dominio.util.Constantes;

public class HistorialTest {

	private static final LocalDateTime FECHA_ENTRADA = LocalDateTime.of(2019, 7, 7, 8, 14);
	private static final LocalDateTime FECHA_SALIDA = LocalDateTime.of(2019, 7, 7, 18, 14);

	private static final double VALOR = Constantes.VALOR_DIA_CARRO;

	private static final Vehiculo VEHICULO = new VehiculoTestDataBuilder().build();

	@Test
	public void validarVehiculoObligatoriaTest() {
		// Arrenge
		HistorialTestDataBuilder historialTestDataBuilder = new HistorialTestDataBuilder();
		historialTestDataBuilder.conVehiculo(null);

		// Act
		try {
			historialTestDataBuilder.build();
			fail();
		} catch (Exception e) {
			// assert
			assertEquals(Constantes.VEHICULO_NULO, e.getMessage());
		}
	}

	@Test
	public void validarFechaEntradaObligatoriaTest() {
		// Arrenge
		HistorialTestDataBuilder historialTestDataBuilder = new HistorialTestDataBuilder();
		historialTestDataBuilder.conFechaEntrada(null);

		// Act
		try {
			historialTestDataBuilder.build();
			fail();
		} catch (Exception e) {
			// assert
			assertEquals(Constantes.SIN_FECHA_DE_ENTRADA, e.getMessage());
		}
	}

	@Test
	public void crearHisotiralTest() {
		// Arrange
		HistorialTestDataBuilder historialTestDataBuilder = new HistorialTestDataBuilder();
		// Act
		Historial historial = historialTestDataBuilder.build();

		// Assert
		assertEquals(VEHICULO.getPlaca(), historial.getVehiculo().getPlaca());
		assertEquals(FECHA_ENTRADA, historial.getFechaEntrada());
		assertEquals(FECHA_SALIDA, historial.getFechaSalida());
		assertTrue(VALOR == historial.getValor());
	}

}
