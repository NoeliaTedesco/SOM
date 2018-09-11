package ar.com.osde.som.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ar.com.osde.som.clases.Base;
import ar.com.osde.som.clases.Coordinador;

public class Test_Coordinador {

	private Base inicial;
	private Coordinador coordinador1;
	

	@Parameters({ "usser", "pass" })
	@BeforeClass
	public void startUp(String usser, String pass) throws InterruptedException {
		inicial = new Base();
		coordinador1 = new Coordinador(inicial.getDriver());
		Thread.sleep(3000);
		coordinador1.IniciarSesion(usser, pass);

	}
    @Parameters ({"nroSocio", "apellido", "nombre", "fechaNacimiento", "NomSolicitante", "TipoMatricula", "NumMatricula", "email", "celular", "Especialidad", "Detalle"})
	@Test
	public void CoordinadorGeneraInvitacion(String nroSocio, String apellido, String nombre, String fechaNacimiento,
			String NomSolicitante, String TipoMatricula, String NumMatricula, String email, String celular,
			String Especialidad, String Detalle) {
		coordinador1.IngresargestionPractica();
		coordinador1.AbrirEnviarInvitacion();
		coordinador1.crearInvitacion(nroSocio, apellido, nombre, fechaNacimiento, NomSolicitante, TipoMatricula, NumMatricula, email, celular, Especialidad, Detalle);
//		inicial.cerrarPagina(inicial.getDriver());
//		inicial.finalizarProcesoDriver();

	}
	

}
