package com.lsco.test.steps.navigation
import com.lsco.test.GBDockersSmoke
import com.lsco.test.page.LevisHomePage
import com.lsco.test.page.navigation.ClothingSweatersCategoryPage
import geb.spock.GebReportingSpec
//Dockers-GB [SPRING-15719]
class ClothingSweatersCategoryPageSpec extends GebReportingSpec{
	@GBDockersSmoke
	def "Verify Navigation to Clothing-Sweaters Category Page [SPRING-15719]"()
	{
		when: "Clicking on Link to Clothing Sweaters Category Page"
		to LevisHomePage
		at LevisHomePage
		toClothingSweatersCategoryPage()

		then: "Navigate to Clothing Category Sweaters Page and click on All Collections Link"
		//to ClothingCategoryPage
		at ClothingSweatersCategoryPage
		//toAllCollectionsPage()
		selectSweaterItemTypeFilter()
		validateProductAfterItemTypeFilters()

	}
}
