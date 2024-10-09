package practice.testng.baseclass.simple.contacttest;

import org.testng.annotations.Test;

import SeleniumCRMGUIFrameworkWithTestNG.generic.ObjectRepository.ContactInfoPage;
import SeleniumCRMGUIFrameworkWithTestNG.generic.ObjectRepository.ContactsPage;
import SeleniumCRMGUIFrameworkWithTestNG.generic.ObjectRepository.CreatingNewContactPage;
import SeleniumCRMGUIFrameworkWithTestNG.generic.ObjectRepository.CreatingNewOrganizationPage;
import SeleniumCRMGUIFrameworkWithTestNG.generic.ObjectRepository.HomePage;
import SeleniumCRMGUIFrameworkWithTestNG.generic.ObjectRepository.OrganizationInfoPage;
import SeleniumCRMGUIFrameworkWithTestNG.generic.ObjectRepository.OrganizationsPage;
import SeleniumCRMGUIFrameworkWithTestNG.generic.simple.BaseTest.BaseClass;

public class CreateContactTest extends BaseClass {

	@Test
	public void createContactTest() throws Throwable {
		// Read data From Excel File
		String firstName = eLib.getDataFromExcel("contact", 1, 2) + jLib.getRandomNumber(); // To Generate random Number
		String lastName = eLib.getDataFromExcel("contact", 1, 3);
		// step 1 : Navigate To Contact Module
		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();
		// step 2 : Click on Create Contact Button
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateNewContactBtn().click();
		// step 3 : Enter all the details and create new contact
		CreatingNewContactPage cncp = new CreatingNewContactPage(driver);
		cncp.createContact(firstName, lastName);
		Thread.sleep(3000);
		// Step 4 : Verify Contact Name info Expected Result
		ContactInfoPage cip = new ContactInfoPage(driver);
		String actContactName = cip.getHeaderMsg().getText();
		if (actContactName.contains(lastName)) {
			System.out.println(lastName + " information is verified==PASS");
		} else {
			System.out.println(lastName + " information isn't verified==FAIL");
		}
		if (actContactName.contains(firstName)) {
			System.out.println(firstName + " information is verified==PASS");
		} else {
			System.out.println(firstName + " information isn't verified==FAIL");
		}
	}

	@Test
	public void createContactWithSupportDateTest() throws Throwable {
		// Read data From Excel File
		String firstName = eLib.getDataFromExcel("contact", 4, 2) + jLib.getRandomNumber(); // To Generate random Number
		String lastName = eLib.getDataFromExcel("contact", 4, 3);
		// step 1 : Navigate To Contact Module
		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();
		// step 2 : Click on Create Contact Button
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateNewContactBtn().click();
		// step 3 : Enter all the details and create new contact
		CreatingNewContactPage cncp = new CreatingNewContactPage(driver);
		String startDate = jLib.getSystemDateYYYYDDMM();
		String endDate = jLib.getRequiredDateYYYYDDMM(30);
		cncp.createContactWithSupportDate(firstName, lastName, startDate, endDate);
		Thread.sleep(3000);
		// Step 4 : Verify Date Details info Expected Result
		ContactInfoPage cip = new ContactInfoPage(driver);
		String actContactName = cip.getHeaderMsg().getText();
		if (actContactName.contains(lastName)) {
			System.out.println(lastName + " information is verified==PASS");
		} else {
			System.out.println(lastName + " information isn't verified==FAIL");
		}
		if (actContactName.contains(firstName)) {
			System.out.println(firstName + " information is verified==PASS");
		} else {
			System.out.println(firstName + " information isn't verified==FAIL");
		}
		String actStartDate = cip.getSupportStartDate().getText();
		if (actStartDate.contains(startDate)) {
			System.out.println(startDate + " information is verified==PASS");
		} else {
			System.out.println(startDate + " information isn't verified==FAIL");
		}
		String actEndDate = cip.getSupportEndDate().getText();
		if (actEndDate.contains(endDate)) {
			System.out.println(endDate + " information is verified==PASS");
		} else {
			System.out.println(endDate + " information isn't verified==FAIL");
		}
	}

	@Test
	public void createContactWithOrgTest() throws Throwable {
		// Read data From Excel File
		String orgName = eLib.getDataFromExcel("contact", 7, 2) + jLib.getRandomNumber();// To Generate random Number
		String firstName = eLib.getDataFromExcel("contact", 7, 3) + jLib.getRandomNumber();
		String lastName = eLib.getDataFromExcel("contact", 7, 4);
		// step 1 : Navigate To Organization Module
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
		// step 2 : Click on Create Organization Button
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();
		// step 3 : Enter all the details and create new organization
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrg(orgName);
		Thread.sleep(3000);
		// Step 4 : Verify Header Message Expected Result
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String headerInfo = oip.getHeaderMsg().getText();
		if (headerInfo.contains(orgName)) {
			System.out.println(orgName + " Header Is Verified==PASS");
		} else {
			System.out.println(orgName + " Header Is Verified==FAIL");
		}
		// Step 5 : Navigate To Contact Module
		hp.getContactLink().click();
		// step 6 : Click on Create Contact Button
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateNewContactBtn().click();
		// step 7 : Enter all the details and create new contact
		CreatingNewContactPage cncp = new CreatingNewContactPage(driver);
		String startDate = jLib.getSystemDateYYYYDDMM();
		String endDate = jLib.getRequiredDateYYYYDDMM(30);
		cncp.createContactWithOrg(firstName, lastName, startDate, endDate, orgName);
		Thread.sleep(3000);
		// Step 8 : Verify Header Message Expected Result For Contact
		ContactInfoPage cip = new ContactInfoPage(driver);
		String actContactName = cip.getHeaderMsg().getText();
		if (actContactName.contains(lastName)) {
			System.out.println(lastName + " information is verified==PASS");
		} else {
			System.out.println(lastName + " information isn't verified==FAIL");
		}
		if (actContactName.contains(firstName)) {
			System.out.println(firstName + " information is verified==PASS");
		} else {
			System.out.println(firstName + " information isn't verified==FAIL");
		}
		String actOrgName = cncp.getOrgName().getText();
		if (actOrgName.trim().equals(orgName)) {
			System.out.println(orgName + " information is created==PASS");
		} else {
			System.out.println(orgName + " information isn't created==FAIL");
		}
		String actStartDate = cip.getSupportStartDate().getText();
		if (actStartDate.contains(startDate)) {
			System.out.println(startDate + " information is verified==PASS");
		} else {
			System.out.println(startDate + " information isn't verified==FAIL");
		}
		String actEndDate = cip.getSupportEndDate().getText();
		if (actEndDate.contains(endDate)) {
			System.out.println(endDate + " information is verified==PASS");
		} else {
			System.out.println(endDate + " information isn't verified==FAIL");
		}
	}
	
}
