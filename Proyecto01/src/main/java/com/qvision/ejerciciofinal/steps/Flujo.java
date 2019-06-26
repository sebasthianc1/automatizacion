package com.qvision.ejerciciofinal.steps;


import net.thucydides.core.annotations.Step;
import com.qvision.ejerciciofinal.pages.SeleccionarItems;
import com.qvision.ejerciciofinal.pages.BuquedaPagina;
import com.qvision.ejerciciofinal.pages.EscribirArchivo;

/**
 * Automatización_El_Empleo.com
 * @author Sebasthian Arias
 * @version 1.1
 * 
 */

public class Flujo {
	
	SeleccionarItems seleccionarItems;
	BuquedaPagina busquedaPagina;
	EscribirArchivo escribirArchivo;
	
	@Step
	public void url() {
		seleccionarItems.open();
	}
	@Step
	public void busquedaEmpleo(String empleo,String ciudad) {
		seleccionarItems.conector(empleo, ciudad);
		
	}
	@Step
	public void filtrosEmpleo(String rangoFecha,String areaTrabajo) {
		busquedaPagina.filterByWages(rangoFecha,areaTrabajo);
		
	}
	@Step
	public void guardarArchivoOfertas(){
		busquedaPagina.saveFileWithJobOffersGenerated();
	}
	@Step
	public void tomarPantallazo() {
		escribirArchivo.pantallazoApp();
	}
	
	
}
