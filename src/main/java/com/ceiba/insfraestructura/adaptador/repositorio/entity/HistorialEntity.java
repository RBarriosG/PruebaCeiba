package com.ceiba.insfraestructura.adaptador.repositorio.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "historial")
public class HistorialEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private LocalDateTime fechaEntrada;

	private LocalDateTime fechaSalida;

	private VehiculoEntity vehiculoEntity;

	private double valor;

	public HistorialEntity(LocalDateTime fechaEntrada, LocalDateTime fechaSalida, VehiculoEntity vehiculoEntity,
			double valor) {
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.vehiculoEntity = vehiculoEntity;
		this.valor = valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public void setFechaSalida(LocalDateTime fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

}
