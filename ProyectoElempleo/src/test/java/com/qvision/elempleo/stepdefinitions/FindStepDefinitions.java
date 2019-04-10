package com.qvision.elempleo.stepdefinitions;

import java.util.List;
import java.util.Map;
import com.qvision.elempleo.steps.StepsPage;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class FindStepDefinitions {

	@Steps
	StepsPage stepFind;

	@Given("^That i am in the page$")
	public void thatIAmInThePage() {
		
		
		stepFind.openApp();
	}

    @When("^I find the data$")
	public void iTypeTheData(DataTable arg1) {
		List<Map<String, String>> data = arg1.asMaps(String.class, String.class);
	   	String Cargo = data.get(0).get("cargo");
		String Ciudad = data.get(0).get("ciudad");
		stepFind.cuaquoe(Cargo, Ciudad);

	}

	@Then("^I get all jobs$")
	public void iGetAllJobs(DataTable arg2) {
//		List<Map<String, String>> data = arg2.asMaps(String.class, String.class);
//	   	String Empresa = data.get(0).get("empresa");
//		String Oferta = data.get(0).get("oferta");
//		stepFind.cuaquoe(Empresa, Oferta);
	}

}
