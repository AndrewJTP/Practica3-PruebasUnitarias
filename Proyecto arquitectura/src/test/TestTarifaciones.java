package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import entidades.CDR;
import tarifaciones.ITarifacion;
import tarifaciones.TarifacionDiferenciadaPorHorario;
import tarifaciones.TarifacionFijaPorMinuto;

class TestTarifaciones {

	@Test
	public void verificaQueRetorneDiferenciadaPorHorarioComoTipoDeTarifacion(){
		ITarifacion tarifacionDiferenciadaPorHorario = new TarifacionDiferenciadaPorHorario();
		assertEquals("DIFERENCIADA POR HORARIO", tarifacionDiferenciadaPorHorario.getTipoDeTarifacion());
	}
	
	@Test
	public void verificaQueRetorne2Punto9ComoCosteALas7amPor2Minutos(){
		
		CDR cdr = new CDR(74701750,73045476,"21/05/22","07:14","00:02:00",0.0);
		ITarifacion tarifacionDiferenciadaPorHorario = new TarifacionDiferenciadaPorHorario();
		assertEquals(2.9, tarifacionDiferenciadaPorHorario.calcularCoste(cdr));
	}
	
	@Test
	public void verificaQueRetorne1Punto9ComoCosteALas21HrsPor2Minutos(){
		
		CDR cdr = new CDR(74701750,73045476,"21/05/22","21:14","00:02:00",0.0);
		ITarifacion tarifacionDiferenciadaPorHorario = new TarifacionDiferenciadaPorHorario();
		assertEquals(1.9, tarifacionDiferenciadaPorHorario.calcularCoste(cdr));
	}
	@Test
	public void verificaQueRetorne0punto95ComoCosteALas00HrsPor1Minutos(){
		
		CDR cdr = new CDR(73045476,74701750,"21/05/22","00:14","00:01:00",0.0);
		ITarifacion tarifacionDiferenciadaPorHorario = new TarifacionDiferenciadaPorHorario();
		assertEquals(0.95, tarifacionDiferenciadaPorHorario.calcularCoste(cdr));
	}
	
	@Test
	public void verificaQueRetorne0ComoCosteALasmenos21HrsPor1Minutos(){
		
		CDR cdr = new CDR(73045476,74701750,"21/05/22","-21:14","00:01:00",0.0);
		ITarifacion tarifacionDiferenciadaPorHorario = new TarifacionDiferenciadaPorHorario();
		assertEquals(0, tarifacionDiferenciadaPorHorario.calcularCoste(cdr));
	}
	@Test
	public void verificaQueRetorne1Punto4ComoCosteALas2amPor2Minutos(){
		
		CDR cdr = new CDR(74701750,73045476,"21/05/22","02:14","00:02:00",0.0);
		ITarifacion tarifacionDiferenciadaPorHorario = new TarifacionDiferenciadaPorHorario();
		assertEquals(1.4, tarifacionDiferenciadaPorHorario.calcularCoste(cdr));
	}
	
	@Test
	public void verificaQueRetorneFijaPorMinutoComoTipoDeTarifacion(){
		ITarifacion tarifacionFijaPorMinuto = new TarifacionFijaPorMinuto();
		assertEquals("FIJA POR MINUTO", tarifacionFijaPorMinuto.getTipoDeTarifacion());
	}
	
	@Test
	public void verificaQueRetorne4Punto35ComoCoste(){
		
		CDR cdr = new CDR(73045476,74701750,"21/05/22","07:14","00:03:00",0.0);
		ITarifacion tarifacionFijaPorMinuto = new TarifacionFijaPorMinuto();
		assertEquals(4.35, tarifacionFijaPorMinuto.calcularCoste(cdr));
	}
	
	@Test
	public void verificaQueRetorne4Punto9ComoCosteTrasEstablecerTarifa2punto45PorMinuto(){
		
		CDR cdr = new CDR(74701750,73045476,"21/05/22","07:14","00:02:00",0.0);
		ITarifacion tarifacionFijaPorMinuto = new TarifacionFijaPorMinuto();
		((TarifacionFijaPorMinuto) tarifacionFijaPorMinuto).establecerMontoDeTarifaFijaPorMinuto(2.45);
		assertEquals(4.9, tarifacionFijaPorMinuto.calcularCoste(cdr));
	}

}
