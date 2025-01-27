package com.sh.cicd.common.dto;

import lombok.Getter;

@Getter
public class ErrorReason {

    private final int status;
    private final String reason;

    ErrorReason(int status, String reason) {
        this.status = status;
        this.reason = reason;
    }

    public static ErrorReason of(int status, String reason) {
        return new ErrorReason(status, reason);
    }
}
