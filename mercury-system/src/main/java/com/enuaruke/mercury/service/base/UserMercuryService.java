package com.enuaruke.mercury.service.base;

import com.enuaruke.base.MercuryPage;
import com.enuaruke.mercury.controller.model.UserQueryParameter;

/**
 * @author: 05
 * @date: 2022-09-27 16:47
 */
public interface UserMercuryService {
    MercuryPage queryUserPage(UserQueryParameter parameter);
}
