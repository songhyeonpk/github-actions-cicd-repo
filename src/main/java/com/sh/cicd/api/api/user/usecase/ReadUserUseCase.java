package com.sh.cicd.api.api.user.usecase;

import com.sh.cicd.domain.common.vo.UserDetailVo;
import com.sh.cicd.domain.common.vo.UserInfoVo;
import com.sh.cicd.domain.user.adapter.UserAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReadUserUseCase {

    private final UserAdapter userAdapter;

    public UserInfoVo findUserInfoById(Long id) {
        return userAdapter.queryUser(id).toUserInfoVo();
    }

    public UserDetailVo findUserDetailById(Long id) {
        return userAdapter.queryUser(id).toUserDetailVo();
    }
}
