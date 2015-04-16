package com.lsco.test.steps.search
import com.lsco.test.GBLevisSmoke
import com.lsco.test.page.FirstProductPage
import com.lsco.test.page.LevisHomePage
import com.lsco.test.page.search.FailSearchResultPage
import geb.spock.GebReportingSpec
import spock.lang.Unroll
//Levi-GB [SPRING-15741,15742,15745]
class FailSearchResultSpec extends GebReportingSpec{
	@GBLevisSmoke
	@Unroll("Search Invalid product #Item and Check OtherItemsYouMightAlsoLike Section [SPRING-15741,15742,15745]")
	def "Verify Search Functionality"()
	{
		when: "Entering #Item to be Searched"
		to LevisHomePage
		at LevisHomePage
		searchTerm(Item)

		then: "Verifing Searched Item #Item"
		at FailSearchResultPage
		checkOtherItemsSection(4)
		toPDPPageOnClickingItemFromYouMightLikeSection()
		at FirstProductPage
		
		where:
		Item<<["05100349"] //Levi-GB
		
	}

}

