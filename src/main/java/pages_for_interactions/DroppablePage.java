 //DroppablePage class for checking the draag and drop feature

package pages_for_interactions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseLibrary.Library_For_Alert_Windows_Frames;

public class DroppablePage extends Library_For_Alert_Windows_Frames {

//Constructor - Initializes the page elements.
	public DroppablePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@data-target='#interations']")
	private WebElement interactions;
	
	@FindBy(xpath = "//a[text()='droppable']")
	private WebElement droppableoption;
	
	@FindBy(xpath = "//iframe[@src='drop.html']")
	private WebElement dropiframe;
	
	@FindBy(xpath = "//img[@id='drag1']")
	private WebElement dragelement;
	
	@FindBy(xpath = "//div[@id='div1']")
	private WebElement droptarget;
	

	public void clickOnInteractions() {
		waitforClick(interactions);
	}

	public void clickOnDroppableoption() {
		waitforClick(droppableoption);
	}

	public void moveDroppableelement() throws InterruptedException {

            driver.switchTo().frame(dropiframe);
            Actions act = new Actions(driver);     // Initialize Actions class

            act.dragAndDrop(dragelement, droptarget).build().perform();       // Perform drag-and-drop action
            
            Thread.sleep(2000); //   // Optionally, you can add a delay to observe the action for 2 seconds
	        driver.switchTo().defaultContent();             
	        }
		
	
	}
