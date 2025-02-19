package com.sh.cicd.common.dto;

import lombok.Getter;

@Getter
public class ErrorResponse {

    private final int status;
    private final String reason;

    ErrorResponse(int status, String reason) {
        this.status = status;
        this.reason = reason;
    }

    public static ErrorResponse of(ErrorReason errorReason) {
        return new ErrorResponse(errorReason.getStatus(), errorReason.getReason());
    }

    public static ErrorResponse of(int status, String reason) {
        return new ErrorResponse(status, reason);
    }
}
