//ResizablePage class for checking the resizing feature

package pages_for_interactions;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseLibrary.Library_For_Alert_Windows_Frames;

public class ResizablePage extends Library_For_Alert_Windows_Frames {

//Constructor - Initializes the page elements.
	public ResizablePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@data-target='#interations']")
	private WebElement interactionsButton;

	@FindBy(xpath = "//a[text()='resizable']")
	private WebElement resizableOption;
	
	@FindBy(xpath = "//div[@class='tab-pane fade active show']//div[@class='resize-box']")
	private WebElement resizeElement;
	

	public void clickOnInteractions() {
		waitforClick(interactionsButton);
		interactionsButton.click();
	}

	public void clickOnResizableOption() {
		waitforClick(resizableOption);
		resizableOption.click();
	}

	public void resizeElementOld() {  //this will work if we can locate bottom right corner which is responsible for resize
                                   //but its in this case it won't work as we can't locate that drag icon responsible for resizing

  try {
      // Get the initial size of the element (width and height)
      Dimension initialSize = resizeElement.getSize();
      int initialWidth = initialSize.width;
      int initialHeight = initialSize.height;
      
      // Print the initial size in a more readable format
      System.out.println("Initial size of the element is:");
      System.out.println("  - Initial Width: " + initialWidth + "px");
      System.out.println("  - Initial Height: " + initialHeight + "px");

      Actions act = new Actions(driver); // Create an Actions object to perform resize

      // Perform the resize action by clicking and holding, then moving the mouse by an offset
      act.clickAndHold(resizeElement).moveByOffset(220, 180).release().build().perform(); 
      //Thread.sleep(5000); // Wait for the resize to complete

      // Get the new size of the element after resize
      Dimension newSize = resizeElement.getSize();
      int newWidth = newSize.width;
      int newHeight = newSize.height;

      // Print the new size of the element in a more readable format
      System.out.println("New size of the element after resizing is:");
      System.out.println("  - New Width: " + newWidth + "px");
      System.out.println("  - New Height: " + newHeight + "px");

      // Check if the element has been resized (both width and height should increase)
      if (newWidth > initialWidth && newHeight > initialHeight) {
          System.out.println("Element resized successfully!");
      }
      else {
          System.out.println("Resize operation failed. The new size is not larger than the initial size.");
      }  }
   
  catch (Exception e) {
      e.printStackTrace();
  }
       driver.quit();             }

	
	public void resizeBoxExample()  {

		try{
		// Get and print the initial width and height of the box
	    int initialWidth = resizeElement.getSize().getWidth(); 
	    int initialHeight = resizeElement.getSize().getHeight();
	    
	    System.out.println("Initial Box Size is:");
	    System.out.println("  - Initial Width: " + initialWidth + "px");
	    System.out.println("  - Initial Height: " + initialHeight + "px");

	    // Get the current size and location of the box to calculate bottom-right corner coordinates
	    Dimension size = resizeElement.getSize(); 
	    Point location = resizeElement.getLocation();

	    // Calculate bottom-right corner coordinates based on the box's size and location
	    int bottomRightX = location.getX() + size.getWidth(); 
	    int bottomRightY = location.getY() + size.getHeight();

	    // Use the Actions class to simulate a resize action
	    Actions actions = new Actions(driver); 

	    // Move to the bottom-right corner, click and hold, then drag to resize the box
	    actions.moveByOffset(bottomRightX - 5, bottomRightY - 5).clickAndHold().moveByOffset(100, 100).release().build().perform();

	    //Thread.sleep(5000); // Wait for the resize operation to complete

	    // Get and print the final width and height of the box after resizing
	    int finalWidth = resizeElement.getSize().getWidth(); 
	    int finalHeight = resizeElement.getSize().getHeight();
	   
	    System.out.println("Final Box Size After Resizing is:");
	    System.out.println("  - Final Width: " + finalWidth + "px");
	    System.out.println("  - Final Height: " + finalHeight + "px");

	    // Check if both width and height have been resized
	    if (finalWidth > initialWidth && finalHeight > initialHeight) 
	    {
	        System.out.println("The box has been resized successfully in both width and height.");
	    }
	    
	    else {
	        // Provide specific feedback if either width or height hasn't changed
	        if (finalWidth <= initialWidth) 
	        {
	            System.out.println("The box width resize did not work. It may not have increased.");
	        }

	        if (finalHeight <= initialHeight)
	        {
	            System.out.println("The box height resize did not work. It may not have increased.");
	        }
	    }
  } 
	  catch (Exception e) {
     
      System.err.println("The resize operation was interrupted: " + e.getMessage());
      e.printStackTrace();       
  } 
		
	  finally {      // Close the browser and quit the WebDriver session in the finally block to ensure cleanup

      if (driver != null) {
          driver.quit();           // Ensure that the browser is completely closed and resources are released
          System.out.println("Browser session closed successfully.");
      }
  }}}

