package com.sh.cicd.infrastructure.s3.exception;

import static com.sh.cicd.common.consts.StaticConsts.*;

import com.sh.cicd.common.exception.BaseErrorCode;

public enum S3ErrorCode implements BaseErrorCode {
    NOT_FOUND_OBJECT(NOT_FOUND, "객체가 존재하지 않습니다.");

    private final int status;
    private final String message;

    S3ErrorCode(int status, String message) {
        this.status = status;
        this.message = message;
    }

    @Override
    public int getStatus() {
        return this.status;
    }

    @Override
    public String getReason() {
        return this.message;
    }
}
