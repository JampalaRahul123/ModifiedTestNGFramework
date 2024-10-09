package SeleniumCRMGUIFrameworkWithTestNG.generic.CrossBrowserParallelExecution.BaseTest;

import java.sql.SQLException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import SeleniumCRMGUIFrameworkWithTestNG.generic.DatabaseUtility.DataBaseUtility;
import SeleniumCRMGUIFrameworkWithTestNG.generic.FileUtility.*;
import SeleniumCRMGUIFrameworkWithTestNG.generic.JavaUtility.JavaUtility;
import SeleniumCRMGUIFrameworkWithTestNG.generic.ObjectRepository.HomePage;
import SeleniumCRMGUIFrameworkWithTestNG.generic.ObjectRepository.LoginPage;

public class BaseClass {
	/* Create Object and declare it as public(Access-Specifier) because they are available in different packages*/
	 public DataBaseUtility dbLib = new DataBaseUtility();
	 public FileUtility fLib = new FileUtility();
	 public ExcelUtility eLib = new ExcelUtility();
	 public JavaUtility jLib = new JavaUtility();
	 public WebDriver driver = null;
	@BeforeSuite
	public void configBS() throws SQLException {
		System.out.println("====connect to DB, Report Config===");
		dbLib.getDbconnection();
	}

	@Parameters ("BROWSER")
	@BeforeClass
	public void configBC(String browser) throws Throwable {
		System.out.println("===launch browser===");
		String BROWSER = browser;
		//fLib.getDataFromPropertiesFile("browser");
		// Run-time Polymorphism.In order to achieve run-time polymorphism, we need to follow three rules.
		// They are : 1.Up casting, 2. Inheritance 3. overriding
		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
	}

	@BeforeMethod
	public void configBM() throws Throwable {
		System.out.println("=login=");
		LoginPage lp = new LoginPage(driver);
		String URL = fLib.getDataFromPropertiesFile("url");
		String USERNAME = fLib.getDataFromPropertiesFile("username");
		String PASSWORD = fLib.getDataFromPropertiesFile("password");
		lp.loginToapp(URL, USERNAME, PASSWORD);
	}

	@AfterMethod
	public void configAM() {
		System.out.println("=logout=");
		HomePage hp = new HomePage(driver);
		hp.logOut();
	}

	@AfterClass
	public void configAC() {
		System.out.println("===close the browser===");
		driver.quit();
	}

	@AfterSuite
	public void configAS() throws SQLException {
		System.out.println("===close Db, Report backup===");
		dbLib.closeDbConnection();
	}

}