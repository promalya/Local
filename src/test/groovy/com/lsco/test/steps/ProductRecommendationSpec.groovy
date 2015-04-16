package com.lsco.test.steps
import com.lsco.test.GBDockersSmoke
import spock.lang.Ignore
import spock.lang.IgnoreRest
import com.lsco.test.GBLevisSmoke
import com.lsco.test.page.FirstProductPage
import com.lsco.test.page.LevisHomePage
import com.lsco.test.page.search.SearchResultPage
import geb.spock.GebReportingSpec
//import com.lsco.test.SmokeLeviGB
//Levi-GB [15703,15702]
//Dockers-GB [15707,15843]
class ProductRecommendationSpec extends GebReportingSpec{
	
	//Levi-GB SPRING-15703 ["GOES WELL WITH" section on PDP]
	//Dockers-GB SPRING-15707 ["YOU MAY ALSO LIKE" section on PDP]
	//Dockers-GB SPRING-15843 [product recommendation on the shopping bag]
	@GBLevisSmoke
	
	def "Verify product recommendation on the shopping bag"()
	{
		when: "Entering #Item1 to be Searched"
		to LevisHomePage
		at LevisHomePage
		searchTerm(Item1)

		then: "Verifing Searched Item #Item1"
		at SearchResultPage
		verifySearchedItem(Item1)
		clickSearchedItem()

		then: "Verify Product Recommendations"
		at FirstProductPage
		addProductToBag("3")
		toProductRecommendationItemPage()
		verifyRecommendationsSectionData("may.like.title.1","may.like.title.2")
		toProductRecommendationGoesWellWithItemPage()
		verifyRecommendationsGoesWellWithSectionData("goes.well.with.title")
		
		where:
		Item1<<["306050044"] //Levi[GB]

	}
	
	@GBDockersSmoke
	def "Verify product recommendation on the shopping bag_Dockers_GB"()
	{
		when: "Entering #Item1 to be Searched"
		to LevisHomePage
		at LevisHomePage
		searchTerm(Item1)

		then: "Verifing Searched Item #Item1"
		at SearchResultPage
		verifySearchedItem(Item1)
		clickSearchedItem()

		then: "Verify Product Recommendations"
		at FirstProductPage
		addProductToBag("3")
		toProductRecommendationItemPage()
		verifyRecommendationsSectionData("may.like.title.1","may.like.title.2")
		toProductRecommendationGoesWellWithItemPage()
		verifyRecommendationsGoesWellWithSectionData("goes.well.with.title")

		where:
		Item1<<["474560008"] //Dockers[GB]

	}
	//Levi-GB SPRING-15702 ["RECENTLY VIEWED PRODUCTS" on PDP]
	//@Ignore
	//@GBLevisSmoke
	def "Verify that items displayed within RECENTLY VIEWED PRODUCTS on PDP"()
	{
		
		when: "Entering #Item1 to be Searched"
		to LevisHomePage
		at LevisHomePage
		searchTerm(Item1)

		then: "Verifing Searched Item #Item1"
		at SearchResultPage
		verifySearchedItem(Item1)
		clickSearchedItem()

		then: "Verify Product Recommendations"
		at FirstProductPage
		addProductToBag("1")
		
		when: "Entering #Item2 to be Searched"
		to LevisHomePage
		at LevisHomePage
		searchTerm(Item2)

		then: "Verifing Searched Item #Item2"
		at SearchResultPage
		verifySearchedItem(Item2)
		clickSearchedItem()

		then: "Verify Product Recommendations"
		at FirstProductPage
		addProductToBagWithQty1("1")
		
		when: "Entering #Item3 to be Searched"
		to LevisHomePage
		at LevisHomePage
		searchTerm(Item3)

		then: "Verifing Searched Item #Item3"
		at SearchResultPage
		verifySearchedItem(Item3)
		clickSearchedItem()

		then: "Verify Product Recommendations"
		at FirstProductPage
		addProductToBagWithQty2("1")
		verifyRecentlyViewedItemsSectionData("recently.viewed.title")
		
		where:
		Item1<<["306050044"] //Levi[GB]
		Item2<<["045111098"] //Levi[GB]
		Item3<<["306050030"] //Levi[GB]

	}
}
