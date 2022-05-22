package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import entidades.CDR;
import planes.IPlan;
import planes.PlanPostpago;
import planes.PlanPrepago;
import planes.PlanWow;
import tarifaciones.ITarifacion;
import tarifaciones.TarifacionFijaPorMinuto;

class TestPlanes {

	@Test
	public void verificaQueRetornePostpagoComoTipoDePlan(){
		IPlan planPostpago = new PlanPostpago();
		assertEquals("POSTPAGO", planPostpago.getTipoDePlan());
	}
	@Test
	public void verificaQueRetorne1punto45AlCalcularElCosteDeLLamadaConTarifacionFijaPorMinuto(){
		CDR cdr = new CDR(72261209,79372469,"20/05/22","07:14","00:01:00",2.2);
		ITarifacion tarifacionFijaPorMinuto = new TarifacionFijaPorMinuto();
		IPlan planPostpago = new PlanPostpago();
		assertEquals(1.45, planPostpago.calcularCostoDeLlamada(tarifacionFijaPorMinuto, cdr));
	}
	
	@Test
	public void verificaQueRetornePrepagoComoTipoDePlan(){
		IPlan planPrepago = new PlanPrepago();
		assertEquals("PREPAGO", planPrepago.getTipoDePlan());
	}
	
	@Test
	public void verificaQueRetorne2punto90AlCalcularElCosteDeLLamadaConTarifacionFijaPorMinuto(){
		CDR cdr = new CDR(72261209,79372469,"20/05/22","07:14","00:02:00",2.2);
		ITarifacion tarifacionFijaPorMinuto = new TarifacionFijaPorMinuto();
		IPlan planPrepago = new PlanPrepago();
		assertEquals(2.9, planPrepago.calcularCostoDeLlamada(tarifacionFijaPorMinuto, cdr));
	}
	
	@Test
	public void verificaQueRetorneWowComoTipoDePlan(){
		IPlan planWow = new PlanWow();
		assertEquals("WOW", planWow.getTipoDePlan());
	}
	
	@Test
	public void verificaQueRetorne2punto90AlCalcularElCosteDeLLamadaConTarifacionFijaPorMinutoNoNumeroAmigo(){
		CDR cdr = new CDR(72261209,79372469,"20/05/22","07:14","00:02:00",0.0);
		ITarifacion tarifacionFijaPorMinuto = new TarifacionFijaPorMinuto();
		IPlan planWow = new PlanWow();
		ArrayList<Integer> numerosAmigos = new ArrayList<Integer>();
		numerosAmigos.add(74701750);
		((PlanWow) planWow).setNumerosAmigos(numerosAmigos);
		assertEquals(2.9, planWow.calcularCostoDeLlamada(tarifacionFijaPorMinuto, cdr));
	}
	
	@Test
	public void verificaQueRetorne0AlCalcularElCosteDeLLamadaConTarifacionFijaPorMinutoNumeroAmigo(){
		CDR cdr = new CDR(70707077,79372469,"20/05/22","07:14","00:02:00",0.0);
		ITarifacion tarifacionFijaPorMinuto = new TarifacionFijaPorMinuto();
		IPlan planWow = new PlanWow();
		ArrayList<Integer> numerosAmigos = new ArrayList<Integer>();
		numerosAmigos.add(79372469);
		((PlanWow) planWow).setNumerosAmigos(numerosAmigos);
		assertEquals(0, planWow.calcularCostoDeLlamada(tarifacionFijaPorMinuto, cdr));
	}
	
	@Test
	public void verificaQueRetorneLaListaDeAmigos(){
		IPlan planWow = new PlanWow();
		ArrayList<Integer> numerosAmigos = new ArrayList<Integer>();
		numerosAmigos.add(74701750);
		((PlanWow) planWow).setNumerosAmigos(numerosAmigos);
		assertEquals("74701750", ((PlanWow) planWow).getNumeroAmigosParaString());
	}
	
	@Test
	public void verificaQueRetorneSinNumerosAmigos(){
		IPlan planWow = new PlanWow();
		assertEquals("Sin numeros amigos", ((PlanWow) planWow).getNumeroAmigosParaString());
	}

}
