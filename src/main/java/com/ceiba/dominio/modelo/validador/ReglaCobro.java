package com.ceiba.dominio.modelo.validador;

import java.time.Duration;
import java.time.LocalDateTime;

import com.ceiba.dominio.util.Constantes;

public final class ReglaCobro {

	private static final long HORAS_DIA = 24;
	private static final long HORA_MAXIMA_PARA_COBRAR_POR_DIA = 9;
	
	private ReglaCobro() {
	}
	
	public static double valorACobrar(LocalDateTime fechaEntrada, LocalDateTime fechaSalida, String tipoVehiculo, int cilindraje) {
		long totalHoras = calcularTotalHoras(fechaEntrada, fechaSalida);
		long dias = calcularDias(totalHoras);
		long horas = calcularHorasUltimoDia(totalHoras) + calcularTotalMilesimas(fechaEntrada, fechaSalida);
		return totalACobrar(dias, horas, tipoVehiculo, cilindraje);
	}

	private static double totalACobrar(long dias, long horas, String tipoVehiculo, int cilindraje) {
		if (tipoVehiculo.equals(Constantes.CARRO))
			return dias * Constantes.VALOR_DIA_CARRO + horas * Constantes.VALOR_HORA_CARRO;
		else if (cilindraje > 500)
			return dias * Constantes.VALOR_DIA_MOTO + horas * Constantes.VALOR_HORA_MOTO + Constantes.VALOR_AGREGADO_MOTO_MAYOR_500CC;
		else
			return dias * Constantes.VALOR_DIA_MOTO + horas * Constantes.VALOR_HORA_MOTO;
	}


	private static long calcularHorasUltimoDia(long totalHoras) {
		long horasPasadas = calcularHorasExtra(totalHoras);
		return horasPasadas < HORA_MAXIMA_PARA_COBRAR_POR_DIA ? horasPasadas : 0;
	}
	
	private static long calcularTotalMilesimas(LocalDateTime fechaEntrada, LocalDateTime fechaSalida) {
		 return Duration.between(fechaEntrada, fechaSalida).toMillis() > 0 ? 1 : 0;
	}

	private static long calcularTotalHoras(LocalDateTime fechaEntrada, LocalDateTime fechaSalida) {
		 return Duration.between(fechaEntrada, fechaSalida).toHours();
	}
	
	private static long calcularDias(long totalHoras) {
		long totalDias = totalHoras / HORAS_DIA;
		return calcularHorasExtra(totalHoras) >= HORA_MAXIMA_PARA_COBRAR_POR_DIA ? ++totalDias : totalDias;
	}
	
	private static long calcularHorasExtra(long totalHoras) {
		return totalHoras > HORAS_DIA ? totalHoras % HORAS_DIA : totalHoras; 
	}
	
}
