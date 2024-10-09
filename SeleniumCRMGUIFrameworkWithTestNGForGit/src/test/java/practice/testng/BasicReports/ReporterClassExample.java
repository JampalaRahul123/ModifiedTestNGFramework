package practice.testng.BasicReports;

import java.lang.reflect.Method;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class ReporterClassExample {

	@Test
	public void homePageTest(Method mtd) {
		// To get the method name dynamically, we use a class called Method which is present in java.reflect package
		Reporter.log(mtd.getName() + " Test Start ");
		Reporter.log("Step-1");
		Reporter.log("Step-2");
		Reporter.log("Step-3");
		Reporter.log("Step-4");
		Reporter.log(mtd.getName() + " Test End");
	}

	@Test
	public void verifyLogoHomePageTest(Method mtd) {
		// To get the method name dynamically, we use a class called Method which is present in java.reflect package
		Reporter.log(mtd.getName() + " Test Start ");
		Reporter.log("Step-1");
		Reporter.log("Step-2");
		Reporter.log("Step-3");
		Reporter.log("Step-4");
		Reporter.log(mtd.getName() + " Test End");
	}
}