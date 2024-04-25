package testRunnerTownScript;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;




@RunWith(Cucumber.class)
@CucumberOptions(

					
					
					features= {".//FeaturestownScript/TownScript.feature",".//FeaturestownScript/GoogleInvalidLogin.feature"},
					//features= {"@target/rerun.txt"},
					glue="stepDefinitiontownScript",
					plugin= {"pretty", "html:reports/myreport.html", 
							  "rerun:target/rerun.txt",
							  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
							},
							
					dryRun=false,    // checks mapping between scenario steps and step definition methods
					monochrome=true   // to avoid junk characters in output
					//publish=true   // to publish report in cucumber server
					//tags="@sanity"  // this will execute scenarios tagged with @sanity
		
		)

public class TestRunnerTownScript  extends AbstractTestNGCucumberTests
{
	

}
