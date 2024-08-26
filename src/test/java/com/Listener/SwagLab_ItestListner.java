package com.Listener;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.MainBase.BaseClass;
import com.aventstack.extentreports.MediaEntityBuilder;

public class SwagLab_ItestListner extends BaseClass implements ITestListener   {
	public String testName;
	public String methodName;
	@Override
	public void onFinish(ITestContext arg0) {
	
	}

	@Override
	public void onStart(ITestContext arg0) {
		
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		try {
			SwagLab_ExtentReport.extenttest.fail(result.getMethod().getMethodName() + " : " + "Test Failed",
					MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		
		
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		try {
			SwagLab_ExtentReport.extenttest.pass(result.getMethod().getMethodName() + " : " + "Test Pass",
					MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
