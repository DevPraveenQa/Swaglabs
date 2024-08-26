package com.pom;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.MainBase.BaseClass;
import com.ObjectManager.MainObjectManager;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.elementInterface.SwagLab_ElementInterface;

public class SwagLab_LoginPage extends BaseClass implements SwagLab_ElementInterface {

	MainObjectManager mom = new MainObjectManager();
//	public static WebDriver logindriver;

	@FindBy(xpath = loginpage_username_xpath)
	private WebElement userName;

	@FindBy(id = loginpage_password_id)
	private WebElement Password;

	@FindBy(xpath = loginpage_loginBtn_xpath)
	private WebElement loginBtn;
	
	@FindBy(xpath = verify_ProductPage1_xpath)
	private WebElement verify_ProductPage1;
	
	


	public SwagLab_LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean testlogin(ExtentTest extenttest) throws IOException {
		try {
			getUrl(mom.getSwagLab_ConfigReader().geturl());
			sendkeys(userName, mom.getSwagLab_ConfigReader().getuserName());
			sendkeys(Password, mom.getSwagLab_ConfigReader().getpassword());
			click(loginBtn);
			System.out.println(verify_ProductPage1.getText());
			
			Assert.assertEquals(verify_ProductPage1.getText(),mom.getSwagLab_ConfigReader().getverifyPage1Text() );
			System.out.println("login successfull and successfully verify the Product page");
			extenttest.log(Status.PASS,"login successfull and successfully verify the Product page" );
		
		} catch (IOException e) {
			extenttest.log(Status.FAIL, "Login Failed" + e.getMessage());
			return false;
		}
		return true;

	}

}
