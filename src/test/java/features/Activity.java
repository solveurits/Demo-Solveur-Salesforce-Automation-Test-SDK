package features;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;
import com.solveurits.automation.SalesforceAT;
import com.solveurits.automation.SeleniumAT;

import page.ActivityPage;

public class Activity {
	//SolveurITS Library
	private SalesforceAT sf=new SalesforceAT();
	private SeleniumAT sl= new SeleniumAT();
	
	//Page
	ActivityPage activityPage=new ActivityPage();
	
    public void clickSave(WebDriver driver,int timeoutSeconds)
    {
    	//CLick Save Button
    	sf.sfClickButton(driver, activityPage.save, timeoutSeconds);
    }

    public void clickAdd(WebDriver driver,int timeoutSeconds)
    {
    	//CLick Add Button
    	sf.sfClickButton(driver, activityPage.add, timeoutSeconds);
    }
    public void clicklogACallTab(WebDriver driver,int timeoutSeconds)
    {
        //Click Log A Call Tab
        sf.sfClickTab(driver, activityPage.logACallTab, timeoutSeconds);
    }
    public void clickNewEventTab(WebDriver driver,int timeoutSeconds)
    {
        //Click New Event Tab
        sf.sfClickTab(driver, activityPage.newEventTab, timeoutSeconds);
    }
    public void clickNewTaskTab(WebDriver driver,int timeoutSeconds)
    {
        //Click Task Tab
        sf.sfClickTab(driver, activityPage.newTaskTab, timeoutSeconds);
    }

    public void clickActivityTab(WebDriver driver,int timeoutSeconds)
    {
        //Click Activity Tab
        sf.sfClickTab(driver, activityPage.activityTab, timeoutSeconds);
    }

    public void fillTaskDetails(WebDriver driver,Recordset data,int timeoutSeconds) throws FilloException
    {
    	sf.sfFormField(driver, activityPage.subject,data.getField("Subject") ,timeoutSeconds, true);
    	sf.sfFormField(driver, activityPage.dueDate,data.getField("Due Date") , timeoutSeconds);
    	sf.sfFormField(driver, activityPage.name,data.getField("Name") , timeoutSeconds);
    	if(!data.getField("Related To").equals("")) sf.sfFormField(driver, activityPage.relatedTo,data.getField("Related To") , timeoutSeconds);
    	if(!data.getField("Assigned To").equals("")) sf.sfFormField(driver, activityPage.assignedTo,data.getField("Assigned To") , timeoutSeconds);
    	sf.sfFormField(driver, activityPage.status,data.getField("Status") , timeoutSeconds);
    }
    
    public void fillLogACallDetails(WebDriver driver,Recordset data,int timeoutSeconds) throws FilloException
    {
    	sf.sfFormField(driver, activityPage.subject,data.getField("Subject"),timeoutSeconds , true);
    	sf.sfFormField(driver, activityPage.comments,data.getField("Comments") , timeoutSeconds);
    	sf.sfFormField(driver, activityPage.name,data.getField("Name") , timeoutSeconds);
    	if(!data.getField("Related To").equals("")) sf.sfFormField(driver, activityPage.relatedTo,data.getField("Related To") , timeoutSeconds);
    }
    
    public void fillEventDetails(WebDriver driver,Recordset data,int timeoutSeconds) throws FilloException
    {
    	sf.sfFormField(driver, activityPage.subject,data.getField("Subject") ,timeoutSeconds, true);
    	DateFormat df = new SimpleDateFormat("MMM dd, yyyy");
    	Date dateobj = new Date();
    	sf.sfFormField(driver, activityPage.date, df.format(dateobj), timeoutSeconds, true,1);
    	sf.sfFormField(driver, activityPage.time, data.getField("StartTime"), timeoutSeconds, true,1);
    	long ltime=dateobj.getTime()+8*24*60*60*1000;
    	dateobj=new Date(ltime); 
    	sf.sfFormField(driver, activityPage.date, df.format(dateobj), timeoutSeconds, true,2);
    	sf.sfFormField(driver, activityPage.time, data.getField("EndTime"), timeoutSeconds, true,2);
    	sf.sfFormField(driver, activityPage.allDayEvent,data.getField("All-Day Event") , timeoutSeconds);
    	sf.sfFormField(driver, activityPage.name,data.getField("Name") , timeoutSeconds);
    	if(!data.getField("Related To").equals("")) sf.sfFormField(driver, activityPage.relatedTo,data.getField("Related To") , timeoutSeconds);
    	if(!data.getField("Assigned To").equals("")) sf.sfFormField(driver, activityPage.assignedTo,data.getField("Assigned To") , timeoutSeconds);
    	sf.sfFormField(driver, activityPage.location,data.getField("Location") , timeoutSeconds);
    }    

    public void fillTaskDetailsWithSpecificMethod(WebDriver driver,Recordset data,int timeoutSeconds) throws FilloException
    {
    	sf.sfInputText(driver, activityPage.subject,data.getField("Subject") ,timeoutSeconds, true);
    	sf.sfInputText(driver, activityPage.dueDate,data.getField("Due Date") , timeoutSeconds);
    	sf.sfInputTextAutoComplete(driver, activityPage.name,data.getField("Name") , timeoutSeconds);
    	if(!data.getField("Related To").equals("")) sf.sfInputTextAutoComplete(driver, activityPage.relatedTo,data.getField("Related To") , timeoutSeconds);
    	if(!data.getField("Assigned To").equals("")) sf.sfInputTextAutoComplete(driver, activityPage.assignedTo,data.getField("Assigned To") , timeoutSeconds);
    	sf.sfSelectOption(driver, activityPage.status,data.getField("Status") , timeoutSeconds);
    }
    
    public void fillLogACallDetailsWithSpecificMethod(WebDriver driver,Recordset data,int timeoutSeconds) throws FilloException
    {
    	sf.sfInputText(driver, activityPage.subject,data.getField("Subject"),timeoutSeconds , true);
    	sf.sfInputText(driver, activityPage.comments,data.getField("Comments") , timeoutSeconds);
    	sf.sfInputTextAutoComplete(driver, activityPage.name,data.getField("Name") , timeoutSeconds);
    	if(!data.getField("Related To").equals("")) sf.sfInputTextAutoComplete(driver, activityPage.relatedTo,data.getField("Related To") , timeoutSeconds);
    }
    
    public void fillEventDetailsWithSpecificMethod(WebDriver driver,Recordset data,int timeoutSeconds) throws FilloException
    {
    	sf.sfInputText(driver, activityPage.subject,data.getField("Subject") ,timeoutSeconds, true);
    	DateFormat df = new SimpleDateFormat("MMM dd, yyyy");
    	Date dateobj = new Date();
    	sf.sfInputText(driver, activityPage.date, df.format(dateobj), timeoutSeconds, true,1);
    	sf.sfInputText(driver, activityPage.time, data.getField("StartTime"), timeoutSeconds, true,1);
    	long ltime=dateobj.getTime()+8*24*60*60*1000;
    	dateobj=new Date(ltime); 
    	sf.sfInputText(driver, activityPage.date, df.format(dateobj), timeoutSeconds, true,2);
    	sf.sfInputText(driver, activityPage.time, data.getField("EndTime"), timeoutSeconds, true,2);
    	sf.sfCheckBoxRadio(driver, activityPage.allDayEvent,data.getField("All-Day Event") , timeoutSeconds);
    	sf.sfInputTextAutoComplete(driver, activityPage.name,data.getField("Name") , timeoutSeconds);
    	if(!data.getField("Related To").equals("")) sf.sfInputTextAutoComplete(driver, activityPage.relatedTo,data.getField("Related To") , timeoutSeconds);
    	if(!data.getField("Assigned To").equals("")) sf.sfInputTextAutoComplete(driver, activityPage.assignedTo,data.getField("Assigned To") , timeoutSeconds);
    	sf.sfInputText(driver, activityPage.location,data.getField("Location") , timeoutSeconds);
    }    

    public void verifyTaskSuccessMessage(WebDriver driver,Recordset data,int timeoutSeconds) throws FilloException {
    	sl.waitUntilPageContainsElement(driver,timeoutSeconds,By.xpath("//*[contains(@class,'Toast')]//*[contains(.,'Task')]"));
    	sl.waitUntilPageContainsElement(driver,timeoutSeconds,By.xpath("//*[contains(@class,'Toast')]//*[contains(.,'was created.')]"));
        }
    
    public void verifyLogACallSuccessMessage(WebDriver driver,Recordset data,int timeoutSeconds) throws FilloException {
    	sl.waitUntilPageContainsElement(driver,timeoutSeconds,By.xpath("//*[contains(@class,'Toast')]//*[contains(.,'Task')]"));
    	sl.waitUntilPageContainsElement(driver,timeoutSeconds,By.xpath("//*[contains(@class,'Toast')]//*[contains(.,'was saved.')]"));
    }
    
    public void verifyEventSuccessMessage(WebDriver driver,Recordset data,int timeoutSeconds) throws FilloException {
    	sl.waitUntilPageContainsElement(driver,timeoutSeconds,By.xpath("//*[contains(@class,'Toast')]//*[contains(.,'Event')]"));
    	sl.waitUntilPageContainsElement(driver,timeoutSeconds,By.xpath("//*[contains(@class,'Toast')]//*[contains(.,'was created.')]"));
    }
    
    public void addNewTaskActivity(WebDriver driver,Recordset data,int timeoutSeconds) throws FilloException
    {
    	//Click New Task
    	clickNewTaskTab(driver, timeoutSeconds);
    	//Click Add tab in Activity
    	clickAdd(driver, timeoutSeconds);
    	
    	//Fill New Task details
    	fillTaskDetails(driver, data, timeoutSeconds);
    	// click save button
    	clickSave(driver, timeoutSeconds);
    	//Verify Success Message
    	verifyTaskSuccessMessage(driver, data, timeoutSeconds);
    	//Wait until New Task Tab Element not visible
    	sf.sfWaitUntilFormElementIsNotVisible(driver, activityPage.subject, timeoutSeconds);
    }

    public void addLogACallActivity(WebDriver driver,Recordset data,int timeoutSeconds) throws FilloException
    {
    	//Click Log a Call
    	clicklogACallTab(driver, timeoutSeconds);
    	//Fill New Log a Call details
    	fillLogACallDetails(driver, data, timeoutSeconds);
    	//Click save button
    	clickSave(driver, timeoutSeconds);
    	verifyLogACallSuccessMessage(driver, data, timeoutSeconds);
    	//Wait until New Log A Call Tab Element not visible
    	sf.sfWaitUntilFormElementIsNotVisible(driver, activityPage.subject, timeoutSeconds);
    }

    public void addNewEventActivity(WebDriver driver,Recordset data,int timeoutSeconds) throws FilloException
    {
    	//Click New Event Tab
    	clickNewEventTab(driver, timeoutSeconds);
    	//Fill New Event details
    	fillEventDetails(driver, data, timeoutSeconds);
    	// click save button
    	clickSave(driver, timeoutSeconds);
    	// Wait until Success Message
    	verifyEventSuccessMessage(driver, data, timeoutSeconds);
    	//Wait until New Event Tab Element not visible
    	sf.sfWaitUntilFormElementIsNotVisible(driver, activityPage.subject, timeoutSeconds);
    }

    public void addNewTaskActivityWithSpecificMethod(WebDriver driver,Recordset data,int timeoutSeconds) throws FilloException
    {
    	//Click New Task
    	clickNewTaskTab(driver, timeoutSeconds);
    	//Click Add tab in Activity
    	clickAdd(driver, timeoutSeconds);
    	
    	//Fill New Task details
    	fillTaskDetailsWithSpecificMethod(driver, data, timeoutSeconds);
    	// click save button
    	clickSave(driver, timeoutSeconds);
    	//Verify Success Message
    	verifyTaskSuccessMessage(driver, data, timeoutSeconds);
    	//Wait until New Task Tab Element not visible
    	sf.sfWaitUntilFormElementIsNotVisible(driver, activityPage.subject, timeoutSeconds);
    }

    public void addLogACallActivityWithSpecificMethod(WebDriver driver,Recordset data,int timeoutSeconds) throws FilloException
    {
    	//Click Log a Call
    	clicklogACallTab(driver, timeoutSeconds);
    	//Fill New Log a Call details
    	fillLogACallDetailsWithSpecificMethod(driver, data, timeoutSeconds);
    	//Click save button
    	clickSave(driver, timeoutSeconds);
    	verifyLogACallSuccessMessage(driver, data, timeoutSeconds);
    	//Wait until New Log A Call Tab Element not visible
    	sf.sfWaitUntilFormElementIsNotVisible(driver, activityPage.subject, timeoutSeconds);
    }

    public void addNewEventActivityWithSpecificMethod(WebDriver driver,Recordset data,int timeoutSeconds) throws FilloException
    {
    	//Click New Event Tab
    	clickNewEventTab(driver, timeoutSeconds);
    	//Fill New Event details
    	fillEventDetailsWithSpecificMethod(driver, data, timeoutSeconds);
    	// click save button
    	clickSave(driver, timeoutSeconds);
    	// Wait until Success Message
    	verifyEventSuccessMessage(driver, data, timeoutSeconds);
    	//Wait until New Event Tab Element not visible
    	sf.sfWaitUntilFormElementIsNotVisible(driver, activityPage.subject, timeoutSeconds);
    }

}
