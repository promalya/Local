package com.lsco.test.page.hac

import geb.Page

import com.lsco.test.page.checkout.OrderDataModel
import com.lsco.test.page.model.ProductDataModel
import com.lsco.test.page.model.ProductDataModelMap
import com.lsco.test.page.register.RegistrationDataModel

class FlexibleSearchPage extends Page {

	String getPageUrl() {
		def url = browser.config.rawConfig.basicUrl + "/admin/console/flexsearch"
		url
	}

	static content = {
		myFrame(page: FlexibleSearchFrame) { $('#flexibleSearchQueryWrapper > div > iframe') }
	}

	static at = {
		assert $("#content > div > h2").text() == "FlexibleSearch"
	}

	def checkAccountCreation(){
		def lowerCaseEmail = RegistrationDataModel.getInstance().email.toLowerCase()
		withFrame(myFrame) {
			$("body.editbox") << "select {uid} from {customer} where {uid} like '%" + lowerCaseEmail + "'"
		}
		$("#buttonSubmit").click()
		waitFor(30){
			$("#queryResultTable_info").text().contains("Showing 1 to 1 of 1 entries")
		}
		assert $("#queryResultTable_info").text().contains("Showing 1 to 1 of 1 entries")
	}

	def checkProductDetailInformation(){
		
		ProductDataModel productDataModel = ProductDataModelMap.getInstance().getProductMap().get("PRODUCT_TO_VERIFY")
		
		
		def productId = productDataModel.productId
		def productGroup = productDataModel.productGroup

		withFrame(myFrame) {
			$("body.editbox") << "select {pc9.code}, {pPG.code} from {pc9product as pc9 JOIN productPageGroup as pPG ON {pc9.productPageGroup} = {pPG.pk} } where {pc9.code} = '" + productId + "'"
		}
		$("#buttonSubmit").click()
		waitFor(30){
			$("#queryResultTable_info").text().contains("Showing 1")
		}
		assert $("#queryResultTable_info").text().contains("Showing 1")

		String productGroupCode = $('tr.odd:nth-child(1) > td:nth-child(2)').text()
		assert productGroupCode == productGroup
	}

	def checkOrderInformation(){

		def orderNumber = OrderDataModel.getInstance().orderNumber
		Double totalPrice = OrderDataModel.getInstance().totalPrice

		withFrame(myFrame) {
			$("body.editbox") << "select {arvatoOrderNumber}, {totalPrice} from {LScoOrder} where  {arvatoOrderNumber} = '" + orderNumber + "'"
		}
		$("#buttonSubmit").click()
		waitFor(30){
			$("#queryResultTable_info").text().contains("Showing 1")
		}
		assert $("#queryResultTable_info").text().contains("Showing 1")

		Double price = $('tr.odd:nth-child(1) > td:nth-child(2)').text().toDouble()
		assert price == totalPrice
	}
}
