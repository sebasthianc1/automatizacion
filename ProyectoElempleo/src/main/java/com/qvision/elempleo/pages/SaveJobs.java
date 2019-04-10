package com.qvision.elempleo.pages;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class SaveJobs extends PageObject{
	
	@FindBy(xpath = "//*[contains(concat(\" \", normalize-space(@class), \" \"), \" text-ellipsis \")]")
	List<WebElement> empresa;
	
	@FindBy(xpath = "//*[contains(concat(\" \", normalize-space(@class), \" \"), \" info-company-name \")]")
	List<WebElement> oferta;


	public void changeList(String Empresa, String Oferta) {

		List<String> temaEmpresa = new ArrayList<String>();
		for (WebElement e : empresa) {
			temaEmpresa.add(e.getText());
			addOferta(e.getText(), Oferta);
			
		}
		List<String> temaOferta = new ArrayList<String>();
		for (WebElement e : oferta) {
			temaOferta.add(e.getText());
			addOferta(e.getText(), Empresa);
			
		}
	}

	public void addOferta(String nomOferta, String nomEmpresa) {

		File file = new File("src/main/salario.txt");
		FileOutputStream fos = null;

		try {

			fos = new FileOutputStream(file);

			fos.write(nomEmpresa.getBytes());
			fos.write(nomOferta.getBytes());

		} catch (FileNotFoundException e) {
			System.out.println("Archivo no Encontrado" + e);
		} catch (IOException ioe) {
			System.out.println("Error al escribir el archivo" + ioe);
		} finally {
			
			try {
				if (fos != null) {
					fos.close();
				}
			} catch (IOException ioe) {
				System.out.println("Error al cerrar: " + ioe);
			}
		}
	}
}
