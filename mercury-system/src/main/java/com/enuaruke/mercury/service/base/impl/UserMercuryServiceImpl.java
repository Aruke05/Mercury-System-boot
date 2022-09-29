package com.enuaruke.mercury.service.base.impl;

import com.enuaruke.base.MercuryPage;
import com.enuaruke.mercury.controller.model.UserQueryParameter;
import com.enuaruke.mercury.mapper.UserMercuryMapper;
import com.enuaruke.mercury.service.base.UserMercuryService;
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
    public MercuryPage queryUserPage(UserQueryParameter parameter) {
        parameter.getPage().setTotal(userMapper.selectUserTotal());
        parameter.getPage().setList(userMapper.selectUserByParameter(parameter));
        return parameter.getPage();
    }
}
