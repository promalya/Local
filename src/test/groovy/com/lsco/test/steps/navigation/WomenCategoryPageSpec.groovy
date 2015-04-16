package com.lsco.test.steps.navigation
import com.lsco.test.GBLevisSmoke
import com.lsco.test.page.LevisHomePage
import com.lsco.test.page.navigation.WomenCategoryPage
import geb.spock.GebReportingSpec
// Levi-GB [SPRING-16000,15686]
class WomenCategoryPageSpec extends GebReportingSpec{
	@GBLevisSmoke
	def "Verify Navigation to Women'sCategory Page [SPRING-16000,15686]"()
	{
		when: "Clicking on Link to Women's Category  Jeans Page"
		to LevisHomePage
		at LevisHomePage
		toWomenCategoryPage()

		then: "Navigate to Women's Category Page and click on All Collections Link"
		to WomenCategoryPage
		at WomenCategoryPage
		toAllCollectionsPage()
		selectWaistFilter()
		validateProductAfterWaistFilters()

	}
}
