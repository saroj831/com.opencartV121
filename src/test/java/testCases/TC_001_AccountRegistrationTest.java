package testCases;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.tools.sjavac.Log;

import org.apache.commons.*;
import org.apache.commons.*;
import org.apache.commons.lang3.RandomStringUtils;



public class TC_001_AccountRegistrationTest extends BaseClass {
	
	
	@Test
	
	public void verify_account_registration()
	{
		
		Log.info("*****TC_001_AccountRegistrationTest *****" );
		//Log.info("*****Home page Started *****" );
		HomePage hp=new HomePage(driver);
		//hp.clickMyAccount();
		hp.clickMyAccount();
		hp.clickRegister();
//		Log.info("*****Home page completed *****" );
//		Log.info("**********************************" );
//		Log.info("***** AccountRegistrationPage Started *****" );
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		
		regpage.setFirstName(randomeString().toUpperCase());
		regpage.setLastName(randomeString().toUpperCase());
		regpage.setEmail(randomeString()+"@gmail.com");// randomly generated the email
		regpage.setTelephone(randomeNumber());
		
		String password=randomAlphaNumeric();
		
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		
		String confmsg=regpage.getConfirmationMsg();
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		
		Log.info("***** Finished TC_001_AccountRegistrationTest *****" );
		
	}
	


}
