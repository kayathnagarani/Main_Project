package pageobjectstownScript;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import utilities.DataWriter;



public class TownScriptpage extends BasePage  {

	
	public TownScriptpage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}


	//elements
	@FindBy(xpath="//a[text()='My Bookings']")
	WebElement myBookinglink;
	@FindBy(xpath="//i[@class='mdi mdi-menu-down text-xl md:text-2xl']")
	///html/body/app-root/div/app-login-signup/section/div[1]/ts-header/nav[1]/div[2]/div[3]/app-search/div/div[2]/i
	WebElement clickonarrow;
	@FindBy(xpath ="//span[@class='text-gray-800 capitalize text-sm'][normalize-space()='Chennai']")
	////span[contains(text(),'Chennai')]
	////span[@class='text-gray-800 capitalize text-sm'][normalize-space()='Chennai']
	///html/body/app-root/div/app-login-signup/section/div[1]/ts-header/nav[1]/div[2]/div[3]/app-search/div/div[2]/app-city-search-popup/div/div/ul/li[6]
	WebElement chennaicity;
	@FindBy(xpath ="//img[@title='Sports & Fitness events']")
	WebElement fitnesswellbeing;
	@FindBy(xpath = "/html/body/app-root/div/app-listing-page/div[2]/app-filter-menu/div[1]/div/div[1]/div/div[1]/div[1]/i[2]")
	///html/body/app-root/div/app-listing-page/div[2]/app-filter-menu/div[1]/div/div[1]/div/div[1]/div[1]/i[2]
	WebElement datearrow;
	@FindBy(xpath ="//li[text()='This Weekend']")
	///html/body/app-root/div/app-listing-page/div[2]/app-filter-menu/div[1]/div/div[1]/div/div[1]/div[2]/ul/li[3]
	WebElement thisWeekend;
	@FindBy(xpath="//i[@class='mdi mdi-view-day text-primary md:text-purple-900 text-xl md:text-2xl']")
	///html/body/app-root/div/app-listing-page/div[2]/app-filter-menu/div[1]/div/div[2]/div[2]/i
	WebElement listview;
	@FindBy(xpath="//span[text()='Load More']")
    WebElement load_more;
	@FindBy(css=".date")
	List<WebElement> date;
	@FindBy(css="div.event-name")
	List<WebElement> name;
	@FindBy(xpath ="//h5[normalize-space()='Popular Cities']")
	///html/body/app-root/div/app-listing-page/div[2]/ts-footer/footer/div/div[2]/div[1]/div[2]/div/h5
	WebElement pupularcities;
	@FindBy(xpath="//li[@class=\"ng-star-inserted\"]")
	///html/body/app-root/div/app-listing-page/div[2]/ts-footer/footer/div/div[2]/div[1]/div[2]/div/ul
	public List<WebElement> cities;
	//actions
	public void clickMybookingslink() 
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",myBookinglink);	
		myBookinglink.click();
	}
	public void clickingOnCityArrow() 
	{
		clickonarrow.click();
	}
	public void selectingNewCity()
	{
		chennaicity.click();
		
	}
	public void fitnesswellBeing() 
	{
		
		fitnesswellbeing.click();
		
	}
	public void clickingondateArrow() 
	{
		datearrow.click();
		
	}
	public void SelectingThisWeekend()
	{
		
		thisWeekend.click();
	}
	public void enablinglistview() 
	{
		 listview.click();
		 
    }
	public void clickLoadMore() throws InterruptedException {
		while(load_more.isEnabled()) {
			Actions ac=new Actions(driver);
			ac.scrollToElement(load_more);
			load_more.click();
			Thread.sleep(3000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
			Thread.sleep(1000);
		}

 }
	public void printingevents() throws IOException 
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
	
						try {
							for(int i=0;i<100;i++) {
								 js.executeScript("window.scrollBy(0,250)");
								 Thread.sleep(1000);
							}}
						
							catch(Exception e) {}
						
                       
                     
						System.out.println(date.size() + "-" + name.size());
						String xlfile="C:\\workspaceeclipse\\townScript\\testdata\\testdata.xlsx";
						String data="";
						for(int i=0;i<name.size();i++) 
						{ 
			                data="Event"+(i+1);
							DataWriter.setCellData(xlfile,"Sheet1",i,0,data); 
							data="Event Name : "+name.get(i).getText();
							DataWriter.setCellData(xlfile,"Sheet1",i,1,data); 
							data="Event Date : "+date.get(i).getText();
							DataWriter.setCellData(xlfile,"Sheet1",i,2,data); 
							System.out.println("Event"+(i+1));
							System.out.println("Event Name : "+name.get(i).getText());
							System.out.println("Event Date : "+date.get(i).getText());
							
				
						}  
	}
	


	public void scrollTillPopularCities() throws InterruptedException 
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",pupularcities);
		//Thread.sleep(4000);
	}
	public void popularCities() throws IOException 
	{
		
		
			System.out.println("Popular cities are"+cities.size());
			String xlfile="C:\\workspaceeclipse\\townScript\\testdata\\testdata.xlsx";
			String data="";
			for(int i=0;i<cities.size();i++) 
			{ 
				
			
				data="city"+(i+1);
				DataWriter.setCellData(xlfile,"Sheet3",i,0,data);
				data=cities.get(i).getText();
				System.out.println(cities.get(i).getText());
				DataWriter.setCellData(xlfile,"Sheet3",i,1,data);
			
			}
	
			
		}
	
	
	public void navigateHomepage() {
	
			 driver.navigate().to("https://www.townscript.com/i/event-registration-software");

	}
	
	
	
	
	

}
