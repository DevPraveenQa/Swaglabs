package com.TestRunner;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Listener.SwagLab_ExtentReport;
import com.Listener.SwagLab_ItestListner;
import com.MainBase.BaseClass;
import com.ObjectManager.MainObjectManager;
@Listeners(SwagLab_ItestListner.class)
public class Runner_SwagLab extends BaseClass {
	MainObjectManager mom = new MainObjectManager();
	
	@BeforeSuite
	public void stertTest() {
	extentReportStart("C:\\Users\\DELL\\Vadapalani_Java\\SwagLabs\\Reports");
	}
	
	@BeforeTest
	private void browserlaunch() throws IOException {
		browserLauncher(mom.getSwagLab_ConfigReader().getBrowser());
	}

	@Test(priority = 0)
	private void login() throws IOException {

		SwagLab_ExtentReport.extenttest=extentReports
		.createTest("LoginTest" + ": " + Thread.currentThread().getStackTrace()[1].getMethodName().toString())
		.info("Valid Emailid With Valid Password");
		
		Assert.assertTrue(mom.getLoginpage().testlogin(SwagLab_ExtentReport.extenttest));
		
		
	}
	
	@Test(priority = 1)
	private void testProduct1() throws IOException {
		SwagLab_ExtentReport.extenttest=extentReports
				.createTest("1st product ADD Test" + ": " + Thread.currentThread().getStackTrace()[1].getMethodName().toString())
				.info("add 1 st product and verify the web pages");
	Assert.assertTrue(mom.getProduct1().testAdd1stProduct(SwagLab_ExtentReport.extenttest));
	}
	
	@AfterTest
	public void closebrowser() {
		Quite();
	}
	
	@AfterSuite
	public void endTest() throws IOException {
	extentReportTearDown("C:\\Users\\DELL\\Vadapalani_Java\\SwagLabs\\Reports\\index.html");
	}

}
