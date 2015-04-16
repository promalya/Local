package com.lsco.test

import geb.*

class PropertyProvider extends Page{

	private static final INSTANCE = new PropertyProvider()

	Properties props
	String site
	String country
	String locale
	String testurl
	String basicURL
	static getInstance(){
		return INSTANCE
	}

	private PropertyProvider() {
		testurl=System.getProperty("testurl")
		if(testurl==null)
		testurl="qa-500"
		props = new Properties()
		new File("resources/"+ testurl+ "tests.properties").withInputStream { stream ->
			props.load(stream)
		}
	}
	
	String getLocalizedPropertyValue(String property){
		String baseProperty = site + "." + country + "." + locale + "."
		String propertyFullName = baseProperty + property
		props[propertyFullName]
	}
	
	
	String getGeneralSitePropertyValue(String property){
		String propertyFullName = site + "." + property
		props[propertyFullName]
	}
	
	String getGeneralPropertyValue(String property){
		String propertyFullName = property
		props[propertyFullName]
	}

}