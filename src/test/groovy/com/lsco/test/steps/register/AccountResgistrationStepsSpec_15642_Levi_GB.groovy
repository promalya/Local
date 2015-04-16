package com.lsco.test.steps.register
import com.lsco.test.GBLevisSmoke
import com.lsco.test.*
import com.lsco.test.page.LevisHomePage
import com.lsco.test.page.login.LevisMyAccountPage
import com.lsco.test.page.register.AccountRegistrationPage
import geb.spock.GebReportingSpec

class AccountResgistrationStepsSpec_15642_Levi_GB extends GebReportingSpec{
@TestFew
	@GBLevisSmoke
	def "Registernowdetails"()
	{
		
		when: "We are Home page & click on MyAccount"
		to LevisHomePage
		at LevisHomePage
		toMyAccountPage()
		
		then: "entering Details"
		at AccountRegistrationPage
		updatedregisterANewRandomUser()
		submitRegistrationForm()
		
		when: "we are on the MyAccount Page"
		to LevisMyAccountPage
		at LevisMyAccountPage
		
		then: "Verify successful registration"
		verifyInHeaderSuccessfulRegistration()
		
	}
}
