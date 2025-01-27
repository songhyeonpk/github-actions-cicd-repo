package com.sh.cicd.api.config.response;

import com.sh.cicd.common.dto.ErrorReason;
import com.sh.cicd.common.dto.ErrorResponse;
import com.sh.cicd.common.exception.BaseCodeException;
import com.sh.cicd.common.exception.BaseErrorCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BaseCodeException.class)
    public ResponseEntity<ErrorResponse> baseCodeExceptionHandle(BaseCodeException exception) {
        BaseErrorCode errorCode = exception.errorCode;
        ErrorReason errorReason = ErrorReason.of(errorCode.getStatus(), errorCode.getReason());
        ErrorResponse errorResponse = ErrorResponse.of(errorReason);

        return ResponseEntity.status(errorReason.getStatus())
                .body(errorResponse);
    }
}
