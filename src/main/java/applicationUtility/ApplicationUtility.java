package applicationUtility;

import org.openqa.selenium.WebElement;

public interface ApplicationUtility {
	
	
	public void doubleClickOnElement(WebElement ele);
	public void rightClickOnElement(WebElement ele);
	public void clickOnElement(WebElement ele);
	public void changeWindow(int tabno);
	public void close();
	public void quit();
	public void fileuploading(String Filepath);
	public boolean isEnabled_Disabled(WebElement ele);
	
	public void selectbyText(WebElement ele, String text);
	public void selectbyIndex(WebElement ele, int index);
	public void selectbyValue(WebElement ele, String value);
	
	public void selectallbyTextUsingLoop(WebElement ele, String text);
	
	public void mouseHover(WebElement ele);
	public void mouseHoverfortooltip(WebElement ele);
	
	public String getDate_Time();
	
    public int  getResponseCodeForRequest(String url);
    public void movetoElement(WebElement ele);
}
