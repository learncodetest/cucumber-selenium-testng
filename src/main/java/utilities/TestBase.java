package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class TestBase {

	private String configFile;
	private FileInputStream fis;
	protected WebDriver driver;
	protected Properties prop;
	private String browser;
	private String appURL;

	@Before
	public void setup() throws IOException {
		try {
			configFile = "/java-selenium-cucumber/src/test/resources/config.properties";
			fis = new FileInputStream(configFile);
			prop.load(fis);
		} finally {
			try {
				if (fis != null) {
					fis.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		browser = prop.getProperty("browser");
		if (browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromeDriverPath"));
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", prop.getProperty("geckoDriverPath"));
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", prop.getProperty("ieDriverPath"));
			driver = new InternetExplorerDriver();
		}
		
		appURL = prop.getProperty("url");
		driver.get(appURL);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
	}
	
	@After
	public void tearDown(){
		if (driver != null){
		driver.quit();
		}
	}
}