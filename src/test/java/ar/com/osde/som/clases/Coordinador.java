package ar.com.osde.som.clases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class Coordinador extends Base{

	private WebDriver robot;
	private String baseUrl = "https://tosdesegundaopinion.doc24.com.ar/prestadores/signin";

	@CacheLookup
	@FindBy(name = "user")
	private WebElement usuario;

	@FindBy(name = "password")
	private WebElement password;

	@FindBy(xpath = ("//button[@type='submit']"))
	private WebElement ingresar;

	@FindBy(xpath = ("(.//*[normalize-space(text()) and normalize-space(.)='Gestión de prácticas'])[1]/following::h5[1]"))
	private WebElement menuGestionPractica;

	@FindBy(css = "button.btn.btn-success")
	private WebElement btnEnviarInvitacion;

	@FindBy(xpath = ("(.//*[normalize-space(text()) and normalize-space(.)='Datos del Paciente'])[1]/preceding::div[1]"))
	private WebElement formularioInvitacion;

	@FindBy(name = "valorIdentificacion")
	private WebElement valorIdentificacion;

	@FindBy(id = "apellido")
	private WebElement campoApellido;

	@FindBy(id = "nombre")
	private WebElement campoNombre;

	@FindBy(id = "fechaNacimiento")
	private WebElement campoFechaNacimiento;

	@FindBy(id = "solicitante")
	private WebElement campoSolicitante;

	@FindBy(id = "tipoMatricula")
	private WebElement campoTipoMatricula;

	@FindBy(id = "nroMatricula")
	private WebElement campoNroMatricula;

	@FindBy(id = "email")
	private WebElement campoEmail;

	@FindBy(id = "phone")
	private WebElement campoTelefono;

	@FindBy(id = "especialidad")
	private WebElement campoEspecialidad;

	@FindBy(name = "detalle")
	private WebElement campoDetalle;
	
	@FindBy (xpath= ("//*[@id=\"enviarInvitacionForm\"]/div/footer/div/div/div/div[2]/button"))
	private WebElement btnEnviar;
	
	@FindBy (css = "i.fa.fa-2x.fa-trash")
	private WebElement btnAnular;
	
	@FindBy (name = "detalleMotivo")
	private WebElement campoMotivoAnular;
	
	@FindBy (xpath = ("//button[2]"))
	private WebElement btnConfirmar;
	
	@FindBy (css ="i.fa.fa-2x.fa-mail-forward")
	private WebElement btnReenviarInvitacion;
	
	private WebElement registroInvitacion;


	public Coordinador() {
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

	public void IngresargestionPractica() {
		try {
			if (menuGestionPractica.isDisplayed()) {
				menuGestionPractica.click();
			} else {
				System.out.println("No se encuentra visible el botón para ingresar a la gestión de prácticas");
			}
		} catch (Exception e) {

		}

	}

	public void AbrirEnviarInvitacion() {
		btnEnviarInvitacion.click();
	}

	public boolean esVisibleFormularioInvitacion() {
		if (formularioInvitacion.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	public void crearInvitacion(String nroSocio, String apellido, String nombre, String fechaNacimiento,
			String NomSolicitante, String TipoMatricula, String NumMatricula, String email, String celular,
			String Especialidad, String Detalle) {

		valorIdentificacion.sendKeys(nroSocio);
		campoApellido.sendKeys(apellido);
		campoNombre.sendKeys(nombre);
		campoFechaNacimiento.sendKeys(fechaNacimiento);
		campoSolicitante.sendKeys(NomSolicitante);
		new Select (campoTipoMatricula).selectByVisibleText(TipoMatricula);
		campoNroMatricula.sendKeys(NumMatricula);
		campoEmail.sendKeys(email);
		campoTelefono.sendKeys(celular);
		new Select (campoEspecialidad).selectByVisibleText(Especialidad);
		campoDetalle.sendKeys(Detalle);
		btnEnviar.click();
	}
	
	public boolean seleccionarInvitacion(String emailInvitacion) {
	 try {
		 registroInvitacion = robot.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='"+emailInvitacion+"'])[1]/following::td[3]"));
		 return true;
	 }catch (Exception e) {
		 System.out.println("El registro no se encuentra");
		 return false;
	 }
		
	}
	
	public void anularInvitacion(String emailInvitacion) {
		if (seleccionarInvitacion(emailInvitacion)) {
			btnAnular.click();
			campoMotivoAnular.sendKeys("Se anula invitación");
			btnConfirmar.click();	
		} else {
			System.out.println("No fue posible anular la invitación");
		}
		
			
	}
	
	
	public void reenviarInvitacion(String emailInvitacion, WebDriver robot) throws InterruptedException {
		if (seleccionarInvitacion(emailInvitacion)) {
			btnReenviarInvitacion.click();
			cambiarFocoFrame();
			ScrollearPaginaBajar(robot);
			Thread.sleep(3000);
			btnConfirmar.click();
			Thread.sleep(3000);
		} else {
			System.out.println("No fue posible reenviar invitación");
		}
		
		
	}

}
