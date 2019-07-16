package com.ceiba.insfraestructura.adaptador.repositorio.conversor;

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
	
}
