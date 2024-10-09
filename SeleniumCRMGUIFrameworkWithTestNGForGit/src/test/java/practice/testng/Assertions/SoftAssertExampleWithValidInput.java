package practice.testng.Assertions;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertExampleWithValidInput {

	@Test
	public void homePageTest(Method mtd) {
		// To get the method name dynamically, we use a class called Method which is present in java.reflect package
		System.out.println(mtd.getName() + " Test Start ");
		String expectedPage = "Home";
		SoftAssert assertObj = new SoftAssert();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://localhost:8888");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("manager");
		driver.findElement(By.id("submitButton")).click();

		String actTitle = driver.findElement(By.xpath("//a[contains(text(),'Home')]")).getText();
		//Soft Asset
		assertObj.assertEquals(actTitle, expectedPage);
		driver.close();
		System.out.println(mtd.getName() + " Test End");
	}

	@Test
	public void verifyLogoHomePageTest(Method mtd) {
		// To get the method name dynamically, we use a class called Method which is present in java.reflect package
		System.out.println(mtd.getName() + " Test Start ");
		SoftAssert assertObj = new SoftAssert();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://localhost:8888");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("manager");
		driver.findElement(By.id("submitButton")).click();
		
		boolean status = driver.findElement(By.xpath("//img[@title='vtiger-crm-logo.gif']")).isEnabled();
		//Soft Asset
		assertObj.assertTrue(status);
		driver.close();
		System.out.println(mtd.getName() + " Test End");
		}
	}