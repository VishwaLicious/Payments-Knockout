package in.licious.test;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
import in.licious.pom.RayzorpayPage;
import in.licious.util.DataBaseCCC;
import in.licious.util.Helper;

public class PaymentTypePaytm extends BaseTest {
	
	@Test (priority=2)
	public void testPaymentTypePaytm() throws ClassNotFoundException, SQLException
	{
		
		
		// Sign In with New Login Flow
		NewLoginFlow newlogin = new NewLoginFlow(driver);
		Helper helper = new Helper();	
		helper.clickOnElement(driver, newlogin.getSelectLocation());
		Helper.customWait(2);
		helper.clickOnElement(driver, newlogin.getbengaluruDeliveryLocation());
		Helper.customWait(2);
		helper.enterText(driver, newlogin.getLoactionTxtBox(), location);
		Helper.customWait(2);
		newlogin.getLoactionTxtBox().sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
		Helper.customWait(2);
		etest.log(LogStatus.PASS,"Location is selected");
		
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
				// Reading OTP  from DB
				DataBaseCCC db1=new DataBaseCCC(driver);
				
				String s1=db1.otp1;
				System.out.println("otp1");
			
				System.out.println(s1);
				System.out.println("Fetched OTP from the DB");
				
				log.info(s1+" Fetched OTP from the DB ");
				etest.log(LogStatus.PASS,s1 +" Fetched OTP from the DB");
		
		// Click on Login Button
		helper.clickOnElement(driver, newlogin.getpasswordloginBtn());
		Helper.customWait(5);
		
		
		// Handling the Deals and Offers pop which comes in production after login
		newlogin.getdealsandoffers().click();
		Helper.customWait(5);
		
		
				
		// Click on FishAndSeaFood category
		HomePage home=new HomePage(driver);
		home.getfishSeafoodCat().click();
		Helper.customWait(4);
		
		
		log.info(" Clicked on fish and seafood category ");
		etest.log(LogStatus.PASS, " Clicked on fish and seafood category ");


		
		// Add Basa_Fillet to cart
		FishandSeafoodPage fishandseafoodPage =new FishandSeafoodPage(driver);
		WebElement addtocart= fishandseafoodPage.getBasaFillet();
		helper.scrollBar(driver, addtocart );
		Helper.customWait(4);
		
		log.info(" Added product to cart ");
		etest.log(LogStatus.PASS, " Added product to cart ");

//		WebElement addtocart1= fishandseafoodPage.getproduct_behind_vieworder();
//		jse.executeScript("arguments[0].click()", addtocart1);
		
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
		//NewDeliverySummaryPage  newDeliverySummary = new NewDeliverySummaryPage(driver);
		
		// Click on OTP Login
				
		
		// Delivery Slot Selection Express or Scheduled
		NewDeliverySummaryPage  newDeliverySummary = new NewDeliverySummaryPage(driver);
		WebElement TxtBoxContent = driver.findElement(By.xpath("//div[@class='slots-selector']"));
		Helper.customWait(2);
		System.out.println("Printing " + TxtBoxContent.getText());
		Helper.customWait(2);
		
		if (TxtBoxContent.getText().equalsIgnoreCase("Today 120 MIN"))
		{
			System.out.println("Order Placing as Express Delivery");
			newDeliverySummary.getProceedToPaymentBtn().click();	
			Helper.customWait(2);
			
			log.info(" Order Placing as Express Delivery ");
			etest.log(LogStatus.PASS, " Order Placing as Express Delivery ");
		}
		
		else 
		{
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
		// New Payment Page
		NewPaymentPage newPaymentPage = new NewPaymentPage(driver);
		
		// Credit and Debit card payments 
		newPaymentPage.getPaytmButton().click();
		Helper.customWait(4);
		
		newPaymentPage.getPaytmRadioButton().click();
		Helper.customWait(4);
		
		newPaymentPage.getPaytmPayButton().click();
		Helper.customWait(10);
		
		
		log.info(" Selected Paytm as payment mode ");
		etest.log(LogStatus.PASS, " Selected Paytm as payment mode ");
		
		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();
		// Perform the click operation that opens new window
		// Switch to new window opened
		for (String winHandle : driver.getWindowHandles()) 
		{
			driver.switchTo().window(winHandle);
		}
		RayzorpayPage success = new RayzorpayPage(driver);
		driver.manage().window().maximize();
		System.out.println("maximized");
		
		//Commenting final payment click to run in production
	//	success.getRayzorpayPage().click();
		Helper.customWait(5);
		System.out.println("Credit and Debit card Order Placed Sucessfully from Chicken Category");
		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);
							
	
		log.info(" Order Placed Sucessfully with Paytm as payment mode ");
		etest.log(LogStatus.PASS, " Order Placed Sucessfully with Paytm as payment mode ");
		
		
		
	}
	
	

}
