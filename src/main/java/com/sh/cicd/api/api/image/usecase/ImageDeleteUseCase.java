package com.sh.cicd.api.api.image.usecase;

import com.sh.cicd.api.api.image.dto.ImageDto;
import com.sh.cicd.domain.image.domain.UserImageEntity;
import com.sh.cicd.domain.image.exception.UserImageUnableDeleteException;
import com.sh.cicd.domain.image.service.ImageDomainService;
import com.sh.cicd.infrastructure.s3.S3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static com.sh.cicd.common.consts.StaticConsts.USER_DEFAULT_IMAGE;

@Component
@RequiredArgsConstructor
public class ImageDeleteUseCase {

    private final ImageDomainService imageDomainService;
    private final S3Service s3Service;

    public ImageDto deleteImageForUser(Long userId) {
        UserImageEntity userImage = imageDomainService.getUserImageByUserId(userId);
        if(userImage.getObjectKey().equals(USER_DEFAULT_IMAGE)) {
            throw UserImageUnableDeleteException.UNABLE_DELETE;
        }

        s3Service.deleteImage(userImage.getObjectKey());

        String url = imageDomainService.deleteUserImage(userImage);
        return ImageDto.from(url);
    }
}
