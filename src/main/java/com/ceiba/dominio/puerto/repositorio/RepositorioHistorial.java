package com.ceiba.dominio.puerto.repositorio;

import java.util.List;

import com.ceiba.dominio.modelo.Historial;
import com.ceiba.dominio.modelo.Vehiculo;
import com.ceiba.dominio.modelo.VehiculosEnParqueadero;

public interface RepositorioHistorial {

	Historial guardar(Historial historial);

	List<Historial> listar();

	void borrar(Historial historial);
	
	long contarVehiculosPorTipo(String tipo);
	
	List<VehiculosEnParqueadero> listarVehiculosEnParqueadero();
	
	List<Vehiculo> listarTodosLosVehiculos();

	boolean existeVehiculoConPlaca(String placa);

	Historial obtenerHistorialPorPlaca(String placa);

	Historial actualizarHistorial(Historial historialActual);
}
