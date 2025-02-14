package com.sh.cicd.domain.image.service;

import com.sh.cicd.domain.image.adapter.UserImageAdapter;
import com.sh.cicd.domain.image.domain.UserImageEntity;
import com.sh.cicd.domain.user.adapter.UserAdapter;
import com.sh.cicd.domain.user.domain.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.sh.cicd.common.consts.StaticConsts.IMAGE_DOMAIN;

@Service
@RequiredArgsConstructor
@Transactional
public class ImageDomainService {

    private final UserAdapter userAdapter;
    private final UserImageAdapter userImageAdapter;

    public String userImageUploadSuccess(Long userId, String imageKey) {
        UserEntity user = userAdapter.queryUser(userId);
        String imageUrl = IMAGE_DOMAIN + "/" + imageKey;

        UserImageEntity userImage = UserImageEntity.builder()
                .user(user)
                .uri(imageUrl)
                .objectKey(imageKey)
                .build();
        userImageAdapter.save(userImage);

        return imageUrl;
    }

    public UserImageEntity getUserImageByUserId(Long userId) {
        return userImageAdapter.queryUserImageByUserId(userId);
    }

    public String deleteUserImage(UserImageEntity userImage) {
        userImage.delete();
        return userImage.getUri();
    }
}
