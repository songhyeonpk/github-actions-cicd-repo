package com.sh.cicd.api.config.response;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum SuccessResults {
    OK(HttpStatus.OK.value(), "리소스 조회에 성공했습니다."),
    CREATED(HttpStatus.CREATED.value(), "리소스 생성에 성공했습니다."),
    UPDATED(HttpStatus.OK.value(), "리소스 업데이트에 성공했습니다."),
    DELETED(HttpStatus.OK.value(), "리소스 삭제에 성공했습니다.");

    private final int status;
    private final String message;

    SuccessResults(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
