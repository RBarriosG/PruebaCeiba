package com.ceiba.dominio.modelo.validador;

import com.ceiba.dominio.excepcion.ExcepcionTipoVehiculo;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.dominio.util.Constantes;

public final class ValidadorArgumento {

	private ValidadorArgumento() {
	}
	
	public static void validarObligatorio(Object valor, String mensaje) {
		if (valor == null)
			throw new ExcepcionValorObligatorio(mensaje);
	}
	
	public static void validarObligatorioCilindrajeSiEsMoto(int cilindraje, String tipo, String mensaje) {
		if (cilindraje == 0 && tipo.equals(Constantes.MOTO)) 
			throw new ExcepcionValorObligatorio(mensaje);
	}
	
	public static void validarTipoVehiculo(Object valor, String mensaje) {
		if (!(valor.toString().equals(Constantes.CARRO) || valor.toString().equals(Constantes.MOTO)))
			throw new ExcepcionTipoVehiculo(mensaje);
	}
}
