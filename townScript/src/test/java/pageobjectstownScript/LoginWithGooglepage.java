package pageobjectstownScript;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import FactoryTownScript.BaseClassTownScript;
import utilities.DataWriter;


public class LoginWithGooglepage extends BasePage {

	public LoginWithGooglepage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	//Elements
	@FindBy(xpath="/html/body/div[1]/div/div/div/div/a")
	WebElement registeritsfreebutton;
	@FindBy(xpath="//*[@id=\"loginForm\"]/div[4]/a")
	WebElement continueWithGoogle;
	@FindBy(xpath="//*[@id=\"identifierId\"]")
	WebElement emailInputBox;
	@FindBy(xpath="//*[@id=\"identifierNext\"]/div/button/span")
	WebElement nextButton;
	@FindBy(xpath="//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/div/div/div[1]/form/span/section/div/div/div[1]/div/div[2]/div[2]/div")
	WebElement warningMessage;
	//actions
	public void clickOnRegisterItsFree() 
	{
		registeritsfreebutton.click();
		
	}
	public void continueWithGoogle() 
	{
		continueWithGoogle.click();
	}
	public void enteringInvalidEmail() throws IOException, InterruptedException
	{
		//BaseClassTownScript Bct = new BaseClassTownScript();
		//emailInputBox.sendKeys(Bct.p.getProperty("Email"));
		String xlfile="C:\\workspaceeclipse\\townScript\\testdata\\testdata.xlsx";
	
		//String xlfile = "C:\\workspaceeclipse\\townScript\\testdata\\testdata.xlsx";
		String sheetName = "Sheet2";

		try {
		    int rowCount = DataWriter.getRowCount(xlfile, sheetName);
		    for (int i = 1; i <= rowCount; i++) {
		        int cellCount = DataWriter.getCellCount(xlfile, sheetName, i);
		        for (int j = 0; j < cellCount; j++) {
		            String cellData = DataWriter.getCellData(xlfile, sheetName, i, j);
		            //System.out.println("Row: " + i + ", Cell: " + j + ", Data: " + cellData);
		            emailInputBox.sendKeys(cellData);
		            Thread.sleep(2000);       
		            nextButton.click();
		            emailInputBox.clear();
		        }
		    }
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		
	}
	
	/*public void clickonnextButton() throws InterruptedException 
	{
		nextButton.click();
		
		//Thread.sleep(1000);
	}*/
	public boolean errormsg_presence() 
	{  
		if(warningMessage.isDisplayed()) 
		{
		return true;
		}
		else {
			return false;
		}
	}
	public String  getErrorMessgae() 
	{
		   String errormsg =warningMessage.getText();
		   
		   return errormsg;
	}
	

}
