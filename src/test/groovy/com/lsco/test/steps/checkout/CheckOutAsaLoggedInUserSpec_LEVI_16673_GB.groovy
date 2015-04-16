package com.lsco.test.steps.checkout
import com.lsco.test.GBLevisSmoke
import com.lsco.test.page.CartPage
import com.lsco.test.page.FirstProductPage
import com.lsco.test.page.LevisHomePage
import com.lsco.test.page.login.LevisLoginPage
import com.lsco.test.page.login.LevisMyAccountPage
import geb.spock.GebReportingSpec

class CheckOutAsaLoggedInUserSpec_LEVI_16673 extends GebReportingSpec{
	@GBLevisSmoke
	def CheckOutAsaLoggedInUser (){
		//Adding Shipping Addrress for Country1-Levi
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
		
	then:"Updating Shipping adrress of country1"
	     UpdateShippingAdrressSection()
		 UpdateShippingData()
		// verifyUpdatedShipping()
		 ChangeLocale1()
		 		 
	//Adding Shipping Addrress for Country2-Levi
		 
	when: "we are on the Home-Page Country-2 & adding a new adrress "
	      at LevisHomePage
		  LoginAfterLocaleChange()
	      ChangeLocale2()
	   		  
	then:"Register user is at country-1 myaccount page"
	      at LevisMyAccountPage
	     	 
	//User re-logs in to country-1	 
	when: "Register user is at country-1 myaccount page& search for product"
	     //to LevisMyAccountPage
	     at LevisMyAccountPage
		 searchProduct()
		 clickOnTheSearchedItem()
	
  	then: "User goes for a search and adding product to Bag"
	   
	   at FirstProductPage
	   addProductToBagLatest("1")
	   viewBagFunctionality()
	   
	when: "user goes to Cart Page and proceed to check out"
	   to CartPage
	   at CartPage
	   toCheckoutPageLatest()
	  // fillingShippingAddrDetailsUpdated()
	   phone()
	   submitData()
	   chooseMasterCard()
		  
	then: "Checking out the order with Credit Card Details"
	   fillCreditCardDataLatest()
		 	   
	   }
	}
	

