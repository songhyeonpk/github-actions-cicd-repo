package com.sh.cicd.domain.user.exception;

import com.sh.cicd.common.exception.BaseCodeException;

public class UserAlreadyException extends BaseCodeException {

    UserAlreadyException(UserErrorCode errorCode) {
        super(errorCode);
    }

    public static final UserAlreadyException USER_ALREADY_EXCEPTION
            = new UserAlreadyException(UserErrorCode.USER_ALREADY);
}
