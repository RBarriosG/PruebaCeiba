package com.ceiba.insfraestructura.configuracion;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class ConfiguracionWeb implements WebMvcConfigurer{

	  private static final long MAX_AGE_SECS = 3600;

	  @Override
	  public void addCorsMappings(CorsRegistry registro) {
	    registro.addMapping("/**").allowedOrigins("*")
	        .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS").allowedHeaders("*")
	        .allowCredentials(true).maxAge(MAX_AGE_SECS);
	  }
	
}
