package com.sh.cicd.api.api.image.usecase;

import com.sh.cicd.api.api.image.dto.ImageUrlResponse;
import com.sh.cicd.infrastructure.s3.S3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetPresignedUrlUseCase {

    private final S3Service s3Service;

    public ImageUrlResponse getPresignedUrlForUser(String filename) {
        return ImageUrlResponse.from(s3Service.getPreSignedUrlForUser(filename));
    }
}
