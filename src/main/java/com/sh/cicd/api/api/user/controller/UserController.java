package com.sh.cicd.api.api.user.controller;

import com.sh.cicd.api.api.user.dto.SaveUserRequest;
import com.sh.cicd.api.api.user.usecase.ReadUserUseCase;
import com.sh.cicd.api.api.user.usecase.UpdateUserUseCase;
import com.sh.cicd.api.config.response.ApiResponse;
import com.sh.cicd.api.config.response.SuccessResults;
import com.sh.cicd.domain.common.vo.UserDetailVo;
import com.sh.cicd.domain.common.vo.UserInfoVo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final ReadUserUseCase readUserUseCase;
    private final UpdateUserUseCase updateUserUseCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<UserInfoVo> createUser(@RequestBody SaveUserRequest request) {
        UserInfoVo vo = updateUserUseCase.saveUser(request);
        return ApiResponse.success(SuccessResults.CREATED, vo);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<UserDetailVo> getUser(@RequestParam Long id) {
        UserDetailVo vo = readUserUseCase.findUserDetailById(id);
        return ApiResponse.success(SuccessResults.OK, vo);
    }
}
