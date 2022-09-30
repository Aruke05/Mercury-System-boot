package com.enuaruke.mercury.controller.model;

import com.enuaruke.base.MercuryPage;
import com.enuaruke.utils.parameter.ViewModel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author: 05
 * @date: 2022-09-29 21:52
 */
@NoArgsConstructor
@AllArgsConstructor
public class UserQueryParameter extends ViewModel {

    String userName;
    String spaceName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSpaceName() {
        return spaceName;
    }

    public void setSpaceName(String spaceName) {
        this.spaceName = spaceName;
    }

}
