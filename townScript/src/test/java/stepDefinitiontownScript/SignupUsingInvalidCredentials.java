package stepDefinitiontownScript;

import java.io.IOException;

import org.junit.Assert;

import FactoryTownScript.BaseClassTownScript;
import io.cucumber.java.en.*;
import pageobjectstownScript.LoginWithGooglepage;
import pageobjectstownScript.TownScriptpage;

public class SignupUsingInvalidCredentials {
	
	TownScriptpage tsp;
	LoginWithGooglepage lgp;
	
	@When("user clicks on the Registraion its free")
	public void user_clicks_on_the_registraion_its_free() 
	
	{
		BaseClassTownScript.getLogger().info("*** Starting invalidgoogle login testcase***");
		
	    
	    tsp = new TownScriptpage(BaseClassTownScript.getDriver());
	    BaseClassTownScript.getLogger().info("navigating to home page");
	    tsp.navigateHomepage();
	    lgp = new LoginWithGooglepage(BaseClassTownScript.getDriver());
	    BaseClassTownScript.getLogger().info("clicking on register its free");
	    lgp.clickOnRegisterItsFree();
	}

	@When("clicks on continue with google")
	public void clicks_on_continue_with_google()
	{
	   BaseClassTownScript.getLogger().info("click on continue button");
	   lgp.continueWithGoogle();
	}

	@When("enters the invalid email")
	public void enters_the_invalid_email() throws IOException, InterruptedException 
	{
		BaseClassTownScript.getLogger().info("entering invalid email");
		lgp.enteringInvalidEmail();
	
	}

	@When("clicks on next and checks for error message")
	public void checks_errormsg_is_displayed () 
	{
		Assert.assertEquals(true, lgp.errormsg_presence() );
		
	}

	@Then("we capture the error message")
	public void we_capture_the_error_message() 
	{
	   BaseClassTownScript.getLogger().info("*** ending InvalidGoogleLogin ***");
	   Assert.assertEquals("Enter a valid email or phone number", lgp.getErrorMessgae());
	}
	

}
