package com.lsco.test.page.register

class RegistrationDataModel {

	String email
	
	private static final INSTANCE = new RegistrationDataModel()
	
	static getInstance(){
		return INSTANCE
	}
	
	private RegistrationDataModel() {
	}
	
	def reset(){
		email = ""
	}	

}