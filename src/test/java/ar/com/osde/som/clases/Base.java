package ar.com.osde.som.clases;

import java.awt.AWTException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {

	public WebDriver driver;
	static WebDriverWait wait;
  
	@FindBy (css = "div.modal-content")
	public WebElement popUp; 

	public Base() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}

	public void refrescarPagina(WebDriver driver) {
		this.driver.navigate().refresh();
	}

	public void finalizarProcesoDriver() {
		try {
			Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
		} catch (IOException e) {
			System.out.println("Ocurrio un error al matar el proceso -" + e);
			e.printStackTrace();
		}
	}

	public WebDriver getDriver() {
		return driver;
	}
	
	public void cerrarPagina(WebDriver driver) {
		driver.close();
		driver.quit();
	}
	
	
	public void ScrollearPaginaSubir( WebDriver robot) throws AWTException, InterruptedException, IOException {

		wait = new WebDriverWait(robot, 500);
		JavascriptExecutor js = ((JavascriptExecutor) robot);
		js.executeScript("window.scrollTo(0, 0)");
		Thread.sleep(3000);
		
	}
	
	public void ScrollearPaginaBajar (WebDriver robot) throws InterruptedException {
		wait = new WebDriverWait(robot, 500);
		JavascriptExecutor js = ((JavascriptExecutor) robot);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(3000);
		
	}
	

}
