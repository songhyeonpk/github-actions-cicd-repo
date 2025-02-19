package com.sh.cicd.domain.user.service;

import static com.sh.cicd.common.consts.StaticConsts.IMAGE_DOMAIN;
import static com.sh.cicd.common.consts.StaticConsts.USER_DEFAULT_IMAGE;

import com.sh.cicd.domain.image.adapter.UserImageAdapter;
import com.sh.cicd.domain.image.domain.UserImageEntity;
import com.sh.cicd.domain.user.adapter.UserAdapter;
import com.sh.cicd.domain.user.domain.UserEntity;
import com.sh.cicd.domain.user.domain.UserStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserDomainService {

    private final UserAdapter userAdapter;
    private final UserImageAdapter userImageAdapter;

    // 회원등록
    public UserEntity registerUser(String nickname) {
        UserEntity user = UserEntity.builder().nickname(nickname).status(UserStatus.ACTIVE).build();

        userAdapter.save(user);

        UserImageEntity userImage =
                UserImageEntity.builder()
                        .user(user)
                        .uri(IMAGE_DOMAIN + "/" + USER_DEFAULT_IMAGE)
                        .objectKey(USER_DEFAULT_IMAGE)
                        .build();
        userImageAdapter.save(userImage);

        return user;
    }
}
