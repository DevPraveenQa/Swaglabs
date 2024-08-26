package com.Listener;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.MainBase.BaseClass;
import com.aventstack.extentreports.ExtentTest;

public class SwagLab_ExtentReport {
	
	
	public static ExtentTest extenttest;

	@BeforeSuite
	public void extentTestReportStartup()throws IOException {
		BaseClass base = new BaseClass();
		base.extentReportStart(null);
	}

	@AfterSuite
	public void extentReportEnd() throws IOException {
		BaseClass base = new BaseClass();
		base.extentReportTearDown(null);
	}


}
