package com.lsco.test.page.search

import com.lsco.test.PropertyProvider
import com.lsco.test.page.FirstProductPage
import geb.Page

/**
 * Created by edu on 18/11/14.
 */

class FailSearchResultPage extends Page {

    static content={
        failSearchPageTitleElem{$(".section-header")}
        productsList{$(".list-type-05 li")}
    }

    static at = {
        failSearchPageTitleElem.text().toLowerCase() == PropertyProvider.getInstance().getLocalizedPropertyValue("search.error.title").toLowerCase()
    }

    String getOtherItemsSectionName(){
        $(".prod-list > h2:nth-child(1)").text()
    }

    def checkOtherItemsSection(int quantity){
        assert getOtherItemsSectionName().toLowerCase()==PropertyProvider.getInstance().getLocalizedPropertyValue("search.other.Items.section.name").toLowerCase()
        assert productsList.size()==quantity
		return true
    }
	def toPDPPageOnClickingItemFromYouMightLikeSection()
	{
		$(".product-images>a>img").click(FirstProductPage)
	}

}
