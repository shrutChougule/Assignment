package Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


public class CustomerSignup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");

		WebDriver driver = new FirefoxDriver();
		driver.get("https://customer.i-on.in:9443/signUp");
		driver.manage().deleteAllCookies();
		
		WebElement userName = driver.findElement(By.id("name"));
		
		WebElement segment =driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div/div/div/div/div[2]/div/div/div/div/div/form/div/div/div/div[1]/div/div[2]/div/div/div/select"));
		Select segment1 = new Select((WebElement) segment);
		
		
			WebElement requiredService = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div/div/div/div/div[2]/div/div/div/div/div/form/div/div/div/div[1]/div/div[3]/div/div/div/select")); 
			//Select requiredService1 = new Select((WebElement) requiredService);
		
		
		
		
			 
		WebElement cpincode = driver.findElement(By.id("Communicationpincode"));	
		WebElement carea = driver.findElement(By.id("Communicationarea"));			
		WebElement cbuilding = driver.findElement(By.id("Communicationbuilding")); 
		WebElement cstate = driver.findElement(By.id("Communicationstate"));
		WebElement ccity = driver.findElement(By.id("Communicationcity"));
		WebElement ipin = driver.findElement(By.id("Installationpin"));
		WebElement iarea = driver.findElement(By.id("Installationarea"));
		WebElement ibuilding = driver.findElement(By.id("Installationbuilding"));
		WebElement istate = driver.findElement(By.id("Installationstate"));
		WebElement icity = driver.findElement(By.id("Installationcity"));
		WebElement orgnaization = driver.findElement(By.id("Orgnaization"));
		WebElement amobile = driver.findElement(By.id("alternatemobile"));
		WebElement lline = driver.findElement(By.id("LandLine"));
		WebElement aName = driver.findElement(By.id("AssociationName"));
		WebElement aContact = driver.findElement(By.id("AssociationContact"));
		WebElement aEmail = driver.findElement(By.id("AssociationEmail"));
		
			
		UtilReader reader = new UtilReader("./src/test/java/Assignment.xlsx");
		String sheetName = "Sheet1";
		 
		int rowCount = reader.getRowCount(sheetName);
		
		System.out.println(rowCount);
		
		for(int rowNum=2; rowNum <= rowCount; rowNum++ )
		{
			String Name = reader.getCellData(sheetName, "Name", rowNum);
			String selectSegment =reader.getCellData(sheetName, "Select Segment", rowNum);
			String serviceRequired =reader.getCellData(sheetName, "Service Required", rowNum);
			String pincode1 = reader.getCellData(sheetName, "Pincode", rowNum);
			String areaSubArea1 = reader.getCellData(sheetName, "Area/SubArea", rowNum);
			String houseno1 = reader.getCellData(sheetName, "House No.", rowNum);
			String city1 = reader.getCellData(sheetName, "City", rowNum);
			String state1 = reader.getCellData(sheetName, "State", rowNum);
			String pincode2 = reader.getCellData(sheetName, "Pincode", rowNum);
			String areaSubArea2 = reader.getCellData(sheetName, "Area/SubArea", rowNum);
			String houseno2 = reader.getCellData(sheetName, "House No.", rowNum);
			String city2 = reader.getCellData(sheetName, "City", rowNum);
			String state2 = reader.getCellData(sheetName, "State", rowNum);
			String pincodeEmail  = reader.getCellData(sheetName, "Pincode	Email ", rowNum);
			String phone = reader.getCellData(sheetName, "Phone", rowNum);
			String organizationDetail = reader.getCellData(sheetName, "Organization Detail", rowNum);
			String alternatePhone = reader.getCellData(sheetName, "Alternate Phone", rowNum);
			String landLine = reader.getCellData(sheetName, "LandLine", rowNum);
			String socityName = reader.getCellData(sheetName, "Socity Name", rowNum);
			String societyContactNo = reader.getCellData(sheetName, "Society Contact No.", rowNum);
			String societyEmail = reader.getCellData(sheetName, "Society Email", rowNum);
					
				
		

			
			System.out.println(Name + "  " + selectSegment+ "  " +serviceRequired+ "  "+pincode1+"  "+areaSubArea1+"  "+houseno1+"  "+city1+"  "+state1+"  "
					+pincode2+"  "+areaSubArea2+"  "+houseno2+"  "+city2+"  "+state2+"  "+pincodeEmail+"  "+phone+"  "+organizationDetail+"  "+alternatePhone+"  "
					+landLine+"  "+socityName+"  "+societyContactNo+"  "+ societyEmail);
			
			
			userName.clear();
			userName.sendKeys(Name);
			
			segment1.selectByVisibleText(selectSegment);
			
			requiredService.sendKeys(serviceRequired);
			
			
			
			cpincode.clear(); 
			cpincode.sendKeys(pincode1);
				
			carea.clear(); 
			carea.sendKeys(areaSubArea1);
			 
			cbuilding.clear(); 
			cbuilding.sendKeys(houseno1);
			 
	
			 cstate.clear();
				cstate.sendKeys(state1);
				
				ccity.clear();
				ccity.sendKeys(city1);
				
				ipin.clear();
				ipin.sendKeys(pincode2);
				
				iarea.clear();
				iarea.sendKeys(areaSubArea2);
				
				ibuilding.clear();
				ibuilding.sendKeys(houseno2);
				
				istate.clear();
				istate.sendKeys(state2);
				
				icity.clear();
				icity.sendKeys(city2);
				
				orgnaization.clear();
				orgnaization.sendKeys(organizationDetail);
				
				amobile.clear();
				amobile.sendKeys(phone);
				
				lline.clear();
				lline.sendKeys(alternatePhone);
				
				aName.clear();
				aName.sendKeys(socityName);
				
				aContact.clear();
				aContact.sendKeys(societyContactNo);
				
				aEmail.clear();
				aEmail.sendKeys(societyEmail);
				
				
			
			
			
		}
		
		

	}

}
