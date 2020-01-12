package features;

import java.text.NumberFormat;
import java.util.Locale;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;
import com.solveurits.automation.SalesforceAT;
import com.solveurits.automation.SeleniumAT;

import page.OpportunityPage;

public class Opportunity {
	//SolveurITS Library
	private SalesforceAT sf=new SalesforceAT();
	private SeleniumAT sl= new SeleniumAT();
	
	private OpportunityPage opportunityPage=new OpportunityPage();

	//Button & Tab
	public void navigateToOpportunityTab(WebDriver driver,int timeoutSeconds)
	{
        // Navigate to Opportunity Page
        sf.sfClickTab(driver,opportunityPage.opportunitiesTab, timeoutSeconds);		
	}

	public void navigateToHomeTab(WebDriver driver,int timeoutSeconds)
	{
        // Navigate to Home Page
        sf.sfClickTab(driver,opportunityPage.homeTab, timeoutSeconds);		
	}

	public void clickNew(WebDriver driver,int timeoutSeconds)
	{
        sf.sfClickButton(driver, opportunityPage.New, timeoutSeconds);
	}

    public void clickSave(WebDriver driver,int timeoutSeconds)
    {
    	//CLick Save Button
    	sf.sfClickButton(driver, opportunityPage.save, timeoutSeconds);
    }

    public void clickSaveAndNew(WebDriver driver,int timeoutSeconds)
    {
    	//CLick Save And New Button
    	sf.sfClickButton(driver, opportunityPage.saveAndNew, timeoutSeconds);
    }
    
    public void clickCancel(WebDriver driver,int timeoutSeconds)
    {
    	//CLick Cancel Button
    	sf.sfClickButton(driver, opportunityPage.cancel, timeoutSeconds);
    }
    
    public void navigateToDetails(WebDriver driver,int timeoutSeconds)
    {
        //Click Details Tab
        sf.sfClickTab(driver, opportunityPage.detailsTab, timeoutSeconds);
    }
    
    public void clickActivityTab(WebDriver driver,int timeoutSeconds)
    {
        //Click Activity Tab
        sf.sfClickTab(driver, opportunityPage.activityTab, timeoutSeconds);
    }

    public void clickChatterTab(WebDriver driver,int timeoutSeconds)
    {
        //Click Chatter Tab
        sf.sfClickTab(driver, opportunityPage.chatterTab, timeoutSeconds,2);
    }

	public void clickNext(WebDriver driver,int timeoutSeconds)
	{
        sf.sfClickButton(driver, opportunityPage.next, timeoutSeconds);
	}
	
	public void clickAddProduct(WebDriver driver,int timeoutSeconds)
	{
        sf.sfClickButton(driver, opportunityPage.addProducts, timeoutSeconds);
	}

	public void clickProduct(WebDriver driver,int timeoutSeconds)
	{
        sf.sfClickPartialLink(driver, opportunityPage.products, timeoutSeconds);
	}

	//SF Global Methods
    public void fillOpportinityDetails(WebDriver driver,Recordset data,int timeoutSeconds) throws FilloException {
        // Fill Form Fields
        sf.sfFormField(driver, opportunityPage.amount,data.getField("Amount"),timeoutSeconds);
        sf.sfFormField(driver, opportunityPage.private1,data.getField("Private"),timeoutSeconds);
        sf.sfFormField(driver, opportunityPage.closeDate,data.getField("Close Date"),timeoutSeconds);
        sf.sfFormField(driver, opportunityPage.opportunityName,data.getField("Opportunity Name"),timeoutSeconds);
        sf.sfFormField(driver, opportunityPage.accountName,data.getField("Account Name"),timeoutSeconds);
        sf.sfFormField(driver, opportunityPage.stage,data.getField("Stage"),timeoutSeconds);
        sf.sfFormField(driver, opportunityPage.type,data.getField("Type"),timeoutSeconds);
        sf.sfFormField(driver, opportunityPage.probability,data.getField("Probability (%)"),timeoutSeconds,true);
        sf.sfFormField(driver, opportunityPage.leadSource,data.getField("Lead Source"),timeoutSeconds);
    }

    public void getOpportinityDetailsAndPrintConsole(WebDriver driver,int timeoutSeconds){
        System.out.println(sf.sfGetPageHeaderTitle(driver, timeoutSeconds));
        System.out.println(sf.sfGetFormDetailText(driver, opportunityPage.amount, timeoutSeconds));
        System.out.println(sf.sfGetFormDetailCheckbox(driver, opportunityPage.private1, timeoutSeconds));
        System.out.println(sf.sfGetFormDetailText(driver, opportunityPage.closeDate, timeoutSeconds));
        System.out.println(sf.sfGetFormDetailText(driver, opportunityPage.opportunityName, timeoutSeconds));
        System.out.println(sf.sfGetFormDetailText(driver, opportunityPage.accountName, timeoutSeconds));
        System.out.println(sf.sfGetFormDetailText(driver, opportunityPage.stage, timeoutSeconds));
        System.out.println(sf.sfGetFormDetailText(driver, opportunityPage.type, timeoutSeconds));
        System.out.println(sf.sfGetFormDetailText(driver, opportunityPage.probability, timeoutSeconds));
        System.out.println(sf.sfGetFormDetailText(driver, opportunityPage.leadSource, timeoutSeconds));    }
    
    public void verifyOpportunityDetails(WebDriver driver,Recordset data,int timeoutSeconds) throws FilloException
    {
        //verify Opportunity Details
    	// number to currency converter
        Locale locale = new Locale("en", "US");      
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
        String amount=currencyFormatter.format(Double.parseDouble(data.getField("Amount")));
        sf.sfVerifyFormDetailShouldContain(driver, opportunityPage.amount,amount,timeoutSeconds);
        sf.sfVerifyFormDetailShouldBe(driver, opportunityPage.private1,data.getField("Private"),timeoutSeconds);
        sf.sfVerifyFormDetailShouldBe(driver, opportunityPage.closeDate,data.getField("Close Date"),timeoutSeconds);
        sf.sfVerifyFormDetailShouldBe(driver, opportunityPage.opportunityName,data.getField("Opportunity Name"),timeoutSeconds);
        sf.sfVerifyFormDetailShouldBe(driver, opportunityPage.accountName,data.getField("Account Name"),timeoutSeconds);
        sf.sfVerifyFormDetailShouldBe(driver, opportunityPage.stage,data.getField("Stage"),timeoutSeconds);
        sf.sfVerifyFormDetailShouldBe(driver, opportunityPage.type,data.getField("Type"),timeoutSeconds);
        sf.sfVerifyFormDetailShouldBe(driver, opportunityPage.probability,data.getField("Probability (%)")+"%",timeoutSeconds);
        sf.sfVerifyFormDetailShouldBe(driver, opportunityPage.leadSource,data.getField("Lead Source"),timeoutSeconds);
    }

    public void selectProductCheckbox(WebDriver driver,Recordset data,int timeoutSeconds) throws FilloException {
        // Select Product Checkbox
    	sf.sfSelectProductCheckbox(driver, data.getField("Product1"), timeoutSeconds);
    	sf.sfSelectProductCheckbox(driver, data.getField("Product2"), timeoutSeconds);
    	sf.sfSelectProductCheckbox(driver, data.getField("Product3"), timeoutSeconds);
    }
    
    public void fillProductDetails(WebDriver driver,Recordset data,int timeoutSeconds) throws FilloException {
        // Fill Product Details
    	sf.sfEnterProductValue(driver, data.getField("Product1"), data.getField("Column1"), data.getField("Quantity1"), timeoutSeconds);
       	sf.sfEnterProductValue(driver, data.getField("Product1"), data.getField("Column2"), data.getField("Line Description 1"), timeoutSeconds);
       	sf.sfEnterProductValue(driver, data.getField("Product2"), data.getField("Column1"), data.getField("Quantity2"), timeoutSeconds);
       	sf.sfEnterProductValue(driver, data.getField("Product2"), data.getField("Column2"), data.getField("Line Description 2"), timeoutSeconds);
       	sf.sfEnterProductValue(driver, data.getField("Product3"), data.getField("Column1"), data.getField("Quantity3"), timeoutSeconds);
       	sf.sfEnterProductValue(driver, data.getField("Product3"), data.getField("Column2"), data.getField("Line Description 3"), timeoutSeconds);
        }
    
    public void createOpportunityAndVerify(WebDriver driver,Recordset data,int timeoutSeconds) throws FilloException
    {
    	// Navigate To Opportunity Tab
    	navigateToOpportunityTab(driver, timeoutSeconds);
    	// Click New Button
    	clickNew(driver, timeoutSeconds);
    	// Fill Account Details
    	fillOpportinityDetails(driver, data, timeoutSeconds);
    	// Click Save Button
    	clickSave(driver, timeoutSeconds);
    	//Navigate to Details tab - Account Details
    	navigateToDetails(driver, timeoutSeconds);
    	//Verify Accounts Details
    	verifyOpportunityDetails(driver, data, timeoutSeconds);
    	//Print Account Details on console
    	getOpportinityDetailsAndPrintConsole(driver, timeoutSeconds);
    }
    
    //SF With Specific Method
    public void createOpportunityAndVerifyWithSpecificMethod(WebDriver driver,Recordset data,int timeoutSeconds) throws FilloException
    {
    	// Navigate To Opportunity Tab
    	navigateToOpportunityTab(driver, timeoutSeconds);
    	// Click New Button
    	clickNew(driver, timeoutSeconds);
    	// Fill Account Details
    	fillOpportinityDetailsWithSpecificMethod(driver, data, timeoutSeconds);
    	// Click Save Button
    	clickSave(driver, timeoutSeconds);
    	//Navigate to Details tab - Account Details
    	navigateToDetails(driver, timeoutSeconds);
    	//Verify Accounts Details
    	verifyOpportunityDetails(driver, data, timeoutSeconds);
    	//Print Account Details on console
    	getOpportinityDetailsAndPrintConsole(driver, timeoutSeconds);
    }
    
    public void fillOpportinityDetailsWithSpecificMethod(WebDriver driver,Recordset data,int timeoutSeconds) throws FilloException {
        // Fill Form Fields
        sf.sfInputText(driver, opportunityPage.amount,data.getField("Amount"),timeoutSeconds);
        sf.sfCheckBoxRadio(driver, opportunityPage.private1,data.getField("Private"),timeoutSeconds);
        sf.sfInputText(driver, opportunityPage.closeDate,data.getField("Close Date"),timeoutSeconds);
        sf.sfInputText(driver, opportunityPage.opportunityName,data.getField("Opportunity Name"),timeoutSeconds);
        sf.sfInputTextAutoComplete(driver, opportunityPage.accountName,data.getField("Account Name"),timeoutSeconds);
        sf.sfSelectOption(driver, opportunityPage.stage,data.getField("Stage"),timeoutSeconds);
        sf.sfSelectOption(driver, opportunityPage.type,data.getField("Type"),timeoutSeconds);
        sf.sfInputText(driver, opportunityPage.probability,data.getField("Probability (%)"),timeoutSeconds,true);
        sf.sfSelectOption(driver, opportunityPage.leadSource,data.getField("Lead Source"),timeoutSeconds);
    }
    
    //SF With Element Method
    public void createOpportunityAndVerifyWithElementMethod(WebDriver driver,Recordset data,int timeoutSeconds) throws FilloException
    {
    	// Navigate To Opportunity Tab
    	navigateToOpportunityTab(driver, timeoutSeconds);
    	// Click New Button
    	clickNew(driver, timeoutSeconds);
    	// Fill Account Details
    	fillOpportinityDetailsWithElementMethod(driver, data, timeoutSeconds);
    	// Click Save Button
    	clickSave(driver, timeoutSeconds);
    	//Navigate to Details tab - Account Details
    	navigateToDetails(driver, timeoutSeconds);
    	//Verify Accounts Details
    	verifyOpportunityDetails(driver, data, timeoutSeconds);
    	//Print Account Details on console
    	getOpportinityDetailsAndPrintConsole(driver, timeoutSeconds);
    }
    
    public void fillOpportinityDetailsWithElementMethod(WebDriver driver,Recordset data,int timeoutSeconds) throws FilloException {
        // Fill Form Fields
        WebElement amount=sf.sfGetFormFieldElement(driver, "Amount",timeoutSeconds);
        amount.sendKeys(data.getField("Amount"));
        System.out.println("Amount :- "+amount.getAttribute("value"));

        WebElement closeDate=sf.sfGetFormFieldElement(driver, "Close Date",timeoutSeconds);
        closeDate.sendKeys(data.getField("Close Date"));
        System.out.println("Close Date :- "+closeDate.getAttribute("value"));

        WebElement closeDate=sf.sfGetFormFieldElement(driver, "Opportunity Name",timeoutSeconds);
        closeDate.sendKeys(data.getField("Opportunity Name"));
        System.out.println("Opportunity Name :- "+closeDate.getAttribute("value"));

        sf.sfCheckBoxRadio(driver, opportunityPage.private1,data.getField("Private"),timeoutSeconds);
        sf.sfInputText(driver, opportunityPage.opportunityName,data.getField("Opportunity Name"),timeoutSeconds);
        sf.sfInputTextAutoComplete(driver, opportunityPage.accountName,data.getField("Account Name"),timeoutSeconds);
        sf.sfSelectOption(driver, opportunityPage.stage,data.getField("Stage"),timeoutSeconds);
        sf.sfSelectOption(driver, opportunityPage.type,data.getField("Type"),timeoutSeconds);
        sf.sfInputText(driver, opportunityPage.probability,data.getField("Probability (%)"),timeoutSeconds,true);
        sf.sfSelectOption(driver, opportunityPage.leadSource,data.getField("Lead Source"),timeoutSeconds);
    }

}
