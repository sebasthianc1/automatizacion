
import static org.junit.Assert.assertTrue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class MainDataDriven {
	
	
	@Test
	
	public void main(String[] args) {
		
		Library classUnderTest = new Library();
		assertTrue("someLibraryMethod should return 'true'", classUnderTest.someLibraryMethod());
        
		System.setProperty("WebDriver.chrome.Driver", "chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		File data = new File("credenciales.csv");

		FileReader fr;

		try {
			fr = new FileReader(data);
			BufferedReader br = new BufferedReader(fr);
			String linea = "";

			while ((linea = br.readLine()) != null) {

				String[] datos = linea.split(",");
				driver.get("https://accounts.google.com/signin/v2/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");

			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}

