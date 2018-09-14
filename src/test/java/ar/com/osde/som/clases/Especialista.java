package ar.com.osde.som.clases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Especialista extends Base {

	WebDriver robot;
	String baseUrl = "https://tosdesegundaopinion.doc24.com.ar/medico";

	@CacheLookup
	@FindBy(id = "email")
	WebElement usuario;

	@FindBy(id = "password")
	private WebElement password;

	@FindBy(id = "submit")
	private WebElement ingresar;

	@FindBy(xpath = ("(.//*[normalize-space(text()) and normalize-space(.)='Mis Servicios Disponibles'])[1]/following::div[10]"))
	private WebElement ingresarMenuAtender;

	@FindBy(xpath = ("(.//*[normalize-space(text()) and normalize-space(.)='Recuerda:'])[1]/following::button[2]"))
	private WebElement ingresarGuardia;

	@FindBy(xpath = ("(.//*[normalize-space(text()) and normalize-space(.)='Recuerda:'])[1]/following::button[1]"))
	private WebElement salirGuardia;

	@FindBy(linkText = "Mi Perfil")
	private WebElement menuPerfil;

	@FindBy(xpath = ("(.//*[normalize-space(text()) and normalize-space(.)='Cambiar contraseña'])[1]/following::button[1]"))
	private WebElement cambiarContrasena;

	@FindBy(id = "btSalir")
	private WebElement btnSalir;

	public Especialista() {
		this.robot = driver;
		PageFactory.initElements(this.robot, this);
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

	public void ingresarServiciosDisponibles() {
		try {
			if (ingresarMenuAtender.isDisplayed()) {
				ingresarMenuAtender.click();
			} else {
				System.out.println("No se encuentra visible el botón para ingresar a la gestión de prácticas");
			}

		} catch (Exception e) {
			System.out.println("Error al ingresar a servicios disponibles");

		}
	}

	public void ingresarGuardia() {
		if (ingresarGuardia.isEnabled()) {
			ingresarGuardia.click();
		}

	}
	
	
	public void SalirGuardia() {
		if (salirGuardia.isEnabled()) {
			salirGuardia.click();
		}

	}


}
