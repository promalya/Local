package com.lsco.test.page.hac

import geb.Page


class HACHomePage extends Page {
	
	
	String getPageUrl() {
		"http://qa-410-web-000.levi-site.com/admin/console/impex/import"
	}
	
	static at = {
		assert $("input", name: "j_username")
	}
	
	def fillHACLoginFields(username,password) {
		$("input", name: "j_username").value(username)
		$("input", name: "j_password").value(password)
	}
		
	def submitLogin(){
		$(".button").click()
	}
	
	def loadFromFiles(folder) {
//		String template = stream.getText();
//		$("#scriptContent").value(template)
//		
//		text = new File("./resources/user/deleteCreatedUser.impex").text
//		println(text)
	}
	
	def stream = getClass().getResourceAsStream("deleteCreatedUser.impex");
	
	
	
	
}
