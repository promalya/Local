package com.lsco.test.steps.login
import com.lsco.test.GBDockersSmoke
import com.lsco.test.page.LevisHomePage
import com.lsco.test.page.login.LevisLoginPage
import geb.spock.GebReportingSpec

class EmailAddrForMarketingEmailsOptInDockersGB extends GebReportingSpec {
	@GBDockersSmoke
	def "emailAddrForMarketingEmailsOptInDockersGB 15948"()
	{
		when: "going to Dockers GB Home page and clicking on My Account"
		to LevisHomePage
		at LevisHomePage
		toMyAccountPage()
		
		
		then: "user is at Dockers GB Login Page and doing the Opt in Flow"
		at LevisLoginPage
		leviLogin()
		submitLoginFormButtonWithPopupCheck()
		selectEmailOptions()
		marketingEmailOptInDockersGB()
		

		}
	

}
