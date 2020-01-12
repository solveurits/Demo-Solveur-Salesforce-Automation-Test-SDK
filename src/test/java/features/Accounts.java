package features;

import java.text.NumberFormat;
import java.util.Locale;
import org.openqa.selenium.WebDriver;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;
import com.solveurits.automation.SalesforceAT;
import com.solveurits.automation.SeleniumAT;

import page.AccountPage;

public class Accounts {
	//SolveurITS Library
	private SalesforceAT sf=new SalesforceAT();
	private SeleniumAT sl= new SeleniumAT();
	
	//Page
	AccountPage accountPage=new AccountPage();
	
	public void navigateToAccountsTab(WebDriver driver,int timeoutSeconds)
	{
        // Navigate to Account Page
        sf.sfClickTab(driver,accountPage.accountsTab, timeoutSeconds);		
	}
	
	public void clickNew(WebDriver driver,int timeoutSeconds)
	{
        sf.sfClickButton(driver, accountPage.New, timeoutSeconds);
	}
	
    public void fillAccountDetails(WebDriver driver,Recordset data,int timeoutSeconds) throws FilloException {
        // Fill Form Fields
        sf.sfFormField(driver, accountPage.accountName,data.getField("Account Name"),timeoutSeconds);
        sf.sfFormField(driver, accountPage.phone, data.getField("Phone"), timeoutSeconds);
        sf.sfFormField(driver, accountPage.rating,data.getField("Rating"), timeoutSeconds);
        sf.sfFormField(driver, accountPage.parentAccount, data.getField("Parent Account"),timeoutSeconds);
        sf.sfFormField(driver, accountPage.fax, data.getField("Fax"), timeoutSeconds);
        sf.sfFormField(driver, accountPage.accountNumber, data.getField("Account Number"), timeoutSeconds);
        sf.sfFormField(driver, accountPage.website, data.getField("Website"), timeoutSeconds);
        sf.sfFormField(driver, accountPage.accountSite, data.getField("Account Site"), timeoutSeconds);
        sf.sfFormField(driver, accountPage.tickerSymbol, data.getField("Ticker Symbol"), timeoutSeconds);
        sf.sfFormField(driver, accountPage.type, data.getField("Type"), timeoutSeconds);
        sf.sfFormField(driver, accountPage.ownership, data.getField("Ownership"), timeoutSeconds);
        sf.sfFormField(driver, accountPage.industry, data.getField("Industry"), timeoutSeconds);
        sf.sfFormField(driver, accountPage.employees, data.getField("Employees"), timeoutSeconds);
        sf.sfFormField(driver, accountPage.annualRevenue, data.getField("Annual Revenue"), timeoutSeconds);
        sf.sfFormField(driver, accountPage.sicCode, data.getField("SIC Code"), timeoutSeconds);
        sf.sfFormField(driver, accountPage.checkbox123, data.getField("checkbox123"), timeoutSeconds);
        sf.sfFormField(driver, accountPage.datetime123, data.getField("datetime123"), timeoutSeconds);
        sf.sfFormField(driver, accountPage.email12, data.getField("email12"), timeoutSeconds);
        sf.sfFormField(driver, accountPage.time12, data.getField("time12"), timeoutSeconds, true);
        sf.sfFormField(driver, accountPage.date, data.getField("Date"), timeoutSeconds,true, 2);
        sf.sfFormField(driver, accountPage.time, data.getField("Time"), timeoutSeconds,true, 2);
        sf.sfFormField(driver, accountPage.billingStreet, data.getField("Billing Street"), timeoutSeconds);
        sf.sfFormField(driver, accountPage.billingCity, data.getField("Billing City"), timeoutSeconds);
        sf.sfFormField(driver, accountPage.billingStateProvince, data.getField("Billing State/Province"), timeoutSeconds);
        sf.sfFormField(driver, accountPage.billingZipPostalCode, data.getField("Billing Zip/Postal Code"), timeoutSeconds);
        sf.sfFormField(driver, accountPage.billingCountry, data.getField("Billing Country"), timeoutSeconds);
        sf.sfFormField(driver, accountPage.shippingStreet, data.getField("Shipping Street"), timeoutSeconds);
        sf.sfFormField(driver, accountPage.shippingStateProvince, data.getField("Shipping State/Province"), timeoutSeconds);
        sf.sfFormField(driver, accountPage.shippingZipPostalCode, data.getField("Shipping Zip/Postal Code"), timeoutSeconds);
        sf.sfFormField(driver, accountPage.shippingCity, data.getField("Shipping City"), timeoutSeconds);
        sf.sfFormField(driver, accountPage.shippingCountry, data.getField("Shipping Country"), timeoutSeconds);
        sf.sfFormField(driver, accountPage.customerPriority, data.getField("Customer Priority"), timeoutSeconds);
        sf.sfFormField(driver, accountPage.sla, data.getField("SLA"), timeoutSeconds);
        sf.sfFormField(driver, accountPage.active, data.getField("Active"), timeoutSeconds);
        sf.sfFormField(driver, accountPage.description, data.getField("Description"), timeoutSeconds);
        sf.sfFormField(driver, accountPage.picklisi678, data.getField("picklisi678_1"), timeoutSeconds);
        sf.sfFormField(driver, accountPage.picklisi678, data.getField("picklisi678_2"), timeoutSeconds);
    }

    public void fillAccountDetailsWithSpecificMethod(WebDriver driver,Recordset data,int timeoutSeconds) throws FilloException {
        // Fill Form Fields
        sf.sfInputText(driver, accountPage.accountName,data.getField("Account Name"),timeoutSeconds);
        sf.sfInputText(driver, accountPage.phone, data.getField("Phone"), timeoutSeconds);
        sf.sfSelectOption(driver, accountPage.rating,data.getField("Rating"), timeoutSeconds);
        sf.sfInputTextAutoComplete(driver, accountPage.parentAccount, data.getField("Parent Account"),timeoutSeconds);
        sf.sfInputText(driver, accountPage.fax, data.getField("Fax"), timeoutSeconds);
        sf.sfInputText(driver, accountPage.accountNumber, data.getField("Account Number"), timeoutSeconds);
        sf.sfInputText(driver, accountPage.website, data.getField("Website"), timeoutSeconds);
        sf.sfInputText(driver, accountPage.accountSite, data.getField("Account Site"), timeoutSeconds);
        sf.sfInputText(driver, accountPage.tickerSymbol, data.getField("Ticker Symbol"), timeoutSeconds);
        sf.sfSelectOption(driver, accountPage.type, data.getField("Type"), timeoutSeconds);
        sf.sfSelectOption(driver, accountPage.ownership, data.getField("Ownership"), timeoutSeconds);
        sf.sfSelectOption(driver, accountPage.industry, data.getField("Industry"), timeoutSeconds);
        sf.sfInputText(driver, accountPage.employees, data.getField("Employees"), timeoutSeconds);
        sf.sfInputText(driver, accountPage.annualRevenue, data.getField("Annual Revenue"), timeoutSeconds);
        sf.sfInputText(driver, accountPage.sicCode, data.getField("SIC Code"), timeoutSeconds);
        sf.sfCheckBoxRadio(driver, accountPage.checkbox123, data.getField("checkbox123"), timeoutSeconds);
        sf.sfInputText(driver, accountPage.datetime123, data.getField("datetime123"), timeoutSeconds);
        sf.sfInputText(driver, accountPage.email12, data.getField("email12"), timeoutSeconds);
        sf.sfInputText(driver, accountPage.time12, data.getField("time12"), timeoutSeconds, true);
        sf.sfInputText(driver, accountPage.date, data.getField("Date"), timeoutSeconds,true, 2);
        sf.sfInputText(driver, accountPage.time, data.getField("Time"), timeoutSeconds,true, 2);
        sf.sfInputText(driver, accountPage.billingStreet, data.getField("Billing Street"), timeoutSeconds);
        sf.sfInputText(driver, accountPage.billingCity, data.getField("Billing City"), timeoutSeconds);
        sf.sfInputText(driver, accountPage.billingStateProvince, data.getField("Billing State/Province"), timeoutSeconds);
        sf.sfInputText(driver, accountPage.billingZipPostalCode, data.getField("Billing Zip/Postal Code"), timeoutSeconds);
        sf.sfInputText(driver, accountPage.billingCountry, data.getField("Billing Country"), timeoutSeconds);
        sf.sfInputText(driver, accountPage.shippingStreet, data.getField("Shipping Street"), timeoutSeconds);
        sf.sfInputText(driver, accountPage.shippingStateProvince, data.getField("Shipping State/Province"), timeoutSeconds);
        sf.sfInputText(driver, accountPage.shippingZipPostalCode, data.getField("Shipping Zip/Postal Code"), timeoutSeconds);
        sf.sfInputText(driver, accountPage.shippingCity, data.getField("Shipping City"), timeoutSeconds);
        sf.sfInputText(driver, accountPage.shippingCountry, data.getField("Shipping Country"), timeoutSeconds);
        sf.sfSelectOption(driver, accountPage.customerPriority, data.getField("Customer Priority"), timeoutSeconds);
        sf.sfSelectOption(driver, accountPage.sla, data.getField("SLA"), timeoutSeconds);
        sf.sfSelectOption(driver, accountPage.active, data.getField("Active"), timeoutSeconds);
        sf.sfInputText(driver, accountPage.description, data.getField("Description"), timeoutSeconds);
        sf.sfAddOptionToMultiPickList(driver, accountPage.picklisi678, data.getField("picklisi678_1"), timeoutSeconds);
        sf.sfAddOptionToMultiPickList(driver, accountPage.picklisi678, data.getField("picklisi678_2"), timeoutSeconds);
    }

    public void clickSave(WebDriver driver,int timeoutSeconds)
    {
    	//CLick Save Button
    	sf.sfClickButton(driver, accountPage.save, timeoutSeconds);
    }

    public void clickSaveAndNew(WebDriver driver,int timeoutSeconds)
    {
    	//CLick Save And New Button
    	sf.sfClickButton(driver, accountPage.saveAndNew, timeoutSeconds);
    }
    
    public void clickCancel(WebDriver driver,int timeoutSeconds)
    {
    	//CLick Cancel Button
    	sf.sfClickButton(driver, accountPage.cancel, timeoutSeconds);
    }

    public void clickAdd(WebDriver driver,int timeoutSeconds)
    {
    	//CLick Add Button
    	sf.sfClickButton(driver, accountPage.add, timeoutSeconds);
    }

    public void navigateToDetails(WebDriver driver,int timeoutSeconds)
    {
        //Click Details Tab
        sf.sfClickTab(driver, accountPage.detailsTab, timeoutSeconds);
    }
    
    public void navigateToRelated(WebDriver driver,int timeoutSeconds)
    {
        //Click Related Tab
        sf.sfClickTab(driver, accountPage.relatedTab, timeoutSeconds);
    }

    public void clickActivityTab(WebDriver driver,int timeoutSeconds)
    {
        //Click Activity Tab
        sf.sfClickTab(driver, accountPage.activityTab, timeoutSeconds);
    }

    public void clickChatterTab(WebDriver driver,int timeoutSeconds)
    {
        //Click Chatter Tab
        sf.sfClickTab(driver, accountPage.chatterTab, timeoutSeconds,2);
    }
   
    public void verifyAccountDetails(WebDriver driver,Recordset data,int timeoutSeconds) throws FilloException
    {
        //verify Account Details
        sf.sfVerifyFormDetailShouldBe(driver, accountPage.accountName,data.getField("Account Name"), timeoutSeconds);
        String phone=String.format("(%s) %s-%s", data.getField("Phone").substring(0, 3),data.getField("Phone").substring(3, 6),data.getField("Phone").substring(6, 10));
        sf.sfVerifyFormDetailShouldBe(driver, accountPage.phone, phone, timeoutSeconds);
        sf.sfVerifyFormDetailShouldBe(driver, accountPage.rating,data.getField("Rating"), timeoutSeconds);
        sf.sfVerifyFormDetailShouldBe(driver, accountPage.parentAccount, data.getField("Parent Account"), timeoutSeconds);
        String fax=String.format("(%s) %s-%s", data.getField("Fax").substring(0, 3),data.getField("Fax").substring(3, 6),data.getField("Fax").substring(6, 10));
        sf.sfVerifyFormDetailShouldBe(driver, accountPage.fax, fax, timeoutSeconds);
        sf.sfVerifyFormDetailShouldBe(driver, accountPage.accountNumber, data.getField("Account Number"), timeoutSeconds);
        sf.sfVerifyFormDetailShouldBe(driver, accountPage.website, data.getField("Website"), timeoutSeconds);
        sf.sfVerifyFormDetailShouldBe(driver, accountPage.accountSite, data.getField("Account Site"), timeoutSeconds);
        sf.sfVerifyFormDetailShouldBe(driver, accountPage.tickerSymbol, data.getField("Ticker Symbol"), timeoutSeconds);
        sf.sfVerifyFormDetailShouldBe(driver, accountPage.type, data.getField("Type"), timeoutSeconds);
        sf.sfVerifyFormDetailShouldBe(driver, accountPage.ownership, data.getField("Ownership"), timeoutSeconds);
        sf.sfVerifyFormDetailShouldBe(driver, accountPage.industry, data.getField("Industry"), timeoutSeconds);
        sf.sfVerifyFormDetailShouldBe(driver, accountPage.employees, data.getField("Employees"), timeoutSeconds);
        // number to currency converter
        Locale locale = new Locale("en", "US");      
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
        String annualRevenue=currencyFormatter.format(Double.parseDouble(data.getField("Annual Revenue"))).replace(".00", "");
        sf.sfVerifyFormDetailShouldContain(driver, accountPage.annualRevenue,annualRevenue, timeoutSeconds);
        sf.sfVerifyFormDetailShouldBe(driver, accountPage.sicCode, data.getField("SIC Code"), timeoutSeconds);
        sf.sfVerifyFormDetailShouldBe(driver, accountPage.checkbox123, data.getField("checkbox123"), timeoutSeconds);
        sf.sfVerifyFormDetailShouldContain(driver, accountPage.datetime123, data.getField("datetime123"), timeoutSeconds);
        sf.sfVerifyFormDetailShouldBe(driver, accountPage.email12, data.getField("email12"), timeoutSeconds);
        sf.sfVerifyFormDetailShouldContain(driver, accountPage.time12, data.getField("time12").replace("AM","").trim(), 20);
        sf.sfVerifyFormDetailShouldContain(driver, accountPage.datetime456, data.getField("Date"), timeoutSeconds);
        sf.sfVerifyFormDetailShouldContain(driver, accountPage.datetime456, data.getField("Time"), timeoutSeconds);
        sf.sfVerifyFormDetailShouldContain(driver, accountPage.billingAddress, data.getField("Billing Street"), timeoutSeconds);
        sf.sfVerifyFormDetailShouldContain(driver, accountPage.billingAddress, data.getField("Billing City"), timeoutSeconds);
        sf.sfVerifyFormDetailShouldContain(driver, accountPage.billingAddress, data.getField("Billing State/Province"), timeoutSeconds);
        sf.sfVerifyFormDetailShouldContain(driver, accountPage.billingAddress, data.getField("Billing Zip/Postal Code"), timeoutSeconds);
        sf.sfVerifyFormDetailShouldContain(driver, accountPage.billingAddress, data.getField("Billing Country"), timeoutSeconds);
        sf.sfVerifyFormDetailShouldContain(driver, accountPage.shippingAddress, data.getField("Shipping Street"), timeoutSeconds);
        sf.sfVerifyFormDetailShouldContain(driver, accountPage.shippingAddress, data.getField("Shipping State/Province"), timeoutSeconds);
        sf.sfVerifyFormDetailShouldContain(driver, accountPage.shippingAddress, data.getField("Shipping Zip/Postal Code"), timeoutSeconds);
        sf.sfVerifyFormDetailShouldContain(driver, accountPage.shippingAddress, data.getField("Shipping City"), timeoutSeconds);
        sf.sfVerifyFormDetailShouldContain(driver, accountPage.shippingAddress, data.getField("Shipping Country"), timeoutSeconds);
        sf.sfVerifyFormDetailShouldContain(driver, accountPage.customerPriority, data.getField("Customer Priority"), timeoutSeconds);
        sf.sfVerifyFormDetailShouldBe(driver, accountPage.sla, data.getField("SLA"), timeoutSeconds);
        sf.sfVerifyFormDetailShouldBe(driver, accountPage.active, data.getField("Active"), timeoutSeconds);
        sf.sfVerifyFormDetailShouldBe(driver, accountPage.description, data.getField("Description"), timeoutSeconds);
        sf.sfVerifyFormDetailShouldContain(driver, accountPage.picklisi678, data.getField("picklisi678_1"), timeoutSeconds);
        sf.sfVerifyFormDetailShouldContain(driver, accountPage.picklisi678, data.getField("picklisi678_2"), timeoutSeconds);    	
    }
    
    public void getAccountDetailsAndPrintConsole(WebDriver driver,int timeoutSeconds)
    {
        System.out.println(sf.sfGetPageHeaderTitle(driver, timeoutSeconds));
        System.out.println(sf.sfGetFormDetailText(driver, accountPage.accountName, timeoutSeconds));
        System.out.println(sf.sfGetFormDetailText(driver, accountPage.phone, timeoutSeconds));
        System.out.println(sf.sfGetFormDetailText(driver, accountPage.rating, timeoutSeconds));
        System.out.println(sf.sfGetFormDetailText(driver, accountPage.parentAccount, timeoutSeconds));
        System.out.println(sf.sfGetFormDetailText(driver, accountPage.fax, timeoutSeconds));
        System.out.println(sf.sfGetFormDetailText(driver, accountPage.accountNumber, timeoutSeconds));
        System.out.println(sf.sfGetFormDetailText(driver, accountPage.website, timeoutSeconds));
        System.out.println(sf.sfGetFormDetailText(driver, accountPage.accountSite, timeoutSeconds));
        System.out.println(sf.sfGetFormDetailText(driver, accountPage.tickerSymbol, timeoutSeconds));
        System.out.println(sf.sfGetFormDetailText(driver, accountPage.type, timeoutSeconds));
        System.out.println(sf.sfGetFormDetailText(driver, accountPage.ownership, timeoutSeconds));
        System.out.println(sf.sfGetFormDetailText(driver, accountPage.industry, timeoutSeconds));
        System.out.println(sf.sfGetFormDetailText(driver, accountPage.employees, timeoutSeconds));
        System.out.println(sf.sfGetFormDetailText(driver, accountPage.annualRevenue, timeoutSeconds));
        System.out.println(sf.sfGetFormDetailText(driver, accountPage.sicCode, timeoutSeconds));
        System.out.println(sf.sfGetFormDetailCheckbox(driver, accountPage.checkbox123, timeoutSeconds));
        System.out.println(sf.sfGetFormDetailText(driver, accountPage.datetime123, timeoutSeconds));
        System.out.println(sf.sfGetFormDetailText(driver, accountPage.email12, timeoutSeconds));
        System.out.println(sf.sfGetFormDetailText(driver, accountPage.time12, timeoutSeconds));
        System.out.println(sf.sfGetFormDetailText(driver, accountPage.datetime123, timeoutSeconds));
        System.out.println(sf.sfGetFormDetailText(driver, accountPage.billingAddress, timeoutSeconds));
        System.out.println(sf.sfGetFormDetailText(driver, accountPage.shippingAddress, timeoutSeconds));
        System.out.println(sf.sfGetFormDetailText(driver, accountPage.customerPriority, timeoutSeconds));
        System.out.println(sf.sfGetFormDetailText(driver, accountPage.sla, timeoutSeconds));
        System.out.println(sf.sfGetFormDetailText(driver, accountPage.active, timeoutSeconds));
        System.out.println(sf.sfGetFormDetailText(driver, accountPage.description, timeoutSeconds));
     }
    
    public void createAccount(WebDriver driver,Recordset data,int timeoutSeconds) throws FilloException
    {
    	// Navigate To Accounts Tab
    	navigateToAccountsTab(driver, timeoutSeconds);
    	// Click New Button
    	clickNew(driver, timeoutSeconds);
    	// Fill Account Details
    	fillAccountDetails(driver, data, timeoutSeconds);
    	// Click Save Button
    	clickSave(driver, timeoutSeconds);
    	//Navigate to Details tab - Account Details
    	navigateToDetails(driver, timeoutSeconds);
    	//Verify Accounts Details
    	verifyAccountDetails(driver, data, timeoutSeconds);
    	//Print Account Details on console
    	getAccountDetailsAndPrintConsole(driver, timeoutSeconds);
    }

    public void createAccountWithSpecificMethod(WebDriver driver,Recordset data,int timeoutSeconds) throws FilloException
    {
    	// Navigate To Accounts Tab
    	navigateToAccountsTab(driver, timeoutSeconds);
    	// Click New Button
    	clickNew(driver, timeoutSeconds);
    	// Fill Account Details
    	fillAccountDetailsWithSpecificMethod(driver, data, timeoutSeconds);
    	// Click Save Button
    	clickSave(driver, timeoutSeconds);
    	//Navigate to Details tab - Account Details
    	navigateToDetails(driver, timeoutSeconds);
    	//Verify Accounts Details
    	verifyAccountDetails(driver, data, timeoutSeconds);
    	//Print Account Details on console
    	getAccountDetailsAndPrintConsole(driver, timeoutSeconds);
    }

}
