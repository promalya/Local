package com.lsco.test.page.navigation

import geb.Page

import org.openqa.selenium.JavascriptExecutor

import com.lsco.test.page.CategoryItemModule
import com.lsco.test.page.JeansFilterItemModule
import com.lsco.test.page.model.CategoryDataModel
import com.lsco.test.page.model.ProductDataModel
import com.lsco.test.page.model.ProductDataModelMap;


class WomenAllJeansCategoryPage extends Page{

	static at = {
		$("#main-container > article:nth-child(1) > header > article > div > h1").text() == "JEANS"
	}

	static content = {
		containerResults (required: false) {$("#container_results")}
		containerProducts (required: false) { moduleList CategoryItemModule, containerResults.find("li.product-tile")}
		legShapeList (required: false) { $("#facet-legShape > ul")}
		legShapeListItems (required: false) { moduleList JeansFilterItemModule, legShapeList.find("li")}
	}

	def checkAllDataRetrieved() {

		//verify that the products are returned
		assert containerProducts.size() > 0

		def products = containerProducts(0)
		
		//for each product checks if it has the description and if its image was loaded properly
		for(CategoryItemModule product : products){

			//This modifications were made because in qa and int enviroment the missing informtion is a common issue. So we just log the missimg data.
			if ((!product.detail.text() || !product.image.@complete || product.image.@naturalWidth == "undefined" || product.image.@naturalWidth.toInteger() == 0)){
				println "*********************** MISSING PRODUCT INFORMATION ***********************"
				println " - Product detail:" + product.detail.text()
				println " - Product image complete:" + product.image.@complete
				println " - Product image natural width:" + product.image.@naturalWidth
				println "***************************************************************************"
			}else{
				//verify description exists
				assert product.detail.text()

				//verify the image src attribute
				assert (product.image.@src)

				//verify that images are loaded properly
				assert product.image.@complete && product.image.@naturalWidth != "undefined" && product.image.@naturalWidth.toInteger() > 0
			}
		}
		//complete: A Boolean that indicates whether the browser is finished loading the image or not. Returns true if the loading is finished, otherwise it returns false
		//naturalWidth:	Returns the original width of an image
	}


	def selectFilters(){
		interact {
			click($(".facet-links"))
		}

		waitFor(30, 10){
			$("#facet-waist > ul > li:nth-child(2) > label:nth-child(1)").isDisplayed()
		}
		$("#facet-waist > ul > li:nth-child(2) > label:nth-child(1)").click()
	}

	def checkDataBeforeFilter() {
		//verify that the products are returned
		assert containerProducts.size() > 0

		CategoryItemModule [] products = containerProducts(0)
		CategoryDataModel.getInstance().quantity = products.length
	}

	def checkDataAfterFilter() {
		//verify that the products are returned
		assert containerProducts.size() > 0

		CategoryItemModule [] products = containerProducts(0)
		assert products.length <= CategoryDataModel.getInstance().quantity
	}

	def chooseFirstProduct(){
		ProductDataModel productDataModel = new ProductDataModel()
		productDataModel.productName = $("#container_results > li > div > a > p.name").text()
		ProductDataModelMap.getInstance().getProductMap().putAt("SELECTED_PRODUCT", productDataModel)

		$("#container_results > li > div > a").click()
	}

	def verifyProductPDP(){
		//		println "Hello"
	}

	def js( String script ){
		(driver as JavascriptExecutor).executeScript( script )
	}

}
