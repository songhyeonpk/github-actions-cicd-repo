package com.sh.cicd.domain.common.vo;

import com.sh.cicd.domain.user.domain.UserEntity;
import lombok.Getter;

@Getter
public class UserInfoVo {

    public Long id;
    public String nickname;

    UserInfoVo(Long id, String nickname) {
        this.id = id;
        this.nickname = nickname;
    }

    public static UserInfoVo from(UserEntity user) {
        return new UserInfoVo(user.getId(), user.getNickname());
    }
}
