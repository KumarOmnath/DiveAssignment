package com.dive.stepDefinitions;

import java.io.FileOutputStream;
import java.io.PrintStream;

import com.dive.pages.diveAssignmentPage;

import commonUtils.BaseTest;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class diveAssignmentsetup {
	diveAssignmentPage diveassignmentPage;
	@Given("^Load the browser and Navigate to URL$")
	public void load_the_browser_and_Navigate_to_URL() throws Throwable {
		PrintStream logs = new PrintStream(new FileOutputStream("AllLogs.txt"));
		System.setOut(logs);
		BaseTest.initialization();
	}
	
	
	@When("^User click on start a rume$")
	public void user_click_on_start_a_rume() throws Throwable {
		diveassignmentPage = new diveAssignmentPage();
		diveassignmentPage.startRumeButton();
	}

	@When("^Enter Host name in field$")
	public void enter_Host_name_in_field() throws Throwable {
	    diveassignmentPage.enterHostName();
	    
	}
	
	
	@When("^User navigated to home page$")
	public void user_navigated_to_home_page() throws Throwable {
	    diveassignmentPage.joinRume();

	}

	@When("^User validate Audio & Vidio is enabled$")
	public void user_validate_Audio_Vidio_is_enabled() throws Throwable {
		diveassignmentPage.audioVideo();
	}

	@When("^Host Share link to (\\d+) participant & validate participant ablr to join$")
	public void host_Share_link_to_participant_validate_participant_ablr_to_join(int arg1) throws Throwable {
	    diveassignmentPage.openEightTab();

	}

	@Then("^Validate switch to  Host & check  all (\\d+) participant  is joined or not$")
	public void validate_switch_to_Host_check_all_participant_is_joined_or_not(int arg1) throws Throwable {
	   
	}

}
