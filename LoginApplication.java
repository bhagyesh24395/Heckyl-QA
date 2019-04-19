package testPackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import framework.utilities.commonFunctions;

public class LoginApplication extends commonFunctions {

	@DataProvider(name="navigationExternalLinks")
	public static Object[][] getDataFromDataprovider1(){
		return new Object[][] {
			{ "SEBI", "https://www.sebi.gov.in" },
			{ "SEBI Scores", "https://scores.gov.in/scores/Welcome.html" },
			{"NSE", "https://www.nseindia.com"},
			{"MCX", "https://www.mcxindia.com"},
			{"FMC", "http://fmc.gov.in/index.aspx"},
			{"NCDEX", "https://www.ncdex.com/index.aspx"},
			{"BSE", "https://www.bseindia.com"},
			{"CDSL", "https://www.cdslindia.com/index.html"},
			{"NSEL", "http://www.nationalspotexchange.com"},
			{"MCXSX", "http://www.mcx-sx.com"},
			{"NSE Disclaimer", "https://www.nseindia.com/disclaimer.htm"},
			{"Terms of Use","https://etrade.adityabirlamoney.com/abg/LoginImages/Terms.html"},
			{"BSE Investor Complaint","https://www.bseindia.com/investors/invGrievances.aspx"},
			{"System Requirements","https://etrade.adityabirlamoney.com/abg/LoginImages/sysreq.html"},
			{"Privacy & Security","https://etrade.adityabirlamoney.com/abg/LoginImages/Privacy.html"},
			{"NSE Investor Complaints","https://www.nseindia.com/content/assist/asst_igcfaqs.htm"}

		};
	}



	@Test(priority=0)
	public void Login() throws Exception {
		long startTime = System.currentTimeMillis();

		openBrowser("webdriver.chrome.driver", "C://Users//Bhagyesh//Desktop//New folder//TestNGProject//chromedriver_win32//chromedriver.exe");
		maximizeBrowser();
		getURL("https://abtrade.adityabirlamoney.com/PlatformWeb/Platform/Account/Login");
		waitForVisible("//div[@class='controls']/input[@id='username']");
		//	Thread.sleep(5000);

		login("3000298","live@222");

	//	waitForVisible("//div[@class='watchlistGrid loading']");
	//	waitForVisible("//div[@class='twofacontent']");
		//	securityQuestions("//div[@class='twofacontent']/.//div[@class='control-group']");
		//	click("\"//*[@id='btntwofasubmit']\"");
		//	twoFAsubmitButton("//*[@id='btntwofasubmit']");

		waitForInvisible("//div[@class='watchlistGrid loading']");
		//	waitForVisible("//div[@class='rightCtrls']./li[@class='userInfo']");
		//	logout("//li[@class='userInfo']");

		long endTime = System.currentTimeMillis();
		long totalTime = (endTime - startTime)/1000;
		System.out.println("Response Time for Login is : " +totalTime + "secs");
		String currentURL = driver.getCurrentUrl();
		System.out.println("Present page is  "+currentURL);
	}

	//@Test(priority=1, dataProvider = "navigationExternalLinks")
	public void navigationExternalLinks(String locator, String text) throws Exception {
		navigateExternalLinks(locator, text);
	}

	@DataProvider(name="watchName")
	public static Object[][] getDataFromDataprovider(){
		return new Object[][] {
			{ "heckylwatch" },
			{ "asdwatch" }

		};
	}

	@Test(priority=1, dataProvider="watchName")
	public void CreateWatchlist(String watchName) {
		long startTime = System.currentTimeMillis();

		createWatchlist(watchName);

		long endTime = System.currentTimeMillis();
		long totalTime = (endTime - startTime)/1000;
		System.out.println("Response Time for Login is : " +totalTime + "secs");



		//	waitForVisible("//div[@class='grid-canvas']");


		//	waitForVisible("//div[@id='mCSB_2']");
		//	deleteWatchlist();
	}


	@DataProvider(name="deleteScrip")
	public static Object[][] getDataFromDataproviderDeleteScrip(){
		return new Object[][] {
			{ "NIFTYBEES" }
		};
	}

	//	@Test(priority=2, dataProvider="deleteScrip")
	public void deleteWatchlist(String text) throws Exception {
		deleteSymbols(text);
	}

	@DataProvider(name="scripName12")
	public static Object[][] scripDataFromDataprovider(){
		return new Object[][] {
			{"NIFTYBEES", "STOCK"},
			{"VEDL", "STOCK"},
			{"YESBANK", "STOCK"},
			{"SBIN", "OTHERS"},
			{"SAGAR", "OTHERS"},
			{"INFY 25APR2019", "FUTURES"},
			{"BANKNIFTY 25APR2019", "FUTURES"},
			{"TCS 25APR2019 2100 CE", "OPTIONS"},
			{"NIFTY 25APR2019 12000 CE", "OPTIONS"},
			{"USDINR 25APR2019", "FUTURES"},
			{"USDJPY 26JUN2019 125 CE", "OPTIONS"}



		};
	}

	//@Test(priority = 4)
	public void navigateWatchlist() throws Exception  {

		navigateWatch();
	}

	//	@Test(priority = 4, dataProvider = "scripName12")
	public void test(String text, String instrument) throws Exception{

		shortcutKeys(text, instrument);
		//buySellFromWatchlist();
		//chartsFromWatchlist();
	}

	@DataProvider(name="scripName")
	public static Object[][] scripDataFromDataprovider1(){
		return new Object[][] {
			{"NSE : NIFTYBEES", "RELIANCE ETF NIFTY BEES", "NIFTYBEES"},
			{"NSE : VEDL","VEDANTA LTD", "VEDL"},
			//	{"NSE : VEDL","VEDANTA LTD", "VEDL"},
			{"BSE : 532648","YES BANK LTD", "YESBANK"},
			//	{"BSE : 532648","YES BANK LTD", "YESBANK"},
			{"NSE : SBIN","SBIN-N2", "SBIN"},
			//	{"NSE : SBIN","SBIN-N2", "SBIN"},
			{"BSE : 540715","SAGAR-M", "SAGAR"},
			//	{"BSE : 540715","SAGAR-M", "SAGAR"},
			{"NSE : INFY","INFY 25 APR 2019", "INFY 25APR2019"},
			//	{"NSE : INFY","INFY 25 APR 2019", "INFY 25APR2019"},
			{"NSE : BANKNIFTY","BANKNIFTY 25 APR 2019", "BANKNIFTY 25APR2019"},
			//	{"NSE : BANKNIFTY","BANKNIFTY 25 APR 2019", "BANKNIFTY 25APR2019"},
			{"NSE : TCS","TCS 25 APR 2019 2100.00 CE", "TCS 25APR2019 2100 CE"},
			//	{"NSE : TCS","TCS 25 APR 2019 2100.00 CE", "TCS 25APR2019 2100 CE"},
			{"NSE : NIFTY","NIFTY 25 APR 2019 12000.00 CE", "NIFTY 25APR2019 12000 CE"},
			//	{"NSE : NIFTY","NIFTY 25 APR 2019 12000.00 CE", "NIFTY 25APR2019 12000 CE"},
			{"NSE : USDINR","USDINR 25 APR 2019", "USDINR 25APR2019"},
			//	{"NSE : USDINR","USDINR 25 APR 2019", "USDINR 25APR2019"},
			{"NSE : USDJPY","USDJPY 26 JUN 2019 125.0000 CE", "USDJPY 26JUN2019 125 CE"},
			//	{"NSE : USDJPY","USDJPY 26 JUN 2019 125.0000 CE", "USDJPY 26JUN2019 125 CE"}



		};
	}

//	@Test(priority=2)
	public void beforeAddSymbol() {

		waitForVisible("//div[@class='watchlist_action']/button[@id='addSymbol']");
		Actions actions = new Actions(driver);
		WebElement element1 = driver.findElement(By.xpath("//div[@class='watchlist_action']/button[@id='addSymbol']"));
		actions.moveToElement(element1).click().perform();
		waitForVisible("//div[@class='nav-search-field']/input[@type='text']");

		WebElement element2 = driver.findElement(By.xpath("//div[@class='nav-search-field']/input[@id='watchlistAddsymbolSearchTextbox']"));
		actions.moveToElement(element2).click().perform();
	}	



//	@Test(priority=3, dataProvider = "scripName")
	public void addSymbol(String text1, String text2, String text3) throws Exception {
		Actions actions = new Actions(driver);
		WebElement element3 = driver.findElement(By.xpath("//div[@class='nav-search-field']/input[@id='watchlistAddsymbolSearchTextbox']"));
		actions.moveToElement(element3).click().build().perform();
		element3.clear();


		//		click("//div[@class='watchlist_action']/button[@id='addSymbol']");

		selectAutoCompleteText(text1, text2, text3);
		Thread.sleep(2000);
		element3.clear();




		//	addAllScrips(scripName);
	}


	@DataProvider(name="navigateOverview")
	public static Object[][] scripDataFromDataproviderNavOverview(){
		return new Object[][] {
			{"NIFTYBEES","RELIANCE ETF NIFTY BEES", "STOCK"},
			{"VEDL","VEDANTA LIMITED", "STOCK"},
			{"YESBANK","YES BANK LIMITED", "STOCK"},
		//	{"SBIN","SBIN", "OTHERS"},
		//	{"SAGAR","SAGAR", "OTHERS"},
			{"INFY 25APR2019","INFOSYS LIMITED", "FUTURES"},
			{"BANKNIFTY 25APR2019", "BANK NIFTY", "FUTURES"},
			{"TCS 25APR2019 2100 CE","TATA CONSULTANCY SERVICES LIMITED", "OPTIONS"},
			{"NIFTY 25APR2019 12000 CE", "NIFTY FIFTY", "OPTIONS"},
			{"USDINR 25APR2019", "USDINR (RBI Ref Rate)", "FUTURES"},
			{"USDJPY 26JUN2019 125 CE", "USDJPY (RBI Ref Rate)", "OPTIONS"}
		};
	}	

//	@Test(priority=2, dataProvider = "navigateOverview")
	public void navigateOverview(String text1,String text2, String text3) throws Exception {
		navOverview(text1,text2,text3);
		
	}
	
	@DataProvider(name="navigateCharts")
	public static Object[][] scripDataFromDataproviderNavCharts(){
		return new Object[][] {
			{"NIFTYBEES","RELIANCE ETF NIFTY BEES", "STOCK"},
			{"VEDL","VEDANTA LTD", "STOCK"},
	//		{"YESBANK","YES BANK LTD", "STOCK"},
	//		{"SBIN","", "OTHERS"},
	//		{"SAGAR","SAGAR", "OTHERS"},
			{"INFY 25APR2019","INFY 25 APR 2019", "FUTURES"},
			{"BANKNIFTY 25APR2019", "BANKNIFTY 25 APR 2019", "FUTURES"},
			{"TCS 25APR2019 2100 CE","TCS 25 APR 2019 2100.00 CE", "OPTIONS"},
			{"NIFTY 25APR2019 12000 CE", "NIFTY 25 APR 2019 12000.00 CE", "OPTIONS"},
			{"USDINR 25APR2019", "USDINR 25 APR 2019", "FUTURES"},
			{"USDJPY 26JUN2019 125 CE", "USDJPY 26 JUN 2019 125.0000 CE", "OPTIONS"}
		};
	}	
	
//	@Test(priority=2, dataProvider = "navigateCharts")
	public void navigateCharts(String text1,String text2, String text3) throws Exception {
	
		navCharts(text1,text2,text3);
	}
	
	@DataProvider(name="topSearchData")
	public static Object[][] scripDataFromDataprovidertopSearch(){
		return new Object[][] {
			{"NSE : TCS", "TATA CONSULTANCY SERVICES LTD", "TATA CONSULTANCY SERVICES LIMITED"},
			{"BSE : 500295", "VEDANTA LTD", "VEDANTA LIMITED"},
			{"BSE : 532648", "YES BANK LTD", "YES BANK LIMITED"},
		//	{"NSE : YESBANK", "YES BANK LTD", "YES BANK LIMITED"},
			
		//	{"NSE : SBIN","SBIN-N2", "SBIN"},
		
		//	{"BSE : 540715","SAGAR-M", "SAGAR"},
		
			{"NSE : INFY","INFY 25 APR 2019", "INFOSYS LIMITED"},
		
			{"NSE : BANKNIFTY","BANKNIFTY 25 APR 2019", "BANK NIFTY"},
		
			{"NSE : TCS","TCS 25 APR 2019 2100.00 CE", "TATA CONSULTANCY SERVICES LIMITED"},
		
			{"NSE : NIFTY","NIFTY 25 APR 2019 12000.00 CE", "NIFTY FIFTY"},
		
			{"NSE : USDINR","USDINR 25 APR 2019", "USDINR (RBI Ref Rate)"},
			
			{"NSE : USDJPY","USDJPY 26 JUN 2019 125.0000 CE", "USDJPY (RBI Ref Rate)"}
		



		};
	}
	
	
	@DataProvider(name="topSearchNews")
	public static Object[][] scripDataFromDataproviderNewsSearch(){
		return new Object[][] {
			{"TCS", "TATA CONSULTANCY SERVICES LTD", "TCS"},
			{"YESBANK", "YES BANK LTD", "YESBANK"},
		};
	}
	
	@Test(priority=2, dataProvider = "topSearchNews")
	public void topSearchBar(String text1, String text2, String text3) throws Exception {
	//	topSearchQuote(text1, text2, text3);
	//	topSearchCharts(text1, text2, text3);
	//	topSearchNews(text1, text2, text3);
		topSearchOptionStrategies(text1, text2, text3);
	}	
	
	
}