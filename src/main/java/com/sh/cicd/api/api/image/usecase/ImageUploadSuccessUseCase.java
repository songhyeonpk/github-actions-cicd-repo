package com.sh.cicd.api.api.image.usecase;

import com.sh.cicd.api.api.image.dto.ImageDto;
import com.sh.cicd.domain.image.service.ImageDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ImageUploadSuccessUseCase {

    private final ImageDomainService imageDomainService;

    public ImageDto userUploadImageSuccess(Long userId, String imageKey) {
        return ImageDto.from(imageDomainService.userImageUploadSuccess(userId, imageKey));
    }
}
