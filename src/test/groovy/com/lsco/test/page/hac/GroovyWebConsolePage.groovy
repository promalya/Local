package com.lsco.test.page.hac

import geb.Page

import org.openqa.selenium.Keys

class GroovyWebConsolePage extends Page {

	String getPageUrl() {
		def url = browser.config.rawConfig.basicUrl + "/admin/console/groovy"
		url
	}

	static content = {
		myFrame(page: GroovyWebConsoleFrame) { $('#textarea-container > div.CodeMirror-wrapping > iframe') }
	}

	static at = {
		assert $("#content > div > h2").text()  == "Groovy Web Console"
	}

	def executeScript(String filePath){
		println "Groovy script to execute: " + filePath
		String groovyCode = null
		new File("resources/" + filePath).withInputStream { stream ->
			groovyCode = stream.getText()
		}

		withFrame(myFrame) {
			while ($("body.editbox").text().length() > 0){
				$("body.editbox") << Keys.DELETE
			}
			$("body.editbox") << groovyCode
		}
		$("#executeButton").click()
		waitFor(60){
			$("#result").isDisplayed()
		}
		println "Updated items: " + $("#result").text()
		assert $("#result").text().contains("Update completed")
	}
}
