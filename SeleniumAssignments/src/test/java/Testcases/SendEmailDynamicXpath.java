package Testcases;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SendEmailDynamicXpath {

	public static void main(String[] args) throws InterruptedException, IOException, AWTException { // TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


		driver.get("https://accounts.google.com/");

		driver.manage().window().maximize();
		
		String parent=driver.getWindowHandle();

		// Login to gmail account
		driver.findElement(By.xpath("//input[@name='identifier']")).sendKeys("008arronsmith@gmail.com");
		
		driver.findElement(By.xpath("//span[@class='VfPpkd-vQzf8d']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Pass@123");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//div[@id='passwordNext']")).click();

		// click on google apps tab.
		WebElement element1 = driver.findElement(By.xpath("//div[@class='gb_zf']")); 
		clickOn(driver, element1, 50);

		// Choose Gmail app by switching to frame
		WebElement frame1 = driver.findElement(By.xpath("//iframe[@role=\"presentation\"]"));
		driver.switchTo().frame(frame1);
		driver.findElement(By.xpath("//ul[@class='LVal7b u4RcUd']//li//a[@href='https://mail.google.com/mail/?tab=km']")).click();

        

		Set<String> Winhandles=driver.getWindowHandles();
		
		//Switch to next tab
		for(String hndl: Winhandles)
		{

			//if the child widow handle is not same as parent window handle
			if(!hndl.equalsIgnoreCase(parent))
			{
				//switching to the opened tab
				driver.switchTo().window(hndl);

				//opening the URL saved.             
				System.out.println("New Tab Window Title:" + driver.getTitle());
				//System.out.println("New Tab Window Page Heading: "+ driver.findElement(By.xpath("//*[@id=\"main\"]/h1")).getText());

				//click on compose 
				WebElement compose= driver.findElement(By.xpath("//div[@class='T-I T-I-KE L3']"));
				clickOn(driver, compose, 20);
				
		        //write the  recipient ID , Subject and  mail body
				driver.findElement(By.xpath("//textarea[@name='to']")).sendKeys("008lolasmith@gmail.com");
				driver.findElement(By.xpath("//input[@name='subjectbox']")).sendKeys("Selenium Attachment");
				driver.findElement(By.xpath("//div[@class='Am Al editable LW-avf tS-tW']")).sendKeys("Please find attachment."); // type mail

				//click on attachment
				driver.findElement(By.xpath("//tbody/tr/td[4]//div//div[@aria-label='Attach files']")).click();
				
				// use AutoIT tool to attach a file
				Runtime.getRuntime().exec("F:\\AutoIT\\Attachment.exe");
				Thread.sleep(10000);

				//click on send
				driver.findElement(By.xpath("//tbody/tr/td[@class='gU Up']//div//div//div[@class='T-I J-J5-Ji aoO v7 T-I-atl L3']")).click(); // Send button click
				/*
				 * String msg =
				 * driver.findElement(By.xpath("//div[contains(text(),'Message sent.')]")).
				 * getText(); String exp = "Your message has been sent. View message";
				 * Assert.assertEquals(msg, exp);
				 */
				System.out.println("Message Sent");
			}
		}
	}

	public static void clickOn(WebDriver driver, WebElement element, long timeout) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}

}










