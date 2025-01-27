package com.sh.cicd.domain.user.domain;

import lombok.Getter;

@Getter
public enum UserStatus {

    ACTIVE("활성 상태"),
    SUSPENDED("정지 상태"),
    DELETED("탈퇴 상태");

    private final String userStatus;

    UserStatus(String userStatus) {
        this.userStatus = userStatus;
    }
}
