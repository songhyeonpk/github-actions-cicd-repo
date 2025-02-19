package com.sh.cicd.common.exception;

public class BaseCodeException extends RuntimeException {

    public BaseErrorCode errorCode;

    protected BaseCodeException(BaseErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
