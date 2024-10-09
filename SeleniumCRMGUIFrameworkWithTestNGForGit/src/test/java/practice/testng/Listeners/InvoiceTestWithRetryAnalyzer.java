package practice.testng.Listeners;

import org.testng.Assert;
import org.testng.annotations.Test;

public class InvoiceTestWithRetryAnalyzer {

	@Test(retryAnalyzer=SeleniumCRMGUIFrameworkWithTestNG.generic.ListenerUtility.RetryListenerImpClass.class)
	//Retry Analyzer is used to retry only the failed scripts
	public void activateSim() {
		System.out.println("execute createInvoiceTest");
		Assert.assertEquals("","Login");
		System.out.println("Step-1");
		System.out.println("Step-2");
		System.out.println("Step-3");
		System.out.println("Step-4");
	}
}
