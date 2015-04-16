package com.lsco.test.page.login
import geb.Page
import com.lsco.test.PropertyProvider
import org.apache.commons.lang.math.RandomUtils

class LeviLoginPageLatest extends Page {
	
	static url = "https://qa-500-web-000.levi-site.com/DE/de_DE/login"
	
	//https://qa-500-web-000.dockers-site.com/GB/en_GB/login
	
	static at = {
		
		$("section.register > h2").text().toUpperCase() == "NEUER KUNDE"
	}
	
	static content = {
		usernameLevi { $("#loginForm").find("input", id: "j_username")}
		passwordLevi { $("#loginForm").find("input", id: "j_password")}

	
	}
	
	def clickonMyAccountLinkLatest(){
		$("#global-myaccount-cta").click()
	}
	
	def leviLogin() {
		
		def okValue7 = PropertyProvider.getInstance().getLocalizedPropertyValue("emailId")
		usernameLevi.value(okValue7)
		
		def pwdLevi = PropertyProvider.getInstance().getLocalizedPropertyValue("passwordLogin")
		passwordLevi.value(pwdLevi)
		
		$("#link-signin").click()
		
		}

	}
