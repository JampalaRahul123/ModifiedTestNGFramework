package practice.testng.ConfigurationAnnotation;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ConfigAnnotationBSASFirstTest {
	@BeforeSuite
	public void configBS() {
		System.out.println("execute BeforeSuite");
	}
	@AfterSuite
	public void configAS() {
		System.out.println("execute AfterSuite");
	}
	@BeforeClass
	public void configBC() {
		System.out.println("execute BeforeClass");
	}
	@BeforeMethod
	public void configBM() {
		System.out.println("execute BeforeMethod");
	}
	@Test
	public void createOrg() {
		System.out.println("execute createOrg");
		}
	@Test
	public void createOrgWithIndustries() {
		System.out.println("execute createOrgWithIndustries");
		}
	@AfterMethod
	public void configAM() {
		System.out.println("execute AfterMethod");
		}
		@AfterClass
		public void configAC() {
			System.out.println("execute AfterClass");
	}
}
