package com.lsco.test.page.login

import geb.Page
import com.lsco.test.PropertyProvider

class FacebookLoginPage extends Page {
	
	static at = { 
		assert $('div>.uiHeaderTitle').text() == "Facebook Login"
		//$("#content > div > div > div.uiHeader.uiHeaderBottomBorder.mhl.mts.uiHeaderPage.interstitialHeader > div > div:nth-child(2) > h2").text() == "Facebook Login"
		return true
	  }
	
	static content = {
		FBusername  { $("#email") }
		FBPassword  { $("#pass") }
		FBHomeHeaderName { $('._2dpb') }
		}
	
	def fillFacebookLogin(email, password){
		$("#email").value(email)
		$("#pass").value(password)
		$("#u_0_1").click()
	}
	
	def FillFacebookLogin(){
		def okValue1=  PropertyProvider.getInstance().getLocalizedPropertyValue("fbemail")
		FBusername.value(okValue1)
		
		def okValue2=  PropertyProvider.getInstance().getLocalizedPropertyValue("fbpw")
		FBPassword.value(okValue2)
		
		$("#u_0_1").click()
		Thread.sleep(1000)
		return true
	}
	
	def RelaunchMyAccount_LEVI(){
		driver.navigate().to("https://qa-500.levi.com/GB/en_GB/login")
		return true
			}
	
	def RelaunchMyAccount_Dockers(){
		driver.navigate().to("https://qa-500.dockers.com/GB/en_GB/login")
		return true
			}

}
