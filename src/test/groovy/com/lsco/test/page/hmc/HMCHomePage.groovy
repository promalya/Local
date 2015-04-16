package com.lsco.test.page.hmc

import com.lsco.test.PropertyProvider
import com.lsco.test.page.model.UserDataModel
import com.lsco.test.page.model.UserDataModelMap
import geb.Page


public class HMCHomePage extends Page {

    static at = {
        assert $(".page-header-left").text().trim() == "Explorer: levi.team@[n/a]/master"
    }

    String getPageUrl() {
        def url = browser.config.rawConfig.basicUrl + "/hmc/hybris"
        url
    }

    def deleteUser(id) {
        $("#Tree\\/GenericExplorerMenuTreeNode\\[user\\]_label").click()
        $("#Tree\\/GenericLeafNode\\[Customer\\]_label").click()
        $("#Content\\/StringEditor\\[in\\ Content\\/GenericCondition\\[Customer\\.uid\\]\\]_input").value(id)
        $(".xp-button > a:nth-child(1)").click()
        interact {
            doubleClick($(".button-on-white > a:nth-child(1)"))
        }
        $("#Content\\/OrganizerItemChip\\\$2\\[organizer\\.editor\\.delete\\.title\\]\\[1\\]_label").click()
    }

    def deleteRandomUserInHybris() {
        deleteUser(browser.config.rawConfig.site+ "-" +(UserDataModelMap.getInstance().getUserMap().get("NEW_USER_DATA").getEmail()).toString().toLowerCase())
        UserDataModelMap.getInstance().getUserMap().clear()
    }

    def submitLoginForm() {
        $("#console").click()
    }


}
