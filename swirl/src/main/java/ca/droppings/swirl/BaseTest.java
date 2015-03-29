package ca.droppings.swirl;

/*
 *  shamlessly swiped from: http://seleniumeasy.com/selenium-tutorials/simple-page-object-model-framework-example
 *  and the mercilessly hacked to pieces
 *
 *  
 */
import java.util.Properties;

// import junit.framework.TestCase;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

 

public class BaseTest {

	
		protected static Properties props = new Properties();
		public WebDriver driver;
		static String driverPath = "D:\\chromedriver\"";
		private static String browserType;
		
		
		public WebDriver getDriver() {
			return driver;
		}

		public void setDriver(String browserType) {
			
			
			if (browserType.toUpperCase().equals("CHROME")) {
				driver = initChromeDriver();
			}
			else if (browserType.toUpperCase().equals("FIREFOX")) {
				driver = initFirefoxDriver();
			}
			else if (browserType.toUpperCase().equals("PHANTOMJS")) {
				driver = initPhantomJsDriver();
			}
			else {
				// System.out.println("browser : " + browserType + " is invalid, Launching Firefox as browser of choice..");
				driver = initFirefoxDriver();
			}
		}

		private static WebDriver initChromeDriver() {
			//System.out.println("Launching google chrome with new profile..");
			System.setProperty("webdriver.chrome.driver", driverPath
					+ "chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			return driver;
		}

		private static WebDriver initFirefoxDriver() {
			//System.out.println("Launching Firefox browser..");
			WebDriver driver = new FirefoxDriver();
			return driver;
		}
		 
		private static WebDriver initPhantomJsDriver() {
			//System.out.println("Launching PhantomJs headless browser..");
			WebDriver driver = new PhantomJSDriver();
			return driver;
		}
		
		public void initializeBaseTest(String browserType) {
			try {
				setDriver(browserType);
			} catch (Exception e) {
				System.out.println("Error....." + e.getStackTrace());
			}
		}
		 
		@Before 
		public void setUp() {
			setDriver(browserType);
			driver = getDriver();
		}
		@After 
		public void tearDown() {
			driver.quit();
		}
		@BeforeClass
		public static void beforeClass() {
			browserType = props.getProperty("doesnt.exist.yet","phantomjs");
		}
		@AfterClass
		public static void afterClass() {
			//System.out.println("after class does nada now");
		}
	 
}

