package com.lsco.test.steps.register
import com.lsco.test.DELevisSmoke
import com.lsco.test.page.LevisHomePage
import com.lsco.test.page.login.LevisLoginPage
import com.lsco.test.page.register.AccountRegistrationPage
import geb.spock.GebReportingSpec

class LeviDEUnsuccessfulRegisterSteps extends GebReportingSpec {
	@DELevisSmoke
	def "LevisDEfillingUnsuccessfulRegisterDetails SPRING-15610"()
	{
		when: "going to Levis DE Home Page and clicking on My account"
		to LevisHomePage
		at LevisHomePage
		toMyAccountPage()
		
		
		then: "user is at Levis DE Login Page"
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
