//Selectable tests class for selecting all the options

package tests_for_interactions;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import baseLibrary.Library_For_Alert_Windows_Frames;
import pages_for_interactions.SelectablePage;

public class SelectableTests extends Library_For_Alert_Windows_Frames {
	pages_for_interactions.SelectablePage ob;

    @BeforeTest                     // BeforeTest method runs before any tests, to initialize browser and page object
    @Parameters("browser")          // Parameters from the testng.xml file, like browser name
	public void launchurl(String browser) throws InterruptedException {
    	System.out.println("Launching browser: " + browser);  // Debugging log
		launchUrl(browser);
		ob = new SelectablePage();    // Instantiate the SelectablePage object to interact with elements on the page
	}

	@Test(priority = 1)
	public void clickoninteractions() {
		ob.clickOnInteractions();
	}
	@Test(priority = 2)
	public void clickonselectable() {
		ob.clickOnSelectableOption();
	}

	@Test(priority = 3)
	public void selectoptionnormally()  {
	    ob.SelectAllOptionNormally();
	}
	
	@Test(priority = 4,enabled=false)
	public void selectoptionthroughstatechange()  {
		ob.SelectAlleOptionByStateChange();
	}
	
	@Test(priority = 5,enabled=false)
	public void selectoptionbycss() {
		ob.selectAllOptionsByCssValue();;
	}
	
	@Test(priority = 6,enabled=false)
	public void selectoneoptionbyattribute() {
		ob.selectAllOptionByStyleAttribute();
	}
}
