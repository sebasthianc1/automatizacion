package com.qvision.elempleo.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)

@CucumberOptions(features = "src/test/resources/features/find.feature", glue = "com.qvision.elempleo.stepdefinitions", snippets = SnippetType.CAMELCASE)

public class LoginRunner {

}
