package com.lsco.test.page.hac

import geb.Page
import com.lsco.test.page.hac.FlexibleSearchPage


class HACLoginPage extends Page {

	String getPageUrl() {
		def url = browser.config.rawConfig.basicUrl + "/admin/login.jsp"
		url
	}

	static at = {
		assert $(".button").text() == "login"
	}

	def hybrisLogin(username, password){
		$("input", name: "j_username").value(username)
		$("input", name: "j_password").value(password)
		$(".button").click()
	}

	
}
