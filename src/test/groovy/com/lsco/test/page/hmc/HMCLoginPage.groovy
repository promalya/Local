package com.lsco.test.page.hmc

import geb.Page

class HMCLoginPage extends Page {


	String getPageUrl() {
		def url = browser.config.rawConfig.basicUrl + "/hmc/hybris"
		url
	}

	static at = {
		assert title == "Login - hybris Management Console (hMC)"
	}
	
	def fillHybrisLoginFields(username,password) {
		$("#Main_user").value(username)
		$("#Main_password").value(password)
		
		assert $("#Main_user").value() == username
		assert $("#Main_password").value() == password
		$("#Main_a").click()
	}

}
