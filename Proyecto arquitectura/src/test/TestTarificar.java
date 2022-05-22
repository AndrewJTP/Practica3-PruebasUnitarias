package test;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import entidades.CDR;
import entidades.Usuario;
import planes.PlanPostpago;
import tarifaciones.TarifacionFijaPorMinuto;
import tarificar.ITarificar;
import tarificar.Tarificar;

class TestTarificar {

	@Test
	public void verificaQueRetorne2punto9ComoCostoDeLaTarifa() throws ParseException{
		ArrayList<CDR> registrosTelefonicos = new ArrayList<CDR>();
		registrosTelefonicos.add(new CDR(70345678,79372469,"20/05/22","19:14","00:02:30",0));
		registrosTelefonicos.add(new CDR(70345678,79372469,"20/05/22","19:14","00:02:00",0));
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		Usuario usuario = new Usuario("Jose Augusto",13892648,70345678);
		usuario.setPlan(new PlanPostpago());
		usuario.setTarifacion(new TarifacionFijaPorMinuto());
		usuarios.add(usuario);
		ITarificar tarificar = new Tarificar(usuarios,registrosTelefonicos);
		assertEquals(tarificar.tarificarCDRs().get(1).getCosto(),2.9);
	}

}
