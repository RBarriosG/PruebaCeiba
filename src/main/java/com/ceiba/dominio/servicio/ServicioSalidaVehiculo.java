package com.ceiba.dominio.servicio;

import java.time.LocalDateTime;

import com.ceiba.dominio.modelo.Historial;
import com.ceiba.dominio.modelo.Vehiculo;
import com.ceiba.dominio.puerto.repositorio.RepositorioHistorial;

public class ServicioSalidaVehiculo {

	private RepositorioHistorial repositorioHistorial;
	private ServicioCobrar servicioCobrar;
	
	public ServicioSalidaVehiculo(RepositorioHistorial repositorioHistorial) {
		this.repositorioHistorial = repositorioHistorial;
		this.servicioCobrar = new ServicioCobrar();
	}
	
	public double ejecutar(String placa, LocalDateTime fechaSalida) {
		Historial historial = repositorioHistorial.obtenerHistorialPorPlaca(placa);
		double valorACobrar = calcularValor(historial, fechaSalida);
		actualizarHistorial(historial, fechaSalida, valorACobrar);
		return valorACobrar;
	}

	private void actualizarHistorial(Historial historial, LocalDateTime fechaSalida, double valorACobrar) {
		Historial historialActual = new Historial(historial.getVehiculo(), historial.getFechaEntrada(), fechaSalida, valorACobrar);
		this.repositorioHistorial.actualizarHistorial(historialActual);
	}

	private double calcularValor(Historial historial, LocalDateTime fechaSalida) {
		Vehiculo vehiculo = historial.getVehiculo();
		LocalDateTime fechaEntrada = historial.getFechaEntrada();
		return servicioCobrar.calcularCobro(vehiculo, fechaEntrada, fechaSalida);
	}
	
}
