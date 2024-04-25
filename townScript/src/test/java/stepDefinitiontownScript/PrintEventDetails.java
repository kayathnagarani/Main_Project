package stepDefinitiontownScript;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import FactoryTownScript.BaseClassTownScript;
import io.cucumber.java.en.*;
import pageobjectstownScript.LoginWithGooglepage;
import pageobjectstownScript.TownScriptpage;

public class PrintEventDetails {
	TownScriptpage tsp;
	LoginWithGooglepage lgp;
	WebDriver driver;
	
	@Given("the user is homepage")
	public void the_user_is_homepage() 
	{
		BaseClassTownScript.getLogger().info(" *** Starting navigating to town script***");
		tsp = new TownScriptpage(BaseClassTownScript.getDriver());


	}

	@When("user clicks on Mybooking")
	public void user_clicks_on_mybooking() 
	{
		BaseClassTownScript.getLogger().info("clicking on mybookings link");
		tsp.clickMybookingslink();
	}

	@When("user clicks on cityArrow and selects new city")
	public void user_clicks_on_city_arrow_and_selects_new_city() throws InterruptedException 
	{
		BaseClassTownScript.getLogger().info("clicking on city dropdown");
	    tsp.clickingOnCityArrow();
	    tsp.selectingNewCity();
	    Thread.sleep(5000);
	}

	@When("clicks on fitnessandwellbeing")
	public void clicks_on_fitnessandwellbeing() throws InterruptedException 
	{
		BaseClassTownScript.getLogger().info("clicking on fitness and wellbeing link");
	    tsp.fitnesswellBeing();
	    Thread.sleep(5000);
	}

	@When("clicks on dateArrow and select thisweekend and enables listview")
	public void clicks_on_date_arrow_and_select_thisweekend_and_enables_listview() throws InterruptedException 
	{
		BaseClassTownScript.getLogger().info("clicking on fitness and wellbeing link");
	    tsp.clickingondateArrow();
	    Thread.sleep(3000);
	    tsp.SelectingThisWeekend();
	    Thread.sleep(3000);
	    tsp.enablinglistview();
	    Thread.sleep(3000);
	}

	@Then("events are printed")
	public void events_are_printed() throws InterruptedException, IOException 
	{
		BaseClassTownScript.getLogger().info("** here we print the events**");
		try{
			tsp.clickLoadMore();
		}
		catch(Exception e) {}
	   tsp.printingevents();
	   
	}
	@Then("scrolls until popular cities")
	public void scrolls_until_popular_cities() throws InterruptedException 
	{
		BaseClassTownScript.getLogger().info("Scrolling to popularcities");
		tsp.scrollTillPopularCities();
	}

	@Then("prints city names")
	public void prints_city_names() throws IOException 
	{
		BaseClassTownScript.getLogger().info("*** ending with popular city names***");
	    tsp.popularCities();
	}

	
	
	
	

}
