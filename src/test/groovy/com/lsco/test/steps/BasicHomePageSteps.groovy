package com.lsco.test.steps
import geb.*
import com.lsco.test.page.LevisHomePage

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)
this.metaClass.mixin(geb.Browser)

Given(~'^an guest user$') { ->
	
}

When(~'^accessing the homepage$') {
	->
	to LevisHomePage
	dismissPopup()
	checkIfSignoutIsRequired()
	emptyTheBag()
}

Then(~'^i am able to see the homepage$') { -> at LevisHomePage }

Then(~'^accessing my account page$') {
	->
	at LevisHomePage
	toMyAccount()
}

