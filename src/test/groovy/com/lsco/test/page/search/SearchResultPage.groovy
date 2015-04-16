package com.lsco.test.page.search

import geb.Page

import com.lsco.test.PropertyProvider
import org.apache.commons.lang.RandomStringUtils
import org.apache.commons.lang.math.RandomUtils
import com.lsco.test.page.FirstProductPage

class SearchResultPage extends Page {
	static url = ""
	
	static at = {
		def okValue = PropertyProvider.getInstance().getLocalizedPropertyValue("search.title")		
		$(".section-header.center-header").text().toUpperCase() == okValue
		
	}
	def verifySearchedItem(item)
	{
		$(".search-results-header>p",text: contains(item))
	}
	def clickSearchedItem()
	{
		$(".stage>img").click(FirstProductPage)
	}
	
	//Added By Dipannita
	def Results_Indeca(){
		driver.getCurrentUrl().contains("Ntt=trousers&_requestConfirmationToken=")
		return true
		}

}