package practice.testng.DataProvidersAnnotation;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import SeleniumCRMGUIFrameworkWithTestNG.generic.FileUtility.ExcelUtility;

public class GetProductInfoUsingExcelTest {
	
	@Test(dataProvider = "getData")
	public void getProductInfoTest(String brandName , String productName) throws Throwable {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.amazon.in/");
		// Search Product
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys(brandName, Keys.ENTER);
		// Capture Product info
		String x ="//span[contains(text(),'"+productName+"')]/ancestor::div[contains(@class,'a-section') and not(contains(.,'Sponsored'))]/descendant::span[@class='a-price-whole']";
		String price = driver.findElement(By.xpath(x)).getText();
		Thread.sleep(3000);
		System.out.println(price);
		driver.quit();
	}
	@DataProvider
	public Object[][] getData() throws Throwable {
		ExcelUtility eLib = new ExcelUtility();
		int rowCount = eLib.getRowCount("product");
		Object[][] objArr = new Object[rowCount][2];
		for(int i=0;i<rowCount;i++) {
			objArr[i][0] = eLib.getDataFromExcel("product", i+1, 0);
			objArr[i][1] = eLib.getDataFromExcel("product", i+1, 1);
		}
		return objArr;
	}
}
