package com.lsco.test.steps.navigation
import com.lsco.test.GBLevisSmoke
import com.lsco.test.page.LevisHomePage
import geb.spock.GebReportingSpec

class FilterByColorSpec_16638_LEVI_GB extends GebReportingSpec{

	@GBLevisSmoke
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
