package com.pom;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.MainBase.BaseClass;
import com.ObjectManager.MainObjectManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.elementInterface.SwagLab_ElementInterface;

public class Product1 extends BaseClass implements SwagLab_ElementInterface {

	MainObjectManager mom = new MainObjectManager();

	@FindBy(xpath = select_1stproduct_A2Cbutton_xpath)
	private WebElement select_1stproduct_A2Cbutton;

	@FindBy(xpath = click_Bucket_xpath)
	private WebElement clickbucket;

	@FindBy(xpath = verify_1stProductName1st_xpath)
	private WebElement verify_1stProductName1st;

	@FindBy(xpath = Verify_yourcardPage2_xpath)
	private WebElement Verify_yourcardPage2;

	@FindBy(xpath = verify_1stProductName2nd_xpath)
	private WebElement verify_1stProductName2nd;

	@FindBy(id = click_Checout_id)
	private WebElement click_Checout;

	@FindBy(xpath = verify_informationPage3_xpath)
	private WebElement verify_informationPage3;

	@FindBy(id = send_firstName_id)
	private WebElement send_firstName;

	@FindBy(id = send_LastName_id)
	private WebElement send_LastName;

	@FindBy(id = send_pincode_id)
	private WebElement send_pincode;

	@FindBy(id = click_continue_id)
	private WebElement click_continue;

	@FindBy(xpath = verify_checkoutOverviewPage4_xpath)
	private WebElement verify_checkoutOverviewPage4;

	@FindBy(xpath = verify_1productName3rdtime_xpath)
	private WebElement verify_1productName3rdtime;

	@FindBy(id = click_finishbtn_id)
	private WebElement click_finishbtn;

	@FindBy(xpath = verify_Confirm_order_xpath)
	private WebElement verify_Confirm_order;

	@FindBy(name = go_backto_products_name)
	private WebElement go_backto_products;

	public Product1(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public boolean testAdd1stProduct(ExtentTest extenttest) throws IOException {
	try {
		javascriptClick(select_1stproduct_A2Cbutton);
		// click(select_1stproduct_A2Cbutton);
		click(clickbucket);
		Assert.assertEquals(Verify_yourcardPage2.getText(), mom.getSwagLab_ConfigReader().getverifyPage2Text());
		System.out.println("successfully verify 2nd page ");
		Assert.assertEquals(verify_1stProductName1st.getText(), verify_1stProductName2nd.getText());
		System.out.println(verify_1stProductName1st.getText());
		System.out.println("verify the product name 1pto2p");
		click(click_Checout);
		Assert.assertEquals(verify_informationPage3.getText(), mom.getSwagLab_ConfigReader().getverifyPage3Text());
		System.out.println("successfully verify 3rd page ");
		sendkeys(send_firstName, mom.getSwagLab_ConfigReader().getfirstName());
		sendkeys(send_LastName, mom.getSwagLab_ConfigReader().getlastName());
		sendkeys(send_pincode, mom.getSwagLab_ConfigReader().getpincode());
		click(click_continue);
		Assert.assertEquals(verify_checkoutOverviewPage4.getText(), mom.getSwagLab_ConfigReader().getverifyPage4Text());
		System.out.println("successfully verify 4th page ");
		Assert.assertEquals(verify_1stProductName1st.getText(), verify_1productName3rdtime.getText());
		System.out.println("successfully verify the product p1to3p");
		click(click_finishbtn);
		Assert.assertEquals(verify_Confirm_order.getText(), mom.getSwagLab_ConfigReader().getverifyLastPage());
		System.out.println("successfully verify order confirm & successfully order placed");
		click(go_backto_products);
		extenttest.log(Status.PASS,"verify the web pages and successfully  order 1'st product " );
		
	} catch (IOException e) {
		extenttest.log(Status.FAIL, "Login Failed" + e.getMessage());
		return false;
	}
	return true;

	}

}
