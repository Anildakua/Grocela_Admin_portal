package UtilityPackage;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class listnerClass extends BaseClass implements ITestListener 
{
	public ExtentSparkReporter sparkrepoter; //Path and UI of the report
	public ExtentReports reports;            //A details in side the document
	public ExtentTest test;
	
	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		//ITestListener.super.onStart(context);
		sparkrepoter =new ExtentSparkReporter("./ExtendRepots/Glocela.html");
		sparkrepoter.config().setDocumentTitle("GROCELA");
		sparkrepoter.config().setReportName("Admin Portal");
		sparkrepoter.config().setTheme(Theme.DARK);
		
		reports=new ExtentReports();
		reports.attachReporter(sparkrepoter);
		reports.setSystemInfo("Application", "GLOCELA");
		reports.setSystemInfo("module", "Admin");
		reports.setSystemInfo("Username", System.getProperty("user.name"));
		reports.setSystemInfo("Enviroment", "QA"); 
		
		
		
	}
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
		test=reports.createTest(result.getName())
		.assignAuthor("Anil")
		.assignCategory("Fuctional")
		.assignDevice("Chrome");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestSuccess(result);
		test.log(Status.PASS, "The Test Case Pass :"+result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailure(result);
		test.log(Status.FAIL,"The Test Case Is Fail"+ result.getName());
		
		File oldFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File newFile=new File("./Screanshot/"+result.getName()+".png");
		try 
		{
			FileUtils.copyFile(oldFile, newFile);
		}
		catch (IOException e)
		{
			System.out.println("Its not takes the screan short :"+e);
		}
		//test.addScreenCaptureFromPath(newFile.getAbsolutePath())   //  this is for test level
		test.fail(MediaEntityBuilder.createScreenCaptureFromPath(newFile.getAbsolutePath()).build()); //this is for log level
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
		test.log(Status.SKIP,"The Test Case Is Skip"+ result.getName());
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
		reports.flush();
	}

	
	
}
