package com.ceiba.dominio.servicio;

import java.util.List;

import com.ceiba.dominio.modelo.Vehiculo;
import com.ceiba.dominio.puerto.repositorio.RepositorioHistorial;

public class ServicioListarVehiculo {

	private RepositorioHistorial repositorioHistorial;
	
	public ServicioListarVehiculo(RepositorioHistorial repositorioHistorial) {
		this.repositorioHistorial = repositorioHistorial;
	}
	
	public List<Vehiculo> ejecutar(){
		return repositorioHistorial.listarTodosLosVehiculos();
	}
	
}
