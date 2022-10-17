package com.enuaruke.mercury.controller.model;

import com.enuaruke.base.MercuryPage;
import com.enuaruke.utils.parameter.ViewModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author: 05
 * @date: 2022-09-29 21:52
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserQueryParameter extends ViewModel {

    String userId;
    List<String> userIds;
    String userName;
    String spaceName;
    String nickName;

}
