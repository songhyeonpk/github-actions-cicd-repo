package com.sh.cicd.domain.image.exception;

import com.sh.cicd.common.exception.BaseCodeException;

public class UserImageNotFoundException extends BaseCodeException {

    UserImageNotFoundException(UserImageErrorCode errorCode) {
        super(errorCode);
    }

    public static final UserImageNotFoundException USER_IMAGE_NOT_FOUND =
            new UserImageNotFoundException(UserImageErrorCode.USER_IMAGE_NOT_FOUND);
}
