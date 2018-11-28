package in.licious.dataplanning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Chromeclass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String os = System.getProperty("os.name").toLowerCase();
		
		System.out.println(os);
		
		WebDriver driver = new ChromeDriver();
		
		if (os.contains("mac")) {
			
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/BrowserDrivers/chromedriver");
			
		}else {
			
			System.out.println("Your OS is Windows");
		}
		
		driver.get("http:www.google.com");

	}

}
