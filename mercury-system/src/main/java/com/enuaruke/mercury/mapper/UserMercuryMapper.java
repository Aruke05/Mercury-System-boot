package com.enuaruke.mercury.mapper;

import com.enuaruke.mercury.controller.model.UserQueryParameter;
import com.enuaruke.mercury.data.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author: 05
 * @date: 2022-09-29 21:55
 */
@Mapper
public interface UserMercuryMapper{

    Integer selectUserTotal(UserQueryParameter parameter);

    List<User> selectUserByParameter(UserQueryParameter parameter);

    List<String> selectUserIdByRoles(List<String> roles);

    void updateUser(User user);

    void syncEnuNode(List nodeList);
}
