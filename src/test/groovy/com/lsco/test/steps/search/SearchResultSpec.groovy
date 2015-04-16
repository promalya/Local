package com.lsco.test.steps.search
import com.lsco.test.DEDockersSmoke
import com.lsco.test.*
import com.lsco.test.DELevisSmoke
import com.lsco.test.GBDockersSmoke
import com.lsco.test.GBLevisSmoke
import com.lsco.test.page.CartPage
import com.lsco.test.page.FirstProductPage
import com.lsco.test.page.LevisHomePage
import com.lsco.test.page.search.SearchResultPage
import geb.spock.GebReportingSpec
//import com.lsco.test.SmokeLeviGB
//Levi-GB [15751,15737,15730,15781,15847,15782,15802,15805,15733]
//Dockers-GB [15790,15793,15795]
//Dockers-DE [15798]
//Levi-DE [15784]
import spock.lang.IgnoreRest
class SearchResultSpec extends GebReportingSpec{
	//SPRING-15751-Levi [GB]- Add to the bag - Verify adding to the bag from PDP
	//SPRING-15737-Levi [GB]- Verify that the Search Result page display products, when the user placed a valid search.
	//SPRING-15730-Levi [GB]- Verify that the user is redirected to the Search Results page when placing a valid search on the global navigation search bar.
	//SPRING-15781-Levi [GB]- Bag editions - Verify product removal from the shopping bag.
	//SPRING-15793-Dockers [GB]- Bag editions - Verify product removal from the shopping bag.
	@GBLevisSmoke
	
	def "Verify Search Functionality"()
	{
		when: "Entering #Item to be Searched"
		to LevisHomePage
		at LevisHomePage
		searchTerm(Item)

		then: "Verifing Searched Item #Item"
		at SearchResultPage
		verifySearchedItem(Item)
		clickSearchedItem()

		then: "adding Item #Item to bag"
		at FirstProductPage
		addProductToBag("1")

		then: "Removing Item #Item from bag"
		to CartPage
		at CartPage
		removeItem()

		where:
		Item<<["306050044"] //Levi[GB]
		//Item<<["447150300"] //Dockers[GB]
	}
	@GBDockersSmoke
	def "Verify Search Functionality_Dockers_GB"()
	{
		when: "Entering #Item to be Searched"
		to LevisHomePage
		at LevisHomePage
		searchTerm(Item)

		then: "Verifing Searched Item #Item"
		at SearchResultPage
		verifySearchedItem(Item)
		clickSearchedItem()

		then: "adding Item #Item to bag"
		at FirstProductPage
		addProductToBag("1")

		then: "Removing Item #Item from bag"
		to CartPage
		at CartPage
		removeItem()

		where:
		Item<<["447150300"] //Dockers[GB]
	}
	//Levi-GB [SPRING-15847(Product Edition)]
	//Dockers-GB[SPRING-15790(Product Edition)]
	//Dockers-DE[SPRING-15798(Product Edition)]
	//Levi-DE [SPRING-15784(Product Edition)]
	@GBLevisSmoke
	
	def "Verify Product Edition from Shopping Bag"()
	{
		//given: "opened the dockers login url "

		when: "Entering #Item to be Searched"
		to LevisHomePage
		at LevisHomePage
		searchTerm(Item)

		then: "Verifing Searched Item #Item"
		//to SearchResultPage
		at SearchResultPage
		verifySearchedItem(Item)
		clickSearchedItem()

		then: "adding Item #Item to bag"
		//to FirstProductPage
		at FirstProductPage
		addProductToBag("1")

		then: "Update Item Quantity in shopping cart"
		to CartPage
		at CartPage
		updateQuantity()

		where:
		Item<<["306050044"] //Levi[GB]

	}

	@DEDockersSmoke
	def "Verify Product Edition from Shopping Bag_Dockers_DE"()
	{
		//given: "opened the dockers login url "

		when: "Entering #Item to be Searched"
		to LevisHomePage
		at LevisHomePage
		searchTerm(Item)

		then: "Verifing Searched Item #Item"
		//to SearchResultPage
		at SearchResultPage
		verifySearchedItem(Item)
		clickSearchedItem()

		then: "adding Item #Item to bag"
		//to FirstProductPage
		at FirstProductPage
		addProductToBag("1")

		then: "Update Item Quantity in shopping cart"
		to CartPage
		at CartPage
		updateQuantity()

		where:
		Item<<["474560008"] //Dockers[DE]

	}

	@DELevisSmoke
	def "Verify Product Edition from Shopping Bag_Levi_DE"()
	{
		//given: "opened the dockers login url "

		when: "Entering #Item to be Searched"
		to LevisHomePage
		at LevisHomePage
		searchTerm(Item)

		then: "Verifing Searched Item #Item"
		//to SearchResultPage
		at SearchResultPage
		verifySearchedItem(Item)
		clickSearchedItem()

		then: "adding Item #Item to bag"
		//to FirstProductPage
		at FirstProductPage
		addProductToBag("1")

		then: "Update Item Quantity in shopping cart"
		to CartPage
		at CartPage
		updateQuantity()

		where:
		Item<<["045111098"] //Levi[DE]

	}

	@GBDockersSmoke

	def "Verify Product Edition from Shopping Bag_Dockers_GB"()
	{
		//given: "opened the dockers login url "

		when: "Entering #Item to be Searched"
		to LevisHomePage
		at LevisHomePage
		searchTerm(Item)

		then: "Verifing Searched Item #Item"
		//to SearchResultPage
		at SearchResultPage
		verifySearchedItem(Item)
		clickSearchedItem()

		then: "adding Item #Item to bag"
		//to FirstProductPage
		at FirstProductPage
		addProductToBag("1")

		then: "Update Item Quantity in shopping cart"
		to CartPage
		at CartPage
		updateQuantity()

		where:
		Item<<["447150300"] //Dockers[GB]

	}

	//Levi-GB [SPRING-15782(Product Edition using continue shopping link)]
	//Dockers-GB[SPRING-15795(Product Edition using continue shopping link)]
	@GBLevisSmoke
	
	def "Verify Product Edition from Shopping Bag using continue shopping link"()
	{
		//given: "opened the dockers login url "
		when: "Entering #Item1 to be Searched"
		to LevisHomePage
		at LevisHomePage
		searchTerm(Item1)

		then: "Verifing Searched Item #Item1"
		//to SearchResultPage
		at SearchResultPage
		verifySearchedItem(Item1)
		clickSearchedItem()

		then: "adding Item #Item1 to bag"
		//to FirstProductPage
		at FirstProductPage
		addProductToBag("1")

		then: "Continue Shopping from shopping cart"
		to CartPage
		at CartPage
		continueShopping()

		then: "Entering #Item2 to be Searched"
		at LevisHomePage
		searchTerm(Item2)

		then: "Verifing Searched Item #Item2"
		//to SearchResultPage
		at SearchResultPage
		verifySearchedItem(Item2)
		clickSearchedItem()

		then: "adding Item #Item2 to bag"
		//to FirstProductPage
		at FirstProductPage
		addProductToBag("1")

		then: "Continue Shopping from shopping cart"
		to CartPage
		at CartPage
		updateQuantity()

		where:
		Item1<<["306050044"] //Levi[GB]
		Item2<<["045111098"] //Levi[GB]

	}
	//@IgnoreRest
	@GBDockersSmoke
	def "Verify Product Edition from Shopping Bag using continue shopping link_Dockers_GB"()
	{
		//given: "opened the dockers login url "
		when: "Entering #Item1 to be Searched"
		to LevisHomePage
		at LevisHomePage
		searchTerm(Item1)

		then: "Verifing Searched Item #Item1"
		//to SearchResultPage
		at SearchResultPage
		verifySearchedItem(Item1)
		clickSearchedItem()

		then: "adding Item #Item1 to bag"
		//to FirstProductPage
		at FirstProductPage
		addProductToBag("1")

		then: "Continue Shopping from shopping cart"
		to CartPage
		at CartPage
		continueShopping()

		then: "Entering #Item2 to be Searched"
		at LevisHomePage
		searchTerm(Item2)

		then: "Verifing Searched Item #Item2"
		//to SearchResultPage
		at SearchResultPage
		verifySearchedItem(Item2)
		clickSearchedItem()

		then: "adding Item #Item2 to bag"
		//to FirstProductPage
		at FirstProductPage
		addProductToBag("1")

		then: "Continue Shopping from shopping cart"
		to CartPage
		at CartPage
		updateQuantity()

		where:
		Item1<<["474560008"] //Dockers[GB]
		Item2<<["447150300"] //Dockers[GB]

	}
//	//Incomplete: zoom functionality not working
////	def "Verify adding to the bag from Zoom view_15776"()
////		{
////			//given: "opened the dockers login url "
////
////			when: "Entering #Item to be Searched"
////			to LevisHomePage
////			at LevisHomePage
////			searchTerm(Item)
////
////			then: "Verifing Searched Item #Item"
////			//to SearchResultPage
////			at SearchResultPage
////			verifySearchedItem(Item)
////			clickSearchedItem()
////
////			then: "adding Item #Item to bag"
////			//to FirstProductPage
////			at FirstProductPage
////			clickImageForZoomView()
////			addProductToBag("1")
////
////			then: "Removing Item #Item from bag"
////			to CartPage
////			at CartPage
////			removeItem()
////
////			where:
////			Item<<["045111098"]
////			//Item<<["005040221"] -Levi[GB]
////			//Item<<["469410001"] -Dockers[GB]
////
////		}
//
	//SPRING-15802- Levi[GB] Verify that the user cannot add more than 3 products of the same SKU to the bag
	@GBLevisSmoke
	
	def "Verify that the user cannot add more than 3 products of the same SKU to the bag"()
	{
			when: "Entering #Item1 to be Searched"
			to LevisHomePage
			at LevisHomePage
			searchTerm(Item1)

			then: "Verifing Searched Item #Item1"
			//to SearchResultPage
			at SearchResultPage
			verifySearchedItem(Item1)
			clickSearchedItem()

			then: "adding Item #Item1 to bag"
			at FirstProductPage
			addProductToBag("3")

			addProductToBag("1")
			CheckErrorsInBagItems("bag.items.error.exceed.sku.max.quantity")
//
			where:
			Item1<<["306050030"] //Levi[GB]
//
			}

	//SPRING-15805- Levi [GB]- Verify that the user cannot add more than 6 products of the same PC9 to the bag.
	@GBLevisSmoke
	//@IgnoreRest
	def "Verify that the user cannot add more than 6 products of the same PC9 to the bag_15805"()
	{
			when: "Entering #Item1 to be Searched"
			to LevisHomePage
			at LevisHomePage
			searchTerm(Item1)

			then: "Verifing Searched Item #Item1"
			at SearchResultPage
			verifySearchedItem(Item1)
			clickSearchedItem()

			then: "adding Item #Item1 to bag"
			at FirstProductPage
			addProductToBag("3")
			selectDifferentMeasures()
			addProductToBagInPDPSection()
			selectDifferentMeasures()
			addProductToBagInPDPSection()

			CheckErrorsInBagItems("bag.items.error.exceed.pc9.max.quantity")

			where:
			Item1<<["306050030"] //Levi[GB]

		}
		//SPRING-15733 - Levi [GB]- Swatch selection - Verify swatch selection when there are out of stock variants.
	@GBLevisSmoke
	
	def "Verify swatch selection when there are out of stock variants_15733"()
		{
				when: "Entering #Item1 to be Searched"
				to LevisHomePage
				at LevisHomePage
				searchTerm(Item1)

				then: "Verifing Searched Item #Item1"
				at SearchResultPage
				verifySearchedItem(Item1)
				clickSearchedItem()

				then: "adding Item #Item1 to bag"
				at FirstProductPage
				verifyHoveringOverSwatchesOutOfStockVariants()

				where:
				Item1<<["045111098"] //Levi[GB] -Product should have multiple color combinations


		}
}
