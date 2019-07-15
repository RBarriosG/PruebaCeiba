package com.ceiba.insfraestructura.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.aplicacion.comando.ComandoVehiculo;
import com.ceiba.aplicacion.comando.manejador.ManejadorIngresarVehiculo;
import com.ceiba.aplicacion.consulta.manejador.ManejadorListarVehiculos;
import com.ceiba.aplicacion.consulta.manejador.ManejadorListarVehiculosEnParqueadero;
import com.ceiba.aplicacion.consulta.manejador.ManejadorSalidaVehiculo;
import com.ceiba.dominio.modelo.Vehiculo;
import com.ceiba.dominio.modelo.VehiculosEnParqueadero;

@RestController
public class ControladorVehiculo {

	private final ManejadorListarVehiculos manejadorListarVehiculos;
	private final ManejadorSalidaVehiculo manejadorSalidaVehiculo;
	private final ManejadorIngresarVehiculo manejadorIngresarVehiculo;
	private final ManejadorListarVehiculosEnParqueadero manejadorListarVehiculosEnParqueadero;

	@Autowired
	public ControladorVehiculo(ManejadorListarVehiculos manejadorListarVehiculos,
			ManejadorSalidaVehiculo manejadorSalidaVehiculo, ManejadorIngresarVehiculo manejadorIngresarVehiculo,
			ManejadorListarVehiculosEnParqueadero manejadorListarVehiculosEnParqueadero) {
		this.manejadorIngresarVehiculo = manejadorIngresarVehiculo;
		this.manejadorListarVehiculos = manejadorListarVehiculos;
		this.manejadorListarVehiculosEnParqueadero = manejadorListarVehiculosEnParqueadero;
		this.manejadorSalidaVehiculo = manejadorSalidaVehiculo;
	}
	
	
	@GetMapping("webapi/parqueos")
	public List<VehiculosEnParqueadero> listarVehiculosEnParqueadero(){
		return this.manejadorListarVehiculosEnParqueadero.ejecutar();
	}
	
	@PostMapping("webapi/parqueos")
	@ResponseStatus(HttpStatus.CREATED)
	public void ingresarVehiculo(@RequestBody ComandoVehiculo comandoVehiculo) {
		this.manejadorIngresarVehiculo.ejecutar(comandoVehiculo);
	}

	@DeleteMapping("webapi/parqueos/{placa}")
	public double salidaVehiculo(@PathVariable String placa) {
		return this.manejadorSalidaVehiculo.ejecutar(placa);
	}
	
	@GetMapping("webapi/vehiculos")
	public List<Vehiculo> vehiculos() {
		return this.manejadorListarVehiculos.ejecutar();
	}
	
}
