package com.lsco.test.page

import java.util.Collection
import java.util.List;
import java.util.Map;
/*import java.util.Spliterator;
import java.util.function.Consumer;*/

import org.openqa.selenium.WebElement;

import geb.Module;
import geb.Page;
import geb.navigator.Navigator;
import groovy.lang.Range;
import org.openqa.selenium.WebDriver

class ProductModule extends Module {

	static content = {
		waist { $("a.size-swatch") }
		length { $("a.size-swatch") }
		size { $("a.size-swatch") }
	}


	/*public void forEach(Consumer arg0) {
		// TODO Auto-generated method stub
		
	}

	public Spliterator spliterator() {
		// TODO Auto-generated method stub
		return null;
	}	*/
}
