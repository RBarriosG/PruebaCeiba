package com.ceiba.insfraestructura.controlador;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.ceiba.aplicacion.comando.ComandoVehiculo;
import com.ceiba.insfraestructura.BaseTest;
import com.ceiba.insfraestructura.testdatabuilder.ComandoVehiculoTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ControladorVehiculoTest extends BaseTest {

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private MockMvc mocMvc;

	private static final String WEBAPI_PARQUEDERO = "/webapi/parqueos";
	private static final String WEBAPI_INGRESAR = WEBAPI_PARQUEDERO;
	private static final String WEBAPI_SALIDA = WEBAPI_PARQUEDERO;
	
	private static final String WEBAPI_VEHICULO = "/webapi/vehiculos";

	@Test
	public void testIngresarVehiculo() throws Exception {
		// arrange
		ComandoVehiculo comandoVehiculo = new ComandoVehiculoTestDataBuilder().build();

		// act - assert
		mocMvc.perform(post(WEBAPI_INGRESAR).contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(objectMapper.writeValueAsString(comandoVehiculo))).andExpect(status().isCreated());
	}

	@Test
	public void testSalidaVehiculo() throws Exception {
		// arrange
		String placa = "PLS123";
		ComandoVehiculo comandoVehiculo = new ComandoVehiculoTestDataBuilder().conPlaca(placa).build();
		String url = WEBAPI_SALIDA + "/" + comandoVehiculo.getPlaca();

		mocMvc.perform(post(WEBAPI_INGRESAR).contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(objectMapper.writeValueAsString(comandoVehiculo)));

		// act - assert
		mocMvc.perform(delete(url).contentType(MediaType.APPLICATION_JSON_UTF8)).andExpect(status().isOk());
	}

	@Test
	public void testListarVehiculosEnParqueadero() throws Exception {
		// arrange
		String placa = "FEF345";
		String tipo = "CARRO";
		int cilindraje = 300;

		ComandoVehiculo comandoVehiculo = new ComandoVehiculoTestDataBuilder().conPlaca(placa).conTipo(tipo)
				.conCilindraje(cilindraje).build();

		mocMvc.perform(post(WEBAPI_PARQUEDERO).contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(objectMapper.writeValueAsString(comandoVehiculo)));	

		// act - assert
		mocMvc.perform(get(WEBAPI_PARQUEDERO).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(1))).andExpect(jsonPath("$[0].placa", is(placa)));
	}

	@Test
	public void testListarVehiculos() throws Exception {
		// arrange
		String placa = "EAF345";
		String tipo = "CARRO";
		int cilindraje = 300;

		ComandoVehiculo comandoVehiculo = new ComandoVehiculoTestDataBuilder().conPlaca(placa).conTipo(tipo)
				.conCilindraje(cilindraje).build();

		mocMvc.perform(post(WEBAPI_PARQUEDERO).contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(objectMapper.writeValueAsString(comandoVehiculo)));	

		// assert
		mocMvc.perform(get(WEBAPI_VEHICULO).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(4))).andExpect(jsonPath("$[3].placa", is(placa)));
	}
	
}
