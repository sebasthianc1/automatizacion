package com.qvision.ejerciciofinal.stepdefinitions;

import java.util.List;
import java.util.Map;
import org.junit.Assert;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import com.qvision.ejerciciofinal.steps.Flujo;

/**
 * Automatización_El_Empleo.com
 * @author Sebasthian Arias
 * @version 1.1
 * 
 */

@SuppressWarnings("unused")
public class FlujoFuncional {
	
	@Steps
	Flujo flujo;

	@Given("^That I am in the look for employ page$")
	public void thatIAmInTheLookForPage() {
		flujo.url();
	}
	@And("^I into by skill and city$")
	public void iTypeTheData(DataTable arg1) {
	    List<Map<String, String>> listData = arg1.asMaps(String.class, String.class);
	    String empleo = listData.get(0).get("empleo");
	    String ciudad = listData.get(0).get("ciudad");
	    flujo.busquedaEmpleo(empleo, ciudad);
	}

	@When("^I filter by wages$")
	public void iFilterByWages(DataTable arg2) {
		   List<Map<String, String>> listData = arg2.asMaps(String.class, String.class);
		    String rangoFecha = listData.get(0).get("rangoFecha");
		    String areaTrabajo = listData.get(0).get("areaTrabajo");
		    flujo.filtrosEmpleo(rangoFecha,areaTrabajo);
	}
	

	@Then("^I save the job offers into a file$")
	public void iSaveTheJobOffersIntoAFile() {
	    flujo.guardarArchivoOfertas();
	  
	}
	@And("^I take Screenshot$")
	public void iTakeScreenshot() {
		flujo.tomarPantallazo();
	}
	

}
