package com.MainBase;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public  class BaseClass {
	
	public static WebDriver driver;
	
	public static ExtentReports extentReports;
	public static File file;
	

	// 1(browserLaunch)
	public static WebDriver browserLauncher(String Browser ) {

		try {
			if (Browser.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
			} else if (Browser.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();

			} else if (Browser.equalsIgnoreCase("edge")) {
				driver = new EdgeDriver();
			} else if (Browser.equalsIgnoreCase("ie")) {
				driver = new InternetExplorerDriver();

			} else {
				System.out.println("only available browser :chrome,edge,firefox,ie ");
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		} catch (Exception e) {

			e.printStackTrace();
		}
		return driver;

	}

// 2 get()
	public static WebDriver getUrl(String url) {
		driver.get(url);
		return driver;
	}

// 3 getCurrentUrl()
	public static void getCurrentURL() {

		String currentUrl = driver.getCurrentUrl();
		System.out.println("current page URL ---> =" + currentUrl);
	}

//4 getTitle()
	public static void title() {
		String title = driver.getTitle();
		System.out.println("current page titile ----> =" + title);

	}

	// 5 quite()
	public static void Quite() {
		driver.quit();
	}

	// 6 close()
	public static void close() {
		driver.close();

	}

	// 7 getPageSource()
	public static void pageSource() {
		String pageSource = driver.getPageSource();
		System.out.println("current page sorce--> =" + pageSource);
	}

	// 8 navigate
	public static void navigate(String command, String url) {
		if (command.equalsIgnoreCase("back")) {
			driver.navigate().back();
		} else if (command.equalsIgnoreCase("forward")) {
			driver.navigate().forward();
		} else if (command.equalsIgnoreCase("refresh")) {
			driver.navigate().refresh();
		} else if (command.equalsIgnoreCase("to")) {
			driver.navigate().to(url);
		} else {
			System.out.println();
			System.out.println("navigate method eror:");
			System.out.println("please enter only= back,forward,refresh,To");
		}
	}

	// 9 clear()
	public static void clear(WebElement element) {
		if (element != null) {
			element.clear();
		} else {
			throw new IllegalArgumentException("WebElement is null.");
		}

	}

	// 10 click()
	public static void click(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();

	}

	// 11 sendkey()
	public static void sendkeys( WebElement element, String values) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.sendKeys(values);
	
	}

	// 12 getText()
	public static void gettext(WebElement element) {
		String text = element.getText();
		System.out.println(text);

	}

	// screenshot
	public static void screenshot(String imageName)  {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File desFile = new File("C:\\Users\\DELL\\Vadapalani_Java\\Adactin\\screenshot\\" + imageName + ".png");
		try {
			FileUtils.copyFile(source, desFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// dropdown
	public static void dropdown( WebElement element, String name, String value, int index) {

		if (name.equalsIgnoreCase("SelectByIndex")) {
			Select selectbyindex = new Select(element);
			selectbyindex.selectByIndex(index);
		} else if (name.equalsIgnoreCase("SelectByValue")) {
			Select selectBYValue = new Select(element);
			selectBYValue.selectByValue(value);
		} else if (name.equalsIgnoreCase("SelectByVisibleText")) {
			Select selectByvisibleText = new Select(element);
			selectByvisibleText.selectByVisibleText(value);
		} else {
			System.out.println("please select correct dropdown");
		}

	}
	public static void extentReportStart(String location) {
		extentReports = new ExtentReports();
		file = new File(location);
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
		extentReports.attachReporter(sparkReporter);
		extentReports.setSystemInfo("OS", System.getProperty("os.name"));
		extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
	}

	public void extentReportTearDown(String location)  {
		extentReports.flush();
		file = new File(location);
		try {
			Desktop.getDesktop().browse((file).toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String takeScreenshot() throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		File scrfile = screenshot.getScreenshotAs(OutputType.FILE);
		File destfile = new File("Screenshort\\.png" + "_" + timeStamp + ".png");
		FileUtils.copyFile(scrfile, destfile);
		return destfile.getAbsolutePath();
	}
	
	
	
	public static void implicityWait(int timeset) {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeset));
		
		
	}
	
	public static void javascriptClick(WebElement element) {
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element );
		
	}
	

	// alert
	// unhhandledalerException//NoAlertException

//	public static void alert(String alertname, AlertsActions alertaction) {
//		Alert alert = driver.switchTo().alert();
//		if (alertname.equalsIgnoreCase("simpleAlert")) {
//			alert.accept();
//		} else if (alertname.equalsIgnoreCase("confirmAlertAccept")) {
//			
//				alert.accept();
//			} else if (alertname.equalsIgnoreCase("confirmAlertDismiss")) {
//				alert.dismiss();
//			}
//		}
		

		
		
		
		

//		driver.switchTo().alert().accept();
//		driver.switchTo().alert().dismiss();
//		driver.switchTo().alert().sendKeys(null);

	}

	// 13 getsize()
//	public static void getsize(WebElement element) {
//		Dimension size = element.getSize();
//		System.out.println(size);
//
//	}


