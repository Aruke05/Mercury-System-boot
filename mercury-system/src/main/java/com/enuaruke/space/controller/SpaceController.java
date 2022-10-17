package com.enuaruke.space.controller;

import com.enuaruke.annotation.AnonymousAccess;
import com.enuaruke.annotation.Result;
import com.enuaruke.mercury.controller.model.UserQueryParameter;
import com.enuaruke.space.service.SpaceService;
import com.enuaruke.utils.random.Data.Person;
import com.enuaruke.utils.random.PersonUtil;
import com.enuaruke.utils.word.AESUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: Yu
 * @date: 2022年09月26日 11:19
 */
@RestController
@RequestMapping("/space")
public class SpaceController {

    @Autowired
    private SpaceService spaceService;

    @RequestMapping("/encrypt/{str}/{key}")
    public Result encrypt(@PathVariable("str") String str, @PathVariable("key")String key){
        String enu = null;
        try {
            enu = AESUtil.encrypt(str, key);
        } catch (Exception e) {
            throw new RuntimeException("加密失败");
        }
        return Result.ok(enu);
    }

    @RequestMapping("/decrypt/{str}/{key}")
    public Result<Object> decrypt(@PathVariable("str") String str, @PathVariable("key")String key){
        String enu = null;
        try {
            enu = AESUtil.decrypt(str, key);
        } catch (Exception e) {
            throw new RuntimeException("解密失败");
        }
        return Result.ok(enu);
    }

    @RequestMapping("/saveSpaceName")
    public Result saveSpaceName(@RequestBody UserQueryParameter userQueryParameter){
        spaceService.updateOrAddSpaceName(userQueryParameter.getUserName(), userQueryParameter.getSpaceName());
        return Result.ok();
    }

    @RequestMapping("/getSpaceName")
    public Result getSpaceName(@RequestBody UserQueryParameter userQueryParameter){
        String spaceName = spaceService.getSpaceName(userQueryParameter.getUserName());
        return Result.ok(spaceName);
    }

    /**
     * public
     * 获取测试用随机个人信息
     * @param num
     * @return
     */
    @RequestMapping("/randomPerson")
    public Result randomPerson(Integer num){
        if(num < 0 || num > 100)
            throw new RuntimeException("?");
        List<Person> random = PersonUtil.random(num);
        return Result.ok(random);
    }
}