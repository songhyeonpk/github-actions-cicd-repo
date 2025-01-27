package com.sh.cicd.domain.user.exception;

import com.sh.cicd.common.exception.BaseCodeException;

public class UserNotFoundException extends BaseCodeException {

    UserNotFoundException(UserErrorCode errorCode) {
        super(errorCode);
    }

    public static final UserNotFoundException USER_NOT_FOUND_EXCEPTION
            = new UserNotFoundException(UserErrorCode.USER_NOT_FOUND);
}
