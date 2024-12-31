//Sortable tests class for sorting all the list options

package tests_for_interactions;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import baseLibrary.Library_For_Alert_Windows_Frames;
import pages_for_interactions.SortablePage;

public class SortableTests extends Library_For_Alert_Windows_Frames {
	pages_for_interactions.SortablePage ob;

	@BeforeTest                     // BeforeTest method runs before any tests, to initialize browser and page object
    @Parameters("browser")          // Parameters from the testng.xml file, like browser name
	public void launchurl(String browser) throws InterruptedException {
    	System.out.println("Launching browser: " + browser);  // Debugging log
		launchUrl(browser);
		ob = new SortablePage();
	}

	@Test(priority = 1)
	public void clickoninteractions() {
		ob.clickOnInteractions();
	}
	@Test(priority = 2)
	public void clickonsortable() {
		ob.clickOnSortableOption();
	}
	
	@Test(priority = 3,enabled=false)
	public void sortNameListUsingMap() {
		ob.sortNameListUsingMap();
	}

	@Test(priority = 4,enabled=false)
	public void sortnamelistusingloop()  {
     ob.sortNameListUsingTraditionalForLoop();
	}
	
	@Test(priority = 5,enabled=false)
	public void sortnamelistusingehancedforloop()  {
		ob.sortNameListUsingEnhancedForLoop();
	}
	@Test(priority = 6,enabled=true)
	public void sortnamelistbygetetxtmethod()  {
		ob.sortNameListbygetTextmethod();
	}
	
	@Test(priority = 7,enabled=false)
	public void sortnameandvalidate()  {
		ob.sortNameListAndValidate();
	}

}
