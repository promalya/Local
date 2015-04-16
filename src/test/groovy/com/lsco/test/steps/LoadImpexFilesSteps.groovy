package com.lsco.test.steps

import geb.*

import com.lsco.test.page.hac.GroovyWebConsolePage
import com.lsco.test.page.hac.HACHomePage


this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)
this.metaClass.mixin(geb.Browser)

Given(~'^a user$') { ->

}

When(~'^accessing the groovy web console and load the file "([^"]*)"$') { String arg1 ->
	to GroovyWebConsolePage
	at GroovyWebConsolePage
	runImpex(arg1)
	
}

When(~'^enter the username "([^"]*)" and password "([^"]*)"$') { String arg1, String arg2 ->
	to HACHomePage
	fillHACLoginFields(arg1, arg2)
	submitLogin()
}

When(~'^load the files in the folder "([^"]*)"$') { String arg1 ->
	loadFromFiles(arg1)
}

Then(~'^I should see the file in hybris$') { ->

}