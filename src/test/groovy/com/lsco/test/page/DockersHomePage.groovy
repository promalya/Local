package com.lsco.test.page
import geb.Page
import org.apache.commons.lang.RandomStringUtils
import com.lsco.test.PropertyProvider
class DockersHomePage extends Page {

	//static url = ""
	
	static at = {
		
       assert title.toUpperCase().contains("DOCKERS") 
		return true
		driver.navigate().refresh()
	}

	static content = { pageData { js.pageData } 
	filterdropdownSelect{ $('.centeredlist>ul>li:nth-child(3)>div>a',it)}
	
	loginEmail {$("#loginForm").find("input", id: "j_username")}
	loginPassWord {$("#loginForm").find("input", id: "j_password")}
	}
	
	def LoginAfterLocaleChange_Dockers()
	{
	  driver.navigate().refresh()
	  $("#global-myaccount-cta2").click()
	  driver.navigate().refresh()
	  Thread.sleep(3000)
	  
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
	def  ChangeLocale2_DK() {
		//driver.navigate().to("https://qa-500-web-000.dockers-site.com/GB/en_GB/login")
		driver.navigate().to(PropertyProvider.getInstance().basicURL+"/GB/en_GB/login")
	//	driver.navigate().to("https://preprod-001-web-000.dockers-site.com/GB/en_GB/login")
		Thread.sleep(2000)
		return true
	 }
	
	
}