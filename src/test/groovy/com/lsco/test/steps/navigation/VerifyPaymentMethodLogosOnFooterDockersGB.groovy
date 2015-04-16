package com.lsco.test.steps.navigation
import com.lsco.test.GBDockersSmoke
import com.lsco.test.page.CartPage
import com.lsco.test.page.FirstProductPage
import com.lsco.test.page.LevisHomePage
import com.lsco.test.page.login.LevisLoginPage
import com.lsco.test.page.login.LevisMyAccountPage
import geb.spock.GebReportingSpec

class VerifyPaymentMethodLogosOnFooterDockersGB extends GebReportingSpec{
	@GBDockersSmoke
	def "verifyPaymentMethodLogosOnFooterDockersGB 16642"()
	{
		when: "going to Dockers GB Home Page and clicking on My Account"
		to LevisHomePage
		at LevisHomePage
		toMyAccountPage()
		
		
		then: "user is at Dockers GB Login Page and logging in"
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
		
		when: "user goes to Cart Page"
		to CartPage
		at CartPage
		toCheckoutPageLatest()
		fillingShippingAddrDetails()
		submitData()
		
		then: "Verifying the payment method logos on the Payment screen and then on the Home screen for GB"
		verifyLogosChckOutPageAndHomePageForGB()
		
		}



}
