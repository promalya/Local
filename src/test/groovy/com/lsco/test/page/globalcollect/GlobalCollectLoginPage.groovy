package com.lsco.test.page.globalcollect

import geb.Page

import com.lsco.test.PropertyProvider


class GlobalCollectLoginPage extends Page {

	String getPageUrl() {
		def url = PropertyProvider.getInstance().getGeneralPropertyValue("global.collect.site") + "/login"
		url
	}

	static at = {
		assert $("#login_label").text() == "Login"
	}

	def globalCollectLogin(){
		String username = PropertyProvider.getInstance().getGeneralSitePropertyValue("global.collect.username")
		String password = PropertyProvider.getInstance().getGeneralSitePropertyValue("global.collect.password")
		$("input", name: "j_username").value(username)
		$("input", name: "j_password").value(password)
		$("#user_login_button").click()
	}
	
}
