package practice.testng.priority;

import org.testng.annotations.Test;

public class ContactTestWithOutPriority {
	@Test
	public void createContactTest() {
		System.out.println("Execute createContactTest with -->HDFC");
	}
	@Test
	public void modifyContactTest() {
		System.out.println("Execute Query insert contact into DB==>ICICI");
		System.out.println("Execute modifyContactTest with -->HDFC=>ICICI");
	}
	@Test
	public void deleteContactTest() {
		System.out.println("Execute Query insert contact into db==>UPI");
		System.out.println("Execute deleteContactTest --> UPI");
}
}