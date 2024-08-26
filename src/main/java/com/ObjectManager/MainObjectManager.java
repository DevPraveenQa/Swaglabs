package com.ObjectManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.MainBase.BaseClass;
import com.Properties.SwagLab_ConfigReader;
import com.pom.Product1;
import com.pom.SwagLab_LoginPage;

public class MainObjectManager extends BaseClass {

	private SwagLab_LoginPage al;
	private SwagLab_ConfigReader cr;
	private Product1 p1;
//	public MainObjectManager(WebDriver driver) {
//
//	this.driver = driver;
//	
//	}

	public SwagLab_LoginPage getLoginpage() {
		if (al == null) {
			al = new SwagLab_LoginPage(driver);
		}
		return al;
	}
	public Product1 getProduct1() {
		if (p1 == null) {
			p1 = new Product1(driver);
		}
		return p1;
	}

	public SwagLab_ConfigReader getSwagLab_ConfigReader() {
		if (cr == null) {
			cr = new SwagLab_ConfigReader();
		}
		return cr;
	}
	
//	private SwagLab_ConfigReader swagLab_ConfigReader;
//	
//	private com.pom.SwagLab_LoginPage swagLab_LoginPage;
//	
//	
//	public SwagLab_ConfigReader getSwagLab_ConfigReader() {
//
//		if (swagLab_ConfigReader == null) {
//			
//			swagLab_ConfigReader = new SwagLab_ConfigReader();
//		}
//		 
//		return swagLab_ConfigReader;
//	}
//	
//	public void getSwagLab_LoginPage() {
//
//		if (swagLab_LoginPage==null) {
//			
//			swagLab_LoginPage = new com.pom.SwagLab_LoginPage();
//			
//		}
//	}

}
