package com.lsco.test.page.navigation

import geb.Page

import com.lsco.test.PropertyProvider

class WomenCategoryPage extends Page{

	static url = "category/women/jeans"

	
	static content = {
		headline { $(".content > h1")}
	}
	
	static at = {
		String okValue = PropertyProvider.getInstance().getLocalizedPropertyValue("women.jeans")
		assert $(".content > h1").text().toUpperCase() == okValue
		return true 
	}

	def toAllCollectionsPage(){
		$("a.cta.see-all").click()
		//waitFor(30){ $("#main-container > article:nth-child(1) > header > article > div > h1").text() == "JEANS"}
	}
	
	def selectWaistFilter(){
		interact {
			click($(".facet-links"))
		}

		waitFor(30, 10){
			$("#facet-waist > ul > li:nth-child(2) > label:nth-child(1)").isDisplayed()
		}
		$("#facet-waist > ul > li:nth-child(2) > label:nth-child(1)").click()
	}
	def validateProductAfterWaistFilters(){
		String sWaistFilteredExpected=$("#facet-waist > ul > li:nth-child(2) > label:nth-child(1)").text()
		//Navigate to PDP page for the 1st product filtered
		$("#container_results > li:nth-child(1) > div:nth-child(1) > a > img").click()
		String sWaistFilteredActual=$(".size-swatch-wrapper.notouch-device.selected>a").text()
		//Compare waist filtered to waist in PDP
		assert sWaistFilteredExpected==sWaistFilteredActual
		println "Expected Waist : "+sWaistFilteredExpected
		println "Actual Waist : "+sWaistFilteredActual
		return true
	}
	
}
