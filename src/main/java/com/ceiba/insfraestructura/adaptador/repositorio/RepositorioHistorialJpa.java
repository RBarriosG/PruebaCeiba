package com.ceiba.insfraestructura.adaptador.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ceiba.insfraestructura.adaptador.repositorio.entity.HistorialEntity;

public interface RepositorioHistorialJpa extends JpaRepository<HistorialEntity, Long> {

	@Query("SELECT Count(*) FROM HistorialEntity h WHERE h.fechaSalida = null AND h.vehiculoEntity.tipo = ?1")
	long contarVehiculoPorTipo(String tipo);

	@Query("SELECT h FROM HistorialEntity h WHERE h.fechaSalida = null")
	List<HistorialEntity> listarVehiculosEnParqueadero();

	@Query("SELECT h FROM HistorialEntity h WHERE h.vehiculoEntity.placa = ?1")
	HistorialEntity obtenerHistorialPorPlaca(String placa);

}
