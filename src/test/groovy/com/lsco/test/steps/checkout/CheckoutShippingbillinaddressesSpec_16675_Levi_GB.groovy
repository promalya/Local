package com.lsco.test.steps.checkout
import com.lsco.test.GBLevisSmoke
import com.lsco.test.page.CartPage
import com.lsco.test.page.FirstProductPage
import com.lsco.test.page.LevisHomePage
import com.lsco.test.page.login.LevisLoginPage
import com.lsco.test.page.login.LevisMyAccountPage
import geb.spock.GebReportingSpec

class CheckoutShippingbillinaddressesSpec_16675_Levi_GB extends GebReportingSpec{
		@GBLevisSmoke
	def CheckoutWithSavedShippingAdrress(){
	
	when: "We are Home page & click on MyAccount"
		to LevisHomePage
		at LevisHomePage
		toMyAccountPage()

	then:"we are on the MyAccount Page"
	    at LevisLoginPage
		FillLoginFields()
		submitLoginForm()
		
	when:"We are into MyProfile-tab"
	     to LevisMyAccountPage
	     at LevisMyAccountPage
	     openAdrressTab()
		
	then:"Updating Shipping adrress & logout"
	     UpdateShippingAdrressSection()
		 UpdateShippingData()
		 verifyUpdatedShipping()
					
	when:"User does perform a search "
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
	   //ChangeShippingAddress()
	   submitData()
	   chooseMasterCard()
   	   
	then: "Checking out the order with Credit Card Details"
	   fillCreditCardDataLatest()
	   
	   }
	}
	

