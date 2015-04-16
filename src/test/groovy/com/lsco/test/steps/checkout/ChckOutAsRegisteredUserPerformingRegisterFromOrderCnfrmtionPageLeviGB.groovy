package com.lsco.test.steps.checkout
import com.lsco.test.GBLevisSmoke
import com.lsco.test.page.CartPage
import com.lsco.test.page.FirstProductPage
import com.lsco.test.page.LevisHomePage
import com.lsco.test.page.OrderConfirmationPage
import geb.spock.GebReportingSpec

class ChckOutAsRegisteredUserPerformingRegisterFromOrderCnfrmtionPageLeviGB extends GebReportingSpec {
	@GBLevisSmoke
	def "ChckOutAsRegisteredUserPerformingRegisterFromOrderCnfrmtionPageLeviGB 15853"()
	{
		when: "going to Levis GB Home Page and searching for product"
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
		chooseVisa()
		
		then: "giving the credentials for VISA cc and performing the register from Order Confirmation Page"
		fillCreditCardDataLatestVISA()
		at OrderConfirmationPage
		fillingRegInfoOrderCnfirmationPage()
		verifyOrderFornewlyRegisteredUser()
		}




}
