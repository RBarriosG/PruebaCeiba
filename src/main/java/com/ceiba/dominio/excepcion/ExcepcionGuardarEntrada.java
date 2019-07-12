package com.ceiba.dominio.excepcion;

public class ExcepcionGuardarEntrada extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExcepcionGuardarEntrada(String mensaje) {
		super(mensaje);
	}
}
