package Testcases;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class SendEmailDynamicXpath {

	public static void main(String[] args) throws InterruptedException, IOException { // TODO Auto-generated method stub


		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://accounts.google.com/"); 

		driver.findElement(By.xpath("//input[@name='identifier']")).sendKeys("abc@gmail.com");
		driver.findElement(By.xpath("//span[@class='VfPpkd-vQzf8d']")).click();
		driver.findElement(By.xpath("//span[@class='VfPpkd-vQzf8d']")).click();
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Pass@123");
		driver.findElement(By.xpath("//span[@class='VfPpkd-vQzf8d']")).click();


		driver.findElement(By.xpath("//svg[@class='gb_Ve']")).click(); //click on google apps tab. 
	driver.findElement(By.cssSelector("#gb23 > span:nth-child(5)")).click();  //click on gmail icon.

		driver.findElement(By.xpath("div[@class='T-I T-I-KE L3']")).click();   // click on compose  

			
		driver.findElement(By.xpath("//textarea[@name='to']")).sendKeys("abcd@gmail.com");
		driver.findElement(By.xpath("//input[@name='subjectbox']")).sendKeys("Selenium Attachment");
		driver.findElement(By.xpath("//div[@class='Am Al editable LW-avf tS-tW']")).sendKeys("Please find attachment."); // type mail body 
		//driver.findElement(By.xpath("//div[@class='a1 aaA aMZ']")).click();

		WebElement upload_file = driver.findElement(By.xpath("//div[@class='a1 aaA aMZ']"));

		upload_file.sendKeys("F:\\Eclips Project\\SeleniumAssignments\\src\\test\\java\\SamplePDF.pdf");
		
		/*
		 * FileInputStream filename= new FileInputStream(System.getProperty("user.dir")+
		 * "\\src\\test\\java\\sample1.pdf"); Properties prop= new Properties();
		 * prop.load(filename);
		 */


		driver.findElement(By.id("//div[@id=':p3']")).click();    // Send button click
		Thread.sleep(8000);  // Apply wait for sending mail 
		driver.close();


	}

}
