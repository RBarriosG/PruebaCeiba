package com.ceiba.dominio.puerto.repositorio;

import java.util.List;

import com.ceiba.dominio.modelo.Salida;

public interface RepositorioSalida {

	Salida guardar(Salida salida);

	List<Salida> listar();

	void borrar(Salida salida);

}
