//SelectablePage class for selecting all the available options

package pages_for_interactions;

import java.util.List;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseLibrary.Library_For_Alert_Windows_Frames;

public class SelectablePage extends Library_For_Alert_Windows_Frames {

//Constructor - Initializes the page elements.
	public SelectablePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@data-target='#interations']")
	private WebElement interactionsButton;

	@FindBy(xpath = "//a[text()='selectable']")
	private WebElement selectableOption;

	@FindBy(xpath = "//li[normalize-space(text())='There’s no traffic after the extra mile.' and @style='background: white; color: black;']")
	private WebElement selectListFirstOption;

	@FindBy(xpath = "//ul[@class='list-group']/li")
	private List<WebElement> listElements;
	
	

	public void clickOnInteractions() {
		waitforClick(interactionsButton);
		interactionsButton.click();
	}
	

	public void clickOnSelectableOption() {
		waitforClick(selectableOption);
		selectableOption.click();
	}

	
	public void SelectAllOptionNormally() {

	try {
		    Actions actions = new Actions(driver);

		for (int i = 0; i < listElements.size(); i++) { // Use a traditional for loop to iterate over the list of elements
														
		    WebElement listItem = listElements.get(i); // Get each list item
			String itemText = listItem.getText();      // Fetch the text of the list item and print it

			actions.moveToElement(listItem).perform();
			listItem.click();

			waitforClick(listItem);  //can be used any one of the wait
			//Thread.sleep(100);        // If the item requires another click then Wait for the second click (if necessary)
			                          // or You can check the state of the element or just click again	
			
			listItem.click();                                    // Retry the click if needed
			System.out.println("Text of listoption is " + (i + 1) + ": " + itemText);
			}
		} 
	 
	 catch (Exception e) 
	       {
		    System.out.println("Elements not selected"+e);
			e.printStackTrace();     }
	 
	 finally {
	     	// driver.quit();        // Close the browser     
	 }}

	
	
	public void SelectAlleOptionByStateChange() {
	    try {
	        Actions actions = new Actions(driver);

	        for (int i = 0; i < listElements.size(); i++) { // Use a traditional for loop to iterate over the list of elements
	            WebElement listItem = listElements.get(i); // Get each list item
	            String itemText = listItem.getText();    // Fetch the text of the list item and print it

	            // Get the initial background color before clicking (or any other attribute you want to track)
	            String initialBackgroundColor = listItem.getCssValue("background-color");
	            System.out.println("Initial background color of listoption " + (i + 1) + ": " + initialBackgroundColor);

	            // Hover over the element and click the item
	            actions.moveToElement(listItem).perform();
	            listItem.click();
	            
	            // Wait for the state change or background color change (adjust the wait time if necessary)
	            Thread.sleep(100);  // Wait a bit to see if the element has changed

	            // Check if the background color or any other attribute has changed
	            String newBackgroundColor = listItem.getCssValue("background-color");

	            if (!initialBackgroundColor.equals(newBackgroundColor)) {
	                System.out.println("Background color changed. New color after single click is: " + newBackgroundColor);
	            }
	            
	            else {
	                System.out.println("Background color not changed. Trying to click again.");
	                listItem.click();  // Retry the click if necessary
	            
	                // Output the text of the item after clicking
	            System.out.println("Text of listoption is after clicking twice" + (i + 1) + ": " + itemText);
	        }}}
	        
	      catch (InterruptedException e) {
	        System.out.println("Elements not selected: " + e);
	        e.printStackTrace();    }
	        
	      finally {
	        // driver.quit(); // Close the browser (if necessary, uncomment to close the browser)
	    }
	}


	
	public void selectAllOptionsByCssValue() {

	try {
	        Actions actions = new Actions(driver);
		
		for (int i = 0; i < listElements.size(); i++) {
			WebElement listItem = listElements.get(i); // Get each list item

			String initialColor = listItem.getCssValue("background-color");  	// Get the current background color of the element (before clicking)
			System.out.println("InitialBackground color is: " + initialColor);
			
			actions.moveToElement(listItem).perform();
			listItem.click();

			Thread.sleep(100); // If the item requires another click then Wait for the second click (if necessary)
			                   // or You can check the state of the element or just click again	
			listItem.click(); // Retry the click if needed
			
			String newColor = listItem.getCssValue("background-color");       // Get the background color after clicking

		if (!initialColor.equals(newColor))          // Check if the background color has changed (indicating selection)
			{
				System.out.println("Element selected: Background color changed to: " + newColor);     }
		
		else {
			    System.out.println("Element not selected or color did not change.");               }
	
		String itemText = listItem.getText();    // Fetch the text of the list item and print it
		System.out.println("Text of listoption " + (i + 1) + ": " + itemText);	
		} }
	   
	catch (InterruptedException e)
	          {
	    	   System.out.println("Elements not selected"+e);
			   e.printStackTrace();    }
	
	finally {
			// Close the browser
			// driver.quit();
		}
	}

	public void selectAllOptionByStyleAttribute() {

	   try {
			 Actions actions = new Actions(driver);

		for (int i = 0; i < listElements.size(); i++) {
			 WebElement listItem = listElements.get(i); // Get each list item
			
			String initialStyle = listItem.getAttribute("style");
			System.out.println("Initial style of listoption is " + (i + 1) + ": " + initialStyle);

			actions.moveToElement(listItem).perform();
			listItem.click();

			Thread.sleep(100); // If the item requires another click then Wait for the second click (if necessary)
			                   // or You can check the state of the element or just click again	
			listItem.click(); // Retry the click if needed
			

			String newStyle = listItem.getAttribute("style");    // Get the background color after clicking ,Get the 'style' attribute after clicking
			System.out.println("New style of listoption is " + (i + 1) + ": " + newStyle);

		if (!initialStyle.equals(newStyle)) {
			System.out.println("Element selected: Style changed.");    }
			
		else {
			System.out.println("Element not selected or style did not change.");  }
		
		String itemText = listItem.getText();
		System.out.println("Text of listoption is " + (i + 1) + ": " + itemText);
		}} 
	   
        catch (InterruptedException e)
          {
    	   System.out.println("Elements not selected"+e);
		   e.printStackTrace();       } 
       
		finally {
		// Close the browser
		// driver.quit();
	}
	}}

