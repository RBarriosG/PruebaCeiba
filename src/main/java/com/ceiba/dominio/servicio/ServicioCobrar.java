package com.ceiba.dominio.servicio;

import java.time.LocalDateTime;

import com.ceiba.dominio.modelo.Vehiculo;
import com.ceiba.dominio.modelo.validador.ReglaCobro;

public class ServicioCobrar {

	public double calcularCobro(Vehiculo vehiculo, LocalDateTime fechaEntrada, LocalDateTime fechaSalida) {
		return ReglaCobro.valorACobrar(fechaEntrada, fechaSalida, vehiculo.getTipo(), vehiculo.getCilindraje());
	}
	
}
