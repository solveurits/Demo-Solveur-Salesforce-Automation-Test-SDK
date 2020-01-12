package features;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.openqa.selenium.WebDriver;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;
import com.solveurits.automation.SalesforceAT;
import com.solveurits.automation.SeleniumAT;

import page.ChatterPage;

public class Chatter {
	//SolveurITS Library
	private SalesforceAT sf=new SalesforceAT();
	private SeleniumAT sl= new SeleniumAT();
	
	//Page
	ChatterPage chatterPage=new ChatterPage();
	
    public void navigateToChatterTab(WebDriver driver,int timeoutSeconds)
    {
        //Click Chatter Tab
        sf.sfClickTab(driver, chatterPage.chatterTab, timeoutSeconds);
    }

    public void clickShare(WebDriver driver,int timeoutSeconds)
    {
        //Click Share
        sf.sfClickButton(driver, chatterPage.share, timeoutSeconds);
    }
    
    public void clickAddNewChoice(WebDriver driver,int timeoutSeconds)
    {
        //Click Add New Choice
        sf.sfClickButton(driver, chatterPage.addNewChoice, timeoutSeconds);
    }
    
    public void clickAsk(WebDriver driver,int timeoutSeconds)
    {
        //Click Ask
        sf.sfClickButton(driver, chatterPage.ask, timeoutSeconds);
    }
    
    public void clickPostTab(WebDriver driver,int timeoutSeconds)
    {
        //Click Post Tab
        sf.sfClickTab(driver, chatterPage.postTab, timeoutSeconds);
    }

    public void clickPollTab(WebDriver driver,int timeoutSeconds)
    {
        //Click Poll Tab
        sf.sfClickTab(driver, chatterPage.pollTab, timeoutSeconds);
    }

    public void clickQuestionTab(WebDriver driver,int timeoutSeconds)
    {
        //Click Question Tab
        sf.sfClickTab(driver, chatterPage.questionTab, timeoutSeconds);
    }
    
    public void fillPostDetails(WebDriver driver,Recordset data,int timeoutSeconds) throws FilloException
    {
    	sf.sfFormField(driver, chatterPage.shareAnUpdate, data.getField("Share An Update"), timeoutSeconds);
    }

    public void fillPollDetails(WebDriver driver,Recordset data,int timeoutSeconds) throws FilloException
    {
    	sf.sfFormField(driver, chatterPage.question, data.getField("Question"), timeoutSeconds);
    	sf.sfFormField(driver, chatterPage.choice+"1", data.getField("Choice 1"), timeoutSeconds);
    	sf.sfFormField(driver, chatterPage.choice+"2", data.getField("Choice 2"), timeoutSeconds);
    	sf.sfClickButton(driver, chatterPage.addNewChoice, timeoutSeconds);
    	sf.sfFormField(driver, chatterPage.choice+"3", data.getField("Choice 3"), timeoutSeconds);
    	sf.sfClickButton(driver, chatterPage.addNewChoice, timeoutSeconds);
    	sf.sfFormField(driver, chatterPage.choice+"4", data.getField("Choice 4"), timeoutSeconds);
    }

    public void fillQuestionDetails(WebDriver driver,Recordset data,int timeoutSeconds) throws FilloException
    {
    	sf.sfFormField(driver, chatterPage.questionEnter255Character, data.getField("Question 255 Character"), timeoutSeconds);
    	sf.sfFormField(driver, chatterPage.details,  data.getField("Details"), timeoutSeconds);
    }

    public void fillPostDetailsWithSpecificMethod(WebDriver driver,Recordset data,int timeoutSeconds) throws FilloException
    {
    	sf.sfInputText(driver, chatterPage.shareAnUpdate, data.getField("Share An Update"), timeoutSeconds);
    }

    public void fillPollDetailsWithSpecificMethod(WebDriver driver,Recordset data,int timeoutSeconds) throws FilloException
    {
    	sf.sfInputText(driver, chatterPage.question, data.getField("Question"), timeoutSeconds);
    	sf.sfInputText(driver, chatterPage.choice+"1", data.getField("Choice 1"), timeoutSeconds);
    	sf.sfInputText(driver, chatterPage.choice+"2", data.getField("Choice 2"), timeoutSeconds);
    	sf.sfClickButton(driver, chatterPage.addNewChoice, timeoutSeconds);
    	sf.sfInputText(driver, chatterPage.choice+"3", data.getField("Choice 3"), timeoutSeconds);
    	sf.sfClickButton(driver, chatterPage.addNewChoice, timeoutSeconds);
    	sf.sfFormField(driver, chatterPage.choice+"4", data.getField("Choice 4"), timeoutSeconds);
    }

    public void fillQuestionDetailsWithSpecificMethod(WebDriver driver,Recordset data,int timeoutSeconds) throws FilloException
    {
    	sf.sfInputText(driver, chatterPage.questionEnter255Character, data.getField("Question 255 Character"), timeoutSeconds);
    	sf.sfInputText(driver, chatterPage.details,  data.getField("Details"), timeoutSeconds);
    }

    public void addPostChatter(WebDriver driver,Recordset data,int timeoutSeconds) throws FilloException
    {
    	//Click Post Tab
    	clickPostTab(driver, timeoutSeconds);
    	//Click Share Button
    	clickShare(driver, timeoutSeconds);

    	//Fill Post Details
    	fillPostDetails(driver, data, timeoutSeconds);
    	//Click Share Button
    	clickShare(driver, timeoutSeconds);
    	//Wait until Post Tab Element not visible
    	sf.sfWaitUntilFormElementIsNotVisible(driver, chatterPage.shareAnUpdate, timeoutSeconds);
    }
    
    public void addPollChatter(WebDriver driver,Recordset data,int timeoutSeconds) throws FilloException
    {
    	//Click Poll Tab
    	clickPollTab(driver, timeoutSeconds);
    	//Fill Poll Details
    	fillPollDetails(driver, data, timeoutSeconds);
    	//Click Ask Button
    	clickAsk(driver, timeoutSeconds);
    	//Wait until Poll Tab Element not visible
    	sf.sfWaitUntilFormElementIsNotVisible(driver, chatterPage.question, timeoutSeconds);
    }
    
    public void addQuestionChatter(WebDriver driver,Recordset data,int timeoutSeconds) throws FilloException
    {
    	//Click Question Tab
    	clickQuestionTab(driver, timeoutSeconds);
    	//Fill Question Details
    	fillQuestionDetails(driver, data, timeoutSeconds);
    	//Click Ask Button
    	clickAsk(driver, timeoutSeconds);
    	//Wait until question Tab Element not visible
    	sf.sfWaitUntilFormElementIsNotVisible(driver, chatterPage.questionEnter255Character, timeoutSeconds);
    }   

    public void addPostChatterWithSpecificMethod(WebDriver driver,Recordset data,int timeoutSeconds) throws FilloException
    {
    	//Click Post Tab
    	clickPostTab(driver, timeoutSeconds);
    	//Click Share Button
    	clickShare(driver, timeoutSeconds);

    	//Fill Post Details
    	fillPostDetailsWithSpecificMethod(driver, data, timeoutSeconds);
    	//Click Share Button
    	clickShare(driver, timeoutSeconds);
    	//Wait until Post Tab Element not visible
    	sf.sfWaitUntilFormElementIsNotVisible(driver, chatterPage.shareAnUpdate, timeoutSeconds);
    }
    
    public void addPollChatterWithSpecificMethod(WebDriver driver,Recordset data,int timeoutSeconds) throws FilloException
    {
    	//Click Poll Tab
    	clickPollTab(driver, timeoutSeconds);
    	//Fill Poll Details
    	fillPollDetailsWithSpecificMethod(driver, data, timeoutSeconds);
    	//Click Ask Button
    	clickAsk(driver, timeoutSeconds);
    	//Wait until Poll Tab Element not visible
    	sf.sfWaitUntilFormElementIsNotVisible(driver, chatterPage.question, timeoutSeconds);
    }
    
    public void addQuestionChatterWithSpecificMethod(WebDriver driver,Recordset data,int timeoutSeconds) throws FilloException
    {
    	//Click Question Tab
    	clickQuestionTab(driver, timeoutSeconds);
    	//Fill Question Details
    	fillQuestionDetailsWithSpecificMethod(driver, data, timeoutSeconds);
    	//Click Ask Button
    	clickAsk(driver, timeoutSeconds);
    	//Wait until question Tab Element not visible
    	sf.sfWaitUntilFormElementIsNotVisible(driver, chatterPage.questionEnter255Character, timeoutSeconds);
    }   

}
