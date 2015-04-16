package com.lsco.test.steps.login
import com.lsco.test.DELevisSmoke
import com.lsco.test.page.LevisHomePage
import com.lsco.test.page.login.LevisLoginPage
import com.lsco.test.page.register.AccountRegistrationPage
import geb.spock.GebReportingSpec

class LeviDeUnsuccessfulLogin extends GebReportingSpec {
	@DELevisSmoke
	def "fillingUnsuccesfulLoginDetailsLevisDE SPRING-15612"()
	{
		when: "going to Levis De Home Page and clicking on My account"
		to LevisHomePage
		at LevisHomePage
		toMyAccountPage()
		
		
		then: "user is at Levis De Login Page"
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
