package com.lsco.test.page
import com.lsco.test.PropertyProvider
import com.lsco.test.page.login.LevisLoginPage
import com.lsco.test.page.model.ProductDataModelMap
import com.lsco.test.page.register.AccountRegistrationPage
import com.lsco.test.page.register.RegistrationDataModel
import geb.Page
import org.apache.commons.lang.RandomStringUtils
import org.apache.commons.lang.math.RandomUtils

class LevisHomePage extends Page {

	static url = ""
	
	static at = {
		//driver.navigate().refresh()
		def okBrand = PropertyProvider.getInstance().getLocalizedPropertyValue("brand")
		//def okCountry = PropertyProvider.getInstance().getLocalizedPropertyValue("country")
		assert title.toUpperCase().contains(okBrand)
		//assert $("#global-lang-cta").text().toUpperCase() == okCountry
		return true
	}

	static content = { pageData { js.pageData } 
		
	}


	def toMyAccountPage(){
		// added By Suprito  6th March 2015//
		Thread.sleep(4000)
		if($("#global-myaccount-signout").displayed){
		$("#global-myaccount-signout").click()
		driver.navigate().refresh();
		
		}
		waitFor(100){$("#global-myaccount-cta")}
		$("#global-myaccount-cta").click(LevisLoginPage)
	
		Thread.sleep(3000)
	}

	def toRegistrationPage(){
		$("#global-myaccount-cta").click(AccountRegistrationPage)
	}
	
	def toFirstRootCategoryPage() {
		$("body > div.header-fluid > header > header > ul > li:nth-child(1) > h2 > a").click()
	}

	def toWomenCategoryPage() {
		//waitFor(30){ $(".email-lightbox").@style == "display: none;" }
		driver.navigate().refresh()
		
		interact {
		//	moveToElement($("body > div.header-fluid > header > header > ul > li:nth-child(2) > h2 > a"))
			moveToElement($("a",text:"WOMEN").parent(),2,2)
		}
		$("#wJeansLink").click()
	}

	def toClothingTrousersCategoryPage() {
		driver.navigate().refresh()
		
		interact {
			moveToElement($("body > div.header-fluid > header > header > ul > li:nth-child(1) > h2 > a"))
		}
		$("#MenTrousersLink").click()
	}
	
	def toClothingSweatersCategoryPage() {
		driver.navigate().refresh()
		
		interact {
			moveToElement($("body > div.header-fluid > header > header > ul > li:nth-child(1) > h2 > a"))
		}
		$("#MenSweatersLink").click()
	}
	
	def dismissPopup(){
		//Added By Suprito
		Thread.sleep(3000)
		if ($("div.email-signup > div:nth-child(1) > span:nth-child(1)").isDisplayed()){
			$("div.email-signup > div:nth-child(1) > span:nth-child(1)").click()
		}
	}

	def searchTerm(term){
		$("#input-search").value(term)
		$("#search-bar > a").click()
	}

	def searchRandomTerm(int length){
		searchTerm("jn!t@#"+generateRamdomString(length))
	}

	private String generateRamdomString(int length) {
		RandomStringUtils.randomAlphanumeric(RandomUtils.nextInt(length) + 1)
	}

	def verifyPopulation(searchTerm){
		def searchTag = "search:"
		def searchTermTag = "term:"
		def searchResultTag = "result_count:"

		StringBuilder pageDataText = new StringBuilder(pageData.toString());

		def searchTagInitialIndex = pageDataText.indexOf(searchTag)

		//verify that searchTag is present
		assert searchTagInitialIndex != -1

		pageDataText.replace(0, pageDataText.length(),  pageDataText.substring(searchTagInitialIndex))
		def searchFinalIndex =  pageDataText.indexOf("]")
		pageDataText.replace(0, pageDataText.length(), pageDataText.substring(0, searchFinalIndex +1))
		def searchTermTagInitialIndex = pageDataText.indexOf(searchTermTag)
		def searchResultTagInitialIndex = pageDataText.indexOf(searchResultTag)

		//verify that termTag is present
		assert searchTermTagInitialIndex != -1
		//verify that resultTag is present
		assert searchResultTagInitialIndex != -1

		String searchTermTagValue = pageDataText.substring(searchTermTagInitialIndex + searchTermTag.size(), pageDataText.indexOf(","))
		String searchResultTagValue = pageDataText.substring(searchResultTagInitialIndex + searchResultTag.size(), pageDataText.indexOf("]"))

		assert searchTerm == searchTermTagValue
		assert searchResultTagValue.toInteger() > 0
		assert $("span.productCount").text() == searchResultTagValue
	}

	def toAllCollectionsPage(){
		$("a.cta.see-all").click()
		//waitFor(30){ $("#main-container > article:nth-child(1) > header > article > div > h1").text() == "JEANS"}
	}
	
	def createNewEmail(arg1){
		def newEmail = RandomStringUtils.randomAlphanumeric(20)
		RegistrationDataModel.getInstance().email = newEmail
		$("#inboxfield").value(newEmail)
		$("btn.btn.btn-success").click()
	}
	
	def checkIfSignoutIsRequired(){
		if ($("#global-myaccount-signout").isDisplayed()){
			$("#global-myaccount-signout").click()
		}
	}

	def emptyTheBag(){
		  def myBagQuantity = $("#cart-container > a > div > h3 > span")
		  int bagQuantity = myBagQuantity.text().trim().toInteger()
		  while(bagQuantity > 0){
			$("#cart-container > a > div").click()
			$(".actions > li:nth-child(1) > a:nth-child(1)").click()
			$(".logo").click()
			myBagQuantity = $("#cart-container > a > div > h3 > span")
			bagQuantity = myBagQuantity.text().trim().toInteger()
		}
		ProductDataModelMap.getInstance().getProductMap().clear()
	}

	def deleteCookies(){
		getBrowser().clearCookies()
	}
	
	def toMyAccount(){
		$("#global-myaccount-signout").click()
	}
	
	
	//added by Suprito------------------------
	
	def toAccountPageLatest(){
		driver.navigate().refresh()
		$("#global-myaccount-cta").click()
	}
	
	def searchProductForGuestUsr(){
		
		def skuItemName = PropertyProvider.getInstance().getLocalizedPropertyValue("itemSearch")
		waitFor{$("#input-search")}.value(skuItemName)
		$("#search-bar > a").click()
	}
	
	
	def clickOnTheSearchedItemForGuestUsr(){
		Thread.sleep(3000)
		$(".list-type-04>li>div:nth-child(1)>a>img").click()
	}
	//Added by dipannita
	def SearchProductIndeca()
	{
	driver.navigate().refresh()
	def skuItemName = PropertyProvider.getInstance().getLocalizedPropertyValue("searchinIndeca")
	waitFor{$("#input-search")}.value(skuItemName)
	//Thread.sleep(500)
	$("#search-bar > a").click()
	return true
	}
	
	
	//Added by dipannita
	 def HandleNewsletterPopUp()
	    {
		
	String Randomresult = RandomStringUtils.random(64, false, true);
	Randomresult = RandomStringUtils.random(6, 0, 10, true, true, "abcdefghij".toCharArray());
	
	def okValue1 = Randomresult.concat("@gmail.com")
	 $("#input-email-popup").value(okValue1)
	
	 Thread.sleep(2000)
	// $(".global-nav>ul:nth-child(2)>div:nth-of-type(2)>div>form#EmailSignupForm>label:nth-of-type(2)").click()
	 //$("input[name='ageCheck']").click()
	 driver.findElement(By.xpath(".//*[@id='EmailSignupForm']/label[1]")).click()
	  Thread.sleep(1000)
	  $("#link-email-popup").click()
	  }
	
		
	//Added by dipannita
	def NewsletterSubscribed()
	   {
	  $(".tooltip-wrapper>h6").text().toUpperCase() == "THANKS!"
	 //	 return true
	   }
	   
	  //Added by dipannita
	def VerifyPopUpLinks()
	   {
	 $(".tooltip-wrapper>h6").text().toUpperCase() == "SUBSCRIBE & SAVE"
	 
	 $(".privacy-terms-text>a:nth-child(1)").click()
	 assert $(".content.wysiwyg>h1").text().toUpperCase() == "TERMS & CONDITIONS"
	 $(".fancybox-item.fancybox-close").click()
	 
	 $(".privacy-terms-text>a:nth-child(2)").click()
	 assert $(".content.wysiwyg>h1").text().toUpperCase() == "PRIVACY POLICY"
	 $(".fancybox-item.fancybox-close").click()
	 
	 return true
	  }
	   
	   //Added by dipannita
	 def ClothingCategoryPage() {
		   driver.navigate().refresh()
		   $(".subnav-list.notouch-device>li>h2>a").click()
		   $("#shop-by-style>ul>li>a>h4").click()
       }
	   
	   //Added by dipannita
    def filterbyColor() {
		   Thread.sleep(4000)
		   $(".centeredlist>ul>li:nth-child(3)>div>a").click()
		   Thread.sleep(2000)
		   //def color = filterdropdownSelect(2)
		   $(".centeredlist>ul>li:nth-child(3)>div>ul>li:nth-child(3)").click()
	   }
	   //Added by dipannita
   def filterbyColor_LEVI() {
		   Thread.sleep(4000)
		   $(".centeredlist>ul>li:nth-child(7)>div>a").click()
		   Thread.sleep(1000)
		   //def color = filterdropdownSelect(2)
		   $(".centeredlist>ul>li:nth-child(7)>div>ul>li:nth-child(3)").click()
	   return true
	   }
   
   //Added by dipannita
   def clickOnTheFilteredItem(String){
	   
	   $(".product-images>a>img").click()
	   String Name= $(".title").text()
	   println Name
	   return true
	   
	   }
   def searchProduct()
   {
   driver.navigate().refresh()
   def skuItemName = PropertyProvider.getInstance().getLocalizedPropertyValue("itemSearch")
   waitFor{$("#input-search")}.value(skuItemName)
   
   $("#search-bar > a").click()
   return true
   }
   
   //Added by dipannita
   def clickOnTheSearchedItem(){
	   
	   $(".list-type-04>li>div:nth-child(1)>a>img").click()
	   return true
	   
	   }
   
   //Added by dipannita
   def LoginAfterLocaleChange()
   {
	 driver.navigate().refresh()
	 $("#global-myaccount-cta2").click()
	 Thread.sleep(1000)
	 driver.navigate().refresh()
	 $(".section-header.center-header").text().toUpperCase() == "MEIN KONTO"
	Thread.sleep(1000)
	$("#AddressLink").click()
	$(".shipping-address-list>div>.btn-dbbdr").click()
	//def okValue10 = PropertyProvider.getInstance().getLocalizedPropertyValue("billingfname")
	$("#firstName").value("Fname")
	
	//def okValue11 = PropertyProvider.getInstance().getLocalizedPropertyValue("billinglname")
	$("#lastName").value("Lname")
	
	//def okValue12 = PropertyProvider.getInstance().getLocalizedPropertyValue("address")
	$("#line1").value("ABCD Road")
			
	//def okValue13 = PropertyProvider.getInstance().getLocalizedPropertyValue("town")
	$("#townCity").value("Berlin")
	
	//def okValue14 = PropertyProvider.getInstance().getLocalizedPropertyValue("postalcode")
	$("#postcode").value("10117")
   
	
	String Randomresult = RandomStringUtils.random(64, false, true);
	Randomresult = RandomStringUtils.random(6, 0, 10, true, true, "1234567890".toCharArray());
	$("#phone").value(Randomresult)
	
	
	$(".default-address-text").click()
	$(".btn-dbbdr").click()
	//return true
	}

//Added by dipannita
   def  ChangeLocale2() {
	   //driver.getCurrentUrl().replace("DE/de_DE", "GB/en_GB")
	   driver.navigate().to(PropertyProvider.getInstance().basicURL+"/GB/en_GB/login")
	//   driver.navigate().to("https://qa-500-web-000.levi-site.com/GB/en_GB/login")
	   Thread.sleep(2000)
	   return true
	}
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
   
   //------------added by Suprito after 6th March-------------------
   
   def myAccountLinkabsentForRussia()
   {
	   boolean myAccountLinkDisplay =  $("#global-myaccount-cta").isDisplayed()
	   println myAccountLinkDisplay
   
	   assert myAccountLinkDisplay == false
	   
   return true
   }
   
   def searchInvalidProduct(){
	   
	   def skuItemName = PropertyProvider.getInstance().getLocalizedPropertyValue("invalidItem")
	   waitFor{$("#input-search")}.value(skuItemName)
	   $("#search-bar > a").click()
	   
	   Thread.sleep(5000)
   } 
   
	
}