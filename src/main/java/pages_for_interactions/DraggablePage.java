//DraggablePage class for checking the drag feature

package pages_for_interactions;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseLibrary.Library_For_Alert_Windows_Frames;

public class DraggablePage extends Library_For_Alert_Windows_Frames {

//Constructor - Initializes the page elements.
	public DraggablePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@data-target='#interations']")
	private WebElement interactions;

	@FindBy(xpath = "//a[text()='draggable']")
	private WebElement draggableoption;

	@FindBy(xpath = "//div[@id='draggable']")
	private WebElement draggableelement;
	
	@FindBy(xpath = "//iframe[@src='dragable.html']")
	private WebElement dragframe;



	public void clickOnInteractions() {
		waitforClick(interactions);
	}

	public void clickOnDraggableoption() {
		waitforClick(draggableoption);
	}

	public void moveDraggablecursor() throws InterruptedException {

		
			
        driver.switchTo().frame(dragframe);
            Actions act = new Actions(driver);       // Use Actions class to perform drag and drop

            act.dragAndDropBy(draggableelement, 300, 0).perform(); // Drag the element by an offset (e.g., 300 pixels in the X direction, 0 in Y direction)
           

            // Wait for a few seconds to visually check the result
            Thread.sleep(2000);  // Wait for 2 seconds (just for demo purposes)
            driver.switchTo().defaultContent();
        }	
}