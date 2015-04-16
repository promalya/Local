package com.lsco.test.page.checkout

import geb.Page

import com.lsco.test.PropertyProvider

class CheckoutPage extends Page {

	static at = {
		def okValue = PropertyProvider.getInstance().getLocalizedPropertyValue("checkout.button")
		assert $("#main-container > div > article.checkout-container > h1").text().toUpperCase() == okValue
	}
	
}
