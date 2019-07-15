package com.ceiba.dominio.servicio;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.dominio.modelo.Historial;
import com.ceiba.dominio.modelo.Vehiculo;
import com.ceiba.dominio.modelo.VehiculosEnParqueadero;
import com.ceiba.dominio.puerto.repositorio.RepositorioHistorial;
import com.ceiba.dominio.testdatabuilder.HistorialTestDataBuilder;
import com.ceiba.dominio.testdatabuilder.VehiculoTestDataBuilder;

public class ServicioIngresarVehiculoTest {

	private static final LocalDateTime FECHA_DOMINGO = LocalDateTime.of(2019, 7, 7, 10, 0);

	@Test
	public void guardarVehiculoEnHistorialTest() {
		// arrange
		Vehiculo vehiculo = new VehiculoTestDataBuilder().build();
		Historial historial = new HistorialTestDataBuilder().build();
		RepositorioHistorial repositorioHistorial = Mockito.mock(RepositorioHistorial.class);
		when(repositorioHistorial.guardar(Mockito.any())).thenReturn(historial);
		ServicioIngresarVehiculo servicioIngresarVehiculo = new ServicioIngresarVehiculo(repositorioHistorial);
		// Act
		VehiculosEnParqueadero experado = servicioIngresarVehiculo.ejecutar(vehiculo, FECHA_DOMINGO);
		// assert
		assertNotNull(experado);
	}

}
