package com.enuaruke.mercury.service.base.impl;

import com.enuaruke.mercury.controller.model.UserQueryParameter;
import com.enuaruke.mercury.mapper.UserMercuryMapper;
import com.enuaruke.mercury.service.base.UserMercuryService;
import com.enuaruke.utils.parameter.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: 05
 * @date: 2022-09-27 16:47
 */
@Service
public class UserMercuryServiceImpl implements UserMercuryService {

    @Autowired
    private UserMercuryMapper userMapper;

    @Override
    public Page queryUserPage(UserQueryParameter parameter) {
        parameter.getPage().setTotal(userMapper.selectUserTotal(parameter));
        parameter.getPage().setRecords(userMapper.selectUserByParameter(parameter));
        return parameter.getPage();
    }
}
