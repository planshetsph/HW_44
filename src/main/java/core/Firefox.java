package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Firefox {
	private static final String DRIVER_PATH = "./resources/windows/geckodriver.exe";

	public static void test() {

		System.setProperty("webdriver.gecko.driver", DRIVER_PATH);

		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("dom.webnotifications.enabled", false);
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability(FirefoxDriver.PROFILE, profile);
		FirefoxOptions options = new FirefoxOptions();
		options.merge(capabilities);

		WebDriver driver = new FirefoxDriver(options);
		driver.manage().window().maximize();
		Common.performTest(driver);
		driver.quit();
	}
}
