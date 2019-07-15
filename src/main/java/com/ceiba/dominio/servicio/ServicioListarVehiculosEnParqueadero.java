package com.ceiba.dominio.servicio;

import java.util.List;

import com.ceiba.dominio.modelo.VehiculosEnParqueadero;
import com.ceiba.dominio.puerto.repositorio.RepositorioHistorial;

public class ServicioListarVehiculosEnParqueadero {

	private RepositorioHistorial repositorioHistorial;
	
	public ServicioListarVehiculosEnParqueadero(RepositorioHistorial repositorioHistorial) {
		this.repositorioHistorial = repositorioHistorial;
	}
	
	public List<VehiculosEnParqueadero> ejecutar(){
		return this.repositorioHistorial.listarVehiculosEnParqueadero();
	}
	
}
