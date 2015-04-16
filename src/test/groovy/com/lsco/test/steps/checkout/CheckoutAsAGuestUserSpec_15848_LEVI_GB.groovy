package com.lsco.test.steps.checkout
import com.lsco.test.GBLevisSmoke
import com.lsco.test.page.CartPage
import com.lsco.test.page.FirstProductPage
import com.lsco.test.page.LevisHomePage
import geb.spock.GebReportingSpec

class CheckoutAsAGuestUserSpec_15848_LEVI_GB extends GebReportingSpec{
	@GBLevisSmoke
	def CheckoutAsAGuest(){
	
	when:"User at HomePage & performs a search "
		to LevisHomePage
		at LevisHomePage
		searchProduct()
		clickOnTheSearchedItem()
		
	then: "User goes to First Product Page and adding product to Bag"
		at FirstProductPage
		addProductToBagLatest("1")
		viewBagFunctionality()

    when: "user goes to Cart Page and proceed to check out"
		to CartPage
		at CartPage
		toCheckoutPageLatest()
	   	fillingShippingAdrressGuest()
		phone()
	    CheckAgeCheckbox()
		submitData()
		chooseMasterCard()
		
	then: "Checking out the order with Credit Card Details"
	   fillCreditCardDataLatest()
	   
	   }
	}
	

