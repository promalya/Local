package com.lsco.test.steps.navigation
import com.lsco.test.GBLevisSmoke
import com.lsco.test.page.FirstProductPage
import com.lsco.test.page.LevisHomePage
import com.lsco.test.page.login.LevisLoginPage
import com.lsco.test.page.login.LevisMyAccountPage
import geb.spock.GebReportingSpec

class VerifyHoveringOverSwatches extends GebReportingSpec {
	@GBLevisSmoke
	def "verifyHoveringOverSwatchesLeviGB 15732"()
	{
		when: "going to Levi GB Home Page and clicking on My Account"
		to LevisHomePage
		at LevisHomePage
		toMyAccountPage()
		
		
		then: "user is at Levi GB Login Page and logging in"
		at LevisLoginPage
		leviLogin()
		//submitLoginFormButton()
		submitLoginFormButtonWithPopupCheck()
		
		when: "user goes to My account page and selecting the product"
		to LevisMyAccountPage
		at LevisMyAccountPage
		searchProductWithMultipleSwatches()
		clickOnTheSearchedItem()
		
		then: "User goes to First Product Page and checking for the colour or swatch updation"
		at FirstProductPage
		verifyHoveringOverSwatches()
		
	}
}
