package waitUtility;

import org.openqa.selenium.WebElement;

public interface WaitUtility {
	
	//public void waitForClick(WebElement ele);
	//public void waitForSendkeys(WebElement ele, String val);
	
	     //or
	
	
	public void waitforClick(WebElement ele);
	public void waitforVisibility(WebElement ele, String val);
	
	public void waitforAlerts();
	


}
