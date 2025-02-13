package com.sh.cicd.api.api.image.dto;

import com.sh.cicd.infrastructure.s3.dto.ImageUrlDto;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ImageUrlResponse {

    private String presignedUrl;
    private String key;

    public static ImageUrlResponse from(ImageUrlDto imageUrlDto) {
        return ImageUrlResponse.builder()
                .presignedUrl(imageUrlDto.getUrl())
                .key(imageUrlDto.getKey())
                .build();
    }
}
