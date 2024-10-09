package practice.testng.Basics;

import org.testng.annotations.Test;

public class ContactTest {
	
	@Test
	public void createContactTest() {
		System.out.println("Execute Login");
		System.out.println("Execute Navigate To Contact");
		System.out.println("Execute Create Contact");
		System.out.println("Execute Verify Contact");
		System.out.println("Execute Logout");
	}
	@Test
	public void createContactWithOrgTest() {
		System.out.println("Execute createContactWithOrgTest");
	}
	@Test
	public void createContactWithSupportDateTest() {
		System.out.println("Execute createContactWithSupportDateTest");
	}
}
