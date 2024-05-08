package com.viewnext.microcatalogo.bussines.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.viewnext.microcatalogo.bussines.model.MapaProductos;
import com.viewnext.microcatalogo.bussines.model.Producto;

public class Reader {

	private static final Logger log = LoggerFactory.getLogger(Reader.class);

	private Reader() {
	}

	/**
	 * Lee los 2 ficheros csv, el primero(stockTerminales.csv) lo pasa a objetos de
	 * Producto y lo mete el mapa de MapaProductos, despues se lee el fichero
	 * terminales.csv, se busca en el mapa el producto creando anteriormente y si
	 * encuentra el que tiene la misma id le hace el set de los atributos que le
	 * faltan
	 * 
	 * @throws IOException
	 */
	public static void readCsv() throws IOException {
		// Lee el primer fichero csv y lo mete en el mapa de MapaProductos
		try (BufferedReader br = new BufferedReader(new FileReader("stockTerminales.csv"))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] values = line.split(",");
				Producto p = new Producto();
				p.setLugar(values[0]);
				p.setId(Long.valueOf(values[1]));
				p.setStock(Integer.valueOf(values[2]));
				p.setStockReal(Integer.valueOf(values[3]));
				p.setStockVirtual(Integer.valueOf(values[4]));

				MapaProductos.addProducto(p.getId(), p);
			}
		}
		// Lee el segundo fichero csv, busca la id dentro del mapa y si lo encuentra usa
		// la información de este csv para ponerlo en el producto encontrado
		try (BufferedReader br = new BufferedReader(new FileReader("terminales.csv"))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] values = line.split(",");
				Producto p = new Producto();

				p = MapaProductos.buscarProducto(Long.valueOf(values[3]));

				if (p != null) {
					p.setNombre(values[1]);
					p.setCodigo(Long.valueOf(values[3]));
				}

			}
		}

	}

}
