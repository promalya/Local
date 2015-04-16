package com.lsco.test.steps.login
import geb.*

import com.lsco.test.page.LevisHomePage
import com.lsco.test.page.login.FacebookLoginPage
import com.lsco.test.page.login.LevisMyAccountPage

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)
this.metaClass.mixin(geb.Browser)

When(~'^accessing the login page$') { ->
    to LevisHomePage
	at LevisHomePage
	dismissPopup()
	checkIfSignoutIsRequired()
	toMyAccountPage()
}

When(~'^enter the email "([^"]*)" and password "([^"]*)"$') { String arg1, String arg2 ->
	fillLoginFields(arg1,arg2)
	submitLoginForm()
	at LevisMyAccountPage
}

Then(~'^I should see the my account page with "([^"]*)" displayed in the header.$') {  String arg1 ->
	to LevisMyAccountPage
	at LevisMyAccountPage
	verifyEmailInHeader(arg1)
}

When(~'^signing in with the facebook acount "([^"]*)" and password "([^"]*)"$') { String arg1, String arg2 ->
	signInWithFacebook()
	at FacebookLoginPage
	fillFacebookLogin(arg1, arg2)
	at LevisMyAccountPage
}

Then(~'^accesing the last placed order in the customer order history$') { ->
	at LevisMyAccountPage
	toLastPlacedOrder()
}

Then(~'^I should see the gift wrap information displayed$') { ->
	giftWrapCheck()
}
