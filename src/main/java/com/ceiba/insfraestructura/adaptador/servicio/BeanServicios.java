package com.ceiba.insfraestructura.adaptador.servicio;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ceiba.dominio.servicio.ServicioIngresarVehiculo;
import com.ceiba.dominio.servicio.ServicioListarVehiculo;
import com.ceiba.dominio.servicio.ServicioListarVehiculosEnParqueadero;
import com.ceiba.dominio.servicio.ServicioSalidaVehiculo;
import com.ceiba.insfraestructura.adaptador.repositorio.RepositorioHistorialJpa;
import com.ceiba.insfraestructura.adaptador.repositorio.RepositorioHistorialmpl;

@Configuration
public class BeanServicios {

	@Bean
	public ServicioIngresarVehiculo servicioIngresarVehiculo(RepositorioHistorialJpa repositorioHistorialJpa) {
		return new ServicioIngresarVehiculo(new RepositorioHistorialmpl(repositorioHistorialJpa));
	}
	
	@Bean
	public ServicioListarVehiculosEnParqueadero servicioListarVehiculosEnParqueadero(RepositorioHistorialJpa repositorioHistorialJpa) {
		return new ServicioListarVehiculosEnParqueadero(new RepositorioHistorialmpl(repositorioHistorialJpa));
	}
	
	@Bean
	public ServicioSalidaVehiculo servicioSalidaVehiculo(RepositorioHistorialJpa repositorioHistorialJpa) {
		return new ServicioSalidaVehiculo(new RepositorioHistorialmpl(repositorioHistorialJpa));
	}
	
	@Bean
	public ServicioListarVehiculo servicioListarVehiculo(RepositorioHistorialJpa repositorioHistorialJpa) {
		return new ServicioListarVehiculo(new RepositorioHistorialmpl(repositorioHistorialJpa));
	}
}
