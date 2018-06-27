package core;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

	public static void main(String[] args) {
		Logger.getLogger("").setLevel(Level.OFF);

		System.out.println("Browser: HtmlUnit");
		HtmlUnit.test();

		System.out.println("Browser: Chrome");
		Chrome.test();

		System.out.println("Browser: Firefox");
		Firefox.test();

		System.out.println("Browser: Edge");
		Edge.test();
	}

}
