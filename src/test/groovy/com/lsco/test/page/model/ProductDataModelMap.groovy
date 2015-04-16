package com.lsco.test.page.model;

import java.util.ArrayList;

public class ProductDataModelMap{


	private static final ProductDataModelMap INSTANCE=new ProductDataModelMap()

	private Map<String,ProductDataModel> productMap

	static ProductDataModelMap getInstance(){
		return INSTANCE
	}

	private ProductDataModelMap() {
		productMap=new HashMap<String,ProductDataModel>()
	}

	def public Map<String,ProductDataModel> getProductMap() {
		return productMap;
	}
}
