package com.lsco.test.steps.login
import com.lsco.test.RULevisSmoke
import com.lsco.test.page.LevisHomePage
import geb.spock.GebReportingSpec

class VerifyUserNotAbletoRegisterAndLoginRussiaLevis extends GebReportingSpec {
	@RULevisSmoke
	def "verifyUserNotAbletoRegisterAndLoginRussiaLevis 15639"()
	{
		when: "going to Levis Russia Home Page and dismissing the pop-up"
		to LevisHomePage
		at LevisHomePage
		dismissPopup()
		
		
		then: "verifying that myAccount link is absent for Levis Russia"
		myAccountLinkabsentForRussia()
	
		}

}
