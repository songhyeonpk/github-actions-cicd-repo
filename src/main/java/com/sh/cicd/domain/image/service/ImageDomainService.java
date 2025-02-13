package com.sh.cicd.domain.image.service;

import com.sh.cicd.domain.image.adapter.UserImageAdapter;
import com.sh.cicd.domain.image.domain.UserImageEntity;
import com.sh.cicd.domain.user.adapter.UserAdapter;
import com.sh.cicd.domain.user.domain.UserEntity;
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
        UserEntity user = userAdapter.queryUser(userId);
        String imageUrl = "https://sh-test-server-bucket.s3.ap-northeast-2.amazonaws.com" + "/" + imageKey;

        UserImageEntity userImage = UserImageEntity.builder()
                .user(user)
                .uri(imageUrl)
                .objectKey(imageKey)
                .build();
        userImageAdapter.save(userImage);

        return imageUrl;
    }
}
