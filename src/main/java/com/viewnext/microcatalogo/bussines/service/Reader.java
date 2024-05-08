package com.viewnext.microcatalogo.bussines.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.viewnext.microcatalogo.bussines.model.MapaProductos;
import com.viewnext.microcatalogo.bussines.model.Producto;

public class Reader {

	private static final Logger log = LoggerFactory.getLogger(Reader.class);

	/**
	 * PARA LEER EN CSV
	 * 
	 * @throws IOException
	 * @throws FileNotFoundException
	 */

	public static void readCsv() throws FileNotFoundException, IOException {

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
