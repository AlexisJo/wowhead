package eql.wowhead;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResultsPage {
	@FindBy(xpath = "(//a[@href='/item=2168/chahuteurs-de-cadavre'])[1]")
	public WebElement chahuteurs;
	
	@FindBy(xpath = "(//a[@href='/item=1934/chausses-de-lardeur'])[1]")
	public WebElement chausses;
	
	@FindBy(xpath = "(//a[@href='/item=151074/espauliers-de-tourne-clé'])[2]")
	public WebElement espauliers;
	
	@FindBy(xpath = "(//a[@href='/item=132569/grèves-de-geôlier-volées'])[1]")
	public WebElement greves;
	
	@FindBy(xpath = "(//a[@href='/item=1959/pioche-en-fer-froid'])[1]")
	public WebElement pioche;
	
	@FindBy(xpath = "(//h2[@class='heading-size-2'])[2]")
	public WebElement footer_overlay;
	
	@FindBy(xpath = "//b[text()='Chahuteurs de cadavre']/ancestor::td[1]")
	public WebElement objet_chahuteurs;
	
	@FindBy(xpath = "//b[text()='Chausses de Lardeur']/ancestor::td[1]")
	public WebElement objet_chausses;
	
	@FindBy(xpath = "//b[text()='Espauliers de Tourne-Clé']/ancestor::td[1]")
	public WebElement objet_espauliers;
	
	@FindBy(xpath = "//b[text()='Grèves de geôlier volées']/ancestor::td[1]")
	public WebElement objet_greves;
	
	@FindBy(xpath = "//b[text()='Pioche en fer froid']/ancestor::td[1]")
	public WebElement objet_pioche;
}
