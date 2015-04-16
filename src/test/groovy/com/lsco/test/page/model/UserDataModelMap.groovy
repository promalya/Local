package com.lsco.test.page.model

/**
 * Created by edu on 20/11/14.
 */
class UserDataModelMap {

    private static final UserDataModelMap INSTANCE=new UserDataModelMap()

    private Map<String,UserDataModelMap> userMap

    static UserDataModelMap getInstance(){
        return INSTANCE
    }

    private UserDataModelMap() {
        userMap=new HashMap<String,UserDataModelMap>()
    }

    def public Map<String,UserDataModelMap> getUserMap() {
        return userMap;
    }
}
