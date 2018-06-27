package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Chrome {

	private static final String DRIVER_PATH = "./resources/windows/chromedriver.exe";

	public static void test() {
		System.setProperty("webdriver.chrome.driver", DRIVER_PATH);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		options.addArguments("--disable-notifications");
		options.addArguments("--start-maximized");

		WebDriver driver = new ChromeDriver(options);
		Common.performTest(driver);
		driver.quit();
	}
}
