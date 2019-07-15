package com.ceiba.dominio.servicio;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;

import com.ceiba.dominio.modelo.VehiculosEnParqueadero;
import com.ceiba.dominio.puerto.repositorio.RepositorioHistorial;
import com.ceiba.dominio.testdatabuilder.VehiculosEnParqueaderoTestDataBuilder;

public class ServicioListarVehiculosEnParqueaderoTest {

	private static final int TAMANIO_REGISTRO = 5;

	@Test
	public void listarVehiculosEnParqueaderotest() {
		// arrange
		RepositorioHistorial repositorioHistorial = mock(RepositorioHistorial.class);
		when(repositorioHistorial.listarVehiculosEnParqueadero())
				.thenReturn(listaVehiculosEnParqueadero(TAMANIO_REGISTRO));
		ServicioListarVehiculosEnParqueadero servicioListarVehiculoEnParqueadero = new ServicioListarVehiculosEnParqueadero(
				repositorioHistorial);
		// act
		List<VehiculosEnParqueadero> listaDeVehiculosEnParqueadero = servicioListarVehiculoEnParqueadero.ejecutar();
		// assert
		assertEquals(TAMANIO_REGISTRO, listaDeVehiculosEnParqueadero.size());
	}

	private List<VehiculosEnParqueadero> listaVehiculosEnParqueadero(int tamanio_registro) {
		return VehiculosEnParqueaderoTestDataBuilder.crearRegistros(tamanio_registro);
	}

}
