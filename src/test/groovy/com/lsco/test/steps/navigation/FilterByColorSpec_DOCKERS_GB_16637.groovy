package com.lsco.test.steps.navigation
import com.lsco.test.GBDockersSmoke
import com.lsco.test.page.LevisHomePage
import geb.spock.GebReportingSpec

class FilterByColorSpec_DOCKERS_GB_16637 extends GebReportingSpec{

	@GBDockersSmoke
	def "FilterByColor"()
	{		
		when: "We are Home page & click ClothingCategory from top-nav"
		to LevisHomePage
		at LevisHomePage
		ClothingCategoryPage()
		
		then: "Filtering By Color"
	    filterbyColor_LEVI()
		clickOnTheFilteredItem()
		
	}
}
