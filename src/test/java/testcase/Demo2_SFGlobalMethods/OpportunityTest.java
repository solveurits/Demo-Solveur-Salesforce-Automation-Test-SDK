package testcase.Demo2_SFGlobalMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.solveurits.automation.SalesforceAT;
import com.solveurits.automation.SeleniumAT;

import features.Accounts;
import features.Activity;
import features.Chatter;
import features.Opportunity;
import io.github.bonigarcia.wdm.WebDriverManager;
import page.ActivityPage;
import page.ChatterPage;

public class OpportunityTest {
	public SalesforceAT sf=new SalesforceAT();
	public SeleniumAT sl= new SeleniumAT();
    public WebDriver driver;
    public Accounts account=new Accounts();
    public Chatter chatter=new Chatter();
    public Activity activity=new Activity();
    public Opportunity opportunity=new Opportunity();

    public ChatterPage chatterPage=new ChatterPage();
    public ActivityPage activityPage=new ActivityPage();
    
	Fillo fillo=new Fillo();

    @BeforeSuite
    public static void setupSuite() {
        WebDriverManager.chromedriver().setup();   //WebDriverManager directly downloads driver based on browser version
        //To set Driver property manually, remove above line & set path of driver below
        //System.setProperty("webdriver.chrome.driver","C:\\Users\\bryogeesh\\Videos\\chromedriver.exe");
    }

    @BeforeTest
    public void setupTest() throws FilloException {
    	driver = new ChromeDriver();
    	//Maximize
    	driver.manage().window().maximize();
    	//Navigate URL
//      driver.get("http://login.Salesforce.com/");
      	driver.get("https://ap15.lightning.force.com/lightning/page/home");

        Connection connectionUser=fillo.getConnection(System.getProperty("user.dir")+"\\src\\test\\java\\testData\\users.xlsx");
    	String strQuery="Select * from Sheet1";
    	Recordset dataUser=connectionUser.executeQuery(strQuery);
    	dataUser.next();

        //Login
        sf.sfLoginIntoApplication(driver,dataUser.getField("Username"),dataUser.getField("Password"), 30);
        sl.waitUntilTitleNotContains(driver, "Login", 30);
    }

    @AfterTest
    public void teardown() {
        if (driver != null) {
        	int timeoutSeconds=30;
        	//Logout
            try{
            	sf.sfLogOutFromApplication(driver, timeoutSeconds);
            }catch(Exception e){}
            driver.quit();
        }
    }

    @Test(priority = 1)
    public void Opportunity() throws FilloException {
    	int timeoutSeconds=30;
    	//Extract Data from Excel Sheet
    	Connection connectionOpportunity=fillo.getConnection(System.getProperty("user.dir")+"\\src\\test\\java\\testData\\opportunity.xlsx");
    	String strQuery="Select * from Sheet1";
    	Recordset dataOpportunity=connectionOpportunity.executeQuery(strQuery);
    	dataOpportunity.next();
    	
    	//Create Opportunity And Verify Data
    	opportunity.createOpportunityAndVerify(driver, dataOpportunity, timeoutSeconds);
    }

    @Test(priority = 2)
    public void addActivity() throws FilloException
    {
    	int timeoutSeconds=30;
    	//Extract Data from Excel Sheet
    	Connection connectionActivity=fillo.getConnection(System.getProperty("user.dir")+"\\src\\test\\java\\testData\\activity.xlsx");
    	String strQuery="Select * from Sheet1";
    	Recordset dataActivity=connectionActivity.executeQuery(strQuery);
    	dataActivity.next();

    	//Click Activity Tab
    	opportunity.clickActivityTab(driver, timeoutSeconds);

    	//Add New Task Activity
    	activity.addNewTaskActivity(driver, dataActivity, timeoutSeconds);
    	//Add New Log A Call Activity
    	activity.addLogACallActivity(driver, dataActivity, timeoutSeconds);
    	//Add New Event Activity
    	activity.addNewEventActivity(driver, dataActivity, timeoutSeconds);
    }
    
    @Test(priority = 3)
    public void addChatter() throws FilloException
    {
    	int timeoutSeconds=30;
    	//Extract Data from Excel Sheet
    	Connection connectionChatter=fillo.getConnection(System.getProperty("user.dir")+"\\src\\test\\java\\testData\\chatter.xlsx");
    	String strQuery="Select * from Sheet1";
    	Recordset dataChatter=connectionChatter.executeQuery(strQuery);
    	dataChatter.next();

    	//Navigate to Chatter Tab
    	opportunity.clickChatterTab(driver, timeoutSeconds);
    	
    	//Add Post Chatter
    	chatter.addPostChatter(driver, dataChatter, timeoutSeconds);
    	//Add Poll Chatter
    	chatter.addPollChatter(driver, dataChatter, timeoutSeconds);
    	//Add Question Chatter
    	chatter.addQuestionChatter(driver, dataChatter, timeoutSeconds);
    }

    	
}
