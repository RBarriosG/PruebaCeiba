package com.ceiba.dominio.servicio.reglas;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.dominio.modelo.Entrada;
import com.ceiba.dominio.modelo.Vehiculo;
import com.ceiba.dominio.puerto.repositorio.RepositorioEntrada;
import com.ceiba.dominio.testdatabuilder.EntradaTestDataBuilder;
import com.ceiba.dominio.testdatabuilder.VehiculoTestDataBuilder;
import com.ceiba.dominio.util.Constantes;

public class ReglasCrearEntradaTest {

	private static final LocalDateTime FECHA_DOMINGO = LocalDateTime.of(2019, 7, 7, 10, 0);
	private static final LocalDateTime FECHA_LUNES = LocalDateTime.of(2019, 7, 8, 0, 0);
	private static final LocalDateTime FECHA_MARTES = LocalDateTime.of(2019, 7, 9, 0, 0);

	private static final String PLACA_COMIENZA_CON_A = "ABC456";
	private static final String PLACA_NO_COMIENZA_CON_A = "CFR097";

	@Test
	public void validarExistenciaVehiculoEnEntradaTest() {
		//Arrange
		EntradaTestDataBuilder entradaTestDataBuilder = new EntradaTestDataBuilder();
		Entrada entrada = entradaTestDataBuilder.build();
		RepositorioEntrada repositorioEntrada = Mockito.mock(RepositorioEntrada.class);
		Mockito.when(repositorioEntrada.existeEntradaConPlaca(Mockito.any())).thenReturn(true);
		ReglasCrearEntrada reglasCrearEntrada =  new ReglasCrearEntrada(repositorioEntrada);
		//Act
		try {
			reglasCrearEntrada.validar(entrada);
		} catch (Exception e) {
			//assert
			assertEquals(Constantes.VEHICULO_YA_EXISTE_EN_EL_PARQUEADERO, e.getMessage());
		}
		
	}
	
	@Test
	public void validarMaximo20CarrosEntradaTest() {
		//Arrange
		VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder()
				.conTipo(Constantes.CARRO);
		EntradaTestDataBuilder entradaTestDataBuilder = new EntradaTestDataBuilder()
				.conVechiculo(vehiculoTestDataBuilder.build());
		Entrada entrada = entradaTestDataBuilder.build();
		RepositorioEntrada repositorioEntrada = Mockito.mock(RepositorioEntrada.class);
		Mockito.when(repositorioEntrada.contarPorTipoVehiculo(Constantes.CARRO)).thenReturn(20L);
		ReglasCrearEntrada reglasCrearEntrada =  new ReglasCrearEntrada(repositorioEntrada);
		//Act
		try {
			reglasCrearEntrada.validar(entrada);
		} catch (Exception e) {
			//assert
			assertEquals(Constantes.MAXIMO_NUMERO_DE_CARROS_EN_EL_PARQUEADERO, e.getMessage());
		}
		
	}
	
	@Test
	public void validarMaximo10MotosEntradaTest() {
		//Arrange
		VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder()
				.conTipo(Constantes.MOTO)
				.conCilindraje(200);
		EntradaTestDataBuilder entradaTestDataBuilder = new EntradaTestDataBuilder()
				.conVechiculo(vehiculoTestDataBuilder.build());
		Entrada entrada = entradaTestDataBuilder.build();
		RepositorioEntrada repositorioEntrada = Mockito.mock(RepositorioEntrada.class);
		Mockito.when(repositorioEntrada.contarPorTipoVehiculo(Constantes.MOTO)).thenReturn(10L);
		ReglasCrearEntrada reglasCrearEntrada =  new ReglasCrearEntrada(repositorioEntrada);
		//Act
		try {
			reglasCrearEntrada.validar(entrada);
		} catch (Exception e) {
			//assert
			assertEquals(Constantes.MAXIMO_NUMERO_DE_MOTOS_EN_EL_PARQUEADERO, e.getMessage());
		}
		
	}
	
	@Test
	public void placaComienzaConAYNoEsDiaHabilTest() {
		// arrange
		Vehiculo vehiculo = new VehiculoTestDataBuilder().conPlaca(PLACA_COMIENZA_CON_A).build();
		Entrada entrada = new EntradaTestDataBuilder().conFechaEntrada(FECHA_MARTES).conVechiculo(vehiculo).build();
		RepositorioEntrada repositorioEntrada = Mockito.mock(RepositorioEntrada.class);
		ReglasCrearEntrada reglasCrearEntrada = new ReglasCrearEntrada(repositorioEntrada);
		// Act
		try {
			reglasCrearEntrada.validar(entrada);
			fail();
		} catch (Exception e) {
			// Assert
			assertEquals(Constantes.NO_PUEDE_INGRESAR_PORQUE_NO_ESTA_EN_UN_DIA_HABIL, e.getMessage());
		}

	}

	@Test
	public void placaComienzaConAYEsDiaHabilDomingoTest() {
		// arrange
		Vehiculo vehiculo = new VehiculoTestDataBuilder().conPlaca(PLACA_COMIENZA_CON_A).build();
		Entrada entrada = new EntradaTestDataBuilder().conFechaEntrada(FECHA_DOMINGO).conVechiculo(vehiculo).build();
		RepositorioEntrada repositorioEntrada = Mockito.mock(RepositorioEntrada.class);
		ReglasCrearEntrada reglasCrearEntrada = new ReglasCrearEntrada(repositorioEntrada);

		// Act
		boolean pasaSiFalso = reglasCrearEntrada.placaComienzaConLetraAYEsDiaHabil(entrada);
		// assert
		assertFalse(pasaSiFalso);
	}

	@Test
	public void placaComienzaConAYEsDiaHabilLunesTest() {
		// arrange
		Vehiculo vehiculo = new VehiculoTestDataBuilder().conPlaca(PLACA_COMIENZA_CON_A).build();
		Entrada entrada = new EntradaTestDataBuilder().conFechaEntrada(FECHA_LUNES).conVechiculo(vehiculo).build();
		RepositorioEntrada repositorioEntrada = Mockito.mock(RepositorioEntrada.class);
		ReglasCrearEntrada reglasCrearEntrada = new ReglasCrearEntrada(repositorioEntrada);

		// Act
		boolean pasaSiFalso = reglasCrearEntrada.placaComienzaConLetraAYEsDiaHabil(entrada);
		// assert
		assertFalse(pasaSiFalso);
	}
	
	@Test
	public void placaComienzaNoConATest() {
		// arrange
		Vehiculo vehiculo = new VehiculoTestDataBuilder().conPlaca(PLACA_NO_COMIENZA_CON_A).build();
		Entrada entrada = new EntradaTestDataBuilder().conFechaEntrada(FECHA_LUNES).conVechiculo(vehiculo).build();
		RepositorioEntrada repositorioEntrada = Mockito.mock(RepositorioEntrada.class);
		ReglasCrearEntrada reglasCrearEntrada = new ReglasCrearEntrada(repositorioEntrada);

		// Act
		boolean pasaSiFalso = reglasCrearEntrada.placaComienzaConLetraAYEsDiaHabil(entrada);
		// assert
		assertTrue(pasaSiFalso);
	}

}
