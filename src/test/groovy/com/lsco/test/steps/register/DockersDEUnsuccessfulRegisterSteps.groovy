package com.lsco.test.steps.register
import com.lsco.test.DEDockersSmoke
import com.lsco.test.page.LevisHomePage
import com.lsco.test.page.login.LevisLoginPage
import com.lsco.test.page.register.AccountRegistrationPage
import geb.spock.GebReportingSpec

class DockersDEUnsuccessfulRegisterSteps extends GebReportingSpec {
	@DEDockersSmoke
	def "dockersDEfillingUnsuccessfulRegisterDetails SPRING-15635"()
	{
		when: "going to Dockers DE Home Page and clicking on My account"
		to LevisHomePage
		at LevisHomePage
		toMyAccountPage()
		
		
		then: "user is at Dockers DE Login Page"
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
