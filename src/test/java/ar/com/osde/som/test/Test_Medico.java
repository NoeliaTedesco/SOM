package ar.com.osde.som.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ar.com.osde.som.clases.Especialista;

public class Test_Medico {
	
	Especialista especialista1;
	
	@Parameters ({"usuarioMedico", "contrasenaMedico"})
	@BeforeClass
	public void starUp(String usuario, String contrasena) {
		especialista1 = new Especialista();
		especialista1.IniciarSesion(usuario, contrasena);
	}
	
	@Test
	public void atenderSocio() throws InterruptedException {
		especialista1.ingresarServiciosDisponibles();
		Thread.sleep(3000);
		especialista1.ingresarGuardia();
		Thread.sleep(3000);
		especialista1.SalirGuardia();
		Thread.sleep(3000);
	}
	
	
	@AfterClass
	public void afterClass() {
		especialista1.cerrarPagina(especialista1.getDriver());
	}
	
	

	
	
}
