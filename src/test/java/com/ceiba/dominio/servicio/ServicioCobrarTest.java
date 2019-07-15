package com.ceiba.dominio.servicio;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Test;

import com.ceiba.dominio.modelo.Vehiculo;
import com.ceiba.dominio.testdatabuilder.VehiculoTestDataBuilder;
import com.ceiba.dominio.util.Constantes;

public class ServicioCobrarTest {

	private static final Vehiculo VEHICULO_TIPO_CARRO = new VehiculoTestDataBuilder().build();
	private static final LocalDateTime FECHA_ENTRADA = LocalDateTime.of(2019, 7, 15, 8, 50);
	private static final LocalDateTime FECHA_SALIDA = LocalDateTime.of(2019, 7, 15, 18, 50);
	private static final double VALOR_QUE_DEBE_GENERAR = 8000;
	
	private static final int CILINDRAJE_200 = 200;
	private static final int CILINDRAJE_600 = 600;

	private static final Vehiculo VEHICULO_TIPO_MOTO_200 = new VehiculoTestDataBuilder().conTipo(Constantes.MOTO)
			.conCilindraje(CILINDRAJE_200).build();
	private static final double VALOR_QUE_DEBE_GENERAR_MOTO_200 = 4000;
	
	private static final Vehiculo VEHICULO_TIPO_MOTO_600 = new VehiculoTestDataBuilder().conTipo(Constantes.MOTO)
			.conCilindraje(CILINDRAJE_600).build();
	private static final double VALOR_QUE_DEBE_GENERAR_MOTO_600 = 6000;

	@Test
	public void generarCobroCarroTest() {
		// arrange
		ServicioCobrar servicioCobrar = new ServicioCobrar();
		// act
		double valorEsperado = servicioCobrar.calcularCobro(VEHICULO_TIPO_CARRO, FECHA_ENTRADA, FECHA_SALIDA);
		// assert
		assertTrue(VALOR_QUE_DEBE_GENERAR == valorEsperado);
	}

	@Test
	public void generarCobroMoto200Test() {
		// arrange
		ServicioCobrar servicioCobrar = new ServicioCobrar();
		// act
		double valorEsperado = servicioCobrar.calcularCobro(VEHICULO_TIPO_MOTO_200, FECHA_ENTRADA, FECHA_SALIDA);
		// assert
		assertTrue(VALOR_QUE_DEBE_GENERAR_MOTO_200 == valorEsperado);
	}

	@Test
	public void generarCobroMoto600Test() {
		// arrange
		ServicioCobrar servicioCobrar = new ServicioCobrar();
		// act
		double valorEsperado = servicioCobrar.calcularCobro(VEHICULO_TIPO_MOTO_600, FECHA_ENTRADA, FECHA_SALIDA);
		// assert
		assertTrue(VALOR_QUE_DEBE_GENERAR_MOTO_600 == valorEsperado);
	}

	
}
