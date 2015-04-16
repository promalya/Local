package com.lsco.test.page.navigation

import geb.Page

class FirstRootCategoryPage extends Page{
	
	static content = {
		shopByStyleSection (wait: true) {$("#shop-by-style")}
	}

	static at = {shopByStyleSection }
	
	def toFirstCategoryPage() {
		$("#shop-by-style > ul > li:nth-child(1) > a").click()
	}
	
}
