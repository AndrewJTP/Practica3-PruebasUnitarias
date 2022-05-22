package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import entidades.CDR;
import entidades.Usuario;
import facturarParaUsuario.FacturarParaUsuario;
import facturarParaUsuario.IFacturarParaUsuario;
import planes.PlanWow;
import responseModels.FacturacionResponseModel;

class TestFacturar {

	@Test
	public void verificaQueRetorneJoseAugustoComoElNombreDelFacturado(){
		ArrayList<CDR> registrosTelefonicosTarificados = new ArrayList<CDR>();
		registrosTelefonicosTarificados.add(new CDR(79372469,72345678,"20/05/22","19:14","00:02:30",2.2));
		registrosTelefonicosTarificados.add(new CDR(79372469,72345677,"20/05/22","19:15","00:02:31",4.8));
		registrosTelefonicosTarificados.add(new CDR(79372469,72345676,"20/05/22","19:16","00:02:32",2.2));
		Usuario usuario = new Usuario("Jose Augusto",13892648,79372469);
		usuario.setPlan(new PlanWow());
		FacturacionResponseModel factura = new FacturacionResponseModel(usuario,7,"20/05/22"); 
		IFacturarParaUsuario facturar= new FacturarParaUsuario();
		assertEquals(factura.getNombre(),facturar.facturarParaUnUsuario(registrosTelefonicosTarificados,usuario, "20-05-22").getNombre()) ;
	}

}
