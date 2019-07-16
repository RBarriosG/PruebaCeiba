package com.ceiba.aplicacion.comando;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ComandoVehiculoEnParqueadero {

	private String placa;

	private String tipo;

	private LocalDateTime fechaEntrada;

}
