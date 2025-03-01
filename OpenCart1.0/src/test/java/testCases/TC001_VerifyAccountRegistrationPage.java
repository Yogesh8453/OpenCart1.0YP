package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_VerifyAccountRegistrationPage extends BaseClass {

	@Test(groups = {"sanity", "regression", "master"})
	public void verify_account_registration() {
		
		logger.info("*** Starting TC001_VerifyAccountRegistrationPage Test***");
		try {
		HomePage hp = new HomePage(wd); 
		hp.clickMyAccount();
		logger.info("*** Clicked on MyAccount Link***");
		hp.clickRegister(); 
		
		logger.info("*** Clicked on Register Link***");


		AccountRegistrationPage reguser = new AccountRegistrationPage(wd);
		logger.info("*** Providing Customer details***");
		reguser.setFirstName(randomString().toUpperCase());
		reguser.setLastName(randomString().toUpperCase());
		reguser.setEmail(randomString() + "@gmail.com");
		reguser.setNumber(randomNumber());
		reguser.setPassword("Pass@123");
		reguser.setConfirmPassword("Pass@123"); 
		reguser.clickSubscribe();
		reguser.clickPolicyTerms();
		reguser.clickContinue();
		
		logger.info("*** Validating expected message***");
		String ActualConfirmationMessage = reguser.getMsgConfirmation();
		if(ActualConfirmationMessage.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Test Failed");
			logger.debug("Debug Logs..");
			Assert.assertTrue(false);
		}
		//Assert.assertEquals(ActualConfirmationMessage, "Your Account Has Been Created!!!");
		}
		catch (Exception e) {
			
			Assert.fail();
		}
		logger.info("****Finished the TC001_VerifyAccountRegistrationPage..****");
	}

}
