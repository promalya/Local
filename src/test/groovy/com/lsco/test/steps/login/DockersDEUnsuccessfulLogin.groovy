package com.lsco.test.steps.login
import com.lsco.test.DEDockersSmoke
import com.lsco.test.page.LevisHomePage
import com.lsco.test.page.login.LevisLoginPage
import com.lsco.test.page.register.AccountRegistrationPage
import geb.spock.GebReportingSpec

class DockersDEUnsuccessfulLogin extends GebReportingSpec {
	@DEDockersSmoke
	def "fillingUnsuccesfulLoginDetailsDockersDE SPRING-15637"()
	{
		when: "going to Dockers DE Home Page and clicking on My Account"
		to LevisHomePage
		at LevisHomePage
		toMyAccountPage()
		
		
		then: "user is at Dockers DE Login Page"
		at LevisLoginPage
		
		when: "user is at Account Registration page"
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
