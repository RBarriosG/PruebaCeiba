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
public class ControladorVehiculoTest extends BaseTest{

	@Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;
	
	private static final String API_PARQUEDERO = "/webapi/parqueos";
	private static final String API_INGRESAR = API_PARQUEDERO;
	private static final String API_SALIDA = API_PARQUEDERO;
	
	
	@Test
	public void testIngresarVehiculo() throws Exception {
		// arrange
		ComandoVehiculo comandoVehiculo = new ComandoVehiculoTestDataBuilder().build();

		// act - assert
		mocMvc.perform(post(API_INGRESAR).contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(objectMapper.writeValueAsString(comandoVehiculo))).andExpect(status().isCreated());
	}

	@Test
	public void testSalidaVehiculo() throws Exception {
		// arrange
		ComandoVehiculo comandoVehiculo = new ComandoVehiculoTestDataBuilder().build();
		String url = API_SALIDA + "/" + comandoVehiculo.getPlaca();

		mocMvc.perform(post(API_INGRESAR).contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(objectMapper.writeValueAsString(comandoVehiculo)));

		// act - assert
		mocMvc.perform(delete(url).contentType(MediaType.APPLICATION_JSON_UTF8)).andExpect(status().isOk());
	}
	
	@Test
	public void testListarVehiculosEnParqueadero() throws Exception {
		// arrange
		String placa = "MXT";
		String tipo = "CARRO";
		
		ComandoVehiculo comandoVehiculo = new ComandoVehiculoTestDataBuilder().conPlaca(placa).conTipo(tipo).build();

		mocMvc.perform(post(API_PARQUEDERO).contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(objectMapper.writeValueAsString(comandoVehiculo)));
		
		//assert
    	mocMvc.perform(get(API_PARQUEDERO)
    		      .contentType(MediaType.APPLICATION_JSON))
    		      .andExpect(status().isOk())
    		      .andExpect(jsonPath("$", hasSize(1)))
    		      .andExpect(jsonPath("$[0].placa", is(placa)));
	}
	
}
