package com.lsco.test.page.checkout

import geb.Page

import com.lsco.test.PropertyProvider


class PayPalPage extends Page {

	static content = {
		loginEmail { $("#login_email") }
		loginPassword { $("#login_password") }
	}

	static at = {
		String okValue = PropertyProvider.getInstance().getLocalizedPropertyValue("paypal.message")
		assert $("#loginPageTitle").text().toUpperCase() == okValue
	}

//	def payPalLogin(payPalUsername, payPalPassword){
//		loginEmail.value(payPalUsername)
//		loginPassword.value(payPalPassword)
//
//		$("#submitLogin").click()
//	}
//
//	def confirmPayPalPayment(){
//		$("#continue_abovefold").click()
//	}
}
