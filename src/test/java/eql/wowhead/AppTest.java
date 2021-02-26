package eql.wowhead;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import eql.wowhead.WelcomePage;
import eql.wowhead.ResultsPage;

/**
 * Unit test for simple App.
 */
public class AppTest 
{	public static boolean containsWords(String inputString, String[] items) {
    boolean found = true;
    for (String item : items) {
        if (!inputString.contains(item)) {
            found = false;
            break;
        }
    }
    return found;
}
public void waitForBrowserReadystateComplete(WebDriver webDriver) {
    for (int a=0; a<20; a++) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) webDriver;
        if (javascriptExecutor.executeScript("return document.readyState")
                .toString().equals("complete")) {
            break;
        }
        sleepResponsibly(500);
    }
}

public void sleepResponsibly(int timeMillisecond){
    try{
        Thread.sleep(timeMillisecond);
    } catch (InterruptedException ex) {
        Thread.currentThread().interrupt(); 
        throw new RuntimeException(ex);
    }
}

public void explicitScrollIntoView(WebDriver webDriver, WebElement elementToScrollIntoView, boolean blockOption) {
    final String scriptStr = "arguments[0].scrollIntoView(" + blockOption + ");";
    ((JavascriptExecutor) webDriver).executeScript(scriptStr, elementToScrollIntoView);

    sleepResponsibly(500);

}
	WebDriver driver;
	JavascriptExecutor js = (JavascriptExecutor) driver;  
	
	String BROWSER = System.getProperty("browser");
	@Before
	public void setup() {
		driver = SocleTechnique.choisirNavigateur(BROWSER);
		/*System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
		driver = new ChromeDriver();*/
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@After
	public void teardown() {
		driver.quit();
	}

	@Test
	public void test() throws InterruptedException {
		driver.get("https://fr.wowhead.com/");

		// Instanciation Pagewelcome
		WelcomePage page_welcome = PageFactory.initElements(driver, WelcomePage.class);
		ResultsPage page_results = PageFactory.initElements(driver, ResultsPage.class);
		
		page_welcome.accept_cookies.click();
		page_welcome.refuse_notifications.click();
		page_welcome.search_field.click();
		page_welcome.search_field.sendKeys("Lardeur");;
		page_welcome.search_button.click();
		page_welcome.Lardeur_link.click();
		
		String newLine = System.getProperty("line.separator");
		page_results.chahuteurs.click();
		String test = page_results.objet_chahuteurs.getText();
		System.out.println(newLine + "assert des chahuteurs");
		System.out.println(test);
		String[] words_chahuteurs = {"Niveau d'objet 57", "Lié quand ramassé", "Pieds Tissu", "Armure : 2", "+12 Intelligence","+18 Endurance", "Augmente votre score de hâte de +13", "+10 Versatilité", "Durabilité 60 / 60" };
		
		assertTrue(containsWords(test, words_chahuteurs));
		
		driver.navigate().back();
		
		page_results.chausses.click();
		test = page_results.objet_chausses.getText();
		System.out.println(newLine + "assert des chausses");
		System.out.println(test);
		String[] words_chausses = {"Niveau d'objet 57", "Lié quand ramassé", "Jambes", "Armure : 6", "+16 [Agilité or Intelligence]","+24 Endurance", "Augmente votre score de coup critique de +21", "+12 Versatilité", "Durabilité 95 / 95" };
		
		assertTrue(containsWords(test, words_chausses));
		
		driver.navigate().back();
		
		explicitScrollIntoView(driver, page_results.footer_overlay, false);
		
		Thread.sleep(3000);
		
		page_results.espauliers.click();
		test = page_results.objet_espauliers.getText();
		System.out.println(newLine + "assert des espauliers");
		System.out.println(test);
		String[] words_espauliers = {"Niveau d'objet 57", "Lié quand ramassé", "Épaule", "Armure : 10", "+12 [Force or Intelligence]","+18 Endurance", "Augmente votre score de coup critique de +9", "+15 Versatilité", "Durabilité 80 / 80" };
		
		assertTrue(containsWords(test, words_espauliers));
		
		driver.navigate().back();
		
		page_results.greves.click();
		test = page_results.objet_greves.getText();
		System.out.println(newLine + "assert des greves");
		System.out.println(test);
		String[] words_greves = {"Niveau d'objet 57", "Lié quand ramassé", "Jambes", "Armure : 8", "+16 [Agilité or Intelligence]","+24 Endurance", "Augmente votre score de coup critique de +19", "Augmente votre score de hâte de +12", "Durabilité 95 / 95" };
		
		assertTrue(containsWords(test, words_greves));
		
		driver.navigate().back();
		
		page_results.pioche.click();
		test = page_results.objet_pioche.getText();
		System.out.println(newLine + "assert des pioches");
		System.out.println(test);
		String[] words_pioche = {"Niveau d'objet 57", "Lié quand ramassé", "Deux mains", "(12.1 dégâts par seconde)", "+16 Force","+24 Endurance", "Augmente votre score de coup critique de +13", "Augmente votre score de hâte de +19", "Durabilité 90 / 90" };
		
		assertTrue(containsWords(test, words_pioche));
		
		
		
		
	}
}
