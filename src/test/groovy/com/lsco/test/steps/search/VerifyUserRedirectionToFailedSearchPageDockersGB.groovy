package com.lsco.test.steps.search
import com.lsco.test.GBDockersSmoke
import com.lsco.test.page.LevisHomePage
import com.lsco.test.page.search.FailSearchResultPage
import geb.spock.GebReportingSpec

class VerifyUserRedirectionToFailedSearchPageDockersGB extends GebReportingSpec {

	@GBDockersSmoke
	def "verifyUserRedirectionToFailedSearchPageDockersGB 15762"()
	{
		when: "going to Dockers GB Home Page and searching for Invalid product"
		to LevisHomePage
		at LevisHomePage
		dismissPopup()
		searchInvalidProduct()
		
		
		then: "user goes to the failed search Page and verifying the Error Message"
		at FailSearchResultPage
		

		}




}
