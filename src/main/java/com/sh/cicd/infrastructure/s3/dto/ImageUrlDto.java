package com.sh.cicd.infrastructure.s3.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ImageUrlDto {

    private String url;
    private String key;

    public static ImageUrlDto of(String url, String key) {
        return ImageUrlDto.builder().url(url).key(key).build();
    }
}
