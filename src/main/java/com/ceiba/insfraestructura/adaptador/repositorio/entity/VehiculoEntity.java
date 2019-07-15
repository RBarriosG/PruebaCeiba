package com.ceiba.insfraestructura.adaptador.repositorio.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class VehiculoEntity {

	@Column(name = "placa")
	private String placa;

	@Column(name = "tipo")
	private String tipo;

	@Column(name = "cilindraje")
	private int cilindraje;

}
