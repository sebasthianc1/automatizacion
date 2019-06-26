package com.qvision.ejerciciofinal.pages;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import net.serenitybdd.core.pages.PageObject;

/**
 * Automatización_El_Empleo.com
 * @author Sebasthian Arias
 * @version 1.1
 * 
 */

@SuppressWarnings("unused")
public class EscribirArchivo extends PageObject {
	
public boolean escribirArchivoVacantes(String[] arregloVacantes) {
		int increase=1;
		boolean isFileSave=false;
		File Archivo = new File("C:\\Automation Project\\Proyects\\Proyecto01\\Resultados\\"+ increase+"Empleos_Disponibles.txt");
		increase ++;
		
		  try {
		       Archivo.createNewFile();
		
		       FileWriter FW = new FileWriter("C:\\Automation Project\\Proyects\\Proyecto01\\Resultados\\"+ increase+"Empleos_Disponibles.txt");
		       BufferedWriter BW = new BufferedWriter(FW); 						
			   for (int i = 0; i < arregloVacantes.length; i++) 
			   {
		         if (arregloVacantes[i] != null && !arregloVacantes[i].isEmpty()) {
		        	BW.write(arregloVacantes[i]);
		        	BW.newLine();
		        }
		       }
		      BW.close();
			   isFileSave=true;
			
            	} catch (IOException e) {
			
			    e.printStackTrace();
			
		        }
		        return isFileSave;
	          }
	
	public void pantallazoApp() {
		int increases=01;
		WebDriver miDriver= getDriver();
		File scrFile = ((TakesScreenshot)miDriver).getScreenshotAs(OutputType.FILE); 
		increases ++;
		
		      try {
			      FileUtils.copyFile(scrFile, new File("C:\\Automation Project\\Proyects\\Proyecto01\\Resultados\\Pantallazo"+ increases+".png"));
		      } 
		      catch (IOException pho) {
			
			   pho.printStackTrace();
		}
	}

}
