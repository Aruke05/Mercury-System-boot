package com.enuaruke.space.service.impl;

import com.enuaruke.mercury.common.config.MercuryConfig;
import com.enuaruke.mercury.controller.model.UserQueryParameter;
import com.enuaruke.mercury.data.model.User;
import com.enuaruke.mercury.mapper.UserMercuryMapper;
import com.enuaruke.space.service.SpaceService;
import com.enuaruke.utils.word.AESUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 05
 * @date: 2022-09-30 22:42
 */
@Service
public class SpaceServiceImpl implements SpaceService {

    @Autowired
    private UserMercuryMapper userMapper;
    @Override
    public void updateOrAddSpaceName(String userName, String spaceName) {
        UserQueryParameter parameter = new UserQueryParameter();
        parameter.setUserName(userName);
        List<User> users = userMapper.selectUserByParameter(parameter);
        if(users.size() == 0){
            throw new RuntimeException("该个体不存在");
        }
        User user = users.get(0);
        user.setSpaceName(spaceName);
        userMapper.updateUser(user);
    }

    @Override
    public String getSpaceName(String userName) {
        UserQueryParameter parameter = new UserQueryParameter();
        parameter.setUserName(userName);
        List<User> users = userMapper.selectUserByParameter(parameter);
        if(users.size() == 0){
            throw new RuntimeException("该个体不存在");
        }
        User user = users.get(0);
        try {
            String src = MercuryConfig.AESkey + "IX" + (user.getUserId() < 10 ? "0" + user.getUserId() : user.getUserId()) + " " + user.getNickName();
            return AESUtil.encrypt(src ,MercuryConfig.AESkey);
        } catch (Exception e) {
            throw new RuntimeException("加密失败");
        }
    }

}
