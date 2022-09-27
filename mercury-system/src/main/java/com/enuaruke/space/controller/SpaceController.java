package com.enuaruke.space.controller;

import com.enuaruke.annotation.AnonymousAccess;
import com.enuaruke.utils.word.AESUtil;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Yu
 * @date: 2022年09月26日 11:19
 */
@RestController
@RequestMapping("/space")
public class SpaceController {

    @AnonymousAccess
    @RequestMapping("/encrypt/{str}")
    public String encrypt(@PathVariable("str") String str){
        String enu = AESUtil.encrypt(str, "Enu");
        return enu;
    }

    @AnonymousAccess
    @RequestMapping("/decrypt/{str}")
    public String decrypt(@PathVariable("str") String str){
        String enu = AESUtil.decrypt(str, "Enu");
        return enu;
    }
}