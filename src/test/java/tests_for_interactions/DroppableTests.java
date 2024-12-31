
//Droppable tests class for checking the drag & drop feature

package tests_for_interactions;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import baseLibrary.Library_For_Alert_Windows_Frames;
import pages_for_interactions.DroppablePage;

public class DroppableTests extends Library_For_Alert_Windows_Frames {
	pages_for_interactions.DroppablePage ob;

	@BeforeTest                     // BeforeTest method runs before any tests, to initialize browser and page object
    @Parameters("browser")          // Parameters from the testng.xml file, like browser name
	public void launchurl(String browser) throws InterruptedException {
    	System.out.println("Launching browser: " + browser);  // Debugging log
		launchUrl(browser);
		ob = new DroppablePage();
	}

	@Test(priority = 1)
	public void clickoninteractions() {
		ob.clickOnInteractions();
	}

	@Test(priority = 2)
	public void clickondroppableoption() {
		ob.clickOnDroppableoption();
	}

	@Test(priority = 3)
	public void movedroopableemelement() throws InterruptedException {
		ob.moveDroppableelement();
}


}
