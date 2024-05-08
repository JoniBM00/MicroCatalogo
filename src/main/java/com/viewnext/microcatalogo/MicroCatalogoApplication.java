package com.viewnext.microcatalogo;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.viewnext.microcatalogo.bussines.model.MapaProductos;
import com.viewnext.microcatalogo.bussines.service.Reader;

@SpringBootApplication
public class MicroCatalogoApplication {

	public static void main(String[] args) {

		SpringApplication.run(MicroCatalogoApplication.class, args);
		try {
			Reader.readCsv();
		} catch (IOException e) {
			e.printStackTrace();
		}

		MapaProductos.mostrarMapa();

	}

}
