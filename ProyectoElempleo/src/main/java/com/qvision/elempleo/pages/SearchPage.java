package com.qvision.elempleo.pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class SearchPage extends PageObject {

	@FindBy(xpath = "input[contains(@class, 'from-control input-lg js-search-input tt-input']")
	WebElement cargo;

	@FindBy(xpath = "//div[contains(@class, 'tt-suggestion tt-selectable')]")
	List<WebElementFacade> cargoList;

	@FindBy(xpath = "//input[contains(@class, 'form-control input-lg js-cities-searchbox ciudad-ux tt-input')]")
	WebElement ciudad;

	@FindBy(xpath = "//input[contains(@class, 'js-cities')]//following::div[contains(@class, 'tt-suggestion tt-selectable')]")
	List<WebElementFacade> ciudadList;


	@FindBy(xpath = "//button[@type='submit']")
	WebElement btnSearch;

	@FindBy(xpath = "//h1")

	WebElement lblTitlePage;

	WebDriver miDriver = getDriver();

	public void getJobs(String Cargo, String Ciudad) {

		cargo.sendKeys(Cargo.substring(0, 4));

		for (WebElement cargoList : cargoList) {

			if (cargoList.getText().contains(Cargo)) {

				cargoList.click();

				break;

			}

		}

		ciudad.sendKeys(Ciudad);

		for (WebElement E : ciudadList) {

			if (E.getText().contains(Ciudad)) {

				E.click();

				break;

			}

		}

	}

//	
//	
//	public void getJobs(String buscar) {
//
//		cargo.sendKeys(buscar);
//
//	}
//
//	public void getDept(String dept) {
//	
//	    List<String> departamento = new ArrayList<String>();
//		
//		for (WebElementFacade e : ciudadList) {
//			
//			
//			departamento.add(e.getText());
//		
//			btnSearch.click();
//			
//	
//		}
//	
//	
//	}

}

//	
//	
//	
//	public void getJobs(String buscar) {
//
//		cargo.sendKeys(buscar);
//		cargo.click();
//		btnSearch.click();
//	}
//
//	public void getDept(String ciudad) {
//		String filtroDept;
//		int i = 0;
//		WebElement list = getDriver().findElement(By.name("listDept"));
//		
//		System.out.println("THE JOBS=" + ciudadList);
//		
//		try {
//
//			List<WebElement> ciudadList = list.findElements(By.xpath("/div[]"));
//            
//			for (WebElement AP : ciudadList) {
//
//				
//				System.out.println(AP.getText());
//				filtroDept = AP.getText().substring(0, ciudad.length() -1);
//				i++;
//				if (filtroDept.equalsIgnoreCase(ciudad.substring(0, ciudad.length() - 1))) {
//					AP.click();
//					//break;
//				}
//
//			}
//		} catch (Exception AP) {
//		}
//		
//	}
//}
