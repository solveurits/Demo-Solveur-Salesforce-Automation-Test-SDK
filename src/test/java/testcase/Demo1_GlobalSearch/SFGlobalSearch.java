package testcase.Demo1_GlobalSearch;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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

import io.github.bonigarcia.wdm.WebDriverManager;

public class SFGlobalSearch {
	public SalesforceAT sf=new SalesforceAT();
	public SeleniumAT sl= new SeleniumAT();
    public WebDriver driver;
    
	Fillo fillo=new Fillo();

    @BeforeSuite
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();   
    }

    @BeforeTest
    public void setupTest() throws FilloException {
    	ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--disable-notifications");
        ops.addArguments("start-maximized");
    	driver = new ChromeDriver(ops);
    	//Navigate URL
//        driver.get("http://login.Salesforce.com/");
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

    @Test
    public void globalSearch() throws FilloException, InterruptedException {
    	int timeoutSeconds=30;
    	//Global Search With Search Text
    	sf.sfGlobalSearch(driver, "Demo Test", timeoutSeconds);
    	Thread.sleep(7000);

    	//Global Search With Search Text & Filter
    	sf.sfGlobalSearch(driver, "Demo Test", "Accounts", timeoutSeconds,true);
    	Thread.sleep(7000);
    	
    	//Global Search With Search Text contains 
    	sf.sfGlobalSearchContains(driver, "Demo Te", timeoutSeconds,true);
    	Thread.sleep(7000);
    	
    	//Global Search With Search Text contains & Filter
    	sf.sfGlobalSearchContains(driver, "Demo Te", "Accounts", timeoutSeconds,true);
    	Thread.sleep(7000);
    	}    
}
