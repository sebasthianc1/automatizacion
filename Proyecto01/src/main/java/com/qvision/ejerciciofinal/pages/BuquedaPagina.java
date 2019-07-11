package com.qvision.ejerciciofinal.pages;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;
import com.qvision.ejerciciofinal.pages.EscribirArchivo;
import net.serenitybdd.core.pages.PageObject;
 
 /**
  * Automatización_El_Empleo.com
  * @author Sebasthian Arias
  * @version 1.1
  * 
  */

@SuppressWarnings("unused")
public class BuquedaPagina extends PageObject {
	
	SeleccionarItems pageLookForPage;
	EscribirArchivo fileWrite;
	JavaScriptExecutor ejecutor1;
	
	@FindBy(xpath = "/html/body/div[8]/div[2]/h1")
	WebElement lblSubTitle;
	
	@FindBy(xpath = "//div[contains(@class,'radio-options ee-mod js-filter-date-published')]/div")
	List<WebElement> raListDates;
	
	@FindBy(name = "PublishDatesInfo1")
	List<WebElement> raListPublishDates;
	
	@FindBy(xpath ="div[contains(@class, 'checkbox')]/label")
	List<WebElement> txtListaSalarios;
	
	@FindBy(id="salary3")
	WebElement cheSalary;
	
	@FindBy(xpath="//*[@id=\"WorkAreaFilter1\"]")
	WebElement txtWorkArea;
	
	@FindBy(id="publishDate1")
	WebElement raDatePublication;
	
	@FindBy(xpath="//*[@id=\"WorkAreaFilter1\"]/option")
	List<WebElement> txtListEmployArea;
	
	@FindBy(xpath="//a[contains(@class, 'text-ellipsis')]")
	List<WebElement> lblListEmploy;

	@FindBy(xpath="//span[contains(@class, 'info-company-name')]")
	List<WebElement> lblListCompany;
	
	public void filterByWages(String rangoFecha,String areaTrabajo) {
		
	    int i = 0,t=0;
	      try {
		       WebDriver miDriver= getDriver();
		
		       JavascriptExecutor ejecutar= (JavascriptExecutor) miDriver;
		       ejecutar.executeScript("window.scrollBy(0,100)");
		       cheSalary.click();
		
		       Thread.sleep(5000);
		       ejecutar.executeScript("window.scrollBy(0,1000)");
	
		for (WebElement radio : raListDates) {
				if (radio.getText().contains(rangoFecha)) {
		        	
		        	for (WebElement lista:raListPublishDates) {
		        		 
		        		if (t==i) {
		        			lista.click();
		        			break;
		        		}
		        		t++;
		        	}
		        	break;
		        }
				i++;
        }	
	
Thread.sleep(5000);
		
      ejecutar.executeScript("window.scrollBy(0,500)");
		
		for (WebElement listArea:txtListEmployArea ) {
			System.out.println("Valor de la lista de arear de trabajo:"+listArea.getText());
	
			if (listArea.getText().contains(areaTrabajo)) {
				listArea.click();
				break;
			}
		}
	} catch (InterruptedException e) {
		 
		e.printStackTrace();
	}
		
}
	
public void saveFileWithJobOffersGenerated() {
		int i;
		String[] arrayListJob = new String[lblListEmploy.size()+1];
		arrayListJob[0]="Job Offers,Companys";
		for(i=1; i<lblListEmploy.size();i++) {
			arrayListJob[i]=lblListEmploy.get(i-1).getAttribute("title") +","+ lblListCompany.get(i-1).getText();
		}
		
		if (fileWrite.escribirArchivoVacantes(arrayListJob)==true){
			System.out.println("El archivo se guardo correctamente");
		}else {
			System.out.println("El archivo no se ha guardado");
		}
	}
	


	public boolean validateLabelSubTitle() {
		boolean isVisible = false;
		try {
			System.out.println(lblSubTitle.getText());
			if (lblSubTitle.getText().contains("Empleos Contador en Bogotá")) {
				isVisible = true;
			}
		} catch (Exception e) {
			
		}
		return isVisible;
	}

}
