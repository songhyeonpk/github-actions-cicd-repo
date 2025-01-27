package com.sh.cicd.domain.common.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sh.cicd.domain.user.domain.UserEntity;
import com.sh.cicd.domain.user.domain.UserStatus;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserDetailVo {

    public Long id;
    public String nickname;
    public UserStatus status;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", shape = JsonFormat.Shape.STRING)
    public LocalDateTime createdAt;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", shape = JsonFormat.Shape.STRING)
    public LocalDateTime updatedAt;

    UserDetailVo(Long id, String nickname, UserStatus status, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.nickname = nickname;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static UserDetailVo from(UserEntity user) {
        return new UserDetailVo(user.getId(), user.getNickname(), user.getStatus(), user.getCreatedAt(), user.getUpdatedAt());
    }
}
