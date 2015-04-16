package com.lsco.test.page.globalcollect

import geb.Page

import com.lsco.test.PropertyProvider
import com.lsco.test.page.checkout.OrderDataModel

class GlobalCollectSearchPage extends Page {
	
	String getPageUrl() {
		def url = PropertyProvider.getInstance().getGeneralPropertyValue("global.collect.site") + "/advancedSearch"
		url
	}

	static at = {
		assert $("#advancedSearchButton")
//		assert $("#contentWrapper > div.tableGrid.clear > div > strong").text() == "Advanced Search"
	}

	def searchTab(){
		$("#search").click()
	}
	
	def searchOrder(){
		String orderNumber = OrderDataModel.getInstance().orderNumber
		//$("#search").click()
		$("#orderIdInput").value(orderNumber)
		$("#advancedSearchButton").click()
	}

	def verifyOrderPlaced(){
		def orderID = $("#advancedSearch_orderID_1")
		waitFor(30, 5){
			orderID.isDisplayed()
		}
		String orderNumber = OrderDataModel.getInstance().orderNumber
		assert orderID.text() == orderNumber
	}
	
	def verifyPaymentPlaced(productName){
		def productID = $("#quickSearch_ProductId_1")
		waitFor(30, 10){
			productID.isDisplayed()
		}
		assert productID.text().toUpperCase().contains(productName)
	}
	
	def verifyPaymentAmountPlaced(productName){
		def productID = $("#quickSearch_ProductId_1")
		waitFor(30, 10){
			productID.isDisplayed()
		}
		assert productID.text().toUpperCase().contains(productName)
		
		Double orderAmount = $("#advancedSearch_orderAmount_1").text().toDouble()
		Double totalPrice = OrderDataModel.getInstance().totalPrice
		
		assert totalPrice == orderAmount
	}
	
}
