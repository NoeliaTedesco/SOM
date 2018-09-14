package ar.com.osde.som.clases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Administrador extends Base {

	WebDriver robot;
	String baseUrl = "https://tosdesegundaopinion.doc24.com.ar/admin/";

	@CacheLookup
	@FindBy(name = "user")
	private WebElement usuario;

	@FindBy(name = "password")
	private WebElement password;

	@FindBy(xpath = ("//button[@type='submit']"))
	private WebElement ingresar;

	@FindBy(xpath = ("(.//*[normalize-space(text()) and normalize-space(.)='Menu'])[1]/following::strong[1]"))
	private WebElement btnMenu;

	@FindBy(linkText = "Guardia")
	private WebElement menuGuardia;
	
	@FindBy(linkText = "Administradores")
	private WebElement menuAdministrador;

	@FindBy(linkText = "Coordinadores")
	private WebElement menuCoordinadores;

	@FindBy(linkText = "Profesionales")
	private WebElement menuProfesionales;

	@FindBy(linkText = "Producción")
	private WebElement menuProduccion;

	@FindBy(linkText = "Parámetros")
	private WebElement menuParametros;

	@FindBy(linkText = "Reportes")
	private WebElement menuReportes;

	@FindBy(linkText = "Cambiar contraseña")
	private WebElement menuCambiarContrasena;

	@FindBy(id = "btnSalir")
	private WebElement btnSalir;

	public Administrador() {
		this.robot = driver;
		PageFactory.initElements(this.driver, this);
		robot.get(baseUrl);
	}

	public void IniciarSesion(String usuarioPrueba, String contrasena) {
		try {
			usuario.click();
			usuario.sendKeys(usuarioPrueba);
			password.clear();
			password.click();
			password.sendKeys(contrasena);
			ingresar.click();
		} catch (Exception e) {
			System.out.println("Error al iniciar sesión");
		}

	}

	public void ingresarOpcionMenu(String opcionMenu) {
		btnMenu.click();
		
		switch (opcionMenu) {
		
		case "Guardia":
			  menuGuardia.click();
			  break;
			  
		case "Administradores":
			menuAdministrador.click();
			break;

		case "Profesionales":
			menuProfesionales.click();
			break;

		case "Coordinadores":
			menuCoordinadores.click();
			break;

		case "Parametros":
			menuParametros.click();
			break;

		case "Reportes":
			menuReportes.click();
			break;

		case "Producción":
			menuProduccion.click();
			break;

		case "Cambiar contraseña":
			menuCambiarContrasena.click();
			break;

		case "Salir":
			btnSalir.click();
			break;
		}
	}

}
