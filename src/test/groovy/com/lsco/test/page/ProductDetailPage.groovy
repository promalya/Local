package com.lsco.test.page

import geb.Page

import com.lsco.test.PropertyProvider
import org.openqa.selenium.WebDriver

class ProductDetailPage extends Page{


	String getPageUrl() {
		String url = browser.config.rawConfig.baseUrl + "p/" + PropertyProvider.getInstance().getGeneralSitePropertyValue("promotion.product.code")
		println url
		url
	}

	static content = { productForm {$("#pdp-buystack-form") }}

	static at = { productForm }
}