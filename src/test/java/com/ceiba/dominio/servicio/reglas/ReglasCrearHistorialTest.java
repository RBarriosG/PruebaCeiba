package com.ceiba.dominio.servicio.reglas;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.dominio.modelo.Vehiculo;
import com.ceiba.dominio.puerto.repositorio.RepositorioHistorial;
import com.ceiba.dominio.testdatabuilder.VehiculoTestDataBuilder;
import com.ceiba.dominio.util.Constantes;

public class ReglasCrearHistorialTest {

	private static final LocalDateTime FECHA_DOMINGO = LocalDateTime.of(2019, 7, 7, 10, 0);
	private static final LocalDateTime FECHA_LUNES = LocalDateTime.of(2019, 7, 8, 0, 0);
	private static final LocalDateTime FECHA_MARTES = LocalDateTime.of(2019, 7, 9, 0, 0);

	private static final String PLACA_COMIENZA_CON_A = "ABC456";
	private static final String PLACA_NO_COMIENZA_CON_A = "CFR097";

	private static final LocalDateTime FECHA_ENTRADA = LocalDateTime.of(2019, 7, 7, 8, 14);
	private static final int CILINDRAJE_200 = 200;

	@Test
	public void validarExistenciaVehiculoEnEntradaTest() {
		// Arrange
		Vehiculo vehiculo = new VehiculoTestDataBuilder().build();
		RepositorioHistorial repositorioHistorial = Mockito.mock(RepositorioHistorial.class);
		Mockito.when(repositorioHistorial.existeVehiculoConPlaca(Mockito.any())).thenReturn(true);
		ReglasCrearHistorial reglasCrearHistorial = new ReglasCrearHistorial(repositorioHistorial);
		// Act
		try {
			reglasCrearHistorial.validar(vehiculo, FECHA_ENTRADA);
		} catch (Exception e) {
			// assert
			assertEquals(Constantes.VEHICULO_YA_EXISTE_EN_EL_PARQUEADERO, e.getMessage());
		}

	}

	@Test
	public void validarMaximo20CarrosEntradaTest() {
		// Arrange
		Vehiculo vehiculo = new VehiculoTestDataBuilder().build();
		RepositorioHistorial repositorioHistorial = Mockito.mock(RepositorioHistorial.class);
		Mockito.when(repositorioHistorial.contarVehiculosPorTipo(Constantes.CARRO)).thenReturn(20L);
		ReglasCrearHistorial reglasCrearHistorial = new ReglasCrearHistorial(repositorioHistorial);
		// Act
		try {
			reglasCrearHistorial.validar(vehiculo, FECHA_ENTRADA);
		} catch (Exception e) {
			// assert
			assertEquals(Constantes.MAXIMO_NUMERO_DE_CARROS_EN_EL_PARQUEADERO, e.getMessage());
		}

	}

	@Test
	public void validarMaximo10MotosEntradaTest() {
		// Arrange
		Vehiculo vehiculo = new VehiculoTestDataBuilder()
				.conTipo(Constantes.MOTO)
				.conCilindraje(CILINDRAJE_200).build();
		RepositorioHistorial repositorioHistorial = Mockito.mock(RepositorioHistorial.class);
		Mockito.when(repositorioHistorial.contarVehiculosPorTipo(Constantes.MOTO)).thenReturn(10L);
		ReglasCrearHistorial reglasCrearHistorial = new ReglasCrearHistorial(repositorioHistorial);
		// Act
		try {
			reglasCrearHistorial.validar(vehiculo, FECHA_ENTRADA);
		} catch (Exception e) {
			// assert
			assertEquals(Constantes.MAXIMO_NUMERO_DE_MOTOS_EN_EL_PARQUEADERO, e.getMessage());
		}

	}

	@Test
	public void placaComienzaConAYNoEsDiaHabilTest() {
		// arrange
		Vehiculo vehiculo = new VehiculoTestDataBuilder().conPlaca(PLACA_COMIENZA_CON_A).build();
		RepositorioHistorial repositorioHistorial = Mockito.mock(RepositorioHistorial.class);
		ReglasCrearHistorial reglasCrearHistorial = new ReglasCrearHistorial(repositorioHistorial);
		// Act
		try {
			reglasCrearHistorial.validar(vehiculo, FECHA_MARTES);
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
		RepositorioHistorial repositorioHistorial = Mockito.mock(RepositorioHistorial.class);
		ReglasCrearHistorial reglasCrearHistorial = new ReglasCrearHistorial(repositorioHistorial);

		// Act
		boolean pasaSiFalso = reglasCrearHistorial.placaComienzaConLetraAYEsDiaHabil(vehiculo, FECHA_DOMINGO);
		// assert
		assertFalse(pasaSiFalso);
	}

	@Test
	public void placaComienzaConAYEsDiaHabilLunesTest() {
		// arrange
		Vehiculo vehiculo = new VehiculoTestDataBuilder().conPlaca(PLACA_COMIENZA_CON_A).build();
		RepositorioHistorial repositorioHistorial = Mockito.mock(RepositorioHistorial.class);
		ReglasCrearHistorial reglasCrearHistorial = new ReglasCrearHistorial(repositorioHistorial);

		// Act
		boolean pasaSiFalso = reglasCrearHistorial.placaComienzaConLetraAYEsDiaHabil(vehiculo, FECHA_LUNES);
		// assert
		assertFalse(pasaSiFalso);
	}

	@Test
	public void placaNoComienzaConATest() {
		// arrange
		Vehiculo vehiculo = new VehiculoTestDataBuilder().conPlaca(PLACA_NO_COMIENZA_CON_A).build();
		RepositorioHistorial repositorioHistorial = Mockito.mock(RepositorioHistorial.class);
		ReglasCrearHistorial reglasCrearHistorial = new ReglasCrearHistorial(repositorioHistorial);

		// Act
		boolean pasaSiFalso = reglasCrearHistorial.placaComienzaConLetraAYEsDiaHabil(vehiculo, FECHA_LUNES);
		// assert
		assertFalse(pasaSiFalso);
	}

}
