package com.lsco.test.steps.login
import com.lsco.test.DEDockersSmoke
import com.lsco.test.page.LevisHomePage
import com.lsco.test.page.login.LevisLoginPage
import com.lsco.test.page.login.LevisMyAccountPage
import geb.spock.GebReportingSpec

class VerifysuccessfulloginDockersDE extends GebReportingSpec {
	@DEDockersSmoke
	def "verifysuccessfulloginDockersDE 15636"()
	{
		when: "going to Dockers DE Home Page and clicking on My account"
		to LevisHomePage
		at LevisHomePage
		toMyAccountPage()
		
		
		then: "entering valid emailId and password for Login"
		at LevisLoginPage
		leviLogin()
		//submitLoginFormButton()
		submitLoginFormButtonWithPopupCheck()
		
		
		when: "going to myaccount page and verifying the email text"
		to LevisMyAccountPage
		at LevisMyAccountPage
		verifyEmailNameInHeader()
		
		then: "verification is completed"
		println "success"
		
		
		}

}
