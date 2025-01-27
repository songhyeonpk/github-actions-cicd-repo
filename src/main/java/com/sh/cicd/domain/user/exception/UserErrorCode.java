package com.sh.cicd.domain.user.exception;

import static com.sh.cicd.common.consts.StaticConsts.*;
import com.sh.cicd.common.exception.BaseErrorCode;

public enum UserErrorCode implements BaseErrorCode {

    USER_NOT_FOUND(NOT_FOUND, "유저를 찾을 수 없습니다."),
    USER_ALREADY(CONFLICT, "이미 존재하는 유저입니다.");

    private final int status;
    private final String reason;

    UserErrorCode(int status, String reason) {
        this.status = status;
        this.reason = reason;
    }

    @Override
    public int getStatus() {
        return this.status;
    }

    @Override
    public String getReason() {
        return this.reason;
    }
}
