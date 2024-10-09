package practice.testng.baseclass.assertions.orgtest;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import SeleniumCRMGUIFrameworkWithTestNG.generic.assertions.BaseTest.BaseClass;
import SeleniumCRMGUIFrameworkWithTestNG.generic.ObjectRepository.CreatingNewOrganizationPage;
import SeleniumCRMGUIFrameworkWithTestNG.generic.ObjectRepository.HomePage;
import SeleniumCRMGUIFrameworkWithTestNG.generic.ObjectRepository.OrganizationInfoPage;
import SeleniumCRMGUIFrameworkWithTestNG.generic.ObjectRepository.OrganizationsPage;

public class CreateOrganizationTest extends BaseClass {
	@Test
	public void createOrganizationTest() throws Throwable {
		String orgName = eLib.getDataFromExcel("org", 1, 2) + jLib.getRandomNumber(); // To Generate random Number
		// step 1 : Navigate To Organization Module
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
		// step 2 : Click on Create Organization Button
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();
		// step 3 : Enter all the details and create new organization
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrg(orgName);
		// Step 4 : Verify Header Message Expected Result
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actOrgName = oip.getHeaderMsg().getText();
		boolean status = actOrgName.contains(orgName);
		Assert.assertEquals(status,true); // Hard Assert
	}
	
	@Test
	public void createOrganizationWithIndustriesTest() throws Throwable {	
		SoftAssert AssertObj = new SoftAssert();  // Soft Assert Object Creation
		//Read data From Excel File
		String orgName = eLib.getDataFromExcel("org", 4, 2) + jLib.getRandomNumber(); // To Generate random Number;
		String industry = eLib.getDataFromExcel("org", 4, 3);
		String type = eLib.getDataFromExcel("org", 4, 4);
		// step 1 : Navigate To Organization Module
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
		// step 2 : Click on Create Organization Button
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();
		// step 3 : Enter all the details and create new organization
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrgWithIndustry(orgName, industry, type);
		Thread.sleep(3000);
		// Step 4 : Verify the industries,type and orgName info
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actOrgName = oip.getHeaderMsg().getText();
		boolean status = actOrgName.contains(orgName);
		Assert.assertEquals(status,true); // Hard Assert
		String actIndustries = oip.getIndustryName().getText();
		AssertObj.assertEquals(actIndustries, industry); // Soft Assert
		String actType = oip.getTypeName().getText();
		AssertObj.assertEquals(actType, type); // Soft Assert
		AssertObj.assertAll();
	}
	
	@Test
	public void createOrganizationWithPhoneNumberTest() throws Throwable {
		SoftAssert AssertObj = new SoftAssert();  // Soft Assert Object Creation
		// Read data From Excel File
		String orgName = eLib.getDataFromExcel("org", 7, 2) + jLib.getRandomNumber(); // To Generate random Number;
		String phoneNumber = eLib.getDataFromExcel("org", 7, 3);
		// step 1 : Navigate To Organization Module
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
		// step 2 : Click on Create Organization Button
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();
		// step 3 : Enter all the details and create new organization
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrgWithPhone(orgName, phoneNumber);
		Thread.sleep(3000);
		// Step 4 : Verify the phonenumber and org name info
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actPhoneNumber = oip.getPhoneNo().getText();
		AssertObj.assertEquals(actPhoneNumber, phoneNumber); // Soft Assert
		String actOrgName = oip.getHeaderMsg().getText();
		boolean status = actOrgName.contains(orgName);
		Assert.assertEquals(status,true); // Hard Assert
		AssertObj.assertAll();
	}

}
