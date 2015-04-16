package com.lsco.test.page

import geb.Page

import org.openqa.selenium.JavascriptExecutor

class FramePage extends Page {

	static content = {
		creditCardNumber (wait: true){ $("#F1009") }
		validateOrderButton (wait: true){ $("#btnSubmit") }
	}

}
