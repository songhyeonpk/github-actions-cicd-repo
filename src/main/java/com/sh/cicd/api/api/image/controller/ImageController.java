package com.sh.cicd.api.api.image.controller;

import com.sh.cicd.api.api.image.dto.ImageDto;
import com.sh.cicd.api.api.image.dto.ImageUrlResponse;
import com.sh.cicd.api.api.image.dto.SuccessUserImageUploadRequest;
import com.sh.cicd.api.api.image.usecase.GetPresignedUrlUseCase;
import com.sh.cicd.api.api.image.usecase.ImageUploadSuccessUseCase;
import com.sh.cicd.api.config.response.ApiResponse;
import com.sh.cicd.api.config.response.SuccessResults;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/api/images")
@RequiredArgsConstructor
public class ImageController {

    private final GetPresignedUrlUseCase getPresignedUrlUseCase;
    private final ImageUploadSuccessUseCase imageUploadSuccessUseCase;

    // 유저 이미지 pre-signed URL 발급 요청
    @GetMapping("/users/{userId}/presigned-url")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<ImageUrlResponse> getPresignedUrlOfUserUpload(
            @PathVariable Long userId,
            @RequestParam String filename) {
        return ApiResponse.success(SuccessResults.OK, getPresignedUrlUseCase.getPresignedUrlForUser(filename));
    }

    // 유저 이미지 업로드 성공 요청 -> 유저 이미지 정보 저장
    @PostMapping("/users/{userId}")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<ImageDto> userUploadImageSuccess(
            @PathVariable Long userId,
            @RequestBody SuccessUserImageUploadRequest request) {
        return ApiResponse.success(SuccessResults.CREATED, imageUploadSuccessUseCase.userUploadImageSuccess(userId, request.getImageKey()));
    }
}
