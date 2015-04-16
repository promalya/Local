package com.lsco.test.page.navigation

import geb.Page

import com.lsco.test.PropertyProvider

class ClothingCategoryPage extends Page{
	
		static url = "category/men/pants/all"
	
		
		static content = {
			headline { $(".content > h1")}
		}
		
		static at = {
			String okValue = PropertyProvider.getInstance().getLocalizedPropertyValue("clothing.trousers")
			//Thread.sleep(5000)
			assert $(".content > h1").text().toUpperCase() == okValue
			return true
		}
	
		def toAllCollectionsPage(){
			$("#shop-by-collection>a.cta.see-all").click()
			//waitFor(30){ $("#main-container > article:nth-child(1) > header > article > div > h1").text() == "JEANS"}
		}
}
