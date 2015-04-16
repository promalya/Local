package com.lsco.test.page.model

class CategoryDataModel {

	int quantity
	
	private static final INSTANCE = new CategoryDataModel()
	
	static getInstance(){
		return INSTANCE
	}
	
	private CategoryDataModel() {
	}
	
	def reset(){
		quantity = 0
	}	

}