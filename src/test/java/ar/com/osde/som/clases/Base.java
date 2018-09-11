package ar.com.osde.som.clases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

	public WebDriver driver;

	public Base() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromeDriver\\chromedriver.exe");
		driver =  new ChromeDriver();
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

}
