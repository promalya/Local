package com.lsco.test.page.navigation

import geb.Page

import com.lsco.test.PropertyProvider

class ClothingSweatersCategoryPage extends Page{
	
		static url = "category/men/clothing/sweaters/all"
	
		
		static content = {
			headline { $(".content > h1")}
		}
		
		static at = {
			String okValue = PropertyProvider.getInstance().getLocalizedPropertyValue("clothing.sweaters")
			assert $(".content > h1").text().toUpperCase() == okValue
			return true
		}
	
//		def toAllCollectionsPage(){
//			$("#shop-by-collection>a.cta.see-all").click()
//			//waitFor(30){ $("#main-container > article:nth-child(1) > header > article > div > h1").text() == "JEANS"}
//		}
		def selectSweaterItemTypeFilter(){
			interact {
				click($(".facet-links"))
			}
	
			waitFor(30, 10){
				$("#facet-itemType > ul > li:nth-child(3) > label:nth-child(1)").isDisplayed()
			}
			$("#facet-itemType > ul > li:nth-child(3) > label:nth-child(1)").click()
		}
		def validateProductAfterItemTypeFilters(){
			assert $("p.name").text().contains("SWEATER")
			return true			
		}
}
