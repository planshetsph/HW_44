package core;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Common {

	public static final String[] URLS = new String[] { "http://alex.academy/exe/payment_tax/index.html",
			"http://alex.academy/exe/payment_tax/index2.html", "http://alex.academy/exe/payment_tax/index3.html",
			"http://alex.academy/exe/payment_tax/index4.html", "http://alex.academy/exe/payment_tax/index5.html",
			"http://alex.academy/exe/payment_tax/indexE.html" };

	public static String regex = "^(?:.*?)?(?:\\$*)?(?:\\s*)?((?:\\d*)|(?:\\d*)(?:\\.)(?:\\d*))(?:\\s*)?(?:[/]*|,\\s*[A-Z]*[a-z]*\\s*[:]*)?"
			+ "(?:\\s*)?((?:\\d*)|(?:\\d*)(?:\\.)(?:\\d*))(?:\\s*)?(?:%)?(?:\\s*)?$";

	public static void performTest(WebDriver driver) {
		for (String url : URLS) {
			driver.get(url);

			String strMonthlyPaymentAndTax = driver.findElement(By.id("id_monthly_payment_and_tax")).getText();

			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(strMonthlyPaymentAndTax);
			m.find();

			double monthlyPayment = Double.parseDouble(m.group(1));
			double tax = Double.parseDouble(m.group(2));
			double monthlyAndTaxAmount = new BigDecimal((monthlyPayment * tax) / 100).setScale(2, RoundingMode.HALF_UP)
					.doubleValue();
			double monthly_payment_with_tax = new BigDecimal(monthlyPayment + monthlyAndTaxAmount)
					.setScale(2, RoundingMode.HALF_UP).doubleValue();
			double annualPaymentWithTax = new BigDecimal(monthly_payment_with_tax * 12)
					.setScale(2, RoundingMode.HALF_UP).doubleValue();

			driver.findElement(By.id("id_annual_payment_with_tax")).sendKeys(String.valueOf(annualPaymentWithTax));
			driver.findElement(By.id("id_validate_button")).submit();

			String actualResult = driver.findElement(By.id("id_result")).getText();

			System.out.println();
			System.out.println("String: \t\t" + strMonthlyPaymentAndTax);
			System.out.println("Annual Payment with Tax: " + annualPaymentWithTax);
			System.out.println("Result: \t\t" + actualResult);
			System.out.println("___________________________________________________");
		}
	}

}
