package com.lsco.test.page.hac

import geb.Page

import org.openqa.selenium.JavascriptExecutor

class FlexibleSearchFrame extends Page {

	static content = {
		body (wait: true){ $("body.editbox") }
	}

}
