package com.lsco.test.steps.checkout
import com.lsco.test.GBDockersSmoke
import com.lsco.test.page.CartPage
import com.lsco.test.page.FirstProductPage
import com.lsco.test.page.LevisHomePage
import com.lsco.test.page.OrderConfirmationPage
import com.lsco.test.page.login.LevisLoginPage
import com.lsco.test.page.login.LevisMyAccountPage
import geb.spock.GebReportingSpec

class OrderHistoryWithGiftWrap extends GebReportingSpec {
	@GBDockersSmoke
	def "orderHistoryWithGiftWrapDockersGB Spring 16594"()
	{
		when: "going to DockersGB Home Page and clicking on My Account"
		to LevisHomePage
		at LevisHomePage
		toMyAccountPage()
		
		
		then: "user is at DockersGB Login Page and logging in"
		at LevisLoginPage
		leviLogin()
		//submitLoginFormButton()
		submitLoginFormButtonWithPopupCheck()
		
		when: "user goes to My account page and selecting the product"
		to LevisMyAccountPage
		at LevisMyAccountPage
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
		fillingShippingAddrDetails()
		checkGiftWrapCheckboxLatest()
		submitData()
		chooseAmex()
	
		
		then: "order history verification for giftWrap orders"
		fillCreditCardDataLatestAmex()
		at OrderConfirmationPage
		orderHistoryWithGiftWrap()
		}


}
