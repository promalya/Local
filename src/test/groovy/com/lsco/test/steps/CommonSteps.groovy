package com.lsco.test.steps

import geb.*

import com.lsco.test.page.LevisHomePage
import com.lsco.test.page.globalcollect.GlobalCollectLoginPage
import com.lsco.test.page.hac.GroovyWebConsolePage
import com.lsco.test.page.hac.HACLoginPage
import com.lsco.test.page.hmc.HMCLoginPage

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)
this.metaClass.mixin(geb.Browser)

Then(~'^access to Global Collect$'){ ->
	to GlobalCollectLoginPage
	at GlobalCollectLoginPage
	globalCollectLogin()
}

Then(~'^access to Hybris Administration Console \\(username "([^"]*)", password = "([^"]*)"\\)$') { String arg1, String arg2 ->
	to HACLoginPage
	at HACLoginPage
	hybrisLogin(arg1, arg2)
}

Then(~'clear browser cookies'){ ->
	to LevisHomePage
	at LevisHomePage
	deleteCookies()
}

Then(~'^access to Hybris Management Console \\(username "([^"]*)", password = "([^"]*)"\\)$') { String username, String password ->
	to HMCLoginPage
	at HMCLoginPage
	fillHybrisLoginFields(username,password)
}

Then(~'^run the groovy script "([^"]*)"$') { String arg1 ->
	to GroovyWebConsolePage
	at GroovyWebConsolePage
	executeScript(arg1)
}


