package com.lsco.test.steps.search
import com.lsco.test.GBDockersSmoke
import com.lsco.test.page.LevisHomePage
import com.lsco.test.page.search.SearchResultPage
import geb.spock.GebReportingSpec

class IndecaSearchSpec_Dockers_GB_15991 extends GebReportingSpec{

	@GBDockersSmoke
	def "SearchForIndeca"()
	{		
		when: "We are Home page & places a search using perticular keyword"
		to LevisHomePage
		at LevisHomePage
		SearchProductIndeca()
				
		then: "User is redirected to a pre-defined search page in Indeca only"
		//to SearchResultPage
		at SearchResultPage
		Results_Indeca()
		
	}
}
