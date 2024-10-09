package practice.testng.DataProvidersAnnotation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GetProductInfoTestWithDataProvidersAnnotation {

	@Test(dataProvider = "getData")
	public void getProductInfoTest(String brandName , String productName) throws Throwable {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.amazon.in/");
		// Search Product
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys(brandName, Keys.ENTER);
		// Capture Product info
		String x = "//span[contains(text(),'"+productName+"')]/ancestor::div[contains(@class,'a-section') and not(contains(.,'Sponsored'))]/descendant::span[@class='a-price-whole']";
		String price = driver.findElement(By.xpath(x)).getText();
		Thread.sleep(3000);
		System.out.println(price);
		driver.quit();
	}
	@DataProvider
	public Object[][] getData() {
		Object[][] objArr = new Object[3][2];
		objArr[0][0] = "iphone";
		objArr[0][1] = "Apple iPhone 13 (128GB) - Midnight";
		objArr[1][0] = "iphone";
		objArr[1][1] = "Apple iPhone 13 (128GB) - Starlight";
		objArr[2][0] = "iphone";
		objArr[2][1] = "Apple iPhone 15 (128 GB) - Black";
		return objArr;
	}
	}
