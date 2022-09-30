package com.enuaruke.mercury.service.base;

import com.enuaruke.mercury.controller.model.UserQueryParameter;
import com.enuaruke.utils.parameter.page.Page;

/**
 * @author: 05
 * @date: 2022-09-27 16:47
 */
public interface UserMercuryService {
    Page queryUserPage(UserQueryParameter parameter);
}
