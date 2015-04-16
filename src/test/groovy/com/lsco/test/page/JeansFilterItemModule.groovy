package com.lsco.test.page

import java.util.Collection
import java.util.List;
import java.util.Map;
//import java.util.Spliterator;
//import java.util.function.Consumer;

import org.openqa.selenium.WebElement;

import geb.Module;
import geb.Page;
import geb.navigator.Navigator;
import groovy.lang.Range;

class JeansFilterItemModule extends Module {

	static content = {
		filter { $("label") }
		detail { filter.find("input") }
	}


	/*public void forEach(Consumer arg0) {
		// TODO Auto-generated method stub
		
	}

	public Spliterator spliterator() {
		// TODO Auto-generated method stub
		return null;
	}	*/
}
