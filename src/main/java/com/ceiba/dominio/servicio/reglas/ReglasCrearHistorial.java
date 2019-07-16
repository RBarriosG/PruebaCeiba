package com.ceiba.dominio.servicio.reglas;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionGuardarEntrada;
import com.ceiba.dominio.modelo.Vehiculo;
import com.ceiba.dominio.puerto.repositorio.RepositorioHistorial;
import com.ceiba.dominio.util.Constantes;

public class ReglasCrearHistorial {

	private RepositorioHistorial repositorioHistorial;

	public ReglasCrearHistorial(RepositorioHistorial repositorioHistorial) {
		this.repositorioHistorial = repositorioHistorial;
	}

	public boolean validar(Vehiculo vehiculo, LocalDateTime fechaEntrada) {
		if (validadExistencia(vehiculo))
			throw new ExcepcionDuplicidad(Constantes.VEHICULO_YA_EXISTE_EN_EL_PARQUEADERO);
		if (maximo20Carros(vehiculo))
			throw new ExcepcionGuardarEntrada(Constantes.MAXIMO_NUMERO_DE_CARROS_EN_EL_PARQUEADERO);
		if (maximo10Motos(vehiculo))
			throw new ExcepcionGuardarEntrada(Constantes.MAXIMO_NUMERO_DE_MOTOS_EN_EL_PARQUEADERO);
		if (placaComienzaConLetraAYEsDiaHabil(vehiculo, fechaEntrada))
			throw new ExcepcionGuardarEntrada(Constantes.NO_PUEDE_INGRESAR_PORQUE_NO_ESTA_EN_UN_DIA_HABIL);
		return true;
	}

	private boolean validadExistencia(Vehiculo vehiculo) {
		return this.repositorioHistorial.existeVehiculoConPlaca(vehiculo.getPlaca());
	}

	private boolean maximo20Carros(Vehiculo vehiculo) {
		return vehiculo.getTipo().equals(Constantes.CARRO)
				&& repositorioHistorial.contarVehiculosPorTipo(vehiculo.getTipo()) >= 20;
	}

	private boolean maximo10Motos(Vehiculo vehiculo) {
		return vehiculo.getTipo().equals(Constantes.MOTO)
				&& repositorioHistorial.contarVehiculosPorTipo(vehiculo.getTipo()) >= 10;
	}

	public boolean placaComienzaConLetraAYEsDiaHabil(Vehiculo vehiculo, LocalDateTime fechaEntrada) {
		if (vehiculo.getPlaca().startsWith(Constantes.LETRA_INICIAL_PLACA_A))
			return !esDiaHabil(fechaEntrada);
		return false;
	}

	private boolean esDiaHabil(LocalDateTime fechaEntrada) {
		return fechaEntrada.getDayOfWeek() == DayOfWeek.SUNDAY || fechaEntrada.getDayOfWeek() == DayOfWeek.MONDAY;
	}

}
