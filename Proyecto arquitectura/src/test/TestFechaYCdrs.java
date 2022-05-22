package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Test;

import entidades.CDR;
import gui.FechaYCdrs;

class TestFechaYCdrs {

	@Test
	public void verificaQueRetorneElDia20AlHacerSetDeLaFecha20DeMayoDel2022() {
		ArrayList<CDR> CDRs = new ArrayList<CDR>();
		CDRs.add(new CDR(70743567,70765342,"19/05/2022","19:14","00:02:30",2.2));
		CDRs.add(new CDR(70743567,70765342,"19/05/2022","21:14","00:02:31",4.8));
		FechaYCdrs fechaYCdrs = new FechaYCdrs(null,CDRs);
		Date fecha = new Date(2022,5,20);
		fechaYCdrs.setFecha(fecha);
		assertEquals(fechaYCdrs.getFecha().getDate(),20);
	}
	
	@Test
	public void verificaQueRetorneElNumero79372411LuegoDeHacerSetDeLosCDRs() {
		Date fecha = new Date(2022,5,20);
		FechaYCdrs fechaYCdrs = new FechaYCdrs(fecha,null);
		ArrayList<CDR> CDRs = new ArrayList<CDR>();
		CDRs.add(new CDR(72268498,79372411,"19/05/2022","19:14","00:02:30",2.2));
		CDRs.add(new CDR(79372411,72268498,"19/05/2022","21:14","00:02:31",4.8));
		fechaYCdrs.setCDRs(CDRs);
		assertEquals(fechaYCdrs.getCDRs().get(1).getTelefonoOrigen(),79372411);
	}
}
