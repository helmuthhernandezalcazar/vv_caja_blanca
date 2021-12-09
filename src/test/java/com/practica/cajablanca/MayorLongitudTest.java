package com.practica.cajablanca;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.cajanegra.EmptyCollectionException;

public class MayorLongitudTest {
	
	@Test
	@DisplayName("Test del camino 1: fichero vacío")
	public void testMayorLongitud1() {
		Editor editor = new Editor();
		
		editor.leerFichero("vacio.txt");

		try {
			assertNull(editor.mayorLongitud());
		}catch(EmptyCollectionException e) {
			System.out.println("Error al leer");
		}
	}

	@Test
	@DisplayName("Test del camino 3: Una linea vacía")
	public void testMayorLongitud3() {
		Editor editor = new Editor();
		
	
		editor.leerFichero("linea_vacia.txt");
			
		try {
			assertNull(editor.mayorLongitud());
		}catch(EmptyCollectionException e) {
			System.out.println("Error");
		}
	}
	
	@Test
	@DisplayName("Test del camino 4: Una sola palabra")
	public void testMayorLongitud4() {
		Editor editor = new Editor();
			
		editor.leerFichero("hola_asecas.txt");

		try {
			assertEquals("Hola", editor.mayorLongitud());
		}catch(EmptyCollectionException e) {
			System.out.println("Error");
		}
	}
	

	@Test
	@DisplayName("Test del camino 6: una palabra después de la primera es mayor")
	public void testMayorLongitud6() {
		Editor editor = new Editor();
		
			
		editor.leerFichero("hey_oye_hola.txt");
			
		try {
			assertEquals("Hola", editor.mayorLongitud());
		}catch(EmptyCollectionException e) {
			System.out.println("Error");
		}
	}
}
