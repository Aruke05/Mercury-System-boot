package com.enuaruke.mercury.controller.base;

import com.enuaruke.annotation.Result;
import com.enuaruke.mercury.controller.model.UserQueryParameter;
import com.enuaruke.mercury.service.base.UserMercuryService;
import com.enuaruke.utils.parameter.page.Page;
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
    public Result<Object> queryUserPage(HttpServletRequest request, @RequestBody UserQueryParameter parameter){
        Page page = userService.queryUserPage(parameter);
        return Result.ok(page);
    }
}
