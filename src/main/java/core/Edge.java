package core;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Edge {

	private static final String DRIVER_PATH = "./resources/windows/MicrosoftWebDriver.exe";

	public static void test() {
		System.setProperty("webdriver.edge.driver", DRIVER_PATH);
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Common.performTest(driver);
		driver.quit();
	}
}
