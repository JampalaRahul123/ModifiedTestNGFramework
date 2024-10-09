package practice.testng.dependsOnMethod;

import org.testng.annotations.Test;

public class ContactTest {
	@Test 
	public void createContactTest() {
		System.out.println("Execute createContactTest with -->HDFC");
	}
	@Test(dependsOnMethods = "createContactTest")
	public void modifyContactTest() {
		System.out.println("Execute modifyContactTest with -->HDFC=>ICICI");
	}
	@Test (dependsOnMethods = "modifyContactTest")
	public void deleteContactTest() {
		System.out.println("Execute deleteContactTest --> ICICI");
}
}
