package com.practica.cajablanca;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.cajanegra.EmptyCollectionException;

public class MayorLongitudTest {
	
	private Editor editor;
	
	@BeforeEach
	public void setUp() {
		editor = new Editor();
	}
	
	@Test
	@DisplayName("Test camino 1: fichero vacío")
	public void testMayorLongitud1() throws EmptyCollectionException {
		editor.leerFichero("vacio.txt");
		assertNull(editor.mayorLongitud());
	}

	@Test
	@DisplayName("Test camino 3: Una linea vacía")
	public void testMayorLongitud3() throws EmptyCollectionException {
		editor.leerFichero("linea_vacia.txt");
		assertNull(editor.mayorLongitud());
	}
	
	@Test
	@DisplayName("Test camino 4: Una sola palabra")
	public void testMayorLongitud4() throws EmptyCollectionException {
		editor.leerFichero("hola_asecas.txt");
		assertEquals("Hola", editor.mayorLongitud());
	}

	@Test
	@DisplayName("Test camino 6: una palabra después de la primera es mayor")
	public void testMayorLongitud6() throws EmptyCollectionException {
		editor.leerFichero("hey_oye_hola.txt");
		assertEquals("Hola", editor.mayorLongitud());
	}
}
