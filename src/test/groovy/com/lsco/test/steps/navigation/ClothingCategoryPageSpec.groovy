package com.lsco.test.steps.navigation
import com.lsco.test.GBDockersSmoke
import com.lsco.test.page.LevisHomePage
import com.lsco.test.page.navigation.ClothingCategoryPage
import geb.spock.GebReportingSpec
//Dockers-GB [SPRING-15716]
class ClothingCategoryPageSpec extends GebReportingSpec{
	@GBDockersSmoke
	def "Verify Navigation to Clothing Category Page [SPRING-15716]"()
	{
		when: "Clicking on Link to Clothing Category Trousers Page"
		to LevisHomePage
		at LevisHomePage
		toClothingTrousersCategoryPage()

		then: "Navigate to Clothing Category Trousers Page and click on All Collections Link"
		//to ClothingCategoryPage
		at ClothingCategoryPage
		toAllCollectionsPage()

	}
}
