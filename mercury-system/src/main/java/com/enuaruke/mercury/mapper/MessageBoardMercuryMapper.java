package com.enuaruke.mercury.mapper;


import com.enuaruke.mercury.data.model.MessageBoard;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author: 05
 * @date: 2022-10-21 10:42
 */
@Mapper
public interface MessageBoardMercuryMapper {

    int submit(Long userId, String desc);

    List<MessageBoard> selectAll();

    void deleteById(String id);
}
