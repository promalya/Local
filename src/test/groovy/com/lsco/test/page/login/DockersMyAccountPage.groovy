package com.lsco.test.page.login

import com.lsco.test.page.model.UserDataModel
import com.lsco.test.page.model.UserDataModelMap
import geb.Page

import com.lsco.test.PropertyProvider
import com.lsco.test.page.register.RegistrationDataModel
import org.apache.commons.lang.RandomStringUtils
import org.apache.commons.lang.math.RandomUtils
import java.lang.Integer
import java.util.Random 
//import com.lsco.test.page.register.AccountRegistrationPage
import org.openqa.selenium.WebDriver


class DockersMyAccountPage extends Page{
	
	static url = "my-account/update-profile"
	
	static at = {
		assert $("h1").text().toUpperCase().contains("MY ACCOUNT") 
		return true
		driver.navigate().refresh()
	}
	
	
	static content = {
		loginForm  { $("#loginForm") }
		
		loginEmail {$("#loginForm").find("input", id: "j_username")}
		loginPassWord {$("#loginForm").find("input", id: "j_password")}
		MyAccountForm  { $("#myaccount-form") }
		//Added by Dipannita
		CurrentPassword {$("#profile-form").find("input", id: "currentPassword")}
		NewPassword {$("#profile-form").find("input", id: "newPassword")}
		ConfirmNewPassword {$("#profile-form").find("input", id: "checkNewPassword")}
				
	}
	def searchProduct()
	{
   def skuItemName = PropertyProvider.getInstance().getLocalizedPropertyValue("itemSearch")
   waitFor{$("#input-search")}.value(skuItemName)
 
   $("#search-bar > a").click()
	}
	
	
	def clickOnTheSearchedItem(){
		
	$(".list-type-04>li>div:nth-child(1)>a>img").click()
		
}
}
