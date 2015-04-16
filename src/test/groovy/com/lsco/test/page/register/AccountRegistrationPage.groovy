package com.lsco.test.page.register

import com.lsco.test.page.model.UserDataModel
import com.lsco.test.page.model.UserDataModelMap
import geb.Page
import org.apache.commons.lang.RandomStringUtils
import org.apache.commons.lang.math.RandomUtils
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebElement

import com.lsco.test.PropertyProvider
import com.lsco.test.page.login.LevisMyAccountPage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.interactions.Actions

class AccountRegistrationPage extends Page {
	
	//static url = "login"
	
	static content = {
		registerForm  { $("#registerForm") }
		
		//++++++++++++added by Suprito 19th Feb 2015++++++++++++++++++
		registrationEmailId { $("#registerForm").find("input", id: "email")}
		registrationPassword { $("#registerForm").find("input", id: "password-new") }
		registrationConfirmPwd { $("#registerForm").find("input", id: "password-confirm") }
		emailinUpdateProfile { $("#EmailSignupForm").find("input", id: "input-email-nav") }
		succesfulRegEmailTxtField { $("#updateProfileForm").find("input", id: "email")}
		
		profileEmailField { $("#updateProfileForm").find("input", id: "email")}
		profileFirstNameField { $("#updateProfileForm").find("input", id: "firstName")}
		profileLastNameField { $("#updateProfileForm").find("input", id: "lastName")}
		//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	}
	
	static at = {
		def okValue = PropertyProvider.getInstance().getLocalizedPropertyValue("register")
		$("section.register > h2").text().toUpperCase() == okValue
	}
	
	def fillRegistrationFields(password){
		fillRegistrationFields(RegistrationDataModel.getInstance().email, password)
	}



	
	def fillRegistrationFields(username,password) {
		registerForm.email = username
		registerForm.find("input", id: "password-new").value(password)
		registerForm.find("input", id: "password-confirm").value(password)
		
		js( ' jQuery( "#age-chkbox" ).css("opacity", "100"); ' )
		js( ' jQuery( "#age-chkbox" ).css("left", "0px"); ' )
		
		$("#age-chkbox").value(true)

		assert registerForm.email == username
		assert registerForm.find("input", id: "password-new").value() == password
		assert registerForm.find("input", id: "password-confirm").value() == password
		assert $("#age-chkbox").value() == "on"
	}
	
	def js( String script ){
		(driver as JavascriptExecutor).executeScript( script )
   }
	
	def submitRegistrationForm() {
		$("#registerForm .btn-dbbdr").click()
	}


	private String generateRamdomAlphabeticString(int length) {
		RandomStringUtils.randomAlphabetic(RandomUtils.nextInt(length) + 9)
	}

	private String generateRamdomAlphanumericString(int length) {
		RandomStringUtils.randomAlphanumeric(RandomUtils.nextInt(length) + 9)
	}

	def registerANewRandomUser(){
		UserDataModel userDataModel= UserDataModelMap.getInstance().getUserMap().get("NEW_USER_DATA")
		userDataModel.setPassword(generateRamdomAlphanumericString(8)+"1Av#!")
		userDataModel.setName(generateRamdomAlphabeticString(10))
		userDataModel.setLastName(generateRamdomAlphabeticString(10))
		fillRegistrationFields(userDataModel.getEmail().toLowerCase(),userDataModel.getPassword())
	}

	def logOut(){
		$("#global-myaccount-signout").click()
	}
	
	
	//++++++++++++++added by Suprito 19th Feb 2015+++++++++++++++++++++++++++++++++++++
	def fillingRegistrationInformation() {
		
		Thread.sleep(5000)
		
		def emailRegister = PropertyProvider.getInstance().getLocalizedPropertyValue("regEmail")
		registrationEmailId.value(emailRegister)
		
		def pwdRegister = PropertyProvider.getInstance().getLocalizedPropertyValue("regPassword")
		registrationPassword.value(pwdRegister)
		
		def confirmPwdRegister = PropertyProvider.getInstance().getLocalizedPropertyValue("regPassword")
		registrationConfirmPwd.value(confirmPwdRegister)
		
}
	
	def clickAgeCheckBoxOption() {
		Thread.sleep(4000)
		/*js( ' jQuery( "#age-chkbox" ).css("opacity", "100"); ' )
		js( ' jQuery( "#age-chkbox" ).css("left", "0px"); ' )
		
		Thread.sleep(2000)
		$("#age-chkbox").value(true)*/
		
		def actions=new Actions(driver);
		WebElement agechkbox=$(".checkbox-label.tag-label").firstElement()
		actions.moveToElement(agechkbox, 10, 2).click().build().perform()
		
		
		
}
	
	def fillingRegInfoRandomEmail() {
		Thread.sleep(5000)
		String Randomresult = RandomStringUtils.random(64, false, true);
		Randomresult = RandomStringUtils.random(32, 0, 20, true, true, "qw32rfHIJk9iQ8Ud7h0X".toCharArray())
		def abcd = Randomresult+"@gmail.com"
		println abcd
		registrationEmailId.value(Randomresult+"@gmail.com")
		
		def pwdRegister1 = PropertyProvider.getInstance().getLocalizedPropertyValue("regPassword")
		registrationPassword.value(pwdRegister1)
		
		def confirmPwdRegister1 = PropertyProvider.getInstance().getLocalizedPropertyValue("regPassword")
		registrationConfirmPwd.value(confirmPwdRegister1)
		
		
		
}
	
	def clickNotTodayLink() {
		
		driver.navigate().refresh()
		
		Thread.sleep(4000)
		
		if ($("#dismiss-btn").isDisplayed())
		
		{
		
			$("#dismiss-btn").click()
		}
		
}
	
	
	def verifyEmailIdFromProfile() {
		
		println emailinUpdateProfile.@value

		
}
	
	def verifyInvalidEmailTxtForRegistration() {
	
		Thread.sleep(5000)
		def myBooleanVariable
		
	myBooleanVariable = $("#registerForm").find("input", id: "email").hasClass( "warning" )
	println myBooleanVariable
	assert myBooleanVariable == true
}
	
	
	def unsuccessfulLoginFromProfilePage() {
		
		/*email Id value after successful registration*/
	def emailFieldValueAfterReg = succesfulRegEmailTxtField.@value
	println emailFieldValueAfterReg
	
	Thread.sleep(5000)
	$("#global-myaccount-signout").click()
	
	driver.navigate().refresh()
	//login with invalid password
	waitFor{$("#loginForm").find("input", id: "j_username")}.value(emailFieldValueAfterReg)
	
	def invalidLoginPassword = PropertyProvider.getInstance().getLocalizedPropertyValue("invalidPwdLogin")
	$("#loginForm").find("input", id: "j_password").value(invalidLoginPassword)
	
	
	$("#link-signin").click()
	
}

	def verifyUnsuccessfulLoginErrorTxt() {
		
		println $(".sign-in>div>p").text()
		println PropertyProvider.getInstance().getLocalizedPropertyValue("signInErrorMessage")
		assert waitFor{$(".sign-in>div>p")}.text()==PropertyProvider.getInstance().getLocalizedPropertyValue("signInErrorMessage")
		return true
		

	
}
	
	def updateProfileInfo(){
		
		//updating the profile details for the customers after registration
		
		Thread.sleep(5000)
			def updateProfileFnam = PropertyProvider.getInstance().getLocalizedPropertyValue("profileFname")
		waitFor{profileFirstNameField}.value(updateProfileFnam)
			
			def updateProfileLnam = PropertyProvider.getInstance().getLocalizedPropertyValue("profileLname")
			profileLastNameField.value(updateProfileLnam)
			
			/*Randomresult1 = RandomStringUtils.random(32, 0, 20, true, true, "qw32rfHIJk9iQ8Ud7h0X".toCharArray())
			profileEmailField.value(Randomresult1+"@gmail.com")*/
			
			//clicking on update profile button
			$(".btn-dbbdr").click()
			
			Thread.sleep(3000)
			
			//reading the value of the email field after updating
			
			def verifyupdatedEmailTxt = waitFor{profileEmailField}.@value
			println verifyupdatedEmailTxt
			
			
			//logout functionality
			
			Thread.sleep(5000)
			$("#global-myaccount-signout").click()
			
			//login again with the updated email id value using variable verifyupdatedEmailTxt
			Thread.sleep(5000)
			waitFor{$("#loginForm").find("input", id: "j_username")}.value(verifyupdatedEmailTxt)
			
			def pwdUsingRegPwd = PropertyProvider.getInstance().getLocalizedPropertyValue("regPassword")
			$("#loginForm").find("input", id: "j_password").value(pwdUsingRegPwd)
			$("#link-signin").click()
			
			//dismissing the pop-up
			
			Thread.sleep(5000)
			
			if ($("#dismiss-btn").isDisplayed())
			
			{
				
				$("#dismiss-btn").click()
			}
			
			//verifying the values of the field with the data passed from the properties file
			Thread.sleep(3000)
			println profileFirstNameField.@value
			println profileLastNameField.@value
			println profileEmailField.@value
		assert profileFirstNameField.@value == updateProfileFnam
		assert profileLastNameField.@value == updateProfileLnam
		assert profileEmailField.@value == verifyupdatedEmailTxt
		
		return true

	}
	
	// Added by Dipannita
	def String result()
	{
	   String Randomresult = RandomStringUtils.random(64, false, true);
	   Randomresult = RandomStringUtils.random(32, 0, 20, true, true, "qw32rfHIJk9iQ8Ud7h0X".toCharArray());
	   return Randomresult
	}

	// Added by Dipannita
	def updatedregisterANewRandomUser(){
		
		def okValue10 = result().concat("@gmail.com")
		registrationEmailId.value(okValue10)
		
		
		def okValue8 = PropertyProvider.getInstance().getLocalizedPropertyValue("password")
		registrationPassword.value(okValue8)
		def okValue9 = PropertyProvider.getInstance().getLocalizedPropertyValue("password")
		registrationConfirmPwd.value(okValue9)
		
		Thread.sleep(1000)
		js( ' jQuery( "#age-chkbox" ).css("opacity", "100"); ' )
		js( ' jQuery( "#age-chkbox" ).css("left", "0px"); ' )
		
		Thread.sleep(1000)
		$("#age-chkbox").value(true)
		//$(".checkbox-label.tag-label").click()

	}
	

	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
}
