package com.sh.cicd.domain.image.service;

import static com.sh.cicd.common.consts.StaticConsts.IMAGE_DOMAIN;

import com.sh.cicd.domain.image.adapter.UserImageAdapter;
import com.sh.cicd.domain.image.domain.UserImageEntity;
import com.sh.cicd.domain.user.adapter.UserAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ImageDomainService {

    private final UserAdapter userAdapter;
    private final UserImageAdapter userImageAdapter;

    public String userImageUploadSuccess(Long userId, String imageKey) {
        String imageUrl = IMAGE_DOMAIN + "/" + imageKey;
        UserImageEntity userImage = userImageAdapter.queryUserImageByUserId(userId);
        userImage.update(imageUrl, imageKey);
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
