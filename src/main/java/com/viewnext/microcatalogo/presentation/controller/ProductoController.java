package com.viewnext.microcatalogo.presentation.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viewnext.microcatalogo.bussines.model.MapaProductos;
import com.viewnext.microcatalogo.bussines.model.Producto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/catalogo")
public class ProductoController {

	private static final Logger log = LoggerFactory.getLogger(ProductoController.class);

	/**
	 * Retorna una lista de todos los productos que hay en el mapa
	 * 
	 * @return Una lista de todos los productos
	 */
	@GetMapping("/get")
	public ResponseEntity<List<Producto>> getProductos() {
		ArrayList<Producto> lProductos = new ArrayList<>(MapaProductos.getmProductos().values());
		log.info("Mostrando los productos.");
		return ResponseEntity.ok(lProductos);

	}

}
