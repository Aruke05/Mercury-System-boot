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

    String userId;
    String userName;
    String spaceName;

    String nickName;

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

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
