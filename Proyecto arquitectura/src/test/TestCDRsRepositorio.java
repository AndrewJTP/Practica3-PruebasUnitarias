package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import cargarCdrsDeRepositorio.CargarCdrsDesdeRepositorio;
import cargarCdrsDeRepositorio.ICargarCdrsDesdeRepositorio;
import cargarUsuariosDeRepositorio.CargarUsuariosDesdeRepositorio;
import cargarUsuariosDeRepositorio.ICargarUsuariosDesdeRepositorio;
import entidades.CDR;
import guardarCdrsTarificados.GuardarCdrsTarificados;
import guardarCdrsTarificados.IGuardarCdrsTarificados;
import repository.IRepository;
import repository.JDBRepository;

class TestCDRsRepositorio{
    @Test
    public void verificaQueRetorne79372469ComoTelefonoDeOrigendelCDRCargadoDesdeElDB(){
        IRepository repositorio = new JDBRepository("TelcoDB.db");
        ICargarCdrsDesdeRepositorio casoDeUso = new CargarCdrsDesdeRepositorio(repositorio);
        assertEquals(79372469, casoDeUso.obtenerCDRS().get(0).getTelefonoOrigen());
    }
    @Test
    public void verificaQueRetorneJoseAugustoComoElNombreDelUsuarioCargadoDesdeElDB(){
		IRepository repositorio = new JDBRepository("TelcoDB.db");
		ICargarUsuariosDesdeRepositorio casoDeUso = new CargarUsuariosDesdeRepositorio(repositorio);
		assertEquals("Jose Augusto", casoDeUso.obtenerUsuarios().get(0).getNombre());
	}
    @Test
	public void verificaQue2punto2ComoCosteDespuesDeProcesarElCDRGuardarloYVolverloACargar(){
		IRepository repositorio = new JDBRepository("TelcoDB.db");
		ArrayList<CDR> cdrs = new CargarCdrsDesdeRepositorio(repositorio).obtenerCDRS();
		for(CDR cdr:cdrs)
		{
			cdr.setCosto(2.2);
		}
		IGuardarCdrsTarificados casoDeUso = new GuardarCdrsTarificados(repositorio);
		casoDeUso.guardarRegistrosEnRepositorio(cdrs);
		assertEquals(2.2, new CargarCdrsDesdeRepositorio(repositorio).obtenerCDRS().get(0).getCosto());
	}
}
