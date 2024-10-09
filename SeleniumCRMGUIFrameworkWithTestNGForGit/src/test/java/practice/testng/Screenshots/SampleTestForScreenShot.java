package practice.testng.Screenshots;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SampleTestForScreenShot {
	
	@Test
	public void amazonTest() throws Throwable {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		// Step 1 : Create an object to takesScreenshot
		TakesScreenshot ts=(TakesScreenshot)driver;
		// Step 2 : Use getScreenshotAs method to get file type of screenshot
		File srcFile=ts.getScreenshotAs(OutputType.FILE); 
		// Step 3 : Store Screenshot on local driver
		File destFile = new File("./Screenshots/amazon.png");
		FileUtils.copyFile(srcFile, destFile);
		driver.quit();
	}
}
