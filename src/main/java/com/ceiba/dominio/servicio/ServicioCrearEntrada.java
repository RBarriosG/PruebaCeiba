package com.ceiba.dominio.servicio;

import com.ceiba.dominio.modelo.Entrada;
import com.ceiba.dominio.puerto.repositorio.RepositorioEntrada;
import com.ceiba.dominio.servicio.reglas.ReglasCrearEntrada;

public class ServicioCrearEntrada {

	private RepositorioEntrada repositorioEntrada;
	private ReglasCrearEntrada reglasCrearEntrada;
	
	public ServicioCrearEntrada(RepositorioEntrada repositorioEntrada) {
		this.repositorioEntrada = repositorioEntrada;
		this.reglasCrearEntrada = new ReglasCrearEntrada(repositorioEntrada);
	}
	
	public boolean ejecutar(Entrada entrada) {
		reglasCrearEntrada.validar(entrada);
		return this.repositorioEntrada.guardar(entrada);
	}
	
}
