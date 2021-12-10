package com.practica.cajablanca;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumPalabrasTest {

	private Editor editor;

	@BeforeEach
	public void setUp() {
		editor = new Editor();
	}
	
	@Test
	@DisplayName("Test camino 1: Excepción inicio menor que 0")
	public void numPalabrasCaso1() {
		assertThrows(IllegalArgumentException.class, () -> { 
			editor.numPalabras(-1, 1, ""); 
		});
	}
	
	@Test
	@DisplayName("Test camino 2: Fin mayor que editor size")
	public void numPalabrasCaso2() {
		editor.leerFichero("hola.txt");
		assertThrows(IllegalArgumentException.class, () -> {
			editor.numPalabras(1, 3, "");
		});
	}
	
	@Test
	@DisplayName("Test camino 3: editor no contiene nada")
	public void numPalabrasCaso3() {
		int result = editor.numPalabras(1,0,"");
		assertEquals(0, result);
	}
	
	@Test
	@DisplayName("Test camino 4: inicio no es menor que fin")
	public void numPalabrasCaso4() {
		editor.leerFichero("hola.txt");
		int result = editor.numPalabras(1,1,"");
		assertEquals(0, result);
	}
	
	@Test
	@DisplayName("Test camino 6: la palabra no aparece ninguna vez")
	public void numPalabrasCaso6() {
		editor.leerFichero("adios.txt");
		int result = editor.numPalabras(1,2,"hola");
		assertEquals(0, result);
	}
	
	@Test
	@DisplayName("Test camino 7: la palabra aparece 1 vez")
	public void numPalabrasCaso7() {
		editor.leerFichero("hola.txt");
		int result = editor.numPalabras(1,2,"hola");
		assertEquals(1, result);
	}
}