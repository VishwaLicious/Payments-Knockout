package in.licious.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FishandSeafoodPage extends BasePage {
	
	// Product_Name Basa_Fillet
//	@FindBy (xpath="//button[@data-prid='pr_5746a6e241199']")
	// In production we have different product Id's
	@FindBy (xpath="//button[@data-prid='pr_8izjlf6xn0k']")
	//	@FindBy(xpath="(//button[@class='add-to-cart addCartBtn-home'])[1]")
	private WebElement addtocart_Basa_Fillet;
	// Production web element
	private WebElement addtocart_Basa_FilletProd;
	
	
	
	
	
	

	
	// Finding the first product which is behind the active order block
	@FindBy (xpath="//button[@data-index='0']")
	private WebElement product_behind_vieworder;
	
	

	public FishandSeafoodPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getBasaFillet(){
		
		return addtocart_Basa_Fillet;
	}
	
	
	// Returning the Production Basa Fillet Product for which product ID is different in Dev
	public WebElement getBasaFilletProd(){
		
		return addtocart_Basa_FilletProd;
	}
	
	public WebElement getproduct_behind_vieworder() {
		
		return product_behind_vieworder;
	}

}
