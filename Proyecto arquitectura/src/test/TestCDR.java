package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import entidades.CDR;

class TestCDR {

	@Test
	public void verificarQueRetorne74701750ComoTelefonoDeOrigenCDR(){
		CDR cdr = new CDR(74701750,73045476,"20/05/22","19:14","00:02:30",2.2);
		assertEquals(74701750, cdr.getTelefonoOrigen());
	}
	@Test
	public void verificarQueRetorne73045476ComoTelefonoDestinoCDR(){
		CDR cdr = new CDR(74701750,73045476,"20/05/22","19:14","00:02:30",2.2);
		assertEquals(73045476, cdr.getTelefonoDestino());
	}
	@Test
	public void verificarQueRetorne200522ComoFechaCDR(){
		CDR cdr = new CDR(74701750,73045476,"20/05/22","19:14","00:02:30",2.2);
		assertEquals("20/05/22", cdr.getFecha());
	}
	
	@Test
	public void verificarQueRetorne2024ComoHoraCDR(){
		CDR cdr = new CDR(74701750,73045476,"20/05/22","20:24","00:02:30",2.2);
		assertEquals("20:24", cdr.getHora());
	}
	
	@Test
	public void verificarQueRetorne0230ComoTiempoDuracionCDR(){
		CDR cdr = new CDR(74701750,73045476,"20/05/22","19:14","00:02:30",2.2);
		assertEquals("00:02:30", cdr.getTiempoDuracion());
	}
	
	@Test
	public void verificarQueRetorne0ComoCostoCDR(){
		CDR cdr = new CDR(74701750,73045476,"20/05/22","19:14","00:02:30",0.0);
		assertEquals(0.0, cdr.getCosto());
	}
	@Test 
	public void verificarQueRetorne5ComoCostoCDRSiModificoElCostoA5(){
		CDR cdr = new CDR(74701750,73045476,"20/05/22","19:14","00:02:30",2.2);
		cdr.setCosto(5);
		assertEquals(5.0, cdr.getCosto());
	}
	@Test 
	public void verificarQueRetorne2punto30ComoDuracionDeLlamadaEnMinutos(){
		CDR cdr = new CDR(74701750,73045476,"20/05/22","19:14","00:02:30",2.2);
		assertEquals(2.30, cdr.getDuracionDeLlamadaEnMinutos());
	}
	@Test 
	public void verificarQueRetorne2ComoDuracionDeLlamadaEnMinutos(){
		CDR cdr = new CDR(74701750,73045476,"20/05/22","19:14","00:02",2.2);
		assertEquals(2, cdr.getDuracionDeLlamadaEnMinutos());
	}
	@Test 
	public void verificarQueRetorne60ComoDuracionDeLlamadaEnMinutos(){
		CDR cdr = new CDR(74701750,73045476,"20/05/22","19:14","01:00",2.2);
		assertEquals(60, cdr.getDuracionDeLlamadaEnMinutos());
	}
	@Test 
	public void verificarQueRetorne60punto2ComoDuracionDeLlamadaEnMinutos(){
		CDR cdr = new CDR(74701750,73045476,"20/05/22","19:14","01:00:20",2.2);
		assertEquals(60.2, cdr.getDuracionDeLlamadaEnMinutos());
	}
	@Test 
	public void verificarQueRetorne05ComoElMesDelCDR(){
		CDR cdr = new CDR(74701750,73045476,"20/05/22","19:14","01:00:20",2.2);
		assertEquals("05", cdr.getMes());
	}
	@Test 
	public void verificarQueRetorne74701750ComoNumeroDeOrigen(){
		CDR cdr = new CDR(74701750,73045476,"20/05/22","19:14","01:00:20",2.2);
		assertEquals(74701750, cdr.getTelefonoOrigen());
	}

}
