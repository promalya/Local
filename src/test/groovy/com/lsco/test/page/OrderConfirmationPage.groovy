package com.lsco.test.page

import geb.Page

import com.lsco.test.PropertyProvider
import org.openqa.selenium.WebDriver
//added By Suprito after 2nd March 2015
import org.apache.commons.lang.RandomStringUtils
import org.apache.commons.lang.math.RandomUtils

class OrderConfirmationPage extends Page {

	static content = {
		orderMessage(wait:true) { $("#top > h1")}
		
		// Added by Suprito after 2nd March 2015
		registrationEmailIdOrderConFirmPage { $("#registerForm").find("input", id: "email")}
		registrationPasswordOrderConFirmPage { $("#registerForm").find("input", id: "password") }
		registrationConfirmPwdOrderConFirmPage { $("#registerForm").find("input", id: "password-confirm") }
	//-----------------------------------------------------------------------------
		
	}


	static at = {
		def okValue = PropertyProvider.getInstance().getLocalizedPropertyValue("order.success.message")
		assert orderMessage.text() == okValue
		
		//+++++++++++++++++added by Suprito
		
		return true
	}
	
	
	//--------------------------Suprito 3rd March 2015
	def clickOnTrackYourOrder(){
		
		Thread.sleep(4000)
		$("#left-col>p>a").click()
		Thread.sleep(4000)
		
		return true
			}
	
	
	def orderHistoryWithGiftWrap(){
		
		Thread.sleep(4000)
		def orderNo = $("div#order-confirmation-box>div>p").text()
		def trimmedOrderNo = orderNo.replaceAll("ORDER NUMBER:", "")
		println trimmedOrderNo
		Thread.sleep(4000)
		$("#left-col>p>a").click()
		Thread.sleep(4000)
		$("#OrdersLink").click()
		Thread.sleep(3000)
		$(".order-history>tbody>tr>td>p>a").click()
		Thread.sleep(2000)
		 def giftWrapTxtFrmScreen = $(".cost-summary>li:nth-child(3)").text()
		 println giftWrapTxtFrmScreen
		
		 def giftWrapText = PropertyProvider.getInstance().getLocalizedPropertyValue("giftWrapTxt")
		println giftWrapText
		assert giftWrapTxtFrmScreen == giftWrapText
		
		return true
			}
	
	//---------------added By Suprito after 2nd March 2015
	
	
	def fillingRegInfoOrderCnfirmationPage() {
		Thread.sleep(3000)
		String Randomresult1 = RandomStringUtils.random(64, false, true);
		Randomresult1 = RandomStringUtils.random(32, 0, 20, true, true, "qw32rfHIJk9iQ8Ud7h0X".toCharArray())
		def emailRandom = Randomresult1+"@gmail.com"
		println emailRandom
		registrationEmailIdOrderConFirmPage.value(Randomresult1+"@gmail.com")
		
		def pwdRegister2 = PropertyProvider.getInstance().getLocalizedPropertyValue("regPassword")
		registrationPasswordOrderConFirmPage.value(pwdRegister2)
		
		def confirmPwdRegister2 = PropertyProvider.getInstance().getLocalizedPropertyValue("regPassword")
		registrationConfirmPwdOrderConFirmPage.value(confirmPwdRegister2)
		
		Thread.sleep(2000)
		$("label[for='age-chkbox']").click()
		Thread.sleep(2000)
		$("#registerForm .btn-dbbdr").click()
		Thread.sleep(5000)
		
		return true
		}
	
	def verifyOrderFornewlyRegisteredUser()
	{
		Thread.sleep(3000)
		// clicking on Orders Link in Myaccount after registration from order confirm page
		$("#OrdersLink").click()
		Thread.sleep(2000)
		// verifying whether the order is getting displayed for the newly registered user
		boolean bol2 = $(".order-history>tbody>tr>td>p>a").isDisplayed()
		
		println bol2
		
		assert bol2 == true
		
		return true
	}
	
	
	def verifyErrorMessageForAlreadyRegsteredUsrFlow() {
		Thread.sleep(3000)
		//giving an already existing username for registration
		def regUsrName = PropertyProvider.getInstance().getLocalizedPropertyValue("emailId")
		registrationEmailIdOrderConFirmPage.value(regUsrName)
		
		def pwdRegisterLatest = PropertyProvider.getInstance().getLocalizedPropertyValue("regPassword")
		registrationPasswordOrderConFirmPage.value(pwdRegisterLatest)
		
		def confirmPwdRegisterLatest = PropertyProvider.getInstance().getLocalizedPropertyValue("regPassword")
		registrationConfirmPwdOrderConFirmPage.value(confirmPwdRegisterLatest)
		
		Thread.sleep(2000)
		$("label[for='age-chkbox']").click()
		Thread.sleep(2000)
		$("#registerForm .btn-dbbdr").click()
		Thread.sleep(5000)
		//verifying the error message when we give existing user ids for new registration
		boolean bol3 = $(".generic-error").isDisplayed()
		
		println bol3
		
		assert bol3 == true
		
		return true
		}	
	
}
