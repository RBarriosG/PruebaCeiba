package com.ceiba.insfraestructura.adaptador.repositorio.conversor;

import java.util.ArrayList;
import java.util.List;

import com.ceiba.dominio.modelo.Vehiculo;
import com.ceiba.insfraestructura.adaptador.repositorio.entity.VehiculoEntity;

public final class ConversorVehiculo {

	private ConversorVehiculo() {
	}

	public static Vehiculo convertirAModelo(VehiculoEntity vehiculoEntity) {
		return new Vehiculo(vehiculoEntity.getPlaca(), vehiculoEntity.getTipo(), vehiculoEntity.getCilindraje());
	}
	
	public static VehiculoEntity convertirAEntidad(Vehiculo vehiculo) {
		return new VehiculoEntity(vehiculo.getPlaca(), vehiculo.getTipo(), vehiculo.getCilindraje());
	}

	public static List<Vehiculo> convertirListaAModelo(List<VehiculoEntity> vehiculosEntity){
		List<Vehiculo> vehiculos = new ArrayList<>();
		for (int i = 0; i < vehiculosEntity.size(); i++) {
			vehiculos.add(convertirAModelo(vehiculosEntity.get(i)));
		}
		return vehiculos;
	}
	
	public static List<VehiculoEntity> convertirListaAEntidad(List<Vehiculo> vehiculos){
		List<VehiculoEntity> vehiculosEntity = new ArrayList<>();
		for (int i = 0; i < vehiculos.size(); i++) {
			vehiculosEntity.add(convertirAEntidad(vehiculos.get(i)));
		}
		return vehiculosEntity;
	}
	
}
