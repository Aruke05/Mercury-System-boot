package com.enuaruke.common.task.mercury;

import com.enuaruke.mercury.controller.model.UserQueryParameter;
import com.enuaruke.mercury.data.model.User;
import com.enuaruke.mercury.mapper.UserMercuryMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @author: 05
 * @date: 2022-10-17 11:39
 */
@Slf4j
@Service
public class EnuNodeSync {

    @Autowired
    private UserMercuryMapper userMercuryMapper;

    public void sync(){
        List list = new ArrayList();
        list.add("1");
        list.add("2");
        List userIds = userMercuryMapper.selectUserIdByRoles(list);
        UserQueryParameter parameter = new UserQueryParameter();
        parameter.setUserIds(userIds);
        List<User> users = userMercuryMapper.selectUserByParameter(parameter);
        List nodeList = new ArrayList();
        users.forEach(item -> {
            HashMap nodeMap = new HashMap();
            nodeMap.put("id", item.getUserId());
            nodeMap.put("name", item.getNickName());
            nodeMap.put("mark", item.getUserName());
            nodeMap.put("space_name", item.getSpaceName());
            nodeList.add(nodeMap);
        });
        userMercuryMapper.syncEnuNode(nodeList);
        log.info(new Date() + ":Enu个体同步完成");
    }

}
