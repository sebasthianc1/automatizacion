package com.qvision.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.opencsv.CSVReader;

public class TestLogin {

	static WebDriver driver;
//	static String Algo = "C:\\Users\\Usuario\\Desktop\\numeros.csv";
	static String Algo = "src/main/resources/numeros.csv";
	static String url = "https://www.netflix.com/co/login";

	@Before
	public void openChrome() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@Test
	public void main() throws IOException {

		try (FileInputStream fis = new FileInputStream(Algo);
				InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);

				CSVReader reader = new CSVReader(isr)) {
			String[] otraCosa;

			while ((otraCosa = reader.readNext()) != null) {

				for (int i = 0; i <= otraCosa.length; i++) {

					String name = otraCosa[i];
					String pasw = otraCosa[i + 1];

//					System.out.println("nombre	: " + otraCosa[i]);
//					System.out.println("contraseña: " + otraCosa[i + 1]);

					driver.get(url);
					driver.findElement(By.id("id_userLoginId")).sendKeys(name);
					driver.findElement(By.id("id_password")).sendKeys(pasw);
					driver.findElement(By.xpath("//*[@id=\"appMountPoint\"]/div/div[3]/div/div/div[1]/form/button"))
							.click();

				}

			}

		}
	}

}