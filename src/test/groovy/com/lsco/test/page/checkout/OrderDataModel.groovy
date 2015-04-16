package com.lsco.test.page.checkout

class OrderDataModel {

	String orderNumber
	Double totalPrice
	
	private static final INSTANCE = new OrderDataModel()
	
	static getInstance(){
		return INSTANCE
	}
	
	private OrderDataModel() {
	}
	
	def reset(){
		orderNumber = ""
		totalPrice = 0D
	}	

}