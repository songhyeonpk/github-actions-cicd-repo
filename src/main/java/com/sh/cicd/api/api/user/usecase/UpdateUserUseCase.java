package com.sh.cicd.api.api.user.usecase;

import com.sh.cicd.api.api.user.dto.SaveUserRequest;
import com.sh.cicd.domain.common.vo.UserInfoVo;
import com.sh.cicd.domain.user.service.UserDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateUserUseCase {

    private final UserDomainService userDomainService;

    public UserInfoVo saveUser(SaveUserRequest request) {
        return userDomainService.registerUser(request.getNickname()).toUserInfoVo();
    }
}
