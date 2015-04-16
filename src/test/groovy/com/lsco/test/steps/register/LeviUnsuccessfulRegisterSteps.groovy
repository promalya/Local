package com.lsco.test.steps.register
import com.lsco.test.GBLevisSmoke
import com.lsco.test.page.LevisHomePage
import com.lsco.test.page.login.LevisLoginPage
import com.lsco.test.page.register.AccountRegistrationPage
import geb.spock.GebReportingSpec

public class LeviUnsuccessfulRegisterSteps extends GebReportingSpec {
	@GBLevisSmoke
	def "fillingUnsuccessfulRegisterDetails SPRING-15576"()
	{
		when: "going to Levis Home Page and clicking on My account"
		to LevisHomePage
		at LevisHomePage
		dismissPopup()
		toMyAccountPage()
				
		then: "user is at Levis Login Page"
		at LevisLoginPage
		
		when: "user is at account registration page"
		at AccountRegistrationPage
		fillingRegistrationInformation()
		clickAgeCheckBoxOption()
		submitRegistrationForm()
		verifyInvalidEmailTxtForRegistration()
		
		then: "invalid email text for registration verified"
		println "success"
		}
}
