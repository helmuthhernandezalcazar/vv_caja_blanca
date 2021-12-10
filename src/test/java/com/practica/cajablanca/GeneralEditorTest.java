package com.practica.cajablanca;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cajanegra.EmptyCollectionException;

public class GeneralEditorTest {
	
	private Editor editor;
	
	@BeforeEach
	public void setUp() {
		editor = new Editor();
	}
	
	@Test
	public void editIsEmptyTest() {
		assertTrue(editor.editIsEmpty());
		editor.leerFichero("vacio.txt");
		assertFalse(editor.editIsEmpty());
	}
	
	@Test
	public void getLinealEmptyCollectionException() {
		assertThrows(EmptyCollectionException.class, () -> {
			editor.getLinea(1);
		});
	}
	
	@Test
	public void getLinealIllegalArgumentExceptionMenorCero() {
		editor.leerFichero("vacio.txt");
		assertThrows(IllegalArgumentException.class, () -> {
			editor.getLinea(-1);
		});
	}
	
	@Test
	public void getLinealIllegalArgumentExceptionMayorSize() {
		editor.leerFichero("vacio.txt");
		assertThrows(IllegalArgumentException.class, () -> {
			editor.getLinea(editor.size()+1);
		});
	}
	
	@Test
	public void numPalabrasEmptyCollectionException() {
		assertThrows(EmptyCollectionException.class, () -> {
			editor.numPalabras();
		});
	}
	
	@Test
	public void numPalabraVacio() throws EmptyCollectionException {
		editor.leerFichero("vacio.txt");
		editor.numPalabras();
	}
	
	@Test
	public void numPalabra() throws EmptyCollectionException {
		editor.leerFichero("avion.txt");
		editor.numPalabras();
	}
	
}
