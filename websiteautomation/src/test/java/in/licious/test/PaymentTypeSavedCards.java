package in.licious.test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
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

public class PaymentTypeSavedCards extends BaseTest {

	@Test(priority = 1)
	public void testPaymentTypeSavedCards() throws ClassNotFoundException, SQLException, AWTException {
		
		
		

		// Sign In with New Login Flow
		NewLoginFlow newlogin = new NewLoginFlow(driver);
		
//		// Handling the location notification provided by browser
//				Actions action = new Actions(driver);
//				action.sendKeys(Keys.ESCAPE).build().perform();
//				System.out.println("Closed the browser pop up for location");
//				Helper.customWait(10);
				
		
		// Handling the browser notification using the desired capabilities
		
//		Helper.customWait(10);
//		ChromeOptions options=new ChromeOptions();
//		Map<String, Object> prefs=new HashMap<String,Object>();
//		prefs.put("profile.default_content_setting_values.notifications", 1);
//		//1-Allow, 2-Block, 0-default
//		options.setExperimentalOption("prefs",prefs);
//		ChromeDriver driver=new ChromeDriver(options);
//		
//		Helper.customWait(10);
		
		
		Helper helper = new Helper();
		helper.clickOnElement(driver, newlogin.getSelectLocation());
		Helper.customWait(2);
		helper.clickOnElement(driver, newlogin.getbengaluruDeliveryLocation());
		Helper.customWait(2);
		helper.enterText(driver, newlogin.getLoactionTxtBox(), location);
		Helper.customWait(2);
		newlogin.getLoactionTxtBox().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		Helper.customWait(2);
		log.info(" Location is selected ");
		etest.log(LogStatus.PASS, "Location is selected");
		Helper.customWait(4);
		
		
		
		
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

		// Click on FishAndSeaFood category
		HomePage home = new HomePage(driver);
		home.getfishSeafoodCat().click();
		Helper.customWait(4);

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
			Helper.customWait(2);

			log.info(" Order Placing as Scheduled Delivery ");
			etest.log(LogStatus.PASS, " Order Placing as Scheduled Delivery ");
		}
		// New Payment Page
		NewPaymentPage newPaymentPage = new NewPaymentPage(driver);

		// Saved card payment
		newPaymentPage.getSavedCard1().click();
		Helper.customWait(2);
		// helper.enterText(driver, newlogin.getMobileNumber(), userName);
		helper.enterText(driver, newPaymentPage.getCvv1(), "111");
		Helper.customWait(5);

		// Commenting final payment click to run in production
		// newPaymentPage.getSavedCardButton().click();
		Helper.customWait(5);

		log.info(" Selected Saved card as payment mode ");
		etest.log(LogStatus.PASS, " Selected Saved card as payment mode ");

		log.info(" Order Placed Sucessfully with Saved card as payment mode ");
		etest.log(LogStatus.PASS, " Order Placed Sucessfully with Saved card as payment mode ");

	}

}
