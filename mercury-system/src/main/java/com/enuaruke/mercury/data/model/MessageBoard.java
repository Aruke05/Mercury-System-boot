package com.enuaruke.mercury.data.model;

import lombok.*;

import java.util.Date;

/**
 * @author: 05
 * @date: 2022-10-21 11:00
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MessageBoard {
    Long id;
    Long userId;
    String userName;
    String avatarName;
    String nickName;
    String desc;
    Date insertTime;
}
