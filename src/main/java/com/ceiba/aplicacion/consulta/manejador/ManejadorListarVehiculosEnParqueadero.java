package com.ceiba.aplicacion.consulta.manejador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.aplicacion.comando.ComandoVehiculoEnParqueadero;
import com.ceiba.dominio.modelo.VehiculosEnParqueadero;
import com.ceiba.dominio.servicio.ServicioListarVehiculosEnParqueadero;

@Component
public class ManejadorListarVehiculosEnParqueadero {

	private ServicioListarVehiculosEnParqueadero servicioListarVehiculosEnParqueadero;
	
	@Autowired
	public ManejadorListarVehiculosEnParqueadero(ServicioListarVehiculosEnParqueadero servicioListarVehiculosEnParqueadero) {
		this.servicioListarVehiculosEnParqueadero = servicioListarVehiculosEnParqueadero;
	}
	
	public List<ComandoVehiculoEnParqueadero> ejecutar(){
		return convertirListaAComando(servicioListarVehiculosEnParqueadero.ejecutar());
	}
	
	private ComandoVehiculoEnParqueadero convertirAComando(VehiculosEnParqueadero vehiculosEnParqueadero) {
		ComandoVehiculoEnParqueadero comando = new ComandoVehiculoEnParqueadero();
		comando.setPlaca(vehiculosEnParqueadero.getVehiculo().getPlaca());
		comando.setTipo(vehiculosEnParqueadero.getVehiculo().getTipo());
		comando.setFechaEntrada(vehiculosEnParqueadero.getFechaEntrada());
		return comando;
	}
	
	private List<ComandoVehiculoEnParqueadero> convertirListaAComando(List<VehiculosEnParqueadero> listaComando){
		List<ComandoVehiculoEnParqueadero> comandos = new ArrayList<>();
		listaComando.forEach(comando -> comandos.add(convertirAComando(comando)));
		return comandos;
	}
	
}
