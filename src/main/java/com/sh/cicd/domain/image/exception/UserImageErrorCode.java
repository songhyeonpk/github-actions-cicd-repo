package com.sh.cicd.domain.image.exception;

import com.sh.cicd.common.exception.BaseErrorCode;

import static com.sh.cicd.common.consts.StaticConsts.NOT_FOUND;

public enum UserImageErrorCode implements BaseErrorCode {

    USER_IMAGE_NOT_FOUND(NOT_FOUND, "유저 이미지를 찾을 수 없습니다.");

    private final int status;
    private final String reason;

    UserImageErrorCode(int status, String reason) {
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
