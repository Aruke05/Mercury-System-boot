package com.enuaruke.mercury.controller.base;

import com.enuaruke.base.MercuryPage;
import com.enuaruke.mercury.controller.model.UserQueryParameter;
import com.enuaruke.mercury.service.base.UserMercuryService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author: 05
 * @date: 2022-09-27 16:41
 */
@RestController
@RequestMapping("/base/users")
public class UserMercuryController {

    @Resource
    private UserMercuryService userService;

    @RequestMapping("queryUserPage")
    public MercuryPage queryUserPage(HttpServletRequest request, @RequestBody UserQueryParameter parameter){
        MercuryPage page = userService.queryUserPage(parameter);
        return page;
    }
}
