package framework.utilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;




public class commonFunctions {

	public WebDriver driver;

	public WebElement element;

	public WebDriverWait wait;

	String nameWatch;



	public void openBrowser(String text1, String text2) throws Exception {

		try {

			System.setProperty(text1,text2);

			ChromeOptions options = new ChromeOptions();
			options.addArguments("disable-infobars");
			driver = new ChromeDriver(options);

			wait = new WebDriverWait(driver, 20);
			System.out.println("Element for wait:" +wait);
			System.out.println(driver);

			int implicitWaitTime = 10;
			driver.manage().timeouts().implicitlyWait(implicitWaitTime, TimeUnit.SECONDS);
		}
		catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("Not able to open the Browser --- " + ex.getMessage());

		}

	}


	public void maximizeBrowser() throws Exception{
		try {

			driver.manage().window().maximize();
		}catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("Not able to open the Browser --- " + ex.getMessage());
		}
	}


	public void getURL(String URL) throws Exception {
		try {


			driver.get(URL);
		}catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("Not able to open the Browser --- " + ex.getMessage());
		}
	}	

	public void click(String locator){
		//	log.info("Clicking on WebElement");
		try {

			driver.findElement(By.xpath(locator)).click();
			//	driver.findElement(By.xpath("//div[@class='form-actions']/button[@id = 'btnValidateUser']")).click();
			System.out.println("Clicked  on Element :");
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	public void clickElement(WebElement element){
		//	log.info("Clicking on WebElement");
		try {

			element.click();
			//	driver.findElement(By.xpath("//div[@class='form-actions']/button[@id = 'btnValidateUser']")).click();
			System.out.println("Clicked  on Element :");
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}



	/*public void enterText(String Username,String Password) {
		try {
			WebDriverWait();
			driver.findElement(By.xpath("//div[@class='controls']/input[@id='username']")).sendKeys(Username);
		//	driver.findElement(By.xpath(path)).sendKeys(Username);
			clickButton("//div[@class='form-actions']/button[@id = 'btnValidateUser']");
	//		WebDriverWait();
			driver.findElement(By.xpath("//div[@class='controls']/input[@id='password']")).sendKeys(Password);
		//	clickButton("//div[@class='form-actions']/button[@id = 'btnValidateUser']");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}*/

	public void login(String username, String password) {

		enterText("//div[@class='controls']/input[@id='username']", username);
		click("//div[@class='form-actions']/button[@id = 'btnValidateUser']");		
		enterText("//div[@class='controls']/input[@id='password']", password);
		click("//div[@class='form-actions']/button[@id = 'btnValidateUser']");
		securityQuestions("//div[@class='twofacontent']/.//div[@class='control-group']");
		twoFAsubmitButton("//*[@id='btntwofasubmit']");

	}



	public void enterText(String locator,String text) {
		try {			
			driver.findElement(By.xpath(locator)).sendKeys(text);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}


	public  WebElement securityQuestions(String locator){
		try {

			//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='twofacontent']")));
			List <WebElement> securityQ = driver.findElements(By.xpath(locator));
			//	System.out.println("securityQ.size()" +securityQ.size());
			Thread.sleep(5000);


			for(int i=0; i < securityQ.size(); i++){
				securityQ.get(i).findElement(By.xpath(".//input")).sendKeys("a");


				System.out.println("Printed a for" +i);

			}
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		return element;

	}

	public  void twoFAsubmitButton(String locator){
		try {
			waitForVisible("//div[@class='msgBoxContainer']");
			System.out.println("Clicking on Submit");
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='msgBoxContainer']")));
			driver.findElement(By.xpath(locator)).click();
			System.out.println("Clicked on Submit");
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	public boolean waitForVisible(String locator) {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
			System.out.println("Element  visible:"  +locator);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	public boolean waitForVisibleLocatorText(String locator) {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator))).getText();
			//	System.out.println("Element  visible:"  +locator);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	public void waitForInvisible(String locator) {
		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locator)));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void clear(String locator) {
		driver.findElement(By.xpath(locator)).clear();
	}



	public void logout(String locator) {
		try {
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(By.xpath(locator))).build().perform();
			//	waitForVisible("//div[@id='logoutInformation']./input[@id='btnLogout']");
			click("//div[@id='logoutInformation']/input[@type='button']");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}



	public void createWatchlist(String text) {
		try {

			DateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
			String date1 = dateFormat.format(new Date()).toString();
			nameWatch = text+date1;

			waitForVisible("//div[@class='slick-header ui-state-default']");
			waitForVisible("//div[@class='watchlist_action']/button[@id='createWatchlist']");
			System.out.println("Watchlist icon is visible");
			click("//div[@class='watchlist_action']/button[@id='createWatchlist']");
			Thread.sleep(3000);
			waitForVisible("//div[@id='transparentLaunchWrap']");
			waitForVisible("//*[@id='popupCreateWatchlist']/div[@class='launchContent launchContentRound']");
			//	waitForVisible("//div[@class='launchBody']");
			waitForVisible("//div[@class = 'createWatchlistControls']/input[@type='text']");
			
			clear("//*[@id='watchlistText']");
			click("//*[@id='watchlistText']");
			Thread.sleep(1000);
			enterText("//*[@id='watchlistText']",nameWatch);
			//	driver.wait(10);
			Thread.sleep(2000);
			waitForVisible("//*[@id='btnWatchlistCreate']");
			click("//*[@id='btnWatchlistCreate']");



			WebElement e = driver.findElement(By.xpath("//div[@class='createWatchlistNotification']"));
			//  System.out.println("getText() " + e.getText());
			if(e.getText().equalsIgnoreCase("Watchlist name already exists")) {
				System.out.println("**********************Watchlist name   "+nameWatch+  "    already exists***********************");
				waitForVisible("//div[@class='launchHeader ui-draggable-handle']/span[@class='closelaunch']");
				driver.findElement(By.xpath("//div[@class='launchHeader ui-draggable-handle']/span[@class='closelaunch']")).click();
				waitForInvisible("//div[@class='launchHeader ui-draggable-handle']/span[@class='closelaunch']");
				Thread.sleep(2000);
			}
			else {

				//	WebElement mySelectElement = driver.findElement(By.id("watchlistCollection"));
				//	Select dropdown= new Select(mySelectElement);
				//	dropdown.selectByVisibleText(nameWatch);


				Select select = new Select(driver.findElement(By.id("watchlistCollection")));
				select.selectByVisibleText(nameWatch);
				WebElement element = select.getFirstSelectedOption();
				System.out.println("New Watchlist  " +element.getText()+ " " + "is created");
				waitForInvisible("//*[@id='popupCreateWatchlist']/div[@class='launchContent launchContentRound']");	
				//	waitForVisible("//div[@class='watchlist_action']/button[@id='createWatchlist']");

			}		


			//	if(waitForVisible("//optgroup[@label='User Defined']/option[@selected='selected'].[contains(text(),'"+nameWatch+"']")) {
			//	System.out.println("Watchlist " +nameWatch+ " " + "successfully created");


			//}

			//	WebElement selectedWatch = driver.findElement(By.xpath("//select[@class='select-skin']/option[@selected='selected']"));
			//	if(selectedWatch.getText().equalsIgnoreCase(nameWatch)) {
			//		System.out.println("Watchlist  " +nameWatch+ " " + "successfully created"  );
			//		}	

			//}



		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void deleteSymbols(String text) throws Exception{
		waitForVisible("//div[contains(@class, 'slick-cell') and contains(@class, 'l2') and contains(@class, 'r2') and contains(@class, 'bold-me') and contains(@class, 'alignLeft')]");
		click("//span[contains(text(),'" +text+"')]/../..//preceding-sibling::div/.//label/span");
		click("//button[@id='removeSymbol']");
		//	click("//div[contains(@class, 'launchContent') and contains(@class, 'launchContentRound')]");
		Thread.sleep(2000);
		click("//div[contains(@class, 'launchBody') and contains(@class, 'removeSymbolWidth')]");
		//	click("//input[@id='btnSymbolRemove']");
		//	waitForVisible("//div[contains(@class, 'launchContent') and contains(@class, 'launchContentRound')]");
		String abc = driver.findElement(By.className("removetxt")).getText();
		//	 String abc = driver.findElement(By.xpath("//div[@class='removetxt']")).getAttribute("innerHTML");
		System.out.println("Print   "  +abc);

		if(abc.equalsIgnoreCase("Watchlist can not be blank, atleast one symbol required")){
			System.out.println("Watchlist can not be blank, atleast one symbol required");
			click("//div[contains(@class, 'launchBody') and contains(@class, 'removeSymbolWidth')]");
			click("//input[@class='btncancel']");
		}else {
			click("//input[@id='btnSymbolRemove']");
		}

	}


	public void downloadExcel() {

		waitForVisible("//button[@id='exportExcel']");
		if(driver.findElement(By.xpath("//button[@id='exportExcel']")).isDisplayed()){
			click("//button[@id='exportExcel']");
			driver.findElement(By.linkText("Excel")).click();
			driver.findElement(By.linkText("CSV")).click();

		}
	}

	public void buySellFromWatchlist() throws Exception {

		waitForVisible("//div[@class='grid-canvas']");
		waitForVisible("//div[contains(@class, 'ui-widget-content') and contains(@class, 'slick-row')]");
		//	driver.findElement(By.xpath("//span[contains(text(), 'SAGAR')]//..//..//..//..//input[@value='BUY']")).click();

		driver.findElement(By.xpath("//input[@value='BUY']")).click();
		Thread.sleep(10000);
		if(driver.findElement(By.xpath("//select[contains(@class, 'orderAction') and contains(@class, 'buy')]")).isDisplayed()) {
			System.out.println("Clicked on BUY and Order form opened is BUY i.e correct");
		}else {
			System.out.println("Something wrong happened");
		}
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ESCAPE).perform();

		waitForVisible("//div[@class='grid-canvas']");
		waitForVisible("//div[contains(@class, 'ui-widget-content') and contains(@class, 'slick-row')]");
		//	driver.findElement(By.xpath("//span[contains(text(), 'SAGAR')]//..//..//..//..//input[@value='SELL']")).click();
		driver.findElement(By.xpath("//input[@value='BUY']")).click();
		Thread.sleep(10000);
		if(driver.findElement(By.xpath("//select[contains(@class, 'orderAction') and contains(@class, 'sell')]")).isDisplayed()) {
			System.out.println("Clicked on SELL and Order form opened is SELL i.e correct");
		}else {
			System.out.println("Something wrong happened");
		}
		action.sendKeys(Keys.ESCAPE).perform();
	}



	public void chartsFromWatchlist() throws Exception {

		waitForVisible("//div[@class='grid-canvas']");
		waitForVisible("//div[contains(@class, 'ui-widget-content') and contains(@class, 'slick-row')]");
		driver.findElement(By.xpath("//span[@class='slick-graph']")).click();
		Thread.sleep(15000);
		waitForVisible("//li[@class='menuItem']");


	}





	public void shortcutKeys(String text, String instrument) throws InterruptedException {

		try {

			if(driver.findElement(By.xpath("//div[@class='grid-canvas']")).isDisplayed())                                                                                                         
			{         
				List<WebElement> list = driver.findElements(By.xpath("//div[contains(@class, 'ui-widget-content') and contains(@class, 'slick-row')]"));
				int count = list.size();
				System.out.println("Count is " +count); 
				//		List<WebElement> checkBoxList = driver.findElements(By.xpath("//div[contains(@class, 'slick-cell') and contains(@class, 'l1') and contains(@class, 'r1') and contains(@class, 'slick-cell-checkboxsel')]"));
				//	List<WebElement> checkBoxList = driver.findElements(By.xpath("//label[starts-with(@for,'watchlistChkBox')]"));
				//	int checkBoxCount = checkBoxList.size();

				//	int checkBoxCount = list.size();
				//	System.out.println("CheckBox Count  " +checkBoxCount);
				//	driver.findElement(By.xpath("//span[contains(text(), 'YESBANK')]/../..//preceding-sibling::div/.//label/span")).click();
				if(!text.equals("OTHERS")) {
					driver.findElement(By.xpath("//span[contains(text(),'" +text+"')]/../..//preceding-sibling::div/.//label/span")).click();
				}
				else {
					driver.findElement(By.xpath("//span[contains(text(),'" +text+"')]/..//preceding-sibling::div/.//label/span")).click();
				}

				//System.out.println(xyz);
				//	driver.findElement(By.xpath("//span[contains(text(),'" +text+"')]/preceding-sibling::label[starts-with]"));
				//	for(int i = 0; i < list.size(); i++) {

				//		System.out.println(i);
				//		System.out.println("Iteration "+i);

				//		System.out.println(list.get(i).getAttribute("innerText"));

				//		WebElement abc = list.get(i).findElement(By.xpath(".//span"));


				//		abc.click();
				//driver.findElement(By.xpath("//body")).sendKeys(Keys.F1);
				Thread.sleep(5000);
				Actions action = new Actions(driver);
				action.sendKeys(Keys.F1).perform();
				waitForVisible("//div[@class='controlColumn']");
				waitForVisible("//select[contains(@class, 'orderAction') and contains(@class, 'buy')]");

				if(driver.findElement(By.xpath("//select[contains(@class, 'orderAction') and contains(@class, 'buy')]")).isDisplayed()) {
					System.out.println("Clicked on F1 and Order form opened is BUY");
				}else {
					System.out.println("Something wrong happened");
				}

				waitForVisible("//div[contains(@class, 'controlRow') and contains(@class, 'clearfix') and contains(@class, 'placeOrModifyOrder')]");
				Thread.sleep(10000);
				action.sendKeys(Keys.ESCAPE).perform();
				System.out.println("escape performed");
				waitForInvisible("//span[@class='controlColumn']");
				System.out.println("launch content invisible");

				if(!instrument.equals("OTHERS")) {
					driver.findElement(By.xpath("//span[contains(text(),'" +text+"')]/../..//preceding-sibling::div/.//label/span")).click();
				}
				else {
					driver.findElement(By.xpath("//span[contains(text(),'" +text+"')]/..//preceding-sibling::div/.//label/span")).click();
				}
				/*list = driver.findElements(By.xpath("//div[contains(@class, 'ui-widget-content') and contains(@class, 'slick-row')]"));
					list.get(i).findElement(By.xpath(".//span")).click();*/

				/*				try {
						list = driver.findElements(By.xpath("//div[contains(@class, 'ui-widget-content') and contains(@class, 'slick-row')]"));
						abc = list.get(i).findElement(By.xpath(".//span"));
						System.out.println(list.get(i).getAttribute("innerText"));
						abc.click();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						abc.click();

					}  

					Thread.sleep(2000);

				//	abc.sendKeys(Keys.F1);

				}
			}    
			else    
			{     
				System.out.println("");
			}  */
			}
		} catch (Exception e) {
			e.printStackTrace();
		}



		//	WebElement checkboxPath = driver.findElement(By.xpath("//input[@id=(//label[text()='watchlistChkBoxX2926']/@for)]"));
		//checkboxPath.click();

	}



	public void selectDropdown(String locator) throws Exception {
		try {


			//	List<WebElement> allElements = driver.findElements(By.xpath("//*[@id='mCSB_2_container']/ul/li"));
			List<WebElement> allElements = driver.findElements(By.xpath(locator));
			int s=allElements.size();
			System.out.println("Size Dropdown is " +s);
			for(int i=0;i<s;i++){
				//	allElements = driver.findElements(By.xpath("//*[@id='mCSB_2_container']/ul/li"));
				allElements = driver.findElements(By.xpath(locator));
				allElements.get(i).click();
				Thread.sleep(2000);



				String abc = allElements.get(i).getText();


				System.out.println("-----------------------------------------------------------------------------------------------------------");
				System.out.println("Clicked on  " +abc);
				//waitForVisible("//div[@id='watchlistGrid']");
				if(driver.findElements(By.xpath("//div[@id='watchlistGrid']")).size() > 0) {
					System.out.println("Watchlist diplayed  " +abc);
					String rowCount = driver.findElement(By.xpath("//span[@id='rowcount']")).getText();
					if(rowCount.equals("") || rowCount.equals("0")) {
						System.out.println("No scrip available");
					}

					else {
						System.out.println("No. of Scrips present for Watchlist " +"'"+abc+"'" +" is : " +rowCount);
					}
					System.out.println("-----------------------------------------------------------------------------------------------------------");

				}
				else {
					System.out.println("No data available");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void navigateWatch() throws Exception {
		try {
			selectDropdown("//select[@id='watchlistCollection']/optgroup[@label='User Defined']/option");
			selectDropdown("//select[@id='watchlistCollection']/optgroup[@label='Predefined']/option");
		} catch (Exception e) {
			e.printStackTrace();
		}


	}


	//	public void addAllScrips(String scrip) {
	//
	//		//		Select select = new Select(driver.findElement(By.id("watchlistCollection")));
	//		//		select.selectByVisibleText(nameWatch);
	//		//		WebElement element = select.getFirstSelectedOption();
	//
	//		waitForVisible("//div[@class='watchlist_action']/button[@id='addSymbol']");
	//		click("//div[@class='watchlist_action']/button[@id='addSymbol']");
	//		waitForVisible("//div[@class='nav-search-field']/input[@type='text']");
	//		click("//div[@class='nav-search-field']/input[@id='watchlistAddsymbolSearchTextbox']");
	//		enterText("//div[@class='nav-search-field']/input[@id='watchlistAddsymbolSearchTextbox']", scrip);
	//
	//	//	selectOptionWithText("TATA CONSULTANCY SERVICES LTD");
	//	//	selectAutoCompleteText("NSE : BSE","BSE LTD");
	//	//	selectAutoCompleteText(text1,text2);
	//
	//	}

	public void selectAutoCompleteText(String text1, String text2, String text3) {

		try {


			enterText("//div[@class='nav-search-field']/input[@id='watchlistAddsymbolSearchTextbox']", text2);

			waitForVisible("//div[@class='searchBoxWrap']/ul[@class='ui-autocomplete ui-front ui-menu ui-widget ui-widget-content']");
			//	waitForVisible("//div[@class='searchBoxWrap']/ul[@id='ui-id-1']");
			Thread.sleep(3000);
			List<WebElement> categoryList = driver.findElements(By.xpath("//li[@class='ui-autocomplete-category']"));
			for(WebElement categoryElement : categoryList) {
				//			System.out.println("CategoryElement" +categoryElement.getAttribute("innerText"));
				//			if(categoryElement.getText().equals("Stocks") || ) {

				List<WebElement> optionsList = driver.findElements(By.xpath("//div[@class='searchBoxWrap']/ul[@id='ui-id-1']/li[@class='ui-menu-item']"));
				for(WebElement webElement : optionsList){
					//			System.out.println("Scrip searching is: " +webElement.getAttribute("innerText"));

					if(webElement.getText().contains(text1) && webElement.getText().contains(text2)){
						Thread.sleep(3000);
						webElement.click();
						System.out.println("-------------------------------------------------------------------------------------------------");
						System.out.println("Trying to select: "+text1 +"    "+ text2);

						Thread.sleep(3000);
						if(driver.findElement(By.xpath("//div[@class='contentMessg']")).getText().equals("Searched symbol already exists")) {
							click("//div[@class='closeAlertWrap']");
							System.out.println("Symobol  " +text2+ " already exists");
							waitForInvisible("//div[@class='contentMessg']");
							Thread.sleep(2000);

						}

						/*	else {

							break;
					}*/
						else {	
							List<WebElement> scripNamePresent = driver.findElements(By.xpath("//div[contains(@class, 'slick-cell') and contains(@class, 'l2') and contains(@class, 'r2') and contains(@class, 'bold-me') and contains(@class, 'alignLeft')]"));
							for(WebElement scripAvailable : scripNamePresent) {
								String abc = scripAvailable.getText();
								if(abc.equalsIgnoreCase(text3)) {
									System.out.println(text3+ "  has been added successfully");
								}/*else if(abc!=(text3)){
									System.out.println("Something went wrong. Please check");
								}*/
							}
						}
					}

				}

			}


			//			List<WebElement> optionsList = driver.findElements(By.xpath("//div[@class='searchBoxWrap']/ul[@id='ui-id-1']/li[@class='ui-menu-item']"));
			//
			//			System.out.println("Size is "+optionsList.size());
			//			//	System.out.println("OptionList :" +optionsList.get(0));
			//			System.out.println("Element visible is " +optionsList.get(0).getText());
			//
			//			for(WebElement webElement : optionsList){
			//				//			System.out.println("Scrip searching is: " +webElement.getAttribute("innerText"));
			//
			//				if(webElement.getText().contains(text1) && webElement.getText().contains(text2)){
			//					System.out.println("Trying to select: "+text1 +"    "+ text2);
			//					//action.moveToElement(webElement).click();
			//					webElement.click();
			//
			//
			//			
			//					break;
			//
			//				}
			//			}

			waitForInvisible("//div[@class='searchBoxWrap']/ul[@class='ui-autocomplete ui-front ui-menu ui-widget ui-widget-content']");
			//			List<WebElement> checkRowCount = driver.findElements(By.xpath("//div[contains(@class, 'ui-widget-content slick-row')]"));
			//			System.out.println("checkRowCount" +checkRowCount.size());
			//			System.out.println("RowCount Name:  " +checkRowCount.get(1).getText());

			//			if(driver.findElement(By.xpath("//div[@class='slick-cell l2 r2 bold-me alignLeft active']")).getText().contains(text1))   {
			//				System.out.println("SCrip " +text2+ "added successfully");
			//			}else {
			//				System.out.println("No scip added");
			//			}

			//	waitForVisible("//div[@class='slick-cell l2 r2 bold-me alignLeft active']");

			//	clear("//div[@class='nav-search-field']/input[@id='watchlistAddsymbolSearchTextbox']");


			//	click("//div[@class='watchlist_action']/button[@id='addSymbol']");



		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void navigateExternalLinks(String locator, String text) throws Exception {
		Actions action = new Actions(driver);
		//	action.moveToElement(driver.findElement(By.linkText("SEBI"))).click().build().perform();
		action.moveToElement(driver.findElement(By.linkText(locator))).click().build().perform();
		Thread.sleep(6000);
		//	driver.findElement(By.linkText("SEBI")).click();
		// Store all currently open tabs in tabs
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());

		// Switch newly open Tab
		driver.switchTo().window(tabs.get(1));

		maximizeBrowser();
		//	if(driver.getCurrentUrl().contains("sebi")) {
		if(driver.getCurrentUrl().contains(text)) {
			System.out.println("----------------------------------------------------------------------");
			System.out.println("External link " +locator+  " has opened successfully");
		}
		else {
			System.out.println("Link Not opened properly");
		}
		// Close newly open tab after performing some operations.
		driver.close();

		// Switch to old(Parent) tab.s
		driver.switchTo().window(tabs.get(0));
		System.out.println("URL is " +driver.getCurrentUrl());

	}


	public void navOverview(String text1,String text2, String text3) throws InterruptedException {
		waitForVisible("//div[@class='grid-canvas']");
		waitForVisible("//div[contains(@class, 'ui-widget-content') and contains(@class, 'slick-row')]");
		if(text3.equalsIgnoreCase("STOCK") || text3.equalsIgnoreCase("FUTURES") || text3.equalsIgnoreCase("OPTIONS")) {

			driver.findElement(By.xpath("//span[contains(text(),'" +text1+"')]")).click();
			//	waitForInvisible("//div[contains(@class, 'ui-widget-content') and contains(@class, 'slick-row')]");
			Thread.sleep(30000);
			String abc = driver.findElement(By.xpath("//div[@id='companyName']")).getText();
			System.out.println(abc);
			if(driver.findElement(By.xpath("//div[@id='companyName']")).getText().equals(text2)) {
				System.out.println("***************************Company Overview page "+text1+ "  " +text2+ "  " +text3+ "  opened successfully***************************");
				System.out.println("***************************Company Overview Page is " +text2+ "********************************");
				driver.navigate().back();
				waitForInvisible("//div[@class='watchlistGrid loading']");
				//	Thread.sleep(10000);

			}
		}else {
			driver.findElement(By.xpath("//span[contains(text(),'" +text1+"')]")).click();
			if(driver.findElement(By.xpath("//div[@class='watchlistHeaderTop']")).isDisplayed()){
				System.out.println("**************************  " +text1+ "  is an OTHERS scrip**************************");
				System.out.println("************************Overview scrips for OTHERS will not be open**************************");

			}

		}


	}


	public void navCharts(String text1,String text2, String text3) throws InterruptedException {
		//	waitForVisible("//div[@class='grid-canvas']");
		//	waitForVisible("//div[contains(@class, 'ui-widget-content') and contains(@class, 'slick-row')]");
		//	if(text3.equalsIgnoreCase("STOCK") || text3.equalsIgnoreCase("FUTURES") || text3.equalsIgnoreCase("OPTIONS")) {


		click("//span[contains(text(),'" +text1+"')]/../../..//.//span[@class='slick-graph']");

		Thread.sleep(10000);
		String abc = driver.findElement(By.xpath("//span[@id='compName']")).getText();
		System.out.println(abc);
		if(driver.findElement(By.xpath("//span[@id='compName']")).getText().equals(text2)) {
			System.out.println("***************************Chart for "+text1+ "  " +text2+ "  " +text3+ "  opened successfully***************************");
			System.out.println("***************************Chart Page is " +text2+ "********************************");
			driver.navigate().back();
			//	waitForInvisible("//div[@class='watchlistGrid loading']");
			Thread.sleep(5000);

		}
		else {
			driver.findElement(By.xpath("//span[contains(text(),'" +text1+"')]")).click();
			if(driver.findElement(By.xpath("//div[@class='watchlistHeaderTop']")).isDisplayed()){
				System.out.println("**************************  " +text1+ "  is an OTHERS scrip**************************");
				System.out.println("************************Charts for OTHERS scrip will not  open**************************");
			}
			/*else {
				System.out.println("Scrip is not present in Watchlist");
			}*/
		}


	}

	public void topSearchQuote(String text1, String text2, String text3) throws Exception {
		waitForVisible("//div[@class='nav-search-facade']");
		if(driver.findElement(By.xpath("//div[@class='nav-search-facade']")).isDisplayed()) {

			Select topSearch = new Select(driver.findElement(By.id("searchContextSelect")));
			topSearch.selectByVisibleText("Quote");
			System.out.println("-------------------------------------------------------------------------------------------------");
			System.out.println("Quote Selected from Top Search");
			clear("//div[@class='nav-search-field']/input[@id='twotabsearchtextbox']");
			enterText("//div[@class='nav-search-field']/input[@id='twotabsearchtextbox']", text2);
			Thread.sleep(3000);

			//		List<WebElement> optionsList = driver.findElements(By.xpath("//div[@class='searchBoxWrap']/ul[@id='ui-id-1']/li[@class='ui-menu-item']"));

			List<WebElement> topSearchList = driver.findElements(By.xpath("//li[@class='ui-menu-item']"));


			for(WebElement webElement : topSearchList){
				//		System.out.println("Scrip searching is: " +webElement.getAttribute("innerText"));
				System.out.println(webElement.getText());
				if(webElement.getText().contains(text1) && webElement.getText().contains(text2)){
					Thread.sleep(3000);
					webElement.click();
					Thread.sleep(3000);

					System.out.println("Company Overview page entered in top search is  "+text1 +"    "+ text3);

					if(driver.findElement(By.xpath("//div[@id='companyName']")).getText().equals(text3)) {
						System.out.println("***************************Company Overview page "+text1+ " " +text3+ "  opened successfully***************************");

					}
					break;	
				}else {
					continue;
				}
				//	break;
			}
			driver.navigate().back();
			Thread.sleep(2000);

		}

	}


	public void topSearchCharts(String text1, String text2, String text3) throws Exception {
		waitForVisible("//div[@class='nav-search-facade']");
		if(driver.findElement(By.xpath("//div[@class='nav-search-facade']")).isDisplayed()) {

			Select topSearch = new Select(driver.findElement(By.id("searchContextSelect")));
			topSearch.selectByVisibleText("Charts");
			System.out.println("-------------------------------------------------------------------------------------------------");
			System.out.println("Charts Selected from Top Search");
			clear("//div[@class='nav-search-field']/input[@id='twotabsearchtextbox']");
			enterText("//div[@class='nav-search-field']/input[@id='twotabsearchtextbox']", text2);
			Thread.sleep(3000);

			//		List<WebElement> optionsList = driver.findElements(By.xpath("//div[@class='searchBoxWrap']/ul[@id='ui-id-1']/li[@class='ui-menu-item']"));

			List<WebElement> topSearchList = driver.findElements(By.xpath("//li[@class='ui-menu-item']"));


			for(WebElement webElement : topSearchList){
				//		System.out.println("Scrip searching is: " +webElement.getAttribute("innerText"));
				System.out.println(webElement.getText());
				if(webElement.getText().contains(text1) && webElement.getText().contains(text2)){
					Thread.sleep(3000);
					webElement.click();
					Thread.sleep(10000);
					waitForInvisible("//img[@class='stx-loader']");
					System.out.println("Company entered in top search is  "+text1 +"    "+ text3);

					if(driver.findElement(By.xpath("//span[@id='compName']")).getText().equals(text2)) {
						System.out.println("***************************Charts for "+text1+ " " +text3+ "  opened successfully***************************");

					}
					break;	
				}else {
					continue;
				}
				//	break;
			}
			driver.navigate().back();
			Thread.sleep(3000);

		}
	}


	public void topSearchNews(String text1, String text2, String text3) throws Exception {
		waitForVisible("//div[@class='nav-search-facade']");
		if(driver.findElement(By.xpath("//div[@class='nav-search-facade']")).isDisplayed()) {

			Select topSearch = new Select(driver.findElement(By.id("searchContextSelect")));
			topSearch.selectByVisibleText("News");
			Thread.sleep(3000);
			System.out.println("-------------------------------------------------------------------------------------------------");
			System.out.println("News Selected from Top Search");
			clear("//div[@class='nav-search-field']/input[@id='twotabsearchtextbox']");
			enterText("//div[@class='nav-search-field']/input[@id='twotabsearchtextbox']", text2);
			Thread.sleep(3000);

			//		List<WebElement> optionsList = driver.findElements(By.xpath("//div[@class='searchBoxWrap']/ul[@id='ui-id-1']/li[@class='ui-menu-item']"));

			List<WebElement> topSearchList = driver.findElements(By.xpath("//li[@class='ui-menu-item']"));


			for(WebElement webElement : topSearchList){
				//		System.out.println("Scrip searching is: " +webElement.getAttribute("innerText"));
				//	System.out.println(webElement.getText());
				if(webElement.getText().contains(text1) && webElement.getText().contains(text2)){
					Thread.sleep(3000);
					webElement.click();
					//	waitForVisible("//div[@id='popup']");
					click("//input[@id='confirm']");
					Thread.sleep(5000);
					List <WebElement> dateTimeStreamNews = driver.findElements(By.xpath("//li[@class='pulseNewsItem']"));
					System.out.println("*****Updated Streaming News*****");
					System.out.println(dateTimeStreamNews.get(0).getText());

					if(dateTimeStreamNews.get(0).getText().contains(text2)) {
						System.out.println("News Displayed is for  " +text2);
					}else if(dateTimeStreamNews.get(0).getText()!=text2){
						System.out.println("Wrong news displayed");
					}else {
						System.out.println("No Data Displayed");
					}

					List <WebElement> dateTimeLatestNews = driver.findElements(By.xpath("//div[@data-name='" +text2+ "']"));
					System.out.println("*****Updated Latest News*****");
				//	System.out.println(dateTimeLatestNews.size());
					System.out.println(dateTimeLatestNews.get(0).getText());
					if(dateTimeLatestNews.get(0).getText().contains(text2)) {
						System.out.println("Latest News Displayed is for  " +text2);
					}else if(dateTimeLatestNews.get(0).getText()!=text2){
						System.out.println("Wrong news displayed");
					}else {
						System.out.println("No Data Displayed");
					}

					break;	
				}else {
					continue;
				}
				//	break;
			}
			
			Thread.sleep(3000);

		}

	}
	
	
	public void topSearchOptionStrategies(String text1, String text2, String text3) throws Exception {
		waitForVisible("//div[@class='nav-search-facade']");
		if(driver.findElement(By.xpath("//div[@class='nav-search-facade']")).isDisplayed()) {

			Select topSearch = new Select(driver.findElement(By.id("searchContextSelect")));
			topSearch.selectByVisibleText("Option Strategies");
			System.out.println("-------------------------------------------------------------------------------------------------");
			System.out.println("OptionStrategies Selected from Top Search");
			clear("//div[@class='nav-search-field']/input[@id='twotabsearchtextbox']");
			enterText("//div[@class='nav-search-field']/input[@id='twotabsearchtextbox']", text2);
			Thread.sleep(3000);

			//		List<WebElement> optionsList = driver.findElements(By.xpath("//div[@class='searchBoxWrap']/ul[@id='ui-id-1']/li[@class='ui-menu-item']"));

			List<WebElement> topSearchList = driver.findElements(By.xpath("//li[@class='ui-menu-item']"));


			for(WebElement webElement : topSearchList){
				//		System.out.println("Scrip searching is: " +webElement.getAttribute("innerText"));
				System.out.println(webElement.getText());
				if(webElement.getText().contains(text1) && webElement.getText().contains(text2)){
					Thread.sleep(2000);
					webElement.click();
					Thread.sleep(10000);

					System.out.println("Option Strategies page entered in top search is  "+ text3);

					if(driver.findElement(By.xpath("//span/input[@value='"+text3+"']")).getText().equals(text3)) {
						System.out.println("***************************Option  Strategies page  " +text3+ "  opened successfully***************************");

					}
					break;	
				}else {
					continue;
				}
				//	break;
			}
			driver.navigate().back();
			Thread.sleep(2000);

		}

	}

	
}

