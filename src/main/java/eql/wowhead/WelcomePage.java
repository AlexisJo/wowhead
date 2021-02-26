package eql.wowhead;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WelcomePage {
	@FindBy(xpath = "//button[@id='onetrust-accept-btn-handler']")
	public WebElement accept_cookies;
	
	@FindBy(xpath = "//button[contains(text(),'Refuser')]")
	public WebElement refuse_notifications;
	
	@FindBy(xpath = "//div[@class='header-search']//input[@type='text']")
	public WebElement search_field;
	
	@FindBy(xpath = "//div[@class='header-search']//a[contains(@class,'search')]")
	public WebElement search_button;
	
	@FindBy(xpath = "//td[@class='icon-boss-padded']//a[contains(text(),'Lardeur')]")
	public WebElement Lardeur_link;	

}
