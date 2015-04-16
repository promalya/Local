package com.lsco.test.steps.login
import com.lsco.test.GBDockersSmoke
import com.lsco.test.page.LevisHomePage
import com.lsco.test.page.login.LevisLoginPage
import com.lsco.test.page.register.AccountRegistrationPage
import geb.spock.GebReportingSpec

class DockersGBUnsuccesfulLogin extends GebReportingSpec {
	@GBDockersSmoke
	def "fillingUnsuccesfulLoginDetailsDockersGB SPRING-15607"()
	{
		when: "going to Dockers GB Home Page and clicking on My Account"
		to LevisHomePage
		at LevisHomePage
		dismissPopup()
		toMyAccountPage()
		
		
		then: "user is at Dockers GB Login Page"
		at LevisLoginPage
		
		when: "user is at account registration page"
		at AccountRegistrationPage
		fillingRegInfoRandomEmail()
		clickAgeCheckBoxOption()
		submitRegistrationForm()
		clickNotTodayLink()
		unsuccessfulLoginFromProfilePage()
		
		then: "verifying the unsuccessful Login Error Message."
		verifyUnsuccessfulLoginErrorTxt()
		}


}
