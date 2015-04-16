package com.lsco.test.steps.login
import com.lsco.test.page.LevisHomePage
import com.lsco.test.page.login.FacebookLoginPage
import com.lsco.test.page.login.LevisLoginPage
import com.lsco.test.page.login.LevisMyAccountPage
import geb.spock.GebReportingSpec

class FacebookLoginSpec_15613_LEVI_DE extends GebReportingSpec{
	//@DELevisSmoke
	def FacebookLogin(){
	
	when: "We are Home page & click on MyAccount"
		to LevisHomePage
		at LevisHomePage
		toMyAccountPage()

	then : "we are on the Login Page"
	    at LevisLoginPage
		signInWithFacebook()
		//to FacebookLoginPage
			
	when: "We are at Facebook Page"
	    at FacebookLoginPage
	    FillFacebookLogin()
	     
	      		
	then:"Verify We are at MyACcount Page after Facebook login"
	     at LevisMyAccountPage
		 VerifyEmailInHeader()
		
		}
	}
	
	
