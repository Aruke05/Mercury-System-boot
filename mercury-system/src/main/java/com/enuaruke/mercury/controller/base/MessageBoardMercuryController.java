package com.enuaruke.mercury.controller.base;

import com.enuaruke.annotation.Result;
import com.enuaruke.mercury.controller.model.MessageBoardParameter;
import com.enuaruke.mercury.service.base.MessageBoardMercuryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: 05
 * @date: 2022-10-21 10:18
 */
@RestController
@RequestMapping("/mercury/messageBoard")
public class MessageBoardMercuryController {

    @Autowired
    private MessageBoardMercuryService messageBoardMercuryService;

    @RequestMapping("submit")
    public Result submit(@RequestBody MessageBoardParameter messageBoardParameter){
        messageBoardMercuryService.submitMessage(messageBoardParameter.getDesc());
        return Result.ok();
    }

    @RequestMapping("selectMessageBoardList")
    public Result selectMessageBoardList(@RequestBody MessageBoardParameter messageBoardParameter){
        return Result.ok(messageBoardMercuryService.selectMessageBoardList());
    }

    @RequestMapping("delete")
    public Result delete(@RequestBody MessageBoardParameter messageBoardParameter){
        messageBoardMercuryService.deleteMessage(messageBoardParameter.getId());
        return Result.ok();
    }
}
