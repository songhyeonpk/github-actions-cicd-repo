package com.sh.cicd.domain.user.adapter;

import com.sh.cicd.domain.user.domain.UserEntity;
import com.sh.cicd.domain.user.exception.UserNotFoundException;
import com.sh.cicd.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserAdapter {

    private final UserRepository userRepository;

    public UserEntity queryUser(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> UserNotFoundException.USER_NOT_FOUND_EXCEPTION);
    }

    public UserEntity save(UserEntity user) {
        return userRepository.save(user);
    }
}
