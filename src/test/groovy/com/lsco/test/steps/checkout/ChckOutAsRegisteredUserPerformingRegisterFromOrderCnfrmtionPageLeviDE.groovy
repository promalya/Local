package com.lsco.test.steps.checkout
import com.lsco.test.DELevisSmoke
import com.lsco.test.page.CartPage
import com.lsco.test.page.FirstProductPage
import com.lsco.test.page.LevisHomePage
import com.lsco.test.page.OrderConfirmationPage
import geb.spock.GebReportingSpec

class ChckOutAsRegisteredUserPerformingRegisterFromOrderCnfrmtionPageLeviDE extends GebReportingSpec {
	@DELevisSmoke
	def "ChckOutAsRegisteredUserPerformingRegisterFromOrderCnfrmtionPageLeviDE 15854"(){
		when: "going to Levi DE home Page and searching for product"
		to LevisHomePage
		at LevisHomePage
		dismissPopup()
		searchProductForGuestUsr()
		clickOnTheSearchedItemForGuestUsr()
		
		
		then: "guest user goes to first Product Page and adding the product to Bag"
		at FirstProductPage
		addProductToBagLatest("1")
		viewBagFunctionality()
		
		when: "control goes to Cart Page"
		to CartPage
		at CartPage
		toCheckoutPageLatest()
		fillingShippingAddrDetails()
		checkAgeCheckboxChckOutPage()
		submitData()
		chooseAmex()
		
		then: "giving the credentials for AMEX cc and performing the register from Order Confirmation Page"
		fillCreditCardDataLatestAmex()
		at OrderConfirmationPage
		fillingRegInfoOrderCnfirmationPage()
		verifyOrderFornewlyRegisteredUser()
		}


	
	
}
