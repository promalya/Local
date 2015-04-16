package com.lsco.test.steps.checkout
import com.lsco.test.GBDockersSmoke
import com.lsco.test.page.CartPage
import com.lsco.test.page.FirstProductPage
import com.lsco.test.page.LevisHomePage
import geb.spock.GebReportingSpec

class SignOutFromCheckOutSpec_17758_Dockers_GB extends GebReportingSpec{
	@GBDockersSmoke
	def CheckoutAsARegisteredUser(){
	
	when:"Registered User at HomePage & performs a search "
		to LevisHomePage
		at LevisHomePage
		searchProduct()
		//at SearchResultPage
		clickOnTheSearchedItem()
		
	then: "User goes to First Product Page and adding product to Bag"
		at FirstProductPage
		addProductToBagLatest("1")
		viewBagFunctionality()

    when: "user goes to Cart Page-> proceed to check out->Performs a signin"
		to CartPage
		at CartPage
		toCheckoutPageLatest()
		SignIn_Checkout()
		VerifyProductAdded()
						
	then: "Registered user performs Sign-out & verifies product is removed from thebag"
	    SignOut_Checkout()
		VerifyProductRemoved()
		
	when: "User Again checks-out as a guest"
		at CartPage
		UserCheckOutAsAGuest()
		
	then: "Registered user again signs-in & sees the product added earlier"
		at CartPage
		SignIn_Checkout()
		VerifyProductAdded()
			   
	   }
	}
	

