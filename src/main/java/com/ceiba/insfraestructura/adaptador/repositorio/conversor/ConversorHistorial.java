package com.ceiba.insfraestructura.adaptador.repositorio.conversor;

import java.util.ArrayList;
import java.util.List;

import com.ceiba.dominio.modelo.Historial;
import com.ceiba.dominio.modelo.Vehiculo;
import com.ceiba.dominio.modelo.VehiculosEnParqueadero;
import com.ceiba.insfraestructura.adaptador.repositorio.entity.HistorialEntity;

public final class ConversorHistorial {

	private ConversorHistorial() {
	}

	public static Historial convertirAModelo(HistorialEntity historialEntity) {
		return new Historial(ConversorVehiculo.convertirAModelo(historialEntity.getVehiculoEntity()),
				historialEntity.getFechaEntrada(), historialEntity.getFechaSalida(), historialEntity.getValor());
	}

	public static HistorialEntity convertirAEntidad(Historial historial) {
		return new HistorialEntity(historial.getFechaEntrada(), historial.getFechaSalida(),
				ConversorVehiculo.convertirAEntidad(historial.getVehiculo()), historial.getValor());
	}

	public static List<Historial> convertirListaAModelo(List<HistorialEntity> historialesEntity) {
		List<Historial> historiales = new ArrayList<>();
		for (int i = 0; i < historialesEntity.size(); i++) {
			historiales.add(convertirAModelo(historialesEntity.get(i)));
		}
		return historiales;
	}

	public static List<HistorialEntity> convertirListaAEntidad(List<Historial> historiales) {
		List<HistorialEntity> historialesEntity = new ArrayList<>();
		for (int i = 0; i < historiales.size(); i++) {
			historialesEntity.add(convertirAEntidad(historiales.get(i)));
		}
		return historialesEntity;
	}

	public static List<VehiculosEnParqueadero> convertirListaAVehiculosEnParqueadero(List<HistorialEntity> historialesEntity){
		List<VehiculosEnParqueadero> vehiculosEnParqueadero = new ArrayList<>();
		for (int i = 0; i < historialesEntity.size(); i++) {
			vehiculosEnParqueadero.add(new VehiculosEnParqueadero(ConversorVehiculo.convertirAModelo(historialesEntity.get(i).getVehiculoEntity()), historialesEntity.get(i).getFechaEntrada()));
		}
		return vehiculosEnParqueadero;
	}
	
	public static List<Vehiculo> convertirListaAVehiculos(List<HistorialEntity> historialesEntity){
		List<Vehiculo> vehiculos = new ArrayList<>();
		for (int i = 0; i < historialesEntity.size(); i++) {
			vehiculos.add(ConversorVehiculo.convertirAModelo(historialesEntity.get(i).getVehiculoEntity()));
		}
		return vehiculos;
	}

}
