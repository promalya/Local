package com.lsco.test.steps.login
import com.lsco.test.GBLevisSmoke
import com.lsco.test.*
import com.lsco.test.page.LevisHomePage
import com.lsco.test.page.login.LevisLoginPage
import geb.spock.GebReportingSpec

class EmailaddressformarketingEmailOptOutLeviGB extends GebReportingSpec {
	@GBLevisSmoke

	def "emailaddressformarketingEmailOptOutLeviGB 15942"()
	{
		when: "going to Levis GB Home page and clicking on My Account"
		to LevisHomePage
		at LevisHomePage
		toMyAccountPage()
		
		
		then: "user is at Levis GB Login Page and doing the Opt Out Flow"
		at LevisLoginPage
		leviLogin()
		submitLoginFormButtonWithPopupCheck()
		selectEmailOptions()
		marketingEmailOptOutLevisGB()
		

		}
	
}
