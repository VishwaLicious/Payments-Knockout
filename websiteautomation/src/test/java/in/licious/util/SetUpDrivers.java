package in.licious.util;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
<<<<<<< HEAD
 import org.openqa.selenium.firefox.FirefoxDriver;
=======
//import org.openqa.selenium.firefox.FirefoxDriver;
>>>>>>> branch 'knockout' of https://github.com/VishwaLicious/Payments-Knockout.git
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class SetUpDrivers {
	private  WebDriver driver;
	public  WebDriver launchFirefoxDriver(String url){
		
		// This is for windows
		//System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\BrowserDrivers\\geckodriver.exe");
		
		// This for mac
		System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/BrowserDrivers/geckodriver");
		
		//System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"C:\\Users\\Sriya\\git\\Payments-Knockout\\websiteautomation\\BrowserDrivers\\geckodriver.exe");
<<<<<<< HEAD
		driver=new FirefoxDriver();
=======
		//driver=new FirefoxDriver();
>>>>>>> branch 'knockout' of https://github.com/VishwaLicious/Payments-Knockout.git
		driver.get(url);
		return driver;
	}
	public  WebDriver launchChromeDriver(String url){
		
		/*// This is for Windows os
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\BrowserDrivers\\chromedriver.exe");
		*/
		
		// This is for Mac os
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/BrowserDrivers/chromedriver");
		
		
	//	System.setProperty("webdriver.chrome.driver",System.getProperty("/Users/Vishwa/Downloads/SeleniumWebDriver-master/BrowserDrivers/chromedriver"));
		
		ChromeOptions options=new ChromeOptions();
		options.addArguments("start-maximized");
		driver=new ChromeDriver(options);
		driver.get(url);
		return driver;
	}
	public  WebDriver launchInternetExplorerDriver(String url){
		System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"\\BrowserDrivers\\IEDriverServer.exe");
		driver=new InternetExplorerDriver();
		driver.get(url);
		return driver;		
	}
	public  WebDriver launchEdgeDriver(String url){
		driver=new EdgeDriver();
		driver.get(url);
		return driver;		
	}
	public  WebDriver launchOperaDriver(String url){
		driver=new OperaDriver();
		driver.get(url);
		return driver;		
	}
	public  WebDriver launchSafariDriver(String url){
		driver=new SafariDriver();
		driver.get(url);
		return driver;		
	}
	public  WebDriver	launchRemoteDriver(String remoteAddress,String url,Capabilities capabilities){
		try {
			driver=new RemoteWebDriver(new URL(remoteAddress), capabilities);
			driver.get(url);
			return driver;
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
			return null;
		}
		
	}
}
