package com.qvision.ejeciciofinal.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;

/**
 * Automatización_El_Empleo.com
 * @author Sebasthian Arias
 * @version 1.1
 * 
 */

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		features = "src/test/resources/features/BusquedaEmpleo.feature",
		glue = "com.qvision.ejerciciofinal.stepdefinitions",
		snippets = SnippetType.CAMELCASE)



public class Inicializador {

	

}
