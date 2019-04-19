package testPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import framework.utilities.commonFunctions;

public class FrontEndValidations extends commonFunctions {



	@DataProvider(name="FrontEndValidation1")
	public static Object[][] scripDataFromDataprovider1(){
		return new Object[][] {
			{"1234"}
		};
	}	

	@Test(priority=0)
	public void Login() throws Exception {
		openBrowser("webdriver.chrome.driver", "C://Users//Bhagyesh//Desktop//New folder//TestNGProject//chromedriver_win32//chromedriver.exe");
		maximizeBrowser();
		getURL("http://uatabtrade.adityabirlamoney.com/PlatformWebFeb18/Platform/Account/LogIn");
	}

	/*	@Test(priority=1)
	public void blankUserID() throws Exception {
		System.out.println("------------------------------------------------------------------------------------------------------------------");
		System.out.println("_____________BLANK USER ID_______________ ");
		openBrowser("webdriver.chrome.driver", "C://Users//Bhagyesh//Desktop//New folder//TestNGProject//chromedriver_win32//chromedriver.exe");
		maximizeBrowser();
		getURL("http://uatabtrade.adityabirlamoney.com/PlatformWebFeb18/Platform/Account/LogIn");
		waitForVisible("//div[@class='controls']/input[@id='username']");
		click("//div[@class='form-actions']/button[@id = 'btnValidateUser']");

		if(driver.findElement(By.xpath("//div[@id='errors']")).getText().equalsIgnoreCase("You haven't entered your User Id")) {
			System.out.println("**********************User ID must not be empty***************************");
		}else {
			System.out.println("Wrong FrontEnd Validations");	
		}
	}

	@Test(priority=2, dataProvider = "FrontEndValidation1")
	public void invalidUserID(String text) throws InterruptedException {
		System.out.println("------------------------------------------------------------------------------------------------------------------");
		System.out.println("_______________INVALID USER ID________________");
		enterText("//div[@class='controls']/input[@id='username']", text);
		click("//div[@class='form-actions']/button[@id = 'btnValidateUser']");
		Thread.sleep(2000);
		if(driver.findElement(By.xpath("//div[@id='errors']")).getText().equalsIgnoreCase("Uid details is not available.")) {
			System.out.println("********************* " +text+ " is Invalid User**********************");
		}else {
			System.out.println("$$$$ " +text+ " is VALID USER $$$$$");	
		}

	}


	@DataProvider(name="FrontEndValidation2")
	public static Object[][] scripDataFromDataprovider2(){
		return new Object[][] {
			{"3000467"}
		};
	}	

	@Test(priority=3, dataProvider = "FrontEndValidation2")
	public void vLoginBlankPassword(String text) throws InterruptedException {
		System.out.println("------------------------------------------------------------------------------------------------------------------");
		System.out.println("____________________VALID LOGIN and BALNK PASSWORD___________________________");
		enterText("//div[@class='controls']/input[@id='username']", text);
		System.out.println("User Entered UserID : " +text);
		click("//div[@class='form-actions']/button[@id = 'btnValidateUser']");
		Thread.sleep(2000);

		if(driver.findElement(By.xpath("//div[@id='errors']")).getText().equalsIgnoreCase("Uid details is not available.")) {
			System.out.println("********************* " +text+ " is Invalid User**********************");
		}else {
			System.out.println("$$$$ " +text+ " is VALID USER $$$$$");	
		}
		waitForVisible("//div[@class='controls']/input[@id='password']");
		click("//div[@class='form-actions']/button[@id = 'btnValidateUser']");
		if(driver.findElement(By.xpath("//div[@id='errors']")).getText().equalsIgnoreCase("'Password' must not be empty.")) {
			System.out.println("*********************'Password' must not be empty.**********************");
		}else {
			System.out.println("$$$$ Something wrong happened $$$$$");	
		}	
	}

	@DataProvider(name="FrontEndValidation3")
	public static Object[][] scripDataFromDataprovider3(){
		return new Object[][] {
			{"123465"}
		};
	}

	@Test(priority=3, dataProvider = "FrontEndValidation3")
	public void vLoginInvalidPassword(String text) throws InterruptedException {
		System.out.println("------------------------------------------------------------------------------------------------------------------");
		System.out.println("____________________VALID LOGIN and INVALID PASSWORD____________________");
		waitForVisible("//div[@class='controls']/input[@id='password']");
		enterText("//div[@class='controls']/input[@id='password']", "text");
		click("//div[@class='form-actions']/button[@id = 'btnValidateUser']");
		Thread.sleep(7000);
		if(driver.findElement(By.xpath("//div[@id='errors']")).getText().equalsIgnoreCase("Please Enter Valid Password")){
			System.out.println("********************* Please Enter Valid Password **********************");
		}else if(driver.findElement(By.xpath("//div[contains(@class, 'control-group') and contains(@class, 'text-center') and contains(@class, 'bottom-border')]")).getText().equalsIgnoreCase("Forgot Password")) {

			//	}else if(driver.findElement(By.xpath("//div[@class='control-group']")).getText().equalsIgnoreCase("Forgot Password")) {
			System.out.println("********************* User entered wrong password 3 Times. Please enter correct password ***********************");	
			waitForVisible("//button[@id='btnreturntologin']");
			click("//button[@id='btnreturntologin']");
		}else {
			System.out.println("Password entered is valid");
		}

	}

	@DataProvider(name="FrontEndValidation4")
	public static Object[][] scripDataFromDataprovider4(){
		return new Object[][] {
			{"3000461"}
		};
	}
	@Test(priority=4, dataProvider = "FrontEndValidation4")
	public void UnselectImgBlankPwd(String text) throws InterruptedException {
		System.out.println("------------------------------------------------------------------------------------------------------------------");
		System.out.println("________________________VALID USERID and UNSELECT IMG and BLANK PWD________________________");
		waitForVisible("//div[@class='controls']/input[@id='username']");
		enterText("//div[@class='controls']/input[@id='username']", text);
		System.out.println("User Entered UserID : " +text);
		click("//div[@class='form-actions']/button[@id = 'btnValidateUser']");
		Thread.sleep(2000);
		click("//input[@id='chksecurityimg']");
		click("//div[@class='form-actions']/button[@id = 'btnValidateUser']");
		Thread.sleep(2000);
		if(driver.findElement(By.xpath("//div[@id='errors']")).getText().equalsIgnoreCase("You haven't confirmed your Secure Access image")) {
			System.out.println("*********************You haven't confirmed your Secure Access image**********************");
		}else {
			System.out.println("$$$$ Something wrong happened $$$$$");	
		}	
		click("//button[@id='btnreturntologin']");
	}

	@DataProvider(name="FrontEndValidation5")
	public static Object[][] scripDataFromDataprovider5(){
		return new Object[][] {
			{"3000461", "123456"}
		};
	}
	@Test(priority=5, dataProvider = "FrontEndValidation5")
	public void UnselectImgInvalidPwd(String username, String pwd) throws InterruptedException {
		System.out.println("------------------------------------------------------------------------------------------------------------------");
		System.out.println("________________________VALID USERID and UNSELECT IMG and INVALID PWD________________________");
		waitForVisible("//div[@class='controls']/input[@id='username']");
		enterText("//div[@class='controls']/input[@id='username']", username);
		System.out.println("User Entered UserID : " +username);
		click("//div[@class='form-actions']/button[@id = 'btnValidateUser']");
		Thread.sleep(2000);
		click("//input[@id='chksecurityimg']");
		enterText("//div[@class='controls']/input[@id='password']", pwd);
		click("//div[@class='form-actions']/button[@id = 'btnValidateUser']");
		Thread.sleep(2000);
		if(driver.findElement(By.xpath("//div[@id='errors']")).getText().equalsIgnoreCase("You haven't confirmed your Secure Access image")) {
			System.out.println("*********************You haven't confirmed your Secure Access image**********************");
		}else {
			System.out.println("$$$$ Something wrong happened $$$$$");	
		}	
		click("//button[@id='btnreturntologin']");


	}

	@DataProvider(name="FrontEndValidation6")
	public static Object[][] scripDataFromDataprovider6(){
		return new Object[][] {
			{"3000298", "password@123"}
		};
	}
	@Test(priority=6, dataProvider = "FrontEndValidation6")
	public void UnselectImgValidPwd(String username, String pwd) throws InterruptedException {
		System.out.println("------------------------------------------------------------------------------------------------------------------");
		System.out.println("________________________VALID USERID and UNSELECT IMG and VALID PWD________________________");
		waitForVisible("//div[@class='controls']/input[@id='username']");
		enterText("//div[@class='controls']/input[@id='username']", username);
		System.out.println("User Entered UserID : " +username);
		click("//div[@class='form-actions']/button[@id = 'btnValidateUser']");
		Thread.sleep(2000);
		click("//input[@id='chksecurityimg']");
		enterText("//div[@class='controls']/input[@id='password']", pwd);
		click("//div[@class='form-actions']/button[@id = 'btnValidateUser']");
		Thread.sleep(2000);
		if(driver.findElement(By.xpath("//div[@id='errors']")).getText().equalsIgnoreCase("You haven't confirmed your Secure Access image")) {
			System.out.println("*********************You haven't confirmed your Secure Access image**********************");
		}else {
			System.out.println("$$$$ Something wrong happened $$$$$");	
		}	
		click("//button[@id='btnreturntologin']");


	}

	@DataProvider(name="FrontEndValidation7")
	public static Object[][] scripDataFromDataprovider7(){
		return new Object[][] {
			{"3000298", "password@123"}
		};
	}

	@Test(priority=7, dataProvider = "FrontEndValidation7")
	public void validUserValidPwd(String username, String pwd) throws InterruptedException {

		System.out.println("------------------------------------------------------------------------------------------------------------------");
		System.out.println("________________________VALID USERID and SELECT IMG and VALID PWD________________________");
		waitForVisible("//div[@class='controls']/input[@id='username']");
		enterText("//div[@class='controls']/input[@id='username']", username);
		System.out.println("User Entered UserID : " +username);
		click("//div[@class='form-actions']/button[@id = 'btnValidateUser']");
		Thread.sleep(2000);

		enterText("//div[@class='controls']/input[@id='password']", pwd);
		System.out.println("User Entered Password : " +pwd);
		click("//div[@class='form-actions']/button[@id = 'btnValidateUser']");
		Thread.sleep(2000);
		if(driver.findElement(By.xpath("//div[@class='msgBoxTitle']")).getText().equalsIgnoreCase("Validate Answers For Security Question")) {
			System.out.println("*********************Navigated to 2FA Popup **********************");
		}else {
			System.out.println("$$$$ Something wrong happened $$$$$");	
		}	
	//	waitForVisible("//div[@id='twofabg']/div[@id='twofabox']");
	//	waitForVisible("//div[@class='msgBoxContainer']");
	//	click("//div[@class='msgBoxContainer']./div[@id='btnrerurntologin']");


		click("//*[@id='btnrerurntologin']");


	}
	 */
	@DataProvider(name="ForgotPassword")
	public static Object[][] scripDataFromDataproviderForgotPassword(){
		return new Object[][] {
			{"1", "Gaa", "rohan"},
			{"1", "AYZPP2674G", "rohan"},
			{"1", "abcd", "rohan.patkar@heckyl.com"},
			{"1837", "abcd", "rohan"},
			{"1837", "AYZPP2674G", "rohan"},
			{"", "", ""},
			{"", "AYZPP2674G", ""},
			{"", "", "rohan.patkar@heckyl.com"},
			{"", "AYZPP2674G", "rohan.patkar@heckyl.com"},
			{"1837", "", ""},
			{"1837", "AYZPP2674G", ""},
			{"1837", "", "rohan.patkar@heckyl.com"},
			{"1837","AYZPP2674G","rohan.patkar@heckyl.com"}
		};
	}

//	@Test(priority=1, dataProvider = "ForgotPassword")
	public void forgotPassword(String	userID, String pan, String emailID) throws InterruptedException{

		driver.findElement(By.linkText("Forgot Password")).click();
		waitForVisible("//div[contains(@class, 'control-group') and contains(@class, 'text-center') and contains(@class, 'bottom-border')]");
		enterText("//div[@class='controls']/input[@placeholder='User ID']", userID);
		System.out.println("Entered UserID is " +userID);
		Thread.sleep(1000);
		enterText("//div[@class='controls']/input[@placeholder='PAN No']", pan);
		System.out.println("Entered Pan is " +pan);
		Thread.sleep(1000);
		enterText("//div[@class='controls']/input[@placeholder='Email ID']", emailID);
		System.out.println("Entered EmailID is " +emailID);
		Thread.sleep(1000);
		click("//*[@id='btnresetpass']");
		Thread.sleep(7000);
		if(driver.findElement(By.xpath("//div[@id='errors']")).getText().equalsIgnoreCase("User Does Not Exist")) {
			System.out.println("*********************User Does Not Exist**********************");
			click("//*[@id='btnreturntologin']");
		}else if(driver.findElement(By.xpath("//div[@id='errors']")).getText().equalsIgnoreCase("email id does not match")) {
			System.out.println("********************* Email Id does not match ********************");	
			click("//*[@id='btnreturntologin']");
		}else if(driver.findElement(By.xpath("//div[@id='errors']")).getText().equalsIgnoreCase("Please enter correct PAN number")){
			System.out.println("*********************Please enter correct PAN number*********************");
			click("//*[@id='btnreturntologin']");
		}else if(driver.findElement(By.xpath("//div[@id='errors']")).getText().equalsIgnoreCase("You haven't entered your User ID")){
			System.out.println("*********************You haven't entered your User ID***********************");
			click("//*[@id='btnreturntologin']");
		}else if(driver.findElement(By.xpath("//div[@id='errors']")).getText().equalsIgnoreCase("You haven't entered your PAN No")){
			System.out.println("*********************You haven't entered your PAN No************************");
			click("//*[@id='btnreturntologin']");
		}else if(driver.findElement(By.xpath("//div[@id='errors']")).getText().equalsIgnoreCase("You haven't entered your Email Id")){
			System.out.println("*********************You haven't entered your Email Id**********************");	
			click("//*[@id='btnreturntologin']");
		}else {
			System.out.println("*********************Success**********************");
			Thread.sleep(5000);

		}


	}
	
	
	@DataProvider(name="UnblockUserID1")
	public static Object[][] scripDataFromDataproviderUnblockID1(){
		return new Object[][] {
			
			{"1", "Gaa", "rohan"},
			{"1", "abcd", "rohan.patkar@heckyl.com"},
			{"1", "AYZPP2674G", "rohan"},
			{"1", "AYZPP2674G", "rohan.patkar@heckyl.com"},
			{"1837", "abcd", "rohan"},
			{"1837", "abcd", "rohan.patkar@heckyl.com"},
			{"1837", "AYZPP2674G", "rohan"},
			{"", "", ""},
			{"", "AYZPP2674G", ""},
			{"", "", "rohan.patkar@heckyl.com"},
			{"", "AYZPP2674G", "rohan.patkar@heckyl.com"},
			{"1837", "", ""},
			{"1837", "AYZPP2674G", ""},
			{"1837", "", "rohan.patkar@heckyl.com"},
			{"1837","AYZPP2674G","rohan.patkar@heckyl.com"}
		};
	}

//	@Test(priority=1, dataProvider = "UnblockUserID1")
	public void unBlockUserID1(String	userID, String pan, String emailID) throws InterruptedException{

		driver.findElement(By.linkText("Unblock User")).click();
		waitForVisible("//div[contains(@class, 'control-group') and contains(@class, 'text-center') and contains(@class, 'bottom-border')]");
		enterText("//div[@class='controls']/input[@placeholder='User ID']", userID);
		System.out.println("Entered UserID is " +userID);
		Thread.sleep(1000);
		enterText("//div[@class='controls']/input[@placeholder='PAN No']", pan);
		System.out.println("Entered Pan is " +pan);
		Thread.sleep(1000);
		enterText("//div[@class='controls']/input[@placeholder='Email ID']", emailID);
		System.out.println("Entered EmailID is " +emailID);
		Thread.sleep(1000);
		click("//button[@id='btnubuser']");
		Thread.sleep(7000);
		if(driver.findElement(By.xpath("//div[@id='errors']")).getText().equalsIgnoreCase("Invalid User")) {
			System.out.println("********************* Invalid User **********************");
			click("//*[@id='btnreturntologin']");
		}else if(driver.findElement(By.xpath("//div[@id='errors']")).getText().equalsIgnoreCase("Email ID does not match")) {
			System.out.println("********************* Email Id does not match ********************");	
			click("//*[@id='btnreturntologin']");
		}else if(driver.findElement(By.xpath("//div[@id='errors']")).getText().equalsIgnoreCase("PAN number does not match")){
			System.out.println("*********************PAN number does not match*********************");
			click("//*[@id='btnreturntologin']");
		}else if(driver.findElement(By.xpath("//div[@id='errors']")).getText().equalsIgnoreCase("You haven't entered your User ID")){
			System.out.println("*********************You haven't entered your User ID***********************");
			click("//*[@id='btnreturntologin']");
		}else if(driver.findElement(By.xpath("//div[@id='errors']")).getText().equalsIgnoreCase("You haven't entered your PAN No")){
			System.out.println("*********************You haven't entered your PAN No************************");
			click("//*[@id='btnreturntologin']");
		}else if(driver.findElement(By.xpath("//div[@id='errors']")).getText().equalsIgnoreCase("You haven't entered your Email Id")){
			System.out.println("*********************You haven't entered your Email Id**********************");	
			click("//*[@id='btnreturntologin']");
		}else if(driver.findElement(By.xpath("//div[@id='errors']")).getText().equalsIgnoreCase("You haven't entered your PAN No / Email Id")){
			System.out.println("*********************You haven't entered your PAN No / Email Id************************");
			click("//*[@id='btnreturntologin']");
		}else {
			System.out.println("********************* User has been unblocked successfully **********************");
			Thread.sleep(5000);

		}


	}


	@DataProvider(name="Reset2FA")
	public static Object[][] scripDataFromDataproviderReset2FA(){
		return new Object[][] {
			
			{"1", "Gaa", "rohan"},
			{"1", "abcd", "rohan.patkar@heckyl.com"},
			{"1", "AYZPP2674G", "rohan"},
			{"1", "AYZPP2674G", "rohan.patkar@heckyl.com"},
			{"1837", "abcd", "rohan"},
			{"1837", "abcd", "rohan.patkar@heckyl.com"},
			{"1837", "AYZPP2674G", "rohan"},
			{"", "", ""},
			{"", "AYZPP2674G", ""},
			{"", "", "rohan.patkar@heckyl.com"},
			{"", "AYZPP2674G", "rohan.patkar@heckyl.com"},
			{"1837", "", ""},
			{"1837", "AYZPP2674G", ""},
			{"1837", "", "rohan.patkar@heckyl.com"},
			{"1837","AYZPP2674G","rohan.patkar@heckyl.com"}
		};
	}

//	@Test(priority=1, dataProvider = "Reset2FA")
	public void reset2FA(String	userID, String pan, String emailID) throws InterruptedException{

		driver.findElement(By.linkText("Reset Security Question")).click();
		waitForVisible("//div[contains(@class, 'control-group') and contains(@class, 'text-center') and contains(@class, 'bottom-border')]");
		enterText("//div[@class='controls']/input[@placeholder='User ID']", userID);
		System.out.println("Entered UserID is " +userID);
		Thread.sleep(1000);
		enterText("//div[@class='controls']/input[@placeholder='PAN No']", pan);
		System.out.println("Entered Pan is " +pan);
		Thread.sleep(1000);
		enterText("//div[@class='controls']/input[@placeholder='Email ID']", emailID);
		System.out.println("Entered EmailID is " +emailID);
		Thread.sleep(1000);
		click("//button[@id='btnreset2fa']");
		Thread.sleep(7000);
		if(driver.findElement(By.xpath("//div[@id='errors']")).getText().equalsIgnoreCase("Not able to Retrieve Reset2FA")) {
			System.out.println("********************* Not able to Retrieve Reset2FA **********************");
			click("//*[@id='btnreturntologin']");
		}else if(driver.findElement(By.xpath("//div[@id='errors']")).getText().equalsIgnoreCase("Email ID does not match")) {
			System.out.println("********************* Email Id does not match ********************");	
			click("//*[@id='btnreturntologin']");
		}else if(driver.findElement(By.xpath("//div[@id='errors']")).getText().equalsIgnoreCase("PAN number does not match")){
			System.out.println("*********************PAN number does not match*********************");
			click("//*[@id='btnreturntologin']");
		}else if(driver.findElement(By.xpath("//div[@id='errors']")).getText().equalsIgnoreCase("You haven't entered your User ID")){
			System.out.println("*********************You haven't entered your User ID***********************");
			click("//*[@id='btnreturntologin']");
		}else if(driver.findElement(By.xpath("//div[@id='errors']")).getText().equalsIgnoreCase("You haven't entered your PAN No")){
			System.out.println("*********************You haven't entered your PAN No************************");
			click("//*[@id='btnreturntologin']");
		}else if(driver.findElement(By.xpath("//div[@id='errors']")).getText().equalsIgnoreCase("You haven't entered your Email Id")){
			System.out.println("*********************You haven't entered your Email Id**********************");	
			click("//*[@id='btnreturntologin']");
		}else if(driver.findElement(By.xpath("//div[@id='errors']")).getText().equalsIgnoreCase("You haven't entered your PAN No / Email Id")){
			System.out.println("*********************You haven't entered your PAN No / Email Id************************");
			click("//*[@id='btnreturntologin']");
		}else {
			System.out.println("********************* Reset user successiful **********************");
			Thread.sleep(5000);

		}


	}
	
	
	@DataProvider(name="ForgotUserIDID1")
	public static Object[][] scripDataFromDataproviderForgotPasswordID1(){
		return new Object[][] {
			{"Gaa", "rohan", "1234567890"},
			{"Gaa", "rohan", "9960995811"},
			{"Gaa", "rohan.patkar@heckyl.com", "1234567890"},
			{"Gaa", "rohan.patkar@heckyl.com", "9960995811"},
			{"AYZPP2674G", "rohan", "1234567890"},
			{"AYZPP2674G", "rohan", "9960995811"},
			{"AYZPP2674G", "rohan.patkar@heckyl.com", "1234567890"},
			{"", "", ""},
			{"", "", "9960995811"},
			{"", "rohan.patkar@heckyl.com", ""},
			{"", "rohan.patkar@heckyl.com", "9960995811"},
			{"AYZPP2674G", "", ""},
			{"AYZPP2674G", "", "9960995811"},
			{"AYZPP2674G","rohan.patkar@heckyl.com",""},
			{"AYZPP2674G", "rohan.patkar@heckyl.com", "9960995811"}
		};
	}

	@Test(priority=1, dataProvider = "ForgotUserIDID1")
	public void forgotUserID(String	pan, String emailID, String mobNo) throws InterruptedException{

		driver.findElement(By.linkText("Forgot User ID")).click();
		waitForVisible("//div[contains(@class, 'control-group') and contains(@class, 'text-center') and contains(@class, 'bottom-border')]");
		enterText("//div[@class='controls']/input[@placeholder='PAN No']", pan);
		System.out.println("Entered UserID is " +pan);
		Thread.sleep(1000);
		enterText("//div[@class='controls']/input[@placeholder='Email ID']", emailID);
		System.out.println("Entered Pan is " +emailID);
		Thread.sleep(1000);
		enterText("//div[@class='controls']/input[@placeholder='Mobile Number']", mobNo);
		System.out.println("Entered EmailID is " +mobNo);
		Thread.sleep(1000);
		click("//*[@id='btnforgotuser']");
		Thread.sleep(7000);
		if(driver.findElement(By.xpath("//div[@id='errors']")).getText().equalsIgnoreCase("Enter valid Email Id")) {
			System.out.println("*********************Enter valid Email Id**********************");
			click("//*[@id='btnreturntologin']");
		}else if(driver.findElement(By.xpath("//div[@id='errors']")).getText().equalsIgnoreCase("email id is invalid")) {
			System.out.println("********************* email id is invalid ********************");	
			click("//*[@id='btnreturntologin']");
		}else if(driver.findElement(By.xpath("//div[@id='errors']")).getText().equalsIgnoreCase("Please enter correct PAN number")){
			System.out.println("*********************Please enter correct PAN number*********************");
			click("//*[@id='btnreturntologin']");
		}else if(driver.findElement(By.xpath("//div[@id='errors']")).getText().equalsIgnoreCase("You haven't entered your User ID")){
			System.out.println("*********************You haven't entered your User ID***********************");
			click("//*[@id='btnreturntologin']");
		}else if(driver.findElement(By.xpath("//div[@id='errors']")).getText().equalsIgnoreCase("You haven't entered your PAN No")){
			System.out.println("*********************You haven't entered your PAN No************************");
			click("//*[@id='btnreturntologin']");
		}else if(driver.findElement(By.xpath("//div[@id='errors']")).getText().equalsIgnoreCase("You haven't entered your Email Id")){
			System.out.println("*********************You haven't entered your Email Id**********************");	
			click("//*[@id='btnreturntologin']");
		}else {
			System.out.println("*********************Success**********************");
			Thread.sleep(5000);

		}


	}


}
