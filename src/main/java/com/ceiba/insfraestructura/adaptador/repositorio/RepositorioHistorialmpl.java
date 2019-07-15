package com.ceiba.insfraestructura.adaptador.repositorio;

import java.util.List;

import com.ceiba.dominio.modelo.Historial;
import com.ceiba.dominio.modelo.Vehiculo;
import com.ceiba.dominio.modelo.VehiculosEnParqueadero;
import com.ceiba.dominio.puerto.repositorio.RepositorioHistorial;
import com.ceiba.insfraestructura.adaptador.repositorio.conversor.ConversorHistorial;
import com.ceiba.insfraestructura.adaptador.repositorio.entity.HistorialEntity;

public class RepositorioHistorialmpl implements RepositorioHistorial {

	private RepositorioHistorialJpa repositorioHistorialJpa;

	public RepositorioHistorialmpl(RepositorioHistorialJpa repositorioHistorialJpa) {
		this.repositorioHistorialJpa = repositorioHistorialJpa;
	}

	@Override
	public Historial guardar(Historial historial) {
		HistorialEntity historialEntity = this.repositorioHistorialJpa
				.save(ConversorHistorial.convertirAEntidad(historial));
		return ConversorHistorial.convertirAModelo(historialEntity);
	}

	@Override
	public List<Historial> listar() {
		return ConversorHistorial.convertirListaAModelo(repositorioHistorialJpa.findAll());
	}

	@Override
	public void borrar(Historial historial) {
		repositorioHistorialJpa.delete(ConversorHistorial.convertirAEntidad(historial));
	}

	@Override
	public long contarVehiculosPorTipo(String tipo) {
		return repositorioHistorialJpa.contarVehiculoPorTipo(tipo);
	}

	@Override
	public List<VehiculosEnParqueadero> listarVehiculosEnParqueadero() {
		return ConversorHistorial
				.convertirListaAVehiculosEnParqueadero(repositorioHistorialJpa.listarVehiculosEnParqueadero());
	}

	@Override
	public List<Vehiculo> listarTodosLosVehiculos() {
		return ConversorHistorial.convertirListaAVehiculos(repositorioHistorialJpa.findAll());
	}

	@Override
	public boolean existeVehiculoConPlaca(String placa) {
		return repositorioHistorialJpa.obtenerHistorialPorPlaca(placa) != null ? true : false;
	}

	@Override
	public Historial obtenerHistorialPorPlaca(String placa) {
		return ConversorHistorial.convertirAModelo(repositorioHistorialJpa.obtenerHistorialPorPlaca(placa));
	}

	@Override
	public Historial actualizarHistorial(Historial historialActual) {
		HistorialEntity historialEntity = repositorioHistorialJpa
				.obtenerHistorialPorPlaca(historialActual.getVehiculo().getPlaca());
		historialEntity.setValor(historialActual.getValor());
		historialEntity.setFechaSalida(historialActual.getFechaSalida());
		HistorialEntity historialActualizado = repositorioHistorialJpa.save(historialEntity);
		return ConversorHistorial.convertirAModelo(historialActualizado);
	}

}
