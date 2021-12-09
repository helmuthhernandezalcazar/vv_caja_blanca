package com.practica.cajablanca;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.cajanegra.EmptyCollectionException;

public class SustituirPalabraTest {

	private Editor editor;
	
	@BeforeEach
	public void setUp() {
		editor = new Editor();
	}
	
	@DisplayName("Test camino 1: A-M")
	@Test
	public void camino1SustituirPalabra() {	
		this.editor.sustituirPalabra("avion", "coche");
		assertEquals(0, this.editor.size());		
	}
	
	@DisplayName("Test camino 2: A-B-C-D-E-J-K-L-M")
	@Test
	public void camino2SustituirPalabra() throws EmptyCollectionException  {	
		this.editor.leerFichero("vacio.txt");
		assertEquals(1, this.editor.size());
		this.editor.sustituirPalabra("avion", "coche");		
		assertEquals(0, this.editor.getLinea(1).size());		
	}
	
	@DisplayName("Test camino 3: A-B-C-D-E-F-G-I-E-J-K-L-M")
	@Test
	public void camino3SustituirPalabra() throws EmptyCollectionException {	
		this.editor.leerFichero("avion.txt");
		assertEquals(1, this.editor.size());		
		assertEquals("avion", this.editor.getLinea(1).getAtPos(1));
		editor.sustituirPalabra("avion", "coche");		
		assertEquals("coche", this.editor.getLinea(1).getAtPos(1));
		assertEquals(1, this.editor.getLinea(1).size());		
	}
	
	@DisplayName("Test camino 4: A-B-C-D-E-F-H-I-E-J-K-L-M")
	@Test
	public void camino4SustituirPalabra() throws EmptyCollectionException {	
		this.editor.leerFichero("avion.txt");
		assertEquals(1, this.editor.size());		
		assertEquals("avion", this.editor.getLinea(1).getAtPos(1));
		editor.sustituirPalabra("tren", "coche");		
		assertEquals("avion", this.editor.getLinea(1).getAtPos(1));
		assertEquals(1, this.editor.getLinea(1).size());	
	}

	@DisplayName("Test camino 5: A-B-C-D-E-J-K-C-D-E-J-K-C-D-E-J-K-L-M")
	@Test
	public void camino5SustituirPalabra() throws EmptyCollectionException {	
		this.editor.leerFichero("vacio.txt");
		this.editor.leerFichero("vacio.txt");
		assertEquals(2, this.editor.size());		
		editor.sustituirPalabra("avion", "coche");		
		assertEquals(0, this.editor.getLinea(1).size());
		assertEquals(0, this.editor.getLinea(2).size());
	}
}
