package com.lsco.test.page.login
import com.lsco.test.PropertyProvider
import com.lsco.test.page.model.UserDataModelMap
import com.lsco.test.page.register.RegistrationDataModel
import geb.Page
import org.apache.commons.lang.RandomStringUtils
import org.apache.commons.lang.math.RandomUtils
import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor

class LevisMyAccountPage extends Page{
	
	static url = "my-account/update-profile"
	
	static at = {
		String okValue = PropertyProvider.getInstance().getLocalizedPropertyValue("my.account")
		//@@@@@ Commented until is resolved
		//assert $("h1").text().toUpperCase() == okValue
		return true
	}
	
	//+++++++++++++++Suprito 23 rd Feb 2015+++++++++++++++++++++++++++++++++++++++
	static content = {
		accountEmailTxtField { $("#updateProfileForm").find("input", id: "email")}
		accountFirstNameTxtField { $("#updateProfileForm").find("input", id: "firstName")}
		accountLastNameTxtField { $("#updateProfileForm").find("input", id: "lastName")}
	}
	
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	
	def verifyEmailInHeader(fullName){
		def headerText = $("#global-myaccount-cta2").text()
		assert headerText == fullName
	}
	
	def verifyEmailInHeader(){
		verifyEmailInHeader(RegistrationDataModel.getInstance().email.toUpperCase())
	}

	def getFirstNameProfileElem(){
		$(".form-container > ul:nth-child(1) > li:nth-child(1) > div:nth-child(2) > input:nth-child(1)")
	}

	def getSurnameProfileElem(){
		$(".form-container > ul:nth-child(1) > li:nth-child(2) > div:nth-child(2) > input:nth-child(1)")
	}

	def getEmailProfileElem() {
		$("#email")
	}

	def editProfileRandomUser(){
		if (isRandomUserDataUpdated()){
			def newEmail=UserDataModelMap.getInstance().getUserMap().get("UPDATED_USER_DATA").getEmail().toLowerCase()
			def newName=generateRamdomAlphabeticString(13)
			def newLastName=generateRamdomAlphabeticString(13)
			UserDataModelMap.getInstance().getUserMap().get("NEW_USER_DATA").setEmail(newEmail)
			UserDataModelMap.getInstance().getUserMap().get("NEW_USER_DATA").setName(newName)
			UserDataModelMap.getInstance().getUserMap().get("NEW_USER_DATA").setLastName(newLastName)
			getFirstNameProfileElem().value(newName)
			getSurnameProfileElem().value(newLastName)
			getEmailProfileElem().value(newEmail)
		}
	}

	private String generateRamdomAlphabeticString(int length) {
		RandomStringUtils.randomAlphabetic(RandomUtils.nextInt(length) + 1)
	}

	def UpdateData(){
		Thread.sleep(1000)
		$(".btn-dbbdr").click()
		Thread.sleep(2000)
		return true
	}

	boolean isRandomUserDataUpdated() {
		UserDataModelMap.getInstance().getUserMap().get("UPDATED_USER_DATA")!=null
	}

	def logOut(){
		Thread.sleep(1000)
		$("#global-myaccount-signout").click()
	}

	def verifyDataUpdateMesage(){
		
		assert $(".js-success").text().toUpperCase()==PropertyProvider.getInstance().getLocalizedPropertyValue("my.account.update.message")
		return true
	}

	def verifyNewRandomUserData(){
		if ($("div.email-signup > div:nth-child(1) > span:nth-child(1)").isDisplayed()){
			$("div.email-signup > div:nth-child(1) > span:nth-child(1)").click()
		}
		assert getFirstNameProfileElem().value()==UserDataModelMap.getInstance().getUserMap().get("NEW_USER_DATA").getName()
		assert getSurnameProfileElem().value()==UserDataModelMap.getInstance().getUserMap().get("NEW_USER_DATA").getLastName()
		assert getEmailProfileElem().value()==UserDataModelMap.getInstance().getUserMap().get("NEW_USER_DATA").getEmail()
	}
	
	def toLastPlacedOrder(){
		$("#OrdersLink").click()
		$("table.order-history > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(1) > p:nth-child(1) > a:nth-child(1)").click()
	}
	
	def giftWrapCheck(){
		assert $(".list-type-04 > li:nth-child(2) > a:nth-child(1) > img:nth-child(1)").@title.toString().trim().toUpperCase().contains("GIFT WRAP") 
	}
	
	//++++++++++++ added by Suprito 19th Feb 2015 +++++++++++++++++++++++++++++++++++
	
	def verifyEmailNameInHeader(){
		
		def loggedInemailId = PropertyProvider.getInstance().getLocalizedPropertyValue("emailId")
		println accountEmailTxtField.@value
		assert accountEmailTxtField.@value == loggedInemailId
	}
		
	def searchProduct(){
		def skuItemName = PropertyProvider.getInstance().getLocalizedPropertyValue("itemSearch")
		waitFor{$("#input-search")}.value(skuItemName)
		$("#search-bar > a").click()
	}
		
	def clickOnTheSearchedItem(){
		Thread.sleep(3000)
		$(".list-type-04>li>div:nth-child(1)>a>img").click()
	}
	
	def clickNotTodayLinkMyAccountPage() {
		driver.navigate().refresh()
		Thread.sleep(4000)
		if ($("#dismiss-btn").isDisplayed())
		{
	    	$("#dismiss-btn").click()
		}
	  }	
  def verifyInHeaderSuccessfulRegistration(){
		 $("#dismiss-btn").click()
		// $(".js-success.generic-success.success").text()=="SUCCESS"
		 def okValue1 = PropertyProvider.getInstance().getLocalizedPropertyValue("SuccesfulRegistration")
		 $(".js-success.generic-success.success").value(okValue1)
		 return true
	}
  
  //Added by Dipannita
   def openPasswordTab(){
	  $("#dismiss-btn").click()
	  Thread.sleep(1000)
	  $("#PasswordLink").click()
	  $("h2").text().toUpperCase() == "PASSWORD"
	  //return true
  }
  //Added by Dipannita
  def editPassword(){
	  
	  def okValue1 = PropertyProvider.getInstance().getLocalizedPropertyValue("password")
	  $("#currentPassword").value(okValue1)
	  
	  def okValue2 = PropertyProvider.getInstance().getLocalizedPropertyValue("password")
	  $("#newPassword").value(okValue2)
	  
	  def okValue3 = PropertyProvider.getInstance().getLocalizedPropertyValue("password")
	  $("#checkNewPassword").value(okValue3)
	  return true
	   }
  
  def UpdateButton(){
	  $(".button-black").click()
  }
  
  def LinkToFB(){
	  Thread.sleep(500)
	  $("#dismiss-btn").click()
	  Thread.sleep(3000)
	  $(".fb").click()
	  Thread.sleep(2000)
	  return true
	  }
  
	 def validateFBloggedIn(){
	  Thread.sleep(2000)
	  $("#global-myaccount-cta2").text().toUpperCase() == "LEVI LNAME"
	  return true
	  }
	 
  def VerifyLEVISOrdersUsingFBlogIn(){
		 $("#OrdersLink").click()
		 $("h2").text().toUpperCase() == "ORDERS"
		 return true
	  }
  
  //Added by Dipannita
  def openOrdersTab(){
	  $("#dismiss-btn").click()
	  
	  $("#OrdersLink").click()
		  
	  $("h2").text().toUpperCase() == "ORDERS"
	  }
  //Added by Dipannita
  def VerifyOrderHistory(){
	  Thread.sleep(1000)
	  int minimum =1
	  int maximum =3
	  int i = minimum + (int)(Math.random()*maximum)
	  waitFor(20){$("p",text:"Submitted",1)}
	  $("p",text:"Submitted",i).parent().previous().find("a").click()
	 // Thread.sleep(2000)
	 // $(".order-history>tbody>tr:nth-child("+i+")>td:nth-child(1)>p>a").click()
	  // Thread.sleep(2000)
	   waitFor(20){$('.myaccount-main')}
	  assert $(".myaccount-top>h2").text().toUpperCase() == "ORDER DETAILS"
	  return true
	  }
  //Added by Dipannita
  def String Result()
  {
	 String Randomresult = RandomStringUtils.random(64, false, true);
	 Randomresult = RandomStringUtils.random(32, 0, 20, true, true, "abcdefghijklmnopqrst".toCharArray());
	 return Randomresult
  
  }
  //Added by Dipannita
  def openAdrressTab(){
	  Thread.sleep(1000)
	  $("#dismiss-btn").click()
	  Thread.sleep(2000)
	  $("#AddressLink").click()
	  Thread.sleep(1000)
	  $(".billing-address-list>div>h3").text().toUpperCase() == PropertyProvider.getInstance().getLocalizedPropertyValue("addressHeader")
	  return true
  }
  //Added by Dipannita
  def UpdateBillingAdrressSection(){
	  $(".billing-address-list>div>.btn-dbbdr").click()
	  
	  $("section.myaccount-top>h2").text().toUpperCase() == PropertyProvider.getInstance().getLocalizedPropertyValue("BillingaddressHeader")
	  return true
	  }
  //Added by Dipannita
  def UpdateBillingData()
  {
	  def okValue10 = PropertyProvider.getInstance().getLocalizedPropertyValue("billingfname")
	  $("#firstName").value(okValue10)
	  
	  def okValue11 = PropertyProvider.getInstance().getLocalizedPropertyValue("billinglname")
	  $("#lastName").value(okValue11)
	  
	  def okValue12 = PropertyProvider.getInstance().getLocalizedPropertyValue("address")
	  $("#line1").value(okValue12)
			  
	  def okValue13 = PropertyProvider.getInstance().getLocalizedPropertyValue("town")
	  $("#townCity").value(okValue13)
	  
	  def okValue14 = PropertyProvider.getInstance().getLocalizedPropertyValue("postalcode")
	  $("#postcode").value(okValue14)
	 
	  
	  String Randomresult = RandomStringUtils.random(64, false, true);
	  Randomresult = RandomStringUtils.random(6, 0, 10, true, true, "1234567890".toCharArray());
	  $("#phone").value(Randomresult)
	  
	  
	  $(".default-address-text").click()
	  $(".btn-dbbdr").click()
				  
  }
  def verifyUpdatedBilling()
  {
  //$(".box.default>p").text().toUpperCase()== "Default Address"
  $(".billing-address-list>div>div>p").text().toUpperCase() == PropertyProvider.getInstance().getLocalizedPropertyValue("defaultaddress")
  return true
  }
  
  def UpdateShippingAdrressSection(){
	  $(".shipping-address-list>div>.btn-dbbdr").click()
	  
	  $("section.myaccount-top>h2").text().toUpperCase() == PropertyProvider.getInstance().getLocalizedPropertyValue("ShippingaddressHeader")
	  return true
	  }
  
  def UpdateShippingData()
  {
	  def okValue10 = PropertyProvider.getInstance().getLocalizedPropertyValue("billingfname")
	  $("#firstName").value(okValue10)
	  
	  def okValue11 = PropertyProvider.getInstance().getLocalizedPropertyValue("billinglname")
	  $("#lastName").value(okValue11)
	  
	  def okValue12 = PropertyProvider.getInstance().getLocalizedPropertyValue("address")
	  $("#line1").value(okValue12)
			  
	  def okValue13 = PropertyProvider.getInstance().getLocalizedPropertyValue("town")
	  $("#townCity").value(okValue13)
	  
	  def okValue14 = PropertyProvider.getInstance().getLocalizedPropertyValue("postalcode")
	  $("#postcode").value(okValue14)
	 
	  
	  String Randomresult = RandomStringUtils.random(64, false, true);
	  Randomresult = RandomStringUtils.random(6, 0, 10, true, true, "1234567890".toCharArray());
	  $("#phone").value(Randomresult)
	  
	  
	  $(".default-address-text").click()
	  $(".btn-dbbdr").click()
				  
  }
  def verifyUpdatedShipping()
  {
  //$(".box.default>p").text().toUpperCase()== "Default Address"
  $(".box.default>p").text().toUpperCase() == PropertyProvider.getInstance().getLocalizedPropertyValue("defaultaddress")
  return true
  }
  
   
  def  ChangeLocale1() {
	  //driver.navigate().to("https://qa-500-web-000.levi-site.com/DE/de_DE")
	  driver.navigate().to(PropertyProvider.getInstance().basicURL+"/DE/de_DE")
	  Thread.sleep(2000)
	  return true
   }
  def  ChangeLocale1_DK() {
	  //driver.navigate().to("https://qa-500-web-000.dockers-site.com/DE/de_DE")
	  driver.navigate().to(PropertyProvider.getInstance().basicURL+"/DE/de_DE")
	  Thread.sleep(2000)
	  return true
   }
  
  def  ChangeLocale2() {
	  //driver.navigate().to("https://qa-500-web-000.levi-site.com/GB/en_GB/my-account")
	  driver.navigate().to(PropertyProvider.getInstance().basicURL+"/GB/en_GB/my-account")
	  Thread.sleep(2000)
	  return true
   }
  
  def clickOnMyAccount()
	  {
	 $(".list-type-04>li>div:nth-child(1)>a>img").click()
	  }
  def VerifyEmailInHeader(){
      def headerText = $("#global-myaccount-cta2").text()
	  assert headerText == PropertyProvider.getInstance().getLocalizedPropertyValue("headername")
	  return true
	          }
  
  
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
  
  
  //----------suprito-- 6th March-2015----------------
  
  def shopAllCollection() {
	  //waitFor(30){ $(".email-lightbox").@style == "display: none;" }
	  //driver.navigate().refresh()
	  Thread.sleep(18000)
	  //hovering over clothing tab
	  interact {
		  moveToElement($("body>div.header-fluid>header >header >ul >li:nth-child(1)>h2 >a"))
	  }
	  Thread.sleep(7000)
	  // selecting shop all option
	  $("#MenShopAllLink").click()
	  Thread.sleep(7000)
	  
	  //verifying whether the control goes to shop all page
	  assert $(".content.tile-02>h1").text().toUpperCase() == "SHOP ALL"

	  // selecting product A-Z option
	  $(".dk_toggle").click()
	  Thread.sleep(7000)
	  
	  driver.findElement(By.xpath(".//*[@id='dk_container_sort-select']/div/ul/li[5]/a")).click()
	  
	  Thread.sleep(8000)
	  
	  // scrolling functionality is written
	  ((JavascriptExecutor) driver).executeScript("scroll(0,1500);")
	  Thread.sleep(10000)
	  ((JavascriptExecutor) driver).executeScript("scroll(1500,3000);")
	  
	  Thread.sleep(8000)
	  ((JavascriptExecutor) driver).executeScript("scroll(3000,4500);")
	  Thread.sleep(8000)
	  
	  // printing all the additional products.Please verify the console to get all products.
	  def len = $("#container_results").text()
	  println len
	  Thread.sleep(8000)
  
	  
	  return true
  
  }
  
  
  def searchProductWithMultipleSwatches(){
	  
	  def skuItemName = PropertyProvider.getInstance().getLocalizedPropertyValue("productWithMultipleColour")
	  waitFor{$("#input-search")}.value(skuItemName)
	  $("#search-bar > a").click()
  }
  
  
  
  
	
}