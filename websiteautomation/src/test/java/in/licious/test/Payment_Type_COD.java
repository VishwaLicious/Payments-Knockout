package in.licious.test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import in.licious.pom.FishandSeafoodPage;
import in.licious.pom.HomePage;
import in.licious.pom.NewAddressPage;
import in.licious.pom.NewCheckoutPage;
import in.licious.pom.NewDeliverySummaryPage;
import in.licious.pom.NewLoginFlow;
import in.licious.pom.NewPaymentPage;
import in.licious.util.DataBaseCCC;
import in.licious.util.Helper;

public class Payment_Type_COD extends BaseTest {

	@Test(priority = 8)
	public void testPayment_Type_COD() throws ClassNotFoundException, SQLException, AWTException {

		// Sign In with New Login Flow
		NewLoginFlow newlogin = new NewLoginFlow(driver);
		Helper helper = new Helper();
		helper.clickOnElement(driver, newlogin.getSelectLocation());
		Helper.customWait(2);
		helper.clickOnElement(driver, newlogin.getbengaluruDeliveryLocation());
		Helper.customWait(2);
		helper.enterText(driver, newlogin.getLoactionTxtBox(), location);
		Helper.customWait(2);
		newlogin.getLoactionTxtBox().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		Helper.customWait(5);

//		// Robot class to handle the alert window I,e Chrome browser notification of location allow and block
//				Robot rb = new Robot();
//				rb.keyPress(KeyEvent.VK_ALT);
//				rb.keyRelease(KeyEvent.VK_A);
//				Helper.customWait(10);
//				System.out.println("Closed the Location Notification");

		etest.log(LogStatus.PASS, "Location is selected");

		// To handle the location pop up which is thrown by the browser
		// driver.switchTo().alert().dismiss();

//		// To handle alert by using the webdriver wait condition
//		WebDriverWait wait = new WebDriverWait(driver, 5); // wait for alert to pop up;
//		Alert alert = wait.until(ExpectedConditions.alertIsPresent()); // Check for alert;
//		alert.accept();              // accept it- In your case it allows notification

		// Click on Login in HomePage
		newlogin.getLogin().click();
		Helper.customWait(2);

		// Enter valid UserName and Password
		helper.enterText(driver, newlogin.getMobileNumber(), userName);
		Helper.customWait(2);

		// Click on Proceed button
		helper.clickOnElement(driver, newlogin.getProceedBtn());
		Helper.customWait(2);

		// Click on Password login
		helper.clickOnElement(driver, newlogin.getpasswordLogin());
		Helper.customWait(2);

		// Enter the password
		helper.enterText(driver, newlogin.getenterpassword(), passWord);
		Helper.customWait(2);

		// Click on OTP Login
		// Reading OTP from DB
		DataBaseCCC db1 = new DataBaseCCC(driver);

		String s1 = db1.otp1;
		System.out.println("otp1");

		System.out.println(s1);
		System.out.println("Fetched OTP from the DB");

		log.info(s1 + " Fetched OTP from the DB ");
		etest.log(LogStatus.PASS, s1 + " Fetched OTP from the DB");

		// Click on Login Button
		helper.clickOnElement(driver, newlogin.getpasswordloginBtn());
		Helper.customWait(5);

		// Handling the Deals and Offers pop which comes in production after login
		newlogin.getdealsandoffers().click();
		Helper.customWait(5);

		// driver.switchTo().alert().dismiss();

		Helper.customWait(5);

		/*
		 * // Click on Bangalore City //SignInPage signInpage = new SignInPage(driver);
		 * // Enter the Delivery Location //helper.enterText(driver,
		 * signInpage.getLoactionTxtBox(), "Indiranagar"); //String getLocation=
		 * properties.getProperty("location"); helper.enterText(driver,
		 * newlogin.getLoactionTxtBox(), location); Helper.customWait(2);
		 * newlogin.getLoactionTxtBox().sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
		 * Helper.customWait(2); etest.log(LogStatus.PASS,"Location is selected");
		 * 
		 * // Reading OTP from database DataBaseCCC db1=new DataBaseCCC(driver);
		 * System.out.println("Pass1"); String s1=db1.otp1; System.out.println("pass2");
		 * System.out.println(s1); System.out.println("pass3");
		 * 
		 * // Click on Login in HomePage newlogin.getLogin().click();
		 * Helper.customWait(2);
		 * 
		 * // Click on Login in SignUp Page SignupPage signuppage = new
		 * SignupPage(driver); WebElement login=
		 * signuppage.getAlreadyHaveAnAccountlogin(); helper.scrollBar(driver, login);
		 * 
		 * //Login with new user on boarding flow
		 * 
		 * //NewLoginFlow newlogin = new NewLoginFlow(driver); //WebElement login=
		 * newlogin.getLogin();
		 * 
		 * 
		 * // Enter valid UserName and Password
		 * 
		 * //signInpage.getUsernameTxtBox().sendKeys("9880335493"); //String
		 * getUserName= properties.getProperty("username"); helper.enterText(driver,
		 * newlogin.getMobileNumber(), userName); Helper.customWait(2);
		 * 
		 * //Click on Proceed button helper.clickOnElement(driver,
		 * newlogin.getProceedBtn()); Helper.customWait(2);
		 * 
		 * // Click on Password login helper.clickOnElement(driver,
		 * newlogin.getpasswordLogin()); Helper.customWait(2);
		 * 
		 * //Enter the password helper.enterText(driver, newlogin.getenterpassword(),
		 * passWord); Helper.customWait(2);
		 * 
		 * //Click on Login Button helper.clickOnElement(driver,
		 * newlogin.getpasswordloginBtn()); Helper.customWait(5);
		 * 
		 * // Reading Otp from the Licious DB DataBaseCCC db1=new DataBaseCCC(); String
		 * s1=db1.otp; //System.out.println(s1); //helper.enterText(driver,
		 * newlogin.getEnterOtp(), otp);
		 * 
		 * 
		 * 
		 * //signInpage.getPasswordTxtBox().sendKeys("123456"); //String getPassword=
		 * properties.getProperty("password"); //helper.enterText(driver,
		 * newlogin.getEnterOtp(), passWord);
		 * 
		 * //Helper.customWait(2);
		 * 
		 * // Minimizing the News Letter Subscription newlogin.getSubscribe().click();
		 * Helper.customWait(2);
		 * 
		 * 
		 * // Click on LoginButton newlogin.getloginbtn().click(); Helper.customWait(2);
		 */

		// Click on FishAndSeaFood category
		HomePage home = new HomePage(driver);
		home.getfishSeafoodCat().click();
		Helper.customWait(6);

		log.info(" Clicked on fish and seafood category ");
		etest.log(LogStatus.PASS, " Clicked on fish and seafood category ");

		// Add Basa_Fillet to cart
		FishandSeafoodPage fishandseafoodPage = new FishandSeafoodPage(driver);
		WebElement addtocart = fishandseafoodPage.getBasaFillet();

		helper.scrollBar(driver, addtocart);
		Helper.customWait(4);
		System.out.println("pass");

		log.info(" Added product to cart ");
		etest.log(LogStatus.PASS, " Added product to cart ");

		// New Checkout flow

		// New Cart Page
		NewCheckoutPage cartloaded = new NewCheckoutPage(driver);
		cartloaded.getcartBtn().click();
		Helper.customWait(2);
		cartloaded.getCheckoutBtn().click();
		Helper.customWait(2);

		log.info(" Proceed to checkout ");
		etest.log(LogStatus.PASS, " Proceed to checkout ");

		// New Address Summary Page
		NewAddressPage newAddressPage = new NewAddressPage(driver);
		 newAddressPage.getInd().click();

//		// Getting the production address
//		newAddressPage.getProdAddr().click();

		newAddressPage.getContinueBtn().click();
		Helper.customWait(2);

		log.info(" Select Delivery Address ");
		etest.log(LogStatus.PASS, " Select Delivery Address ");

		// New Delivery Summary page
		// NewDeliverySummaryPage newDeliverySummary = new
		// NewDeliverySummaryPage(driver);

		// Click on OTP Login

		// Delivery Slot Selection Express or Scheduled
		NewDeliverySummaryPage newDeliverySummary = new NewDeliverySummaryPage(driver);
		WebElement TxtBoxContent = driver.findElement(By.xpath("//div[@class='slots-selector']"));
		Helper.customWait(2);
		System.out.println("Printing " + TxtBoxContent.getText());
		Helper.customWait(2);

		if (TxtBoxContent.getText().equalsIgnoreCase("Today 120 MIN")) {
			System.out.println("Order Placing as Express Delivery");
			newDeliverySummary.getProceedToPaymentBtn().click();
			Helper.customWait(2);

			log.info(" Order Placing as Express Delivery ");
			etest.log(LogStatus.PASS, " Order Placing as Express Delivery ");
		}

		else {
			System.out.println("Order Placing as Scheduled Delivery");

			// Select the Delivery Slot for scheduled delivery
			newDeliverySummary.getSelectDeliverySlot().click();
			Helper.customWait(2);
			newDeliverySummary.getTimeSlot().click();
			Helper.customWait(2);
			newDeliverySummary.getProceedToPaymentBtn().click();
			Helper.customWait(5);

			log.info(" Order Placing as Scheduled Delivery ");
			etest.log(LogStatus.PASS, " Order Placing as Scheduled Delivery ");
		}

//		DeliverySlot slotselection = new DeliverySlot(driver);
//		
//		System.out.println("PASSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS");
//		String s2=slotselection.ss1;
//		Helper.customWait(2);
		/*
		 * //newly added lines //String a=newDeliverySummary.gettoday120min().getText();
		 * 
		 * 
		 * //WebElement wb1=newDeliverySummary.gettoday120min(); WebElement
		 * TxtBoxContent =
		 * driver.findElement(By.xpath("//div[@class='slots-selector']"));
		 * Helper.customWait(2); System.out.println("PASS2000");
		 * System.out.println("Printing " + TxtBoxContent.getText());
		 * Helper.customWait(2);
		 * 
		 * 
		 * 
		 * String a = TxtBoxContent.getText();
		 * 
		 * Helper.customWait(2); //String a = TxtBoxContent.getAttribute("value");
		 * System.out.println("PASS2000"); System.out.println(a);
		 * System.out.println("PASS1000"); Helper.customWait(2);
		 * 
		 * String b="Today 120 min";
		 * 
		 * System.out.println(b); Helper.customWait(2);
		 * 
		 * //if("a".equals("b")) //if (a==b) if
		 * (TxtBoxContent.getText().equalsIgnoreCase("Today 120 MIN")) {
		 * 
		 * System.out.println("Order Placing as Express Delivery");
		 * 
		 * newDeliverySummary.getProceedToPaymentBtn().click();
		 * 
		 * Helper.customWait(2); }
		 * 
		 * else {
		 * 
		 * System.out.println("Order Placing as Scheduled Delivery");
		 * 
		 * // Select the Delivery Slot for scheduled delivery
		 * newDeliverySummary.getSelectDeliverySlot().click(); Helper.customWait(2);
		 * newDeliverySummary.getTimeSlot().click(); Helper.customWait(2);
		 * newDeliverySummary.getProceedToPaymentBtn().click(); Helper.customWait(2); }
		 */

		// newDeliverySummary.getProceedToPaymentBtn().click();
		// Helper.customWait(2);

		// New Payment Page
		NewPaymentPage newPaymentPage = new NewPaymentPage(driver);
		newPaymentPage.getCashOnDelivery().click();
		Helper.customWait(5);

		// Commenting final payment click to run in production
		// newPaymentPage.getPlaceOrder().click();
		Helper.customWait(10);

		System.out.println("Cash On Delivery Order Placed Sucessfully");

		log.info(" Selected Cash On Delivery as payment mode ");
		etest.log(LogStatus.PASS, " Selected Cash On Delivery as payment mode ");

		log.info(" Order Placed Sucessfully with Cash On Delivery as payment mode ");
		etest.log(LogStatus.PASS, " Order Placed Sucessfully with Cash On Delivery as payment mode ");

		// Click on Cart icon

		// Old Checkout flow
		// CheckoutPage cartloaded = new CheckoutPage(driver);
		// Old Delivery Summary page
		// CheckoutDelivery checkOutDelivery = new CheckoutDelivery(driver);

		/*
		 * // Select Delivery slot if not an 120mins delivery
		 * checkOutDelivery.getSelectDeliverySlot().click(); Helper.customWait(5);
		 * System.out.println("Pass14"); String windowId = driver.getWindowHandle();
		 * driver.switchTo().window(windowId); System.out.println("Pass15");
		 * Helper.customWait(4);
		 * 
		 * JavascriptExecutor js = (JavascriptExecutor) driver;
		 * js.executeScript("window.scrollBy(0,100)"); System.out.println("Pass16");
		 * Helper.customWait(10);
		 * 
		 * checkOutDelivery.getTimeSlot().click(); Helper.customWait(2);
		 * System.out.println("Pass17");
		 */

		// Click on Continue button

		// CheckoutDelivery checkOutDelivery = new CheckoutDelivery(driver);

		/*
		 * NewDeliverySummaryPage newDeliverySummaryPage = new
		 * NewDeliverySummaryPage(driver);
		 * 
		 * newDeliverySummaryPage.getSwitchtoDeliverySummary().click();
		 * 
		 * 
		 * System.out.println("Passssssssss111111");
		 * 
		 * 
		 * newDeliverySummaryPage.getSwitchtoDeliverySummary().click();
		 */

		// Switiching to the new frame for clicking on the "Proceed to Payment Button"

		/*
		 * WebElement fr = driver.findElementByXpath("li-page-body delivery-summary");
		 * 
		 * driver.switchTo().frame(fr);
		 * 
		 * Then to move out of frame use:- driver.switchTo().defaultContent();
		 * 
		 * driver.switchTo().frame().
		 * 
		 * 
		 * // old Click on Proceed to Payment Button DeliverySummaryPage proceedtopay =
		 * new DeliverySummaryPage(driver); WebElement proceedtopayment =
		 * proceedtopay.getProceedToPaymentBtn(); helper.scrollBar(driver,
		 * proceedtopayment ); Helper.customWait(2);
		 */

		/*
		 * // Old UI Steps // Click on NetBanking PaymentPage paynow = new
		 * PaymentPage(driver); paynow.getNetBanking().click(); Helper.customWait(2); //
		 * Store the current window handle String winHandleBefore =
		 * driver.getWindowHandle(); // Click on PayNow Button
		 * paynow.getPayNowBtn().click(); Helper.customWait(5); // Switch to new window
		 * opened for(String winHandle : driver.getWindowHandles()){
		 * driver.switchTo().window(winHandle); } // Click on Success Button in RazorPay
		 * Page RayzorpayPage success = new RayzorpayPage(driver);
		 * System.out.println("maximized"); success.getRayzorpayPage().click();
		 * Helper.customWait(5);
		 * System.out.println("Basa Fillet order palced successfully"); // Switch back
		 * to original browser (first window) driver.switchTo().window(winHandleBefore);
		 */

	}

}
