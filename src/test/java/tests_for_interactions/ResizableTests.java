//Resizable tests class for checking the resizing feature

package tests_for_interactions;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import baseLibrary.Library_For_Alert_Windows_Frames;
import pages_for_interactions.ResizablePage;

public class ResizableTests extends Library_For_Alert_Windows_Frames {
	pages_for_interactions.ResizablePage ob;
	
	@BeforeTest                     // BeforeTest method runs before any tests, to initialize browser and page object
    @Parameters("browser")          // Parameters from the testng.xml file, like browser name
	public void launchurl(String browser) throws InterruptedException {
    	System.out.println("Launching browser: " + browser);  // Debugging log
		launchUrl(browser);

		ob = new ResizablePage();     // Instantiate the ResizablePage object to interact with elements on the page
	}

	@Test(priority = 1)
	public void clickoninteractions() {
		ob.clickOnInteractions();
	}

	@Test(priority = 2)
	public void clickonresizableoption() {
		ob.clickOnResizableOption();
	}

	@Test(priority = 3,enabled=false)
	public void resizelementold() {
	      ob.resizeElementOld();
     }

	@Test(priority = 4)
	public void resizeboxexample()  {
		ob.resizeBoxExample();
	}
}
