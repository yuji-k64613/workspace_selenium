package com.sample;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

// PATH=$PATH:$(pwd)/bin
// java -jar lib/selenium-server-standalone-3.4.0.jar
// mvn install -Dmaven.test.skip=true
public class SeleniumTest {
	private WebDriver driver;

	private WebDriver getWebDriver() {
		// return new FirefoxDriver();
		WebDriver driver = null;
		DesiredCapabilities firefox = DesiredCapabilities.firefox();
		try {
			//driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), firefox);
			driver = new RemoteWebDriver(new URL("http://192.168.100.149:4444/wd/hub"), firefox);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driver;
	}

	@Before
	public void beforeTest() {
		driver = getWebDriver();
		System.setProperty("webdriver.gecko.driver", "/Users/konishiyuji/workspaces/selenium/bin");
	}

	@Test
	public void open() {
		driver.get("https://search.maven.org/");
	}

	@After
	public void afterTest() {
		driver.quit();
	}

}
