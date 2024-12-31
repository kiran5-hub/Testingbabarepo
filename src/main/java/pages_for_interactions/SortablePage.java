
//Sortable page class for sorting all the list options

package pages_for_interactions;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseLibrary.Library_For_Alert_Windows_Frames;

public class SortablePage extends Library_For_Alert_Windows_Frames {

    // Constructor - Initializes the page elements.
    public SortablePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@data-target='#interations']")
    private WebElement interactionsButton;

    @FindBy(xpath = "//a[text()='sortable']")
    private WebElement sortableOption;

    @FindBy(xpath = "//button[@onclick='sortTable()']")
    private WebElement sortButton;

    //@FindBy(xpath = "//table[@id='myTable']//tr[th[text()='Name']]/following-sibling::tr/td[following-sibling::td]")
    @FindBy(xpath = "//table[@id='myTable']//tr/td[count(//table[@id='myTable']//th[text()='Name']/preceding-sibling::th)+1]")
    private List<WebElement> List1;    //List of names before clicking sort button

    @FindBy(xpath = "//table[@id='myTable']//tr[td]/td[1]")
    private List<WebElement> List2;      //List of names after clicking sort button(actual names list)

    @FindBy(xpath = "//table[@id='myTable']//tr[th[text()='Country']]/following-sibling::tr/td[preceding-sibling::td]")
    private List<WebElement> List3;       //List of countries before clicking sort button

    @FindBy(xpath = "//table[@id='myTable']//tr[td]/td[last()]")
    private List<WebElement> List4;       //List of countries after clicking sort button(actual countries list)
    
    @FindBy(xpath = "//table[@id='myTable']//tr/td")
    private List<WebElement> List5;         //List which contains both names and countries

    public void clickOnInteractions() {
        waitforClick(interactionsButton);
        //interactionsButton.click();
    }

    public void clickOnSortableOption() {
        waitforClick(sortableOption);
        //sortableOption.click();
    }
    
    public void sortNameListUsingMap() {
    	
    	//convert webelement list to a list of strings containing the text of each webelement using map
    	List<String> textList = List1.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    	Collections.sort(textList);
    	
    	//Print each text value
    	textList.forEach(System.out::println);
    }

    public void sortNameListUsingTraditionalForLoop(){


	    // Create a new list to hold the text values of the WebElements in List1
	    List<String> textList = new ArrayList<String>();

	    // Extract the text from each WebElement in List1 and add it to the textList
	    for (int i = 0; i < List1.size(); i++) {
	        String text = List1.get(i).getText();
	        textList.add(text);
	    }

	    // Print the original (unsorted) list
	    System.out.println("Original list of texts from List1:");
	    for (int i = 0; i < textList.size(); i++) {
	        System.out.println("Text of element " + (i + 2) + ": " + textList.get(i));
	    }

	    // Sort the list of texts
	    Collections.sort(textList);  //this will sort the textlist so you dont need to store it seperately

	    // Print the sorted list
	    System.out.println("\nSorted list of texts from List1:");
	    for (int i = 0; i < textList.size(); i++) {
	        System.out.println("Text of element " + (i + 2) + ": " + textList.get(i));
	    }
	}

	public void sortNameListUsingEnhancedForLoop() {
		
	    List<String> names = new ArrayList<String>();
	    names.add("Berglunds snabbkop");
	    names.add("North/South");
	    names.add("Alfreds Futterkiste");
	    names.add("Koniglich Essen");
	    names.add("Magazzini Alimentari Riuniti");
	    names.add("Paris specialites");
	    names.add("Island Trading");
	    names.add("Laughing Bacchus Winecellars");
	    
	    Collections.sort(names);
	    
	    System.out.println("sorted names");
	   
	/*    for(String name : names) {
        System.out.println(name);
    } */
	    
	    for(int i = 0; i<names.size(); i++) {
	    	System.out.println(names.get(i));
	    }
}

	public void sortNameListbygetTextmethod() {
		    }

	public void sortNameListAndValidate() {
		// Create a new list to hold the text values of the WebElements in List1
	    List<String> textList = new ArrayList<String>();

	    // Extract the text from each WebElement in List1 and add it to the textList
	    for (int i = 0; i < List5.size(); i++) {
	        String text = List5.get(i).getText();
	        textList.add(text);
	    }

	    // Print the original (unsorted) list
	    System.out.println("Original list of texts from List5:");
	    for (int i = 0; i < textList.size(); i++) {
	        System.out.println("Text of element " + (i + 1) + ": " + textList.get(i));
	    }

	    // Sort the list of texts
	    Collections.sort(textList);  //this will sort the textlist so you dont need to store it seperately

	    // Print the sorted list
	    System.out.println("\nSorted list of texts from List5:");
	    for (int i = 0; i < textList.size(); i++) {
	        System.out.println("Text of element " + (i + 1) + ": " + textList.get(i));
	    }

		
	}
	
}