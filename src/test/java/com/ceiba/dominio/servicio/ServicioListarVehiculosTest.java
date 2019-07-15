package com.ceiba.dominio.servicio;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;

import com.ceiba.dominio.modelo.Vehiculo;
import com.ceiba.dominio.puerto.repositorio.RepositorioHistorial;
import com.ceiba.dominio.testdatabuilder.VehiculoTestDataBuilder;

public class ServicioListarVehiculosTest {

	private static final int TAMANIO_REGISTRO = 5;

	@Test
	public void listarVehiculosEnParqueaderotest() {
		// arrange
		RepositorioHistorial repositorioHistorial = mock(RepositorioHistorial.class);
		when(repositorioHistorial.listarTodosLosVehiculos()).thenReturn(listaVehiculos(TAMANIO_REGISTRO));
		ServicioListarVehiculo servicioListarVehiculo = new ServicioListarVehiculo(repositorioHistorial);
		// act
		List<Vehiculo> listaDeVehiculos = servicioListarVehiculo.ejecutar();
		// assert
		assertEquals(TAMANIO_REGISTRO, listaDeVehiculos.size());
	}

	private List<Vehiculo> listaVehiculos(int tamanio_registro) {
		return VehiculoTestDataBuilder.crearVehiculos(tamanio_registro);
	}

}
