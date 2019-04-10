package com.qvision.elempleo.steps;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.Test;
import org.openqa.selenium.remote.server.handler.GetElementDisplayed;
import org.openqa.selenium.remote.server.handler.GetElementText;

import com.qvision.elempleo.pages.HomePage;
import com.qvision.elempleo.pages.SaveJobs;
import com.qvision.elempleo.pages.SearchPage;

import au.com.bytecode.opencsv.CSVWriter;
import net.thucydides.core.annotations.Step;

public class StepsPage {

	HomePage homePage;
	SearchPage searchPage;
	SaveJobs saveJob;

	@Step
	public void openApp() {
		homePage.open();
	}

	@Step
	public void cuaquoe(String Cargo, String Ciudad) {

		searchPage.getJobs(Cargo, Ciudad);

	}

	@Step
	public void guardarOferta(String Empresa, String Oferta) {

		saveJob.changeList(Empresa, Oferta);
	}
}
