package com.ceiba.dominio.servicio;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.dominio.modelo.Entrada;
import com.ceiba.dominio.modelo.Vehiculo;
import com.ceiba.dominio.puerto.repositorio.RepositorioEntrada;
import com.ceiba.dominio.servicio.reglas.ReglasCrearEntrada;
import com.ceiba.dominio.testdatabuilder.EntradaTestDataBuilder;
import com.ceiba.dominio.testdatabuilder.VehiculoTestDataBuilder;

public class ServicioCrearEntradaTest {

	private static final LocalDateTime FECHA_DOMINGO = LocalDateTime.of(2019, 7, 7, 10, 0);
	private static final String PLACA_COMIENZA_CON_A = "ABC456";
	
	@Test
	public void guardarEntradaTestest() {
		// arrange
		Vehiculo vehiculo = new VehiculoTestDataBuilder().conPlaca(PLACA_COMIENZA_CON_A).build();
		Entrada entrada = new EntradaTestDataBuilder().conFechaEntrada(FECHA_DOMINGO).conVechiculo(vehiculo).build();
		RepositorioEntrada repositorioEntrada = Mockito.mock(RepositorioEntrada.class);
		ServicioCrearEntrada servicioCrearEntrada = new ServicioCrearEntrada(repositorioEntrada);
		ReglasCrearEntrada reglasCrearEntrada = new ReglasCrearEntrada(repositorioEntrada);
		// Act
		boolean esGuardado = servicioCrearEntrada.ejecutar(entrada);
		// assert
		assertTrue(esGuardado);
	}

}
