package com.sh.cicd.api.api.image.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ImageDto {

    private String imageUrl;

    public static ImageDto from(String imageUrl) {
        return ImageDto.builder()
                .imageUrl(imageUrl)
                .build();
    }
}
