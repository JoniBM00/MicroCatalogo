package com.viewnext.microcatalogo.bussines.model;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.Data;

/**
 * Es para tener recogida la información de los productos que tengo leidos desde
 * csv Tiene un mapa que es donde se almacena
 */
@Data
public class MapaProductos {

	private static Map<Long, Producto> mProductos = new HashMap<>();
	private static final Logger log = LoggerFactory.getLogger(MapaProductos.class);

	private MapaProductos() {
	}

	/**
	 * Mete un nuevo producto
	 * 
	 * @param id Map key
	 * @param p  El producto
	 */
	public static void addProducto(Long id, Producto p) {
		mProductos.put(id, p);
	}

	/**
	 * Busca un producto por el id
	 * 
	 * @param id
	 * @return El producto si lo ha encontrado o null si no lo ha hecho
	 */
	public static Producto buscarProducto(Long id) {
		return mProductos.get(id);
	}

	/**
	 * @return El mapa completo de productos
	 */
	public static Map<Long, Producto> getmProductos() {
		return mProductos;
	}

	/**
	 * Muestra todos los productos
	 */
	public static void mostrarMapa() {
		log.info("{}", mProductos);
	}

}
