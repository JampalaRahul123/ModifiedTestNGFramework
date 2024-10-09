package practice.testng.priority;

import org.testng.annotations.Test;

public class ContactTestWithPriority {
	@Test(priority = -1)
	public void createContactTest() {
		System.out.println("Execute createContactTest");
	}
	@Test(priority = 0)
	public void modifyContactTest() {
		System.out.println("Execute modifyContactTest");
	}
	@Test (priority = 3)
	public void deleteContactTest() {
		System.out.println("Execute deleteContactTest");
}
}