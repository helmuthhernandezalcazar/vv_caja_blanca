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
		
		try {
			File testCamino1txt = new File("Test_Camino_1.txt");
			testCamino1txt.createNewFile();
			editor.leerFichero("./Test_Camino_1.txt");
		}catch(IOException e) {
			e.getStackTrace();
		}

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
		
		try {
			
			File testCamino3txt = new File("Test_Camino_3.txt");
			testCamino3txt.createNewFile();
			
			FileWriter fw = new FileWriter("Test_Camino_3.txt");
			fw.write(" ");
			fw.close();
			
			editor.leerFichero("Test_Camino_3.txt");
			
		}catch(IOException e) {
			e.getStackTrace();
		}
		
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
		
		try {
			
			File testCamino4txt = new File("Test_Camino_4.txt");
			testCamino4txt.createNewFile();
			
			FileWriter fw = new FileWriter("Test_Camino_4.txt");
			fw.write("Hola");
			fw.close();
			
			editor.leerFichero("Test_Camino_4.txt");
			
		}catch(IOException e) {
			e.getStackTrace();
		}

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
		
		try {
			
			File testCamino6txt = new File("Test_Camino_6.txt");
			testCamino6txt.createNewFile();
			
			FileWriter fw = new FileWriter("Test_Camino_6.txt");
			fw.write("Hey oye\nHola");
			fw.close();
			
			editor.leerFichero("Test_Camino_6.txt");
			
		}catch(IOException e) {
			e.getStackTrace();
		}

		try {
			assertEquals("Hola", editor.mayorLongitud());
		}catch(EmptyCollectionException e) {
			System.out.println("Error");
		}
	}
}
