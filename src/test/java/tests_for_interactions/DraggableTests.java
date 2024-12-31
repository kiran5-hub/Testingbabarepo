package tests_for_interactions;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import baseLibrary.Library_For_Alert_Windows_Frames;
import pages_for_interactions.DraggablePage;

public class DraggableTests extends Library_For_Alert_Windows_Frames {

    private pages_for_interactions.DraggablePage ob;

    @BeforeTest
    @Parameters({"browser"}) // Pass browser parameter from testng.xml
    public void launchurl(String browser) throws InterruptedException {
        System.out.println("Launching browser: " + browser);  // Debugging log
        launchUrl(browser); // Make sure this method is working for browser initialization
        ob = new DraggablePage(); // Initialize DraggablePage object
    }

    

    @Test(priority = 1)
    public void clickoninteractions() {
        ob.clickOnInteractions(); // Assuming this method clicks on "Interactions"
    }

    @Test(priority = 2)
    public void clickondraggableoption() {
        ob.clickOnDraggableoption(); // Assuming this method clicks on "Draggable"
    }

    @Test(priority = 3)
    public void movedraggablecursor() throws InterruptedException {
        ob.moveDraggablecursor(); // Assuming this method handles the drag action
    }
}
