package com.ceiba.dominio.puerto.repositorio;

import java.util.List;

import com.ceiba.dominio.modelo.Entrada;

public interface RepositorioEntrada {

	boolean guardar(Entrada entrada);

	List<Entrada> listar();

	void borrar(Entrada entrada);

	long contarPorTipoVehiculo(String tipo);
	
	boolean existeEntradaConPlaca(String placa);

}
