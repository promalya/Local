package com.lsco.test.page.register

import com.lsco.test.page.model.UserDataModel
import com.lsco.test.page.model.UserDataModelMap
import geb.Page

import org.apache.commons.lang.RandomStringUtils

import com.lsco.test.PropertyProvider
import com.lsco.test.page.checkout.OrderDataModel
import org.openqa.selenium.WebDriver

class ExternalEmailPage extends Page {

	static content = {
		myFrame(page: ExternalEmailFrame) { $('#mailshowdivbody > iframe:nth-child(1)') }
	}

	static at = {
		$("btn.btn.btn-success").text().trim() == "Check it"
	}

	boolean isNewUser() {
		UserDataModelMap.getInstance().getUserMap().get("NEW_USER_DATA")==null
	}

	def createNewEmail(arg1){
		def newEmail = RandomStringUtils.randomAlphanumeric(10)
		RegistrationDataModel.getInstance().email = newEmail + arg1
		UserDataModel userDataModel= new UserDataModel();
		userDataModel.setEmail(newEmail + arg1)
		if (isNewUser()) {
			UserDataModelMap.getInstance().getUserMap().put("NEW_USER_DATA",userDataModel)
		}else{

			UserDataModelMap.getInstance().getUserMap().put("UPDATED_USER_DATA",userDataModel)
		}
		$("#inboxfield").value(newEmail)
		$("btn.btn.btn-success").click()
	}


	def logOut() {
		$("#global-myaccount-signout").click()
	}

	def checkExternalEmailInbox(){
		checkExternalEmailInbox(RegistrationDataModel.getInstance().email)
	}

	def checkExternalEmailInbox(String username){
		$("#inboxfield").value(username)
		$("btn.btn.btn-success").click()

		int retries = 0
		waitFor(600, 10){
			println "Waiting for the confirmation email ..." + retries++
			$("div.from").isDisplayed()
		}

		String brand = PropertyProvider.getInstance().getLocalizedPropertyValue("brand")

		//@@@@@ Commented until SPRING-17256 is resolved
		//assert $("div.from").text().toUpperCase().contains(brand)

		//Access the email
		$("div.from").click()

		//Wait for the Delete button to be displayed
		waitFor(30, 10){
			$("button.btn:nth-child(3)").isDisplayed()
		}

		//Delete the email
		$("button.btn:nth-child(3)").click()

		Thread.sleep(10000)
	}


	def checkSavingsExternalEmailInbox(expectedSavingsAmount){
		$("#inboxfield").value(RegistrationDataModel.getInstance().email)
		$("btn.btn.btn-success").click()

		int retries = 0
		waitFor(600, 10){
			println "Waiting for the confirmation email ..." + retries++
			$("div.from").isDisplayed()
		}

		String brand = PropertyProvider.getInstance().getLocalizedPropertyValue("brand")

		//@@@@@ Commented until SPRING-17256 is resolved
		//assert $("div.from").text().toUpperCase().contains(brand)

		$("div.from").click()

		waitFor(30, 10){
			$("button.btn:nth-child(3)").isDisplayed()
		}

		String currencySymbol = PropertyProvider.getInstance().getLocalizedPropertyValue("currency.symbol")
		String decimalSeparator = PropertyProvider.getInstance().getLocalizedPropertyValue("decimal.separator")

		String expectedSavings = "(" + currencySymbol + expectedSavingsAmount + ")"

		println expectedSavings
		//		println $("td", text: expectedSavings).text()
		//
		//		assert $("td", text: expectedSavings).isDisplayed()
		//
		//		$("button.btn:nth-child(3)").click()
		//
		//		Thread.sleep(10000)
	}

	def checkOrderConfirmationAndLinksEmail(){
		checkOrderConfirmationAndLinksEmail(RegistrationDataModel.getInstance().email)
	}
	
	def checkOrderConfirmationEmail(){
		checkOrderConfirmationEmail(RegistrationDataModel.getInstance().email)
	}

	def checkOrderConfirmationEmail(username){
		$("#inboxfield").value(username)
		$("btn.btn.btn-success").click()
		int retries = 0
		waitFor(600, 10){
			println "Waiting for the confirmation email ..." + retries++
			$("div.from").isDisplayed()
		}
		String brand = PropertyProvider.getInstance().getLocalizedPropertyValue("brand")
		//@@@@@ Commented until SPRING-17256 is resolved
		//assert $("div.from").text().toUpperCase().contains(brand)
		//Access the received email
		$("div.from").click()
		//Wait for the Delete button to be displayed
		waitFor(30, 10){
			$("button.btn:nth-child(3)").isDisplayed()
		}
		withFrame(myFrame) {
			String orderNumber = OrderDataModel.getInstance().orderNumber
			//			String orderNumber = "6560015038"
			def order = $("font", text: orderNumber)
			println "Order number: " + order.text()
			assert order.isDisplayed()
		}
		//Delete the email
		$("button.btn:nth-child(3)").click()
		Thread.sleep(10000)
	}

	def checkOrderConfirmationAndLinksEmail(username){

		$("#inboxfield").value(username)
		$("btn.btn.btn-success").click()

		int retries = 0
		waitFor(600, 10){
			println "Waiting for the confirmation email ..." + retries++
			$("div.from").isDisplayed()
		}

		String brand = PropertyProvider.getInstance().getLocalizedPropertyValue("brand")

		//@@@@@ Commented until SPRING-17256 is resolved
		//assert $("div.from").text().toUpperCase().contains(brand)

		//Access the received email
		$("div.from").click()
		//Wait for the Delete button to be displayed
		waitFor(30, 10){
			$("button.btn:nth-child(3)").isDisplayed()
		}

		withFrame(myFrame) {
			String orderNumber = OrderDataModel.getInstance().orderNumber
			//			String orderNumber = "6560015038"

			def order = $("font", text: orderNumber)
			println "Order number: " + order.text()
			assert order.isDisplayed()
			String link1Text = PropertyProvider.getInstance().getLocalizedPropertyValue("email.link1.text")
			//			String link1Text = "CLOTHING"
			def link1 = $("a", text: link1Text)
			println link1.text()
			assert link1.isDisplayed()
			getBrowser().withNewWindow ({ link1.click()}) { assert  $("#shop-by-style > h2").text().toUpperCase() == "SHOP BY CATEGORY" }
		}

		withFrame(myFrame) {
			String link2Text = PropertyProvider.getInstance().getLocalizedPropertyValue("email.link2.text")
			//			String link2Text = "ACCESSORIES"
			def link2 = $("a", text: link2Text)
			println link2.text()
			assert link2.isDisplayed()
			getBrowser().withNewWindow ({ link2.click()}) { assert  $("header > article > div > h1").text().toUpperCase()  == "ACCESSORIES" }
		}
		
		//Delete the email
		$("button.btn:nth-child(3)").click()

		Thread.sleep(10000)
	}

}
