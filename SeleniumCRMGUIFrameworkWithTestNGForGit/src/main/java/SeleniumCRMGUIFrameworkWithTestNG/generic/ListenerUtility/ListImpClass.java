package SeleniumCRMGUIFrameworkWithTestNG.generic.ListenerUtility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import SeleniumCRMGUIFrameworkWithTestNG.generic.listeners.BaseTest.BaseClass;

public class ListImpClass implements ITestListener , ISuiteListener {
	public void onStart(ISuite suite) {
		System.out.println("Report Configuration");
	}

	public void onFinish(ISuite suite) {
		System.out.println("Report BackUp");
	}

	public void onTestStart(ITestResult result) {
		System.out.println("===== ======>" + result.getMethod().getMethodName() + ">===START======");
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("===== ======>" + result.getMethod().getMethodName() + ">===END======");
	}

	public void onTestFailure(ITestResult result){
		String testName = result.getMethod().getMethodName();
		//Takes Screenshot
		TakesScreenshot ts = (TakesScreenshot)BaseClass.sdriver;
		File srcFile=ts.getScreenshotAs(OutputType.FILE);
		String time = new Date().toString().replace(" ","_").replace(":","_");
		try {
			FileUtils.copyFile(srcFile, new File("./Screenshots/"+testName+ "+"+time+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}
	
	public void onStart(ITestContext context) {
		
	}
	
	public void onFinish(ITestContext context) {
		
	}
}

