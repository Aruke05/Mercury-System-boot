package com.enuaruke.mercury.service.base.impl;

import com.enuaruke.mercury.data.model.MessageBoard;
import com.enuaruke.mercury.mapper.MessageBoardMercuryMapper;
import com.enuaruke.mercury.service.base.MessageBoardMercuryService;
import com.enuaruke.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: 05
 * @date: 2022-10-21 10:39
 */
@Service
public class MessageBoardMercuryServiceImpl implements MessageBoardMercuryService {

    @Autowired
    private MessageBoardMercuryMapper messageBoardMercuryMapper;

    @Override
    public void submitMessage(String desc) {
        Long userId = SecurityUtils.getCurrentUserId();
        messageBoardMercuryMapper.submit(userId, desc);
    }

    @Override
    public List<MessageBoard> selectMessageBoardList() {
        return messageBoardMercuryMapper.selectAll();
    }

    @Override
    public void deleteMessage(String id) {
        messageBoardMercuryMapper.deleteById(id);
    }

}
