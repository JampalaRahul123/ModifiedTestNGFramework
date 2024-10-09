package practice.testng.Assertions;

import java.lang.reflect.Method;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertMethodsWithValidValueExample {

	@Test
	public void homePageTest(Method mtd) {
		// To get the method name dynamically, we use a class called Method which is present in java.reflect package
		SoftAssert assertObj = new SoftAssert();
		System.out.println(mtd.getName() + " Test Start ");
			System.out.println("Step-1");
		    System.out.println("Step-2");
		    assertObj.assertEquals("Home", "Home-Page");
		    System.out.println("Step-3");
		    assertObj.assertEquals("Home-CRM", "Home-CRM");
		    System.out.println("Step-4");
		System.out.println(mtd.getName() + " Test End");
	}

	@Test
	public void verifyLogoHomePageTest(Method mtd) {
		// To get the method name dynamically, we use a class called Method which is present in java.reflect package
		System.out.println(mtd.getName() + " Test Start ");
		SoftAssert assertObj = new SoftAssert();
		System.out.println("Step-1");
	    System.out.println("Step-2");
	    assertObj.assertTrue(true);
	    System.out.println("Step-3");
	    System.out.println("Step-4");
		System.out.println(mtd.getName() + " Test End");
		}
}