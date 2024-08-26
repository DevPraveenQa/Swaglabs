package com.Properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class SwagLab_ConfigReader {
	static FileInputStream fis;
	static Properties pp;
	

	private Properties getData() throws IOException {

		File file = new File("C:\\Users\\DELL\\Vadapalani_Java\\SwagLabs\\src\\main\\java\\com\\Properties\\SwagLabDatas.properties");
		
		fis = new FileInputStream(file);
		
		pp= new Properties();
		
		pp.load(fis);
		
		return pp;

	}

	public String getBrowser() throws IOException {

		String browser = getData().getProperty("browser");
		
		return browser;
	}

	public String geturl() throws IOException {
		String url = getData().getProperty("url");
		return url;
	}

	public String getuserName() throws IOException {
		String username = getData().getProperty("validUserName");
		return username;
	}

	public String getpassword() throws IOException {
		String password = getData().getProperty("validPassword");
		return password;
	}

	public String getverifyPage1Text() throws IOException {
		String vfp1 = getData().getProperty("verifyproductPage1text");
		return vfp1;
	}

	public String getverifyPage2Text() throws IOException {
		String vfp2 = getData().getProperty("verifyyourCardpage2text");
		return vfp2;
	}

	public String getverifyPage3Text() throws IOException {
		String vfp3 = getData().getProperty("verifyYourConfirmPage3text");
		return vfp3;
	}

	public String getverifyPage4Text() throws IOException {
		String vfp4 = getData().getProperty("verifyOverViewPage4Text");
		return vfp4;
	}

	public String getfirstName() throws IOException {
		String firstname = getData().getProperty("FirstName");
		return firstname;
	}

	public String getlastName() throws IOException {
		String lastname = getData().getProperty("Lastname");
		return lastname;
	}

	public String getpincode() throws IOException {
		String pincode = getData().getProperty("pincode");
		return pincode;
	}

	public String getverifyLastPage() throws IOException {
		String vlp = getData().getProperty("verifylastConfirmText");
		return vlp;
	}
	
	public static void main(String[] args) throws IOException {
		SwagLab_ConfigReader s = new SwagLab_ConfigReader();
		System.out.println(s.getBrowser());
		System.out.println(s.geturl());
		System.out.println(s.getuserName());
		System.out.println(s.getpassword());
		System.out.println(s.getverifyLastPage());
		
	}

}
