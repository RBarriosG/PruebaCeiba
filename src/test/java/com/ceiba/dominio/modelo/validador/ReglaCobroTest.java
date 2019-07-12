package com.ceiba.dominio.modelo.validador;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Test;

import com.ceiba.dominio.util.Constantes;

public class ReglaCobroTest {

	private static final LocalDateTime FECHA_ENTRADA = LocalDateTime.of(2019, 7, 10, 6, 30);
	private static final LocalDateTime FECHA_SALIDA = LocalDateTime.of(2019, 7, 10, 8, 30);
	private static final int CILINDRAJE = 200;
	private static final double VALOR_ESPERADO_CARRO_MENOR_9_HORAS = 2000.0;
	
	private static final LocalDateTime FECHA_SALIDA_1 = LocalDateTime.of(2019, 7, 10, 20, 20);
	private static final double VALOR_ESPERADO_CARRO_ENTRE_9_Y_24_HORAS = 8000.0;
	
	private static final LocalDateTime FECHA_SALIDA_2 = LocalDateTime.of(2019, 7, 11, 9, 30);
	private static final double VALOR_ESPERADO_CARRO_UN_DIA_3_HORAS = 11000.0;
	
	private static final int CILINDRAJE_MAYOR_A_500 = 600;
	
	private static final double VALOR_ESPERADO_MOTO_MENOR_9_HORAS_CILINDRAJE_MENOR_A_500 = 1000;
	private static final double VALOR_ESPERADO_MOTO_MENOR_9_HORAS_CILINDRAJE_MAYOR_A_500 = 3000;
	private static final double VALOR_ESPERADO_MOTO_ENTRE_9_Y_24_HORAS_CILINDRAJE_MENOR_A_500 = 4000.0;
	private static final double VALOR_ESPERADO_MOTO_ENTRE_9_Y_24_HORAS_CILINDRAJE_MAYOR_A_500 = 6000.0;
	private static final double VALOR_ESPERADO_MOTO_UN_DIA_3_HORAS_CILINDRAJE_MENOR_A_500 = 5500.0;
	private static final double VALOR_ESPERADO_MOTO_UN_DIA_3_HORAS_CILINDRAJE_MAYOR_A_500 = 7500.0;
	
	@Test
	public void ValorACobrarTipoCarroHorasNoMayorA9Test() {
		//Arrange - Act
		double valorACobrar = ReglaCobro.valorACobrar(FECHA_ENTRADA, FECHA_SALIDA, Constantes.CARRO, CILINDRAJE);
		//assert
		assertTrue(VALOR_ESPERADO_CARRO_MENOR_9_HORAS==valorACobrar);
	}
	
	@Test
	public void ValorACobrarTipoCarroHoraIgual9Hasta24Test() {
		//Arrange - Act
		double valorACobrar = ReglaCobro.valorACobrar(FECHA_ENTRADA, FECHA_SALIDA_1, Constantes.CARRO, CILINDRAJE);
		//assert
		assertTrue(VALOR_ESPERADO_CARRO_ENTRE_9_Y_24_HORAS==valorACobrar);
	}
	
	@Test
	public void ValorACobrarTipoCarroMayorAUnDiaTest() {
		//Arrange - Act
		double valorACobrar = ReglaCobro.valorACobrar(FECHA_ENTRADA, FECHA_SALIDA_2, Constantes.CARRO, CILINDRAJE);
		//assert
		assertTrue(VALOR_ESPERADO_CARRO_UN_DIA_3_HORAS==valorACobrar);
	}
	
	@Test
	public void ValorACobrarTipoMotoHorasNoMayorA9YCilindrajeMenorA500Test() {
		//Arrange - Act
		double valorACobrar = ReglaCobro.valorACobrar(FECHA_ENTRADA, FECHA_SALIDA, Constantes.MOTO, CILINDRAJE);
		//assert
		assertTrue(VALOR_ESPERADO_MOTO_MENOR_9_HORAS_CILINDRAJE_MENOR_A_500==valorACobrar);
	}
	
	@Test
	public void ValorACobrarTipoMotoHorasNoMayorA9YCilindrajeMayorA500Test() {
		//Arrange - Act
		double valorACobrar = ReglaCobro.valorACobrar(FECHA_ENTRADA, FECHA_SALIDA, Constantes.MOTO, CILINDRAJE_MAYOR_A_500);
		//assert
		assertTrue(VALOR_ESPERADO_MOTO_MENOR_9_HORAS_CILINDRAJE_MAYOR_A_500==valorACobrar);
	}
	
	@Test
	public void ValorACobrarTipoMotoHorasEntre9Y24YCilindrajeMenorA500Test() {
		//Arrange - Act
		double valorACobrar = ReglaCobro.valorACobrar(FECHA_ENTRADA, FECHA_SALIDA_1, Constantes.MOTO, CILINDRAJE);
		//assert
		assertTrue(VALOR_ESPERADO_MOTO_ENTRE_9_Y_24_HORAS_CILINDRAJE_MENOR_A_500==valorACobrar);
	}
	
	@Test
	public void ValorACobrarTipoMotoHorasEntre9Y24YCilindrajeMayorA500Test() {
		//Arrange - Act
		double valorACobrar = ReglaCobro.valorACobrar(FECHA_ENTRADA, FECHA_SALIDA_1, Constantes.MOTO, CILINDRAJE_MAYOR_A_500);
		//assert
		assertTrue(VALOR_ESPERADO_MOTO_ENTRE_9_Y_24_HORAS_CILINDRAJE_MAYOR_A_500==valorACobrar);
	}

	@Test
	public void ValorACobrarTipoMotoMayoAUnDiaYCilindrajeMenorA500Test() {
		//Arrange - Act
		double valorACobrar = ReglaCobro.valorACobrar(FECHA_ENTRADA, FECHA_SALIDA_2, Constantes.MOTO, CILINDRAJE);
		//assert
		assertTrue(VALOR_ESPERADO_MOTO_UN_DIA_3_HORAS_CILINDRAJE_MENOR_A_500==valorACobrar);
	}
	
	@Test
	public void ValorACobrarTipoMotoMayoAUnDiaYCilindrajeMayorA500Test() {
		//Arrange - Act
		double valorACobrar = ReglaCobro.valorACobrar(FECHA_ENTRADA, FECHA_SALIDA_2, Constantes.MOTO, CILINDRAJE_MAYOR_A_500);
		//assert
		assertTrue(VALOR_ESPERADO_MOTO_UN_DIA_3_HORAS_CILINDRAJE_MAYOR_A_500==valorACobrar);
	}
	
}
