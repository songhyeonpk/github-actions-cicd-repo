package com.sh.cicd.api.config.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ApiResponse<T> {

    private final int status;
    private final String message;
    private final T data;

    public static <T> ApiResponse<T> success(SuccessResults success) {
        return new ApiResponse<>(success.getStatus(), success.getMessage(), null);
    }

    public static <T> ApiResponse<T> success(SuccessResults success, T data) {
        return new ApiResponse<>(success.getStatus(), success.getMessage(), data);
    }

    public static <T> ApiResponse<T> success(int status, String message) {
        return new ApiResponse<>(status, message, null);
    }

    public static <T> ApiResponse<T> success(int status, String message, T data) {
        return new ApiResponse<>(status, message, data);
    }
}
