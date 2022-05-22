package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import entidades.Usuario;
import planes.IPlan;
import planes.PlanWow;
import tarifaciones.ITarifacion;
import tarifaciones.TarifacionFijaPorMinuto;

class TestUsuario {

	@Test
	public void verificaQueRetorneAndrew() {
		Usuario usuario= new Usuario("Andrew",9568487,76654488);
		assertEquals("Andrew",usuario.getNombre());
	}
	@Test
	public void verificaQueRetorneAugusto() {
		Usuario usuario= new Usuario("Andrew",9568487,76654488);
		usuario.setNombre("Augusto");
		assertEquals("Augusto",usuario.getNombre());
	}
	@Test
	public void verificaQueRetorne76654488DeNumeroDeTelefono() {
		Usuario usuario= new Usuario("Andrew",9568487,76654488);
		assertEquals(76654488, usuario.getNumeroTelefonoMovil());
	}
	@Test
	public void verificaQueRetorne12345678DeNumeroDeTelefono() {
		Usuario usuario= new Usuario("Andrew",9568487,76654488);
		usuario.setNumeroTelefonoMovil(12345678);
		assertEquals(12345678, usuario.getNumeroTelefonoMovil());
	}
	@Test
	public void verificaQueRetorne9568487ComoCi() {
		Usuario usuario= new Usuario("Andrew",9568487,76654488);
		assertEquals(9568487, usuario.getCi());
	}
	@Test
	public void verificaQueRetorne1234567ComoCi() {
		Usuario usuario= new Usuario("Andrew",9568487,76654488);
		usuario.setCi(1234567);
		assertEquals(1234567, usuario.getCi());
	}
	@Test
	public void verificaQueRetornePlanWOWSiSeteoEsePlan() {
		Usuario usuario= new Usuario("Andrew",9568487,76654488);
		IPlan plan = new PlanWow();
		usuario.setPlan(plan);
		assertEquals("WOW", usuario.getPlan().getTipoDePlan());
	}
	
	@Test
	public void verificaQueRetorneFijaPorMinutoComoTipoDeTarifacion() {
		Usuario usuario= new Usuario("Andrew",9568487,76654488);
		ITarifacion tarifacion = new TarifacionFijaPorMinuto();
		usuario.setTarifacion(tarifacion);
		assertEquals("FIJA POR MINUTO", usuario.getTarifacion().getTipoDeTarifacion());
	}

}
