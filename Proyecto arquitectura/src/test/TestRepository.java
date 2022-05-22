package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import entidades.CDR;
import entidades.FabricaDePlanesYTarifas;
import entidades.Usuario;
import repository.IRepository;
import repository.JDBRepository;
import repository.SerializationRepository;

class TestRepository {

	@Test
	public void verificaQueRetorne5ComoTamanioDelArraySiCargamos5CDRs(){
		IRepository serializationRepository =new SerializationRepository("cdrs.csv","usuarios.csv");
		ArrayList<CDR> CDRs = serializationRepository.obtenerCDRs();
		assertEquals(5,CDRs.size() );
	}
	
	@Test
	public void verificaQueRetorne0ComoTamanioDelArraySiNoSeEncontroElArchivoDeCarga(){
		IRepository serializationRepository =new SerializationRepository("jtestdata\\cdrs.csv","usuarios.csv");
		ArrayList<CDR> CDRs = serializationRepository.obtenerCDRs();
		assertEquals(0,CDRs.size() );
	}
	@Test
	public void verificaQueGuardeLosCDRsProcesados(){
		IRepository serializationRepository =new SerializationRepository("cdrs.csv","usuarios.csv");
		ArrayList<CDR> CDRs = serializationRepository.obtenerCDRs();
		serializationRepository.guardarCDRsProcesados(CDRs);
		ArrayList<CDR> CDRsGuardados = serializationRepository.obtenerCDRs();
		assertEquals(CDRs.size(),CDRsGuardados.size() );
	}
	
	@Test
	public void verificaQueRetorne5ComoTamanioDeLaListaDeUsuariosQueCargo(){
		IRepository serializationRepository =new SerializationRepository("cdrs.csv","usuarios.csv");
		FabricaDePlanesYTarifas fabrica = new FabricaDePlanesYTarifas();
		ArrayList<Usuario> Usuarios= serializationRepository.obtenerUsuarios(fabrica);
		assertEquals(5,Usuarios.size() );
	}
	
	@Test
	public void verificaQueGuardeElArchivoEnLaBaseDeDatos(){
		IRepository JDBRepository =new JDBRepository("TelcoDB.db");
		ArrayList<CDR> CDRs = JDBRepository.obtenerCDRs();
		JDBRepository.guardarCDRsProcesados(CDRs);
		ArrayList<CDR> CDRsGuardados = JDBRepository.obtenerCDRs();
		assertEquals(CDRs.size(),CDRsGuardados.size() );
	}
	
	@Test
	public void verificaQueRetorne5ComoTamanioDelArraySiCargamos5CDRsDesdeJDB(){
		IRepository JDBRepository =new JDBRepository("TelcoDB.db");
		assertEquals(5,JDBRepository.obtenerCDRs().size() );
	}
	
	@Test
	public void verificaLaSalidaDeUnMensajeDeErrorAlCargarCDRSDesdeLaBaseDeDatosErronea(){
		IRepository JDBRepository =new JDBRepository("TelDB.db");
		assertEquals(0,JDBRepository.obtenerCDRs().size());
	}
	
	@Test
	public void verificaLaSalidaDeUnMensajeDeErrorAlGuardarCDRSEnLaBaseDeDatosErronea(){
		IRepository JDBRepository =new JDBRepository("TelDB.db");
		ArrayList<CDR> registrosTelefonicosTarificados = new ArrayList<CDR>();
		registrosTelefonicosTarificados.add(new CDR(70768498,72265305,"19/5/22","19:14","00:02:30",2.2));
		JDBRepository.guardarCDRsProcesados(registrosTelefonicosTarificados);
	}
	
	@Test
	public void verificaQueCargue4UsuariosDesdeLaBaseDeDatos(){
		IRepository JDBRepository =new JDBRepository("TelcoDB.db");
		FabricaDePlanesYTarifas fabrica = new FabricaDePlanesYTarifas();
		assertEquals(4,JDBRepository.obtenerUsuarios(fabrica).size());
	}

	@Test
	public void verificaLaSalidaDeUnMensajeDeErrorAlCargarUsuariosDesdeLaBaseDeDatosErronea(){
		IRepository JDBRepository =new JDBRepository("TelDB.db");
		FabricaDePlanesYTarifas fabrica = new FabricaDePlanesYTarifas();
		assertEquals(0,JDBRepository.obtenerUsuarios(fabrica).size());
	}

}
