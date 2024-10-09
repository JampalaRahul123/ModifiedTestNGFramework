package practice.testng.DataProvidersAnnotation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class GetProductInfoDemoTest {

	@Test
	public void getProductInfoTest() throws Throwable {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.amazon.in/");
		//Search Product
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iphone",Keys.ENTER);	
		//Capture Product info
		String x = "//span[contains(text(),'Apple iPhone 15 (128 GB) - Black')]/ancestor::div[contains(@class,'a-section') and not(contains(.,'Sponsored'))]/descendant::span[@class='a-price-whole']";
		String price = driver.findElement(By.xpath(x)).getText();
		System.out.println(price);
		driver.close();
		}
	}
