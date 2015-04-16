package com.lsco.test.steps
import geb.*
import com.lsco.test.page.LevisHomePage

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)
this.metaClass.mixin(geb.Browser)

Given(~'^a registered user$') { ->
}