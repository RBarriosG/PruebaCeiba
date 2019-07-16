package com.ceiba.dominio.modelo.validador;

import java.time.Duration;
import java.time.LocalDateTime;

import com.ceiba.dominio.util.Constantes;

public final class ReglaCobro {

	private static final long HORAS_DIA = 24;
	private static final long HORA_MAXIMA_PARA_COBRAR_POR_DIA = 9;
	private static final int CILINDRAJE_MAXIMO_PARA_COBRAR_EXCEDENTE = 500;
	
	private static final int MINUTO_EN_SEGUNDO = 60;
	
	private static final int CERO_HORAS = 0;
	
	private static final int UNA_HORA = 1;
	
	private ReglaCobro() {
	}
	
	public static double valorACobrar(LocalDateTime fechaEntrada, LocalDateTime fechaSalida, String tipoVehiculo, int cilindraje) {
		long totalHoras = calcularTotalHoras(fechaEntrada, fechaSalida);
		long dias = calcularDias(totalHoras);
		long horas = calcularHorasUltimoDia(totalHoras, fechaEntrada, fechaSalida);
		return totalACobrar(dias, horas, tipoVehiculo, cilindraje);
	}

	private static double totalACobrar(long dias, long horas, String tipoVehiculo, int cilindraje) {
		if (tipoVehiculo.equals(Constantes.CARRO))
			return dias * Constantes.VALOR_DIA_CARRO + horas * Constantes.VALOR_HORA_CARRO;
		else if (cilindraje > CILINDRAJE_MAXIMO_PARA_COBRAR_EXCEDENTE)
			return dias * Constantes.VALOR_DIA_MOTO + horas * Constantes.VALOR_HORA_MOTO + Constantes.VALOR_AGREGADO_MOTO_MAYOR_500CC;
		else
			return dias * Constantes.VALOR_DIA_MOTO + horas * Constantes.VALOR_HORA_MOTO;
	}


	private static long calcularHorasUltimoDia(long totalHoras, LocalDateTime fechaEntrada, LocalDateTime fechaSalida) {
		long horasPasadas = calcularHorasExtra(totalHoras);
		return horasPasadas < HORA_MAXIMA_PARA_COBRAR_POR_DIA ? horasPasadas + AgregarHoraSiHayMinutoDeDiferencia(fechaEntrada, fechaSalida) : CERO_HORAS;
	}
	
	private static long AgregarHoraSiHayMinutoDeDiferencia(LocalDateTime fechaEntrada, LocalDateTime fechaSalida) {
		 return Duration.between(fechaEntrada, fechaSalida).toMinutes() % MINUTO_EN_SEGUNDO > 0 ? UNA_HORA : CERO_HORAS;
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
