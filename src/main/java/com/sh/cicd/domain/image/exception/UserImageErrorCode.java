package com.sh.cicd.domain.image.exception;

import static com.sh.cicd.common.consts.StaticConsts.BAD_REQUEST;
import static com.sh.cicd.common.consts.StaticConsts.NOT_FOUND;

import com.sh.cicd.common.exception.BaseErrorCode;

public enum UserImageErrorCode implements BaseErrorCode {
    USER_IMAGE_NOT_FOUND(NOT_FOUND, "유저 이미지를 찾을 수 없습니다."),
    USER_IMAGE_UNABLE_DELETE(BAD_REQUEST, "유저 이미지를 삭제할 수 없습니다.");

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
