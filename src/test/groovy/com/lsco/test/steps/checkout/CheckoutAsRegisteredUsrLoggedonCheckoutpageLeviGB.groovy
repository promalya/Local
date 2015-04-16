package com.lsco.test.steps.checkout
import com.lsco.test.GBLevisSmoke
import com.lsco.test.page.CartPage
import com.lsco.test.page.FirstProductPage
import com.lsco.test.page.LevisHomePage
import com.lsco.test.page.OrderConfirmationPage
import geb.spock.GebReportingSpec

class CheckoutAsRegisteredUsrLoggedonCheckoutpageLeviGB extends GebReportingSpec {
	@GBLevisSmoke
	def "CheckoutAsRegisteredUsrLoggedonCheckoutpageLeviGB 15851"()
	{
		when: "going to LevisGB Home Page and searching for product"
		to LevisHomePage
		at LevisHomePage
		dismissPopup()
		searchProductForGuestUsr()
		clickOnTheSearchedItemForGuestUsr()
		
		
		then: "guest user goes to first Product Page and adding the product to Bag"
		at FirstProductPage
		addProductToBagLatest("1")
		viewBagFunctionality()
		
		when: "control goes to Cart Page and logged in from CheckOut Page"
		to CartPage
		at CartPage
		toCheckoutPageLatest()
		loginFromCheckOutPage()
		fillingShippingAddrDetails()
		submitData()
		chooseAmex()
		
		then: "giving the credentials for Amex CC and going to Order Confirmation Page"
		fillCreditCardDataLatestAmex()
		at OrderConfirmationPage
		}



}
