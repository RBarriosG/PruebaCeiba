package com.ceiba.dominio.servicio;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.dominio.modelo.Historial;
import com.ceiba.dominio.puerto.repositorio.RepositorioHistorial;
import com.ceiba.dominio.testdatabuilder.HistorialTestDataBuilder;

public class ServicioSalidaVehiculoTest {

	private static final LocalDateTime FECHA_ENTRADA= LocalDateTime.of(2019,  7, 8, 6, 20);
	private static final LocalDateTime FECHA_SALIDA= LocalDateTime.of(2019,  7, 8, 10, 20);
	private static final double VALOR_ESPERADO = 4000;
	
	@Test
	public void salidaVehiculoTest() {
		//arrange
		Historial historial = new HistorialTestDataBuilder().conFechaEntrada(FECHA_ENTRADA).build();
		RepositorioHistorial repositorioHistorial = mock(RepositorioHistorial.class);
		when(repositorioHistorial.obtenerHistorialPorPlaca(Mockito.anyString())).thenReturn(historial);
		ServicioSalidaVehiculo servicioSalidaVehiculo = new ServicioSalidaVehiculo(repositorioHistorial);
		//act
		double valorACobrar = servicioSalidaVehiculo.ejecutar(historial.getVehiculo().getPlaca(), FECHA_SALIDA);
		//assert
		assertTrue(VALOR_ESPERADO==valorACobrar);
	}

}
