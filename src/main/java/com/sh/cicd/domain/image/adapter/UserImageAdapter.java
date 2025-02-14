package com.sh.cicd.domain.image.adapter;

import com.sh.cicd.domain.image.domain.UserImageEntity;
import com.sh.cicd.domain.image.exception.UserImageNotFoundException;
import com.sh.cicd.domain.image.repository.UserImageRepository;
import com.sh.cicd.domain.user.domain.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserImageAdapter {

    private final UserImageRepository userImageRepository;

    public UserImageEntity queryUserImage(Long id) {
        return userImageRepository.findById(id)
                .orElseThrow(() -> UserImageNotFoundException.USER_IMAGE_NOT_FOUND);
    }

    public UserImageEntity queryUserImageByUserId(Long userId) {
        return userImageRepository.findByUserId(userId)
                .orElseThrow(() -> UserImageNotFoundException.USER_IMAGE_NOT_FOUND);
    }

    public UserImageEntity save(UserImageEntity userImage) { return userImageRepository.save(userImage); }
}
