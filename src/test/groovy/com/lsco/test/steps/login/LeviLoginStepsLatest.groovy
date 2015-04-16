package com.lsco.test.steps.login
import com.lsco.test.GBLevisSmoke
import com.lsco.test.page.LevisHomePage
import com.lsco.test.page.login.LevisLoginPage
import com.lsco.test.page.login.LevisMyAccountPage
import geb.spock.GebReportingSpec

class LeviLoginStepsLatest extends GebReportingSpec{
	@GBLevisSmoke
	def "fillingLoginDetails SPRING-15643"()
	{
		when: "going to Levis Home Page and clicking on My account"
		to LevisHomePage
		at LevisHomePage
		toMyAccountPage()
		
		
		then: "entering Login details and submitting the form"
		at LevisLoginPage
		leviLogin()
		//submitLoginFormButton()
		submitLoginFormButtonWithPopupCheck()
		
		when: "going to myaccount page and verifying the email name"
		to LevisMyAccountPage
		at LevisMyAccountPage
		verifyEmailNameInHeader()
		
		then: "Verifiication of the email id"
		println "Email name is present in the header"
		}
	}
