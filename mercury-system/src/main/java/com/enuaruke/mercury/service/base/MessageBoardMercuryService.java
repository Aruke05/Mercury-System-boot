package com.enuaruke.mercury.service.base;

import com.enuaruke.mercury.data.model.MessageBoard;

import java.util.List;

/**
 * @author: 05
 * @date: 2022-10-21 10:39
 */
public interface MessageBoardMercuryService {
    void submitMessage(String desc);

    List<MessageBoard> selectMessageBoardList();

    void deleteMessage(String id);
}
