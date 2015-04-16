package com.lsco.test.page.checkout

import geb.Page

class PaymentPage extends Page {

	static content = {
		paymentMethodForm = { $("#PaymentMethodForm")}
		validateOrderButton = { $("#btnSubmit")}
	}

	static at = {
		assert paymentMethodForm
	}
	
	def fillPaymentData(crediCardNumber, securityCode){
		$("input", name: "method").value("3-K")
		$("#FIELD_F1009").value(crediCardNumber)
		$("#F1010_MM").value("12")
		$("#F1010_YY").value("20")
		$("#FIELD_F1136").value(securityCode)
	}
	
	def submitPaymentData() {
		validateOrderButton.click(OrderPage)
	}
	
}
