package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import entidades.FabricaDePlanesYTarifas;
import planes.IPlan;
import tarifaciones.ITarifacion;

class TestPlanesYTarifas {

	@Test
	public void verificaQueRetornePlanPREPAGO(){
		FabricaDePlanesYTarifas fabrica= new FabricaDePlanesYTarifas();
		IPlan plan = fabrica.getPlan("PREPAGO");
		assertEquals("PREPAGO", plan.getTipoDePlan());
	}
	
	@Test
	public void verificaQueRetornePlanPOSTPAGO(){
		FabricaDePlanesYTarifas fabrica= new FabricaDePlanesYTarifas();
		IPlan plan = fabrica.getPlan("POSTPAGO");
		assertEquals("POSTPAGO", plan.getTipoDePlan());
	}
	
	@Test
	public void verificaQueRetornePlanWOW(){
		FabricaDePlanesYTarifas fabrica= new FabricaDePlanesYTarifas();
		IPlan plan = fabrica.getPlan("WOW");
		assertEquals("WOW", plan.getTipoDePlan());
	}
	
	@Test
	public void verificaQueRetornePlanNull(){
		FabricaDePlanesYTarifas fabrica= new FabricaDePlanesYTarifas();
		assertNull(fabrica.getPlan("asd"));
	}
	@Test
	public void verificaQueRetorneTarificacionDIFERENCIADAPORHORARIO(){
		FabricaDePlanesYTarifas fabrica= new FabricaDePlanesYTarifas();
		ITarifacion tarificacion = fabrica.getTarifacion("DIFERENCIADA POR HORARIO");
		assertEquals("DIFERENCIADA POR HORARIO", tarificacion.getTipoDeTarifacion());
	}
	
	@Test
	public void verificaQueRetorneTarificacionFIJAPORMINUTO(){
		FabricaDePlanesYTarifas fabrica= new FabricaDePlanesYTarifas();
		ITarifacion tarificacion = fabrica.getTarifacion("FIJA POR MINUTO");
		assertEquals("FIJA POR MINUTO",tarificacion.getTipoDeTarifacion());
	}
	
	
	@Test
	public void verificaQueRetorneTarificacionNull(){
		FabricaDePlanesYTarifas fabrica= new FabricaDePlanesYTarifas();
		assertNull(fabrica.getTarifacion("asd"));
	}

}
