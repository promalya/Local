package com.lsco.test.page.login

import com.lsco.test.page.model.UserDataModel
import com.lsco.test.page.model.UserDataModelMap
import geb.Page

import com.lsco.test.PropertyProvider
import org.apache.commons.lang.RandomStringUtils
import org.apache.commons.lang.math.RandomUtils
import org.openqa.selenium.WebDriver
//--added by suprito --6thMarch 2015
import org.openqa.selenium.*
import org.openqa.selenium.internal.FindsByXPath

class LevisLoginPage extends Page {

	//static url = "login"

	static at = {
		def okValue = PropertyProvider.getInstance().getLocalizedPropertyValue("my.account")
		$("#main-container > div > article > h1").text().toUpperCase() == okValue
	}
	
	//-------added by Suprito 19th Feb 2015-------------------------
	static content = {
		usernameLevi { $("#loginForm").find("input", id: "j_username")}
		passwordLevi { $("#loginForm").find("input", id: "j_password")}
		
		loginForm  { $("#loginForm") }
		
		//---------------------------Suprito 6th March 2015
		marketingEmailTxtBox { $("#emailUnsubscribeForm").find("input", id: "email")}
	
	}
	
	//-------------------------------------------------------------------------------------
	
	def fillLoginFields(username,password) {
		$("#loginForm").j_username = username
		$("#loginForm").j_password = password
		
		assert $("#loginForm").j_username == username
		assert $("#loginForm").j_password == password
	}
	
	def submitLoginForm() {
		$("#link-signin").click()
		Thread.sleep(1000)
		return true
	}
	
	def signInWithFacebook() {
		$("button", text:'Sign in with Facebook').click()
	}

	def signUpAsRegisteredRandomUser(){
		def email=UserDataModelMap.getInstance().getUserMap().get("NEW_USER_DATA").getEmail().toLowerCase()
		def password=UserDataModelMap.getInstance().getUserMap().get("NEW_USER_DATA").getPassword()
		fillLoginFields(email,password)
	}
	
	
	//Added by Suprito 19th Feb 2015##########################################
	
	def leviLogin() {
		
		def emailLevi = PropertyProvider.getInstance().getLocalizedPropertyValue("emailId")
		usernameLevi.value(emailLevi)
		
		println emailLevi
		
		def pwdLevi = PropertyProvider.getInstance().getLocalizedPropertyValue("passwordLogin")
		passwordLevi.value(pwdLevi)
		}
	def submitLoginFormButton(){
		$("#link-signin").click()
		return true
	}
	def submitLoginFormButtonWithPopupCheck(){
		$("#link-signin").click()
		Thread.sleep(5000)
		driver.navigate().refresh()
		
		Thread.sleep(4000)
		
		if ($("#dismiss-btn").isDisplayed())
		
		{	
			$("#dismiss-btn").click()
		}		
		else{
			println "pop-up not present."
		}
		return true
	}
	
	def FillLoginFields() {
		def okValue1 = PropertyProvider.getInstance().getLocalizedPropertyValue("username_dipa")
		usernameLevi.value(okValue1)
		def okValue2 = PropertyProvider.getInstance().getLocalizedPropertyValue("password")
		passwordLevi.value(okValue2)
		
	}
	def FillLoginFieldsToCheckOrderHistory() {
		def okValue1 = PropertyProvider.getInstance().getLocalizedPropertyValue("usernameOrderHistory")
		usernameLevi.value(okValue1)
		def okValue2 = PropertyProvider.getInstance().getLocalizedPropertyValue("pwOrderHistory")
		passwordLevi.value(okValue2)
		
	}
	
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	
	//Suprito--6thMarch 2015--------------
	
	def selectEmailOptions(){
		
	Thread.sleep(3000)
			
		$("#EmailOptionLink").click()
	
	Thread.sleep(2000)
	
	return true
	}
	
	
	def marketingEmailOptInDockersGB(){
		Thread.sleep(3000)
		// entering random email id under Email Options section
	String Randomresult4 = RandomStringUtils.random(64, false, true);
			Randomresult4 = RandomStringUtils.random(32, 0, 20, true, true, "qw32rfHIJk9iQ8Ud7h0X".toCharArray())
			marketingEmailTxtBox.value(Randomresult4+"@gmail.com")
			
			// clicking on Edit Options Button
			$(".btn-dbbdr").click()

			Thread.sleep(3000)
			// checking all the checkboxes under send me Dockers News and Offers
			driver.switchTo().frame("manageEmailOptsIframe")
			Thread.sleep(2000)
			def emailTxt = $("#check>table>tbody>tr:nth-child(1)>td:nth-child(2)").text()
			println emailTxt
			
			
			$("input#New_Arrivals").click()
			$("input#Men").click()
			$("input#Promotions_Sales").click()
			$("input#Social_Campaigns").click()
			$("input#Brand_Campaign_Events").click()
			$("input#Brand_Messages").click()
			
			Thread.sleep(2000)
			//click on save button
			$("input[type='image']").click()
			
			Thread.sleep(5000)
			waitFor{$("#content>span").displayed}
			//verifying the succesful optin message
			def cnfrmMsg = $("#content>span").text()
			assert cnfrmMsg.contains("Your preferences have been saved")
			
			driver.switchTo().defaultContent()
			Thread.sleep(4000)
			// again verifying whether the checkboxes are checked for the same email id
			$("#EmailOptionLink").click()
			Thread.sleep(8000)
			marketingEmailTxtBox.value(emailTxt)
			$(".btn-dbbdr").click()
			Thread.sleep(7000)
			driver.switchTo().frame("manageEmailOptsIframe")
			Thread.sleep(2000)
			println $("input#New_Arrivals").attr('checked')
		assert $("input#New_Arrivals").attr('checked') == "true"
		assert $("input#Men").attr('checked') == "true"
		assert $("input#Promotions_Sales").attr('checked') == "true"
		assert $("input#Social_Campaigns").attr('checked') == "true"
		assert $("input#Brand_Campaign_Events").attr('checked') == "true"
		assert $("input#Brand_Messages").attr('checked') == "true"
	
		return true
			
	}
	
	def marketingEmailOptOutDockersGB(){
		Thread.sleep(3000)
		// entering random email id under Email Options section
	String Randomresult5 = RandomStringUtils.random(64, false, true);
			Randomresult5 = RandomStringUtils.random(32, 0, 20, true, true, "qw32rfHIJk9iQ8Ud7h0X".toCharArray())
			marketingEmailTxtBox.value(Randomresult5+"@gmail.com")
			
			// clicking on Edit Options Button
			$(".btn-dbbdr").click()

			Thread.sleep(3000)
			// checking all the checkboxes under send me Dockers News and Offers
			driver.switchTo().frame("manageEmailOptsIframe")
			Thread.sleep(2000)
			def emailTxt1 = $("#check>table>tbody>tr:nth-child(1)>td:nth-child(2)").text()
			println emailTxt1
			$("input#New_Arrivals").click()
			$("input#Men").click()
			$("input#Promotions_Sales").click()
			$("input#Social_Campaigns").click()
			$("input#Brand_Campaign_Events").click()
			$("input#Brand_Messages").click()
			Thread.sleep(2000)
			//click on save button
			$("input[type='image']").click()
			Thread.sleep(2000)
			if($("input[type='image']").displayed)
			$("input[type='image']").click()
			Thread.sleep(5000)
			//verifying the succesful optin message
			waitFor(100){$("#content>span").text()!=null}
			def cnfrmMsg = $("#content>span").text()
			assert cnfrmMsg.contains("Your preferences have been saved")
			
			driver.switchTo().defaultContent()
			Thread.sleep(4000)
			// Now Un-checking the checkboxes doing the Opt-Out Flow
			$("#EmailOptionLink").click()
			Thread.sleep(8000)
			marketingEmailTxtBox.value(emailTxt1)
			$(".btn-dbbdr").click()
			Thread.sleep(7000)
			driver.switchTo().frame("manageEmailOptsIframe")
			Thread.sleep(2000)
						$("#Unsubscribe").click()
						waitFor(20){$("input[type='image']")}
						$("input[type='image']").click()
						waitFor(50){$("#content>span")}
						def optOutMsg = $("#content>span").text()
			assert optOutMsg.contains("You will no longer receive")
			driver.switchTo().defaultContent()
			Thread.sleep(5000)
// Now verifying whether the checkboxes are unchecked by re-accesing the email id
						$("#EmailOptionLink").click()
			Thread.sleep(8000)
			marketingEmailTxtBox.value(emailTxt1)
			$(".btn-dbbdr").click()
			Thread.sleep(7000)
			driver.switchTo().frame("manageEmailOptsIframe")
			Thread.sleep(2000)
					   println $("input#New_Arrivals").attr('checked')
		assert $("input#New_Arrivals").attr('checked') != "true"
		assert $("input#Men").attr('checked') != "true"
		assert $("input#Promotions_Sales").attr('checked') != "true"
		assert $("input#Social_Campaigns").attr('checked') != "true"
		assert $("input#Brand_Campaign_Events").attr('checked') != "true"
		assert $("input#Brand_Messages").attr('checked') != "true"
	return true
			
	}
	
	
	def marketingEmailOptInLevisGB(){
		Thread.sleep(3000)
		// entering random email id under Email Options section
	String Randomresult6 = RandomStringUtils.random(64, false, true);
			Randomresult6 = RandomStringUtils.random(32, 0, 20, true, true, "qw32rfHIJk9iQ8Ud7h0X".toCharArray())
			marketingEmailTxtBox.value(Randomresult6+"@gmail.com")
			
			// clicking on Edit Options Button
			$(".btn-dbbdr").click()

			Thread.sleep(3000)
			// checking all the checkboxes under send me Dockers News and Offers
			driver.switchTo().frame("manageEmailOptsIframe")
			Thread.sleep(2000)
			def emailTxt2 = $("#check>table>tbody>tr:nth-child(1)>td:nth-child(2)").text()
			println emailTxt2
			
			
			$("input#Men").click()
			$("input#New_Arrivals").click()
			$("input#Women").click()
			$("input#Promotions_Sales").click()
			$("input#Kids_Baby").click()
			$("input#Social_Campaigns").click()
						$("input#Brand_Campaign_Events").click()
			$("input#Brand_Messages").click()
			
			Thread.sleep(4000)
			//click on save button
			$("input[type='image']").click()
			
			Thread.sleep(7000)
			//verifying the succesful optin message
			waitFor(100){$("#content>span")}
			def cnfrmMsg = $("#content>span").text()
			assert cnfrmMsg.contains("Your preferences have been saved")
			
			driver.switchTo().defaultContent()
			Thread.sleep(4000)
			// again verifying whether the checkboxes are checked for the same email id
			$("#EmailOptionLink").click()
			Thread.sleep(8000)
			marketingEmailTxtBox.value(emailTxt2)
			$(".btn-dbbdr").click()
			Thread.sleep(7000)
			driver.switchTo().frame("manageEmailOptsIframe")
			Thread.sleep(2000)
			println $("input#New_Arrivals").attr('checked')
		assert $("input#Men").attr('checked') == "true"
		assert $("input#New_Arrivals").attr('checked') == "true"
		assert $("input#Women").attr('checked') == "true"
		assert $("input#Promotions_Sales").attr('checked') == "true"
		assert $("input#Kids_Baby").attr('checked') == "true"
		assert $("input#Social_Campaigns").attr('checked') == "true"
				assert $("input#Brand_Campaign_Events").attr('checked') == "true"
				assert $("input#Brand_Messages").attr('checked') == "true"
	
		return true
			
	}
	
	
	def marketingEmailOptOutLevisGB(){
		Thread.sleep(3000)
		// entering random email id under Email Options section
	String Randomresult6 = RandomStringUtils.random(64, false, true);
			Randomresult6 = RandomStringUtils.random(32, 0, 20, true, true, "qw32rfHIJk9iQ8Ud7h0X".toCharArray())
			marketingEmailTxtBox.value(Randomresult6+"@gmail.com")
			
			// clicking on Edit Options Button
			$(".btn-dbbdr").click()

			Thread.sleep(3000)
			// checking all the checkboxes under send me Dockers News and Offers
			driver.switchTo().frame("manageEmailOptsIframe")
			Thread.sleep(2000)
			def emailTxt3 = $("#check>table>tbody>tr:nth-child(1)>td:nth-child(2)").text()
			println emailTxt3
				
			$("input#Men").click()
			$("input#New_Arrivals").click()
			$("input#Women").click()
			$("input#Promotions_Sales").click()
			$("input#Kids_Baby").click()
			$("input#Social_Campaigns").click()
			$("input#Brand_Campaign_Events").click()
			$("input#Brand_Messages").click()
			

			Thread.sleep(2000)
			//click on save button
			$("input[type='image']").click()
			
			Thread.sleep(5000)
			waitFor(100){$("#content>span")}
			waitFor{$("#content>span").isDisplayed()}
			//verifying the succesful optin message
			def cnfrmMsg = $("#content>span").text()
			assert cnfrmMsg.contains("Your preferences have been saved")
			
			driver.switchTo().defaultContent()
			Thread.sleep(4000)
			// Now Un-checking the checkboxes doing the Opt-Out Flow
			$("#EmailOptionLink").click()
			Thread.sleep(8000)
			marketingEmailTxtBox.value(emailTxt3)
			$(".btn-dbbdr").click()
			Thread.sleep(7000)
			driver.switchTo().frame("manageEmailOptsIframe")
			Thread.sleep(2000)
			$("#Unsubscribe").click()
			$("input[type='image']").click()
			Thread.sleep(5000)
			waitFor(100){$("#content>span")}
			def optOutMsg = $("#content>span").text()
			assert optOutMsg.contains("You will no longer receive")
			Thread.sleep(2000)
			driver.switchTo().defaultContent()
			Thread.sleep(5000)
// Now verifying whether the checkboxes are unchecked by re-accesing the email id
						$("#EmailOptionLink").click()
			Thread.sleep(8000)
			marketingEmailTxtBox.value(emailTxt3)
			$(".btn-dbbdr").click()
			Thread.sleep(7000)
			driver.switchTo().frame("manageEmailOptsIframe")
			Thread.sleep(2000)
					   println $("input#New_Arrivals").attr('checked')
		assert $("input#Men").attr('checked') != "true"
		assert $("input#New_Arrivals").attr('checked') != "true"
		assert $("input#Women").attr('checked') != "true"
		assert $("input#Promotions_Sales").attr('checked') != "true"
		assert $("input#Kids_Baby").attr('checked') != "true"
		assert $("input#Social_Campaigns").attr('checked') != "true"
				assert $("input#Brand_Campaign_Events").attr('checked') != "true"
				assert $("input#Brand_Messages").attr('checked') != "true"
	return true
			
	}
	
	
	def marketingEmailOptInFlowDockersGB(){
			
		//$("input", type:"checkbox", name:"New_Arrivals").value(true)
			//$("input[name='New_Arrivals']")
			Thread.sleep(2000)
			//$("#Promotions_Sales").attr("value",true)
			//$("input[id='namedattr_New_Arrivals']").click()
			
			//$('input.checkbox').attr('checked',true);
			
			//$("#Social_Campaigns").value(true)
			//$("input#Brand_Campaign_Events&&type='checkbox'").value(1)
			
			//println $("input#Brand_Campaign_Events").text()
			waitFor(100){$("#Brand_Messages")}
			$("#Brand_Messages").click()
			Thread.sleep(4000)
			
		// clicking on save button
			$("input[type='image']").click()
			
			Thread.sleep(3000)
			
			return true
	}
	
	
	
	

}
