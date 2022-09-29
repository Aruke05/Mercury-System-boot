package com.enuaruke.mercury.data.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.enuaruke.base.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author Zheng Jie
 * @date 2018-11-22
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User extends BaseEntity implements Serializable {

    private Long userId;

    private String userName;
    private String spaceName;
    private String nickName;
    private String deptId;
    private String email;
    private String phone;
    private String gender;
    private String avatarName;
    private String avatarPath;
    private String password;
    private Boolean enabled;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(userId, user.userId) &&
                Objects.equals(userName, user.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName);
    }
}