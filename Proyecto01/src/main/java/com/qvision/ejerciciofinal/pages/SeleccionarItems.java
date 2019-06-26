package com.qvision.ejerciciofinal.pages;

import java.util.List;
import java.util.regex.Pattern;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

/**
 * Automatización_El_Empleo.com
 * @author Sebasthian Arias
 * @version 1.1
 * 
 */
@SuppressWarnings("unused")
@DefaultUrl("https://www.elempleo.com/co/")
public class SeleccionarItems extends PageObject {
	
	@FindBy(xpath="//input[contains(@class, 'form-control input-lg js-searchbox-input tt-input')]")
	WebElement ttEmpleos;
	
	@FindBy(xpath="//div[contains(@class, 'tt-suggestion tt-selectable')]")
	List<WebElementFacade> ttListaEmp;
	
	@FindBy(xpath="//input[contains(@class, 'form-control input-lg js-cities-searchbox ciudad-ux tt-input')]")
	WebElement ttCiudad;

	
	@FindBy(xpath="//input[contains(@class, 'js-cities')]//following::div[contains(@class, 'tt-suggestion tt-selectable')]")
	List<WebElementFacade> ttListaCiu;

	
	@FindBy(xpath="//h1")
	WebElement lblTitlePage;
	
public void conector(String empleo, String ciudad) {
		
	WebDriver miDriver= getDriver();
	JavascriptExecutor ejecutar= (JavascriptExecutor) miDriver;
	ejecutar.executeScript("window.scrollBy(0,300)");
		
	ttEmpleos.sendKeys(empleo.substring(0, 4));
	    for (WebElement listaEmpleos: ttListaEmp) {
	    	
			if (listaEmpleos.getText().contains(empleo)) {
				listaEmpleos.click();
				break;
			}
		}
	    
		ttCiudad.sendKeys(ciudad);
		
		for (WebElement E: ttListaCiu) {
			if (E.getText().contains(ciudad)) {
				E.click();
				break;
			}
		}
	}
}
