package Testcases;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IRCTCTrainSearch {

	public static void main(String[] args) throws InterruptedException, IOException {
		{ // TODO Auto-generated method stub

			System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");

			WebDriver driver = new FirefoxDriver();
			driver.get("https://www.irctc.co.in/nget/train-search");
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();

			WebElement okbutton = driver.findElement(By.xpath(
					"/html/body/app-root/app-home/div[1]/app-header/p-dialog[2]/div/div/div[2]/div/form/div[2]/button"));
			clickOn(driver, okbutton, 5);

			WebElement from = driver.findElement(By.xpath("//*[@id=\"origin\"]/span/input"));
			sendKeys(driver, from, 10, "C SHIVAJI MAH T - CSTM");
			WebElement to = driver.findElement(By.xpath("//*[@id=\"destination\"]/span/input"));
			sendKeys(driver, to, 5, "HOWRAH JN - HWH");

			WebElement journeyQuota = driver.findElement(By.xpath("//*[@id=\"journeyQuota\"]"));
			// journeyQuota.click();
			clickOn(driver, journeyQuota, 5);

			WebElement journeyQuota2 = driver.findElement(By.xpath(
					"/html/body/app-root/app-home/div[3]/div/app-main-page/div/div/div[1]/div[1]/div[1]/app-jp-input/div/form/div[3]/div/div/p-dropdown/div/div[4]/div/ul/p-dropdownitem[5]/li/span"));
			// journeyQuota2.click();
			clickOn(driver, journeyQuota2, 5);

			WebElement journeyClass = driver.findElement(By.xpath("//*[@id=\"journeyClass\"]"));
			// journeyClass.click();
			clickOn(driver, journeyClass, 5);

			WebElement journeyClass2 = driver.findElement(By.xpath(
					"/html/body/app-root/app-home/div[3]/div/app-main-page/div/div/div[1]/div[1]/div[1]/app-jp-input/div/form/div[2]/div[2]/div[2]/p-dropdown/div/div[4]/div/ul/p-dropdownitem[7]/li/span"));
			// journeyClass2.click();
			clickOn(driver, journeyClass2, 5);

			/*
			 * driver.findElement(By.xpath("//*[@id=\"jDate\"]")).click();
			 * driver.findElement(By.xpath("//*[@id=\"jDate\"]/span/div/div/div[1]/a[2]")).
			 * click();
			 * 
			 * int numberOfDays = 30; DateFormat dateFormat = new
			 * SimpleDateFormat("MMM dd yyyy"); Calendar cal = Calendar.getInstance();
			 * cal.add(Calendar.DATE, numberOfDays); String toDate =
			 * dateFormat.format(cal.getTime()); System.out.println(toDate);
			 * 
			 * 
			 * String toDateXpath =
			 * "//td[@class='ng-tns-c59-10 ng-star-inserted']//td//a[contains(@aria-label='"
			 * + toDate + "')]"; driver.findElement(By.xpath(toDateXpath)).click();
			 */

			WebElement element = driver.findElement(By.xpath(
					"//*[@id=\"divMain\"]/div/app-main-page/div/div/div[1]/div[1]/div[1]/app-jp-input/div/form/div[4]/div/span[3]/label"));
			element.click();

			WebElement btn = driver.findElement(By.xpath("//*[@id=\"divMain\"]/div/app-main-page/div/div/div[1]/div[1]/div[1]/app-jp-input/div/form/div[5]/div/button"));
			clickOn(driver, btn, 5);

		}

	}

	public static void sendKeys(WebDriver driver, WebElement element, long timeout, String value) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfAllElements(element));
		element.sendKeys(value);
	}

	public static void clickOn(WebDriver driver, WebElement element, long timeout) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}

}
