package com.sh.cicd.domain.user.service;

import com.sh.cicd.domain.user.adapter.UserAdapter;
import com.sh.cicd.domain.user.domain.UserEntity;
import com.sh.cicd.domain.user.domain.UserStatus;
import com.sh.cicd.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserDomainService {

    private final UserAdapter userAdapter;

    // 회원등록
    public UserEntity registerUser(String nickname) {
        UserEntity user = UserEntity.builder()
                .nickname(nickname)
                .status(UserStatus.ACTIVE)
                .build();

        return userAdapter.save(user);
    }
}
