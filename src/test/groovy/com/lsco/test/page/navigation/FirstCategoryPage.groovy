package com.lsco.test.page.navigation

import geb.Page

import org.apache.commons.lang.math.RandomUtils

import com.lsco.test.page.CategoryItemModule
import com.lsco.test.page.FirstProductPage
import com.lsco.test.page.model.ProductDataModel
import com.lsco.test.page.model.ProductDataModelMap

class FirstCategoryPage extends Page{

	static content = {
		containerResults (wait: true) {$("#container_results")}
		containerProducts(required: false) { moduleList CategoryItemModule, containerResults.find("li.product-tile")}
	}

	static at = {containerResults }

	def checkAllDataRetrieved() {
		//verify that the products are returned
		assert containerProducts.size() > 0

		def products = -containerProducts(0)
		//for each product checks if it has the description and if its image was loaded properly
		for(CategoryItemModule product : products){
			
			//verify description exists
			assert product.detail.text()
			
			//verify the image src attribute
			assert (product.image.@src)
			
			//verify that images are loaded properly
			assert product.image.@complete && product.image.@naturalWidth != "undefined" && product.image.@naturalWidth.toInteger() > 0
		}
		//complete: A Boolean that indicates whether the browser is finished loading the image or not. Returns true if the loading is finished, otherwise it returns false
		//naturalWidth:	Returns the original width of an image
	}
	
	def checkDataRetrieved() {
		//verify that the products are returned
		assert containerProducts.size() > 0

		CategoryItemModule [] products = containerProducts(0)
		
		assert products.length > 0
	}
	
	def toFirstProductPage(){
		$("#container_results > li.product-tile > div.product-images > a").click(FirstProductPage)
	}
	
	String getProductIdInPDP(String elem){
		$(elem).attr("data-product-id")
	}




	boolean isProductAlreadyInBag(String code){
		ProductDataModelMap.getInstance().getProductMap().containsKey(code)
	}

	def addProductToProductsMap(String elemSelector){
		def product = new ProductDataModel()
		def productCode = getProductIdInPDP(elemSelector)
		product.setProductId(productCode)
		ProductDataModelMap.getInstance().getProductMap().put(productCode, product)
	}



	String getProductSelector(int index){
		"li.product-tile:nth-child("+index+")"
	}


	def toRandomDifferentProductPage(){
		def productAlreadyAdded=true
		int productIndex = RandomUtils.nextInt(6)+1
		while(productAlreadyAdded){
			productAlreadyAdded = isProductAlreadyInBag(getProductIdInPDP(getProductSelector(productIndex)))
			if(!productAlreadyAdded){
				while(!($(getProductSelector(productIndex)).isDisplayed())){
				}
				addProductToProductsMap(getProductSelector(productIndex))
				$(getProductSelector(productIndex)+"> div > a").click(FirstProductPage)
			}
			productIndex = RandomUtils.nextInt(6)+1
		}
	}
	
	def toRandomProductPage(){
		CategoryItemModule [] products = containerProducts(0)
		int productIndex = RandomUtils.nextInt(6) + 1
		String selector =  "#container_results > li:nth-child(" + productIndex + ") > div > a"
		while(!($(selector).isDisplayed())){
			productIndex = RandomUtils.nextInt(6) + 1
			selector =  "#container_results > li:nth-child(" + productIndex + ") > div > a"
		}
		$(selector).click(FirstProductPage)
	}
	
}
