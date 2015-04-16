package com.lsco.test.steps.search
import com.lsco.test.GBLevisSmoke
import com.lsco.test.page.LevisHomePage
import com.lsco.test.page.search.FailSearchResultPage
import geb.spock.GebReportingSpec

class VerifyUserRedirectionToFailedSearchPageLeviGB extends GebReportingSpec{
	@GBLevisSmoke
	def "verifyUserRedirectionToFailedSearchPageLeviGB 15739"()
	{
		when: "going to Levis GB Home Page and searching for Invalid product"
		to LevisHomePage
		at LevisHomePage
		dismissPopup()
		searchInvalidProduct()
		
		
		then: "user goes to the failed search Page and verifying the Error Message"
		at FailSearchResultPage
		

		}




}
