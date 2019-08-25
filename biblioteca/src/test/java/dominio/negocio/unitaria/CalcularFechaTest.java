package dominio.negocio.unitaria;

import java.util.Date;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertNotNull;

import dominio.negocio.CalcularFecha;


public class CalcularFechaTest {

	@Test
	public void obtenerFechaActualTest(){
		Date fechaActual = new Date();
		
		assertEquals(CalcularFecha.obtenerFechaActual(), fechaActual);
		
	}
	
	@Test
	public void generarFechaEntregaLibroTest() {
		assertNotNull(CalcularFecha.generarFechaEntregaLibro());
	}
	
	@Test
	public void sumarDiasFechaActualTest(){
		Date fechaActual = CalcularFecha.obtenerFechaActual();
		
		assertNotNull(CalcularFecha.sumarDiasFechaActual(fechaActual));
	}
}
