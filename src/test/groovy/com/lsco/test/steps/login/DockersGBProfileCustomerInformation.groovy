package com.lsco.test.steps.login
import com.lsco.test.GBDockersSmoke
import com.lsco.test.page.LevisHomePage
import com.lsco.test.page.login.LevisLoginPage
import com.lsco.test.page.register.AccountRegistrationPage
import geb.spock.GebReportingSpec

class DockersGBProfileCustomerInformation extends GebReportingSpec {
	@GBDockersSmoke
	def "profileCustomerInformationDockersGB SPRING-15870"()
	{
		when: "going to DockersGB Home page and clicking on My Account"
		to LevisHomePage
		at LevisHomePage
		toMyAccountPage()
		
		
		then: "user is at Dockers GB Login Page"
		at LevisLoginPage
		
		when: "user is at Account Registration Page"
		at AccountRegistrationPage
		fillingRegInfoRandomEmail()
		clickAgeCheckBoxOption()
		submitRegistrationForm()
		clickNotTodayLink()
		
		
		then: "verifying the update Profile functionality"
		updateProfileInfo()
		}



}
