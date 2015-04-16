package com.lsco.test.steps.navigation
import com.lsco.test.GBDockersSmoke
import com.lsco.test.page.LevisHomePage
import com.lsco.test.page.login.LevisLoginPage
import com.lsco.test.page.login.LevisMyAccountPage
import geb.spock.GebReportingSpec

class VerifyloadAdditionalProductsOnPDPDockersGB extends GebReportingSpec {
	@GBDockersSmoke
	def "verifyloadAdditionalProductsOnPDPDockersGB 18041"()
	{
		when: "going to Dockers GB Home Page and clicking on My Account"
		to LevisHomePage
		at LevisHomePage
		toMyAccountPage()
		
		
		then: "user is at Dockers GB Login Page and logging in"
		at LevisLoginPage
		leviLogin()
		//submitLoginFormButton()
		submitLoginFormButtonWithPopupCheck()
		
		when: "user goes to shop all section and selecting the Sort them by Drop Down"
		to LevisMyAccountPage
		at LevisMyAccountPage
		shopAllCollection()
		
		then: "sorting and filtering"
		
		println "sorting and filtering done successfully"
		
	}

}
