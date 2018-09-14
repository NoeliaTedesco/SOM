package ar.com.osde.som.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ar.com.osde.som.clases.Administrador;

public class Test_Administrador {
	
	Administrador administrador1;
	
	
	@Parameters ({"usuarioAdministrador", "contrasenaAdministrador"})
	@BeforeClass
	public void startUp (String usuarioPrueba, String contrasena) throws InterruptedException {
		administrador1 = new Administrador();
		Thread.sleep(3000);
		administrador1.IniciarSesion(usuarioPrueba, contrasena);
	}
	
	@Parameters ({"opcionMenu"})
	@Test
	public void NavegarMenuAdministrador(String opcionMenu) {
		administrador1.ingresarOpcionMenu(opcionMenu);
		
	}
	
	@AfterClass
	public void afterClass() {
		administrador1.cerrarPagina(administrador1.getDriver());
	}

}
