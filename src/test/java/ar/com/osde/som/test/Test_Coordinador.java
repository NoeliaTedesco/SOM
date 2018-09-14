package ar.com.osde.som.test;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ar.com.osde.som.clases.Coordinador;

public class Test_Coordinador {


	private Coordinador coordinador1;

	@Parameters({ "usser", "pass" })
	@BeforeClass
	public void startUp(String usser, String pass) throws InterruptedException {
		coordinador1 = new Coordinador();
		Thread.sleep(3000);
		coordinador1.IniciarSesion(usser, pass);

	}

	@Parameters({ "nroSocio", "apellido", "nombre", "fechaNacimiento", "NomSolicitante", "TipoMatricula",
			"NumMatricula", "email", "celular", "Especialidad", "Detalle" })
	@Test
	public void CoordinadorGeneraInvitacion(String nroSocio, String apellido, String nombre, String fechaNacimiento,
			String NomSolicitante, String TipoMatricula, String NumMatricula, String email, String celular,
			String Especialidad, String Detalle) throws InterruptedException, AWTException, IOException {
		coordinador1.IngresargestionPractica();
		coordinador1.AbrirEnviarInvitacion();
		coordinador1.crearInvitacion(nroSocio, apellido, nombre, fechaNacimiento, NomSolicitante, TipoMatricula,
				NumMatricula, email, celular, Especialidad, Detalle);
		Thread.sleep(10000);
		coordinador1.ScrollearPaginaSubir(coordinador1.getDriver());
		coordinador1.reenviarInvitacion(email, coordinador1.getDriver());
		coordinador1.anularInvitacion(email);
		Thread.sleep(3000);
		// inicial.cerrarPagina(inicial.getDriver());
		// inicial.finalizarProcesoDriver();

	}

	@AfterClass
	public void afterClass() {
		coordinador1.cerrarPagina(coordinador1.getDriver());
		coordinador1.finalizarProcesoDriver();
	}

}
